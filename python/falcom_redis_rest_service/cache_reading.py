#http://falcon.readthedocs.org/en/0.3.0/user/quickstart.html
import json
import logging
from wsgiref import simple_server
from redis_wrapper import RedisWrapper
import falcon


class StorageError(Exception):
    @staticmethod
    def handle(ex, req, resp, params):
        description = ('Sorry, could not store the message, it worked on my machine')
        raise falcon.HTTPError(falcon.HTTP_725, 'Database Error', description)


class AuthMiddleware(object):
    def process_request(self, req, resp):
		pass


class RequireJSON(object):
    def process_request(self, req, resp):
        if not req.client_accepts_json:
            raise falcon.HTTPNotAcceptable('This API only supports responses encoded as JSON.')

        if req.method in ('POST'):
            if 'application/json' not in req.content_type:
                raise falcon.HTTPUnsupportedMediaType('This API only supports requests encoded as JSON.')


class JSONTranslator(object):

    def process_request(self, req, resp):
        if req.content_length in (None, 0):
            return

        body = req.stream.read()
        if not body:
            raise falcon.HTTPBadRequest('Empty request body', 'A valid JSON document is required.')

        try:
            req.context['doc'] = json.loads(body.decode('utf-8'))
        except (ValueError, UnicodeDecodeError):
            raise falcon.HTTPError(falcon.HTTP_753, 'Malformed JSON', 'Could not decode the request body. The JSON was incorrect or not encoded as UTF-8.')

    def process_response(self, req, resp, resource):
        if 'result' not in req.context:
            return

        resp.body = json.dumps(req.context['result'])


def max_body(limit):
    def hook(req, resp, resource, params):
        length = req.content_length
        if length is not None and length > limit:
            msg = ('The size of the request is too large. The body must not exceed ' + str(limit) + ' bytes in length.')
            raise falcon.HTTPRequestEntityTooLarge('Request body is too large', msg)
    return hook


class MessageStorageResource:

    def __init__(self):
        self.logger = logging.getLogger('storage.' + __name__)

    @falcon.before(max_body(64 * 1024))
    def on_post(self, req, resp):
        try:
            doc = req.context['doc']
            redis = RedisWrapper()
            key = redis.store_message(doc)
        except KeyError:
			raise falcon.HTTPBadRequest('Missing body','A json body must be submitted.')

        resp.status = falcon.HTTP_200
        resp.body = '{"key": "'+str(key)+'"}'


class MessageRetrieverResource:

    def __init__(self):
        self.logger = logging.getLogger('retrieve.' + __name__)

    def on_get(self, req, resp, key):
    	redis = RedisWrapper()
    	message = redis.get_message(key)
        resp.status = falcon.HTTP_200
        resp.body = message


app = falcon.API(middleware=[
    AuthMiddleware(),
    RequireJSON(),
    JSONTranslator(),
])

app.add_route('/storemessage/', MessageStorageResource())
app.add_route('/retrievemessage/{key}', MessageRetrieverResource())

app.add_error_handler(StorageError, StorageError.handle)

if __name__ == '__main__':
    httpd = simple_server.make_server('127.0.0.1', 8000, app)
    httpd.serve_forever()

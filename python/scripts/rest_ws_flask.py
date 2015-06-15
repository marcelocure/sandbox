#http://blog.luisrei.com/articles/flaskrest.html
from flask import Flask, url_for
from flask import request
from flask import Response
from flask import json


app = Flask(__name__)

@app.route('/')
def api_root():
    return 'Welcome Cure'

@app.route('/articles')
def articles():
    return 'List all articles'

@app.route('/articles/<articleid>')
def article(articleid):
    return 'You are reading the article ' + articleid

@app.route('/create', methods = ['POST'])
def create():
    retuned_json = json.dumps(request.json)
    data = {'status'  : 'Article created successfully'}
    js = json.dumps(data)
    resp = Response(js, status=200, mimetype='application/json')
    return resp

@app.errorhandler(404)
def not_found(error=None):
    message = {
            'status': 404,
            'message': 'Article not found: ' + error,
    }
    resp = jsonify(message)
    resp.status_code = 404

    return resp

if __name__ == '__main__':
    app.run()

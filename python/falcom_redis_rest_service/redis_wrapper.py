import redis

class RedisWrapper(object):
	def __init__(self):
		self.conn = self.connect()	
	
	def connect(self):
		return redis.StrictRedis(host='127.0.0.1', port='6379', db=0)

	def store_message(self, message):
		key = self.build_input_key()
		self.conn.set(key, message)
		return key

	def build_input_key(self):
		key = len(self.conn.keys())+1
		return 'in_{0}'.format(key)

	def build_output_key(self):
		key = len(self.conn.keys())+1
		return 'in_{0}'.format(key)

	def get_message(self, key):
		return self.conn.get(key)

#!/usr/bin/env python
import pika

class Sender(object):
	def __init__(self):
		self.connection = None
		self.channel = None

	def connect(self, host):
		self.connection = pika.BlockingConnection(pika.ConnectionParameters(host=host))
		self.channel = self.connection.channel()

	def create_queue(self, queue_name):
		self.channel.queue_declare(queue=queue_name)

	def send_message(self, queue_name, message):
		self.channel.basic_publish(exchange='', routing_key=queue_name, body=message)
		print 'message sent successfully'

	def disconnect(self):
		self.connection.close()

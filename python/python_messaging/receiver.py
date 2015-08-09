#!/usr/bin/env python
import pika

class Receiver(object):
	def __init__(self):
		self.connection = None
		self.channel = None

	def connect(self, host):
		self.connection = pika.BlockingConnection(pika.ConnectionParameters(host=host))
		self.channel = self.connection.channel()

	def callback(self, ch, method, properties, body):
	    print " Received:  %r" % (body,)

	def receive(self, queue_name):
		print 'press ctrl+c to abort'
		self.channel.basic_consume(self.callback, queue=queue_name, no_ack=True)
		self.channel.start_consuming()

	def disconnect(self):
		self.connection.close()

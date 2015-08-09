#!/usr/bin/env python
from sender import Sender
from receiver import Receiver

def main():
	sender = Sender('localhost')
	sender.connect()
	sender.create_queue('inbox')
	sender.send_message('inbox', 'hello')

	receiver = Receiver('localhost')
	receiver.connect()
	receiver.receive('inbox')

if __name__ == '__main__':
	main()

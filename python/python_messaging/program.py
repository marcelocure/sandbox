#!/usr/bin/env python
from sender import Sender
from receiver import Receiver

def main():
	sender = Sender('localhost')
	sender.connect()
	sender.create_queue('inbox')
	sender.send_message('inbox', 'hello')
	sender.disconnect()

	receiver = Receiver('localhost')
	receiver.connect()
	receiver.receive('inbox')
	receiver.disconnect()

if __name__ == '__main__':
	main()

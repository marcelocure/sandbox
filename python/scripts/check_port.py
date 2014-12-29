import socket
import argparse
import sys

def parse_input(argv):
	arg_parser = argparse.ArgumentParser(
        prog=argv[0],
        formatter_class=argparse.RawDescriptionHelpFormatter,
        description='This script helps identifying is a port in a host is listening properly')

	arg_parser.add_argument('host', help='Host')
	arg_parser.add_argument('port', help='port')
	args = arg_parser.parse_args()
	return (args.host, int(args.port))

def main(args):
	host, port = parse_input(args)
	s = socket.socket()

	try:
	    result = s.connect_ex((host, port)) 
	    print 'port is available'
	except Exception as e:
	    print (host, port, e)

if __name__ == '__main__':
    main(sys.argv)
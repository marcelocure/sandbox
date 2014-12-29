import sys


def main(args):
	f = open('<file name>')
	results = []
	for line in f.readlines():
		if '<text to find>' in line:
			initial_position = line.find('<text to find>')
			without_begin = line[initial_position:]
			results.append(without_begin.split(': ')[1].split(' ')[0])
	print results

if __name__ == '__main__':
	main(sys.argv)

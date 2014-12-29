import math


def main():

	lines = read_file('c:/Temp/dados.txt')
	vertices = parse_vertices(lines)
	arestas = parse_arestas(lines, len(vertices)+3)

	data = []
	for v in arestas:
		try:
			vertice_x = vertices[int(v[0])]
			vertice_y = vertices[int(v[1])]
			data.append((vertice_x,vertice_y, calculate_distance(vertice_x, vertice_y)))
		except:
			pass
	print 'data done'
	del lines, vertices, arestas
	#data = [('a','b',1),('a','c',2),('b','d',3),('b','d',8),('c','d',6),('c','e',3),('d','e',5),('d','f',8),('d','g',1),('e','f',2),('f','g',2),('g','h',3),('g','i',1),('g','j',4)]

	distinct = get_distinct(data)
	print 'distinct done'
	matriz = mock_matriz(distinct)
	print 'matriz mocked'

	indexes = map(lambda a: a, enumerate(distinct))
	print 'indexes'

	for row in data:
		x = get_index(row[0], indexes)
		y = get_index(row[1], indexes)
		matriz[x][y] = row[2]
		matriz[y][x] = row[2]

	for i in matriz:
		print i

	dijsktra(matriz, 'a', distinct)

def calculate_distance(p1, p2):
	soma = 0
	for i in range(len(p1)):
		v1 = float(p1[i])
		v2 = float(p2[i])
		soma = soma + (v2 - v1)**2
	distancia = math.sqrt(soma)
	return distancia

def read_file(fname):
	return open(fname, 'r').readlines()

def parse_vertices(lines):
	values = []
	for line in lines[1:]:
		if 'arestas' in line:
			return values[:-1]
		else:
			values.append(get_tuple_from_line(line))

def parse_arestas(lines, start):
	return map(lambda line: get_tuple_from_line(line),  lines[start:])

def get_tuple_from_line(line):
	value = line.split(' ')
	return (value[0], value[1].replace('\n',''))

def mock_matriz(distinct):
	h = len(distinct)
	return [[0 for x in range(h)] for x in range(h)] 

def get_index(val, indexes):
    return filter(lambda v : v[1] == val, indexes)[0][0]

def get_distinct(data):
	distinct = []
	for row in data:
		if row[0] not in distinct:
			distinct.append(row[0])
		if row[1] not in distinct:
			distinct.append(row[1])
	return distinct

if __name__ == '__main__':
	main()

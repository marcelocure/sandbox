

def dijkstra(graph, initial, distinct):
    fila = [initial]
    data = map(lambda val: (val, -1, False, None), distinct)
    choosen = initial

    while fila is not None:
        if is_visited(data, choosen):
            distinct.remove(choosen)
            if len(distinct) > 0:
                choosen = distinct[0]
            else:
                fila = None
        else:
            for child in get_children_vertices(graph, choosen):
                fila.append(choosen)
                custo = get_distance(data, choosen) + get_cost(graph, choosen, child)
                if custo < get_child_cost(child):
                    data = update_response(data, choosen, custo)
                    data = update_previous(data, choosen, get_child_name(child))
            data = update_visited(data, choosen)

    reverse_list = get_reverse_list(data)

    for d in reverse_list:
        print d

    shortest_path = ShortestPath(reverse_list, 'a')
    shortest_path.calculate_path()
    print 'shortest path {0}'.format(shortest_path.path)
    print shortest_path.cost


class ShortestPath(object):
    def __init__(self, reverse_list, dest):
        self.reverse_list = reverse_list
        self.dest = dest
        self.path = []
        self.cost = 0

    def calculate_path(self):
        row = self.reverse_list[0]
        self.reverse_list.pop(0)
        if row[0] != self.dest:
            self.path.append(row[0])
            self.cost = self.cost + 1
            return self.calculate_path()


def get_reverse_list(input_list):
    rev = []
    list_len = len(input_list) - 1
    for i in range(list_len, -1, -1):
        rev.append(input_list[i])
    return rev


def update_visited(data, val):
    for i, row in enumerate(data):
        if row[0] == val:
            data[i] = (row[0], row[1], True, row[3])
            return data


def update_response(data, val, cost):
    for i, row in enumerate(data):
        if row[0] == val:
            data[i] = (row[0], cost, row[2], row[3])
            return data


def update_previous(data, val, previous):
    for i, row in enumerate(data):
        if row[0] == val:
            data[i] = (row[0], row[1], row[2], previous)
            return data


def get_child_cost(child):
    return child.values()[0]


def get_child_name(child):
    return child.keys()[0]


def get_cost(graph, orig, dest):
    children = get_children_vertices(graph, orig)
    cost = -1
    for child in children:
        try:
            cost = child[dest.keys()[0]]
        except:
            pass
    return cost


def get_children_vertices(graph, val):
    for i in graph:
        if val in i.keys():
            return i[val]
    return None


def get_row(data, val):
    return filter(lambda d: d[0] == val, data)


def is_visited(data, val):
    row = get_row(data, val)
    return row[0][2]


def get_distance(data, val):
    row = get_row(data, val)
    return row[0][1]


def build_data():
    data = []
    data.append(('a', 'b', 1))
    data.append(('a', 'c', 2))
    data.append(('b', 'd', 3))
    data.append(('b', 'e', 8))
    data.append(('c', 'd', 6))
    data.append(('c', 'e', 3))
    data.append(('d', 'e', 5))
    data.append(('d', 'f', 8))
    data.append(('d', 'g', 1))
    data.append(('e', 'f', 2))
    data.append(('f', 'g', 2))
    data.append(('g', 'h', 3))
    data.append(('g', 'i', 1))
    data.append(('g', 'j', 4))
    data.append(('h', 'f', 2))
    data.append(('h', 'g', 1))
    data.append(('i', 'j', 3))
    data.append(('i', 'g', 5))
    data.append(('j', 'g', 2))
    return data


def main():
    data = build_data()
    distinct = get_distinct(data)
    graph = map(lambda current: get_children(data, current), distinct)
    dijkstra(graph, 'a', distinct)


def get_children(data, current):
    children = {current: []}
    content = []
    for i in data:
        if i[0] == current:
            content.append({i[1]: i[2]})
    children[current] = content
    return children


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

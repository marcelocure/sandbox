class BinnarySearch(object):
	comparisons = 0
	
	def do(self, data_list, value_to_find):
		self.comparisons = self.comparisons + 1
		mid = self.get_middle_index(data_list)
		
		if data_list[mid] < value_to_find:
			return self.do(data_list[mid:], value_to_find)
		elif data_list[mid] > value_to_find:
			return self.do(data_list[:mid], value_to_find)
		return data_list[mid]

	def get_middle_index(self, data_list):
		return int(round(len(data_list)/2))


def generate_big_list(list_size):
	return range(1, list_size)

def main():
	binnary_search = BinnarySearch()
	result = binnary_search.do(data_list=generate_big_list(10), value_to_find=10)
	print '{0} comparisons made to reach the result: {1}'.format(binnary_search.comparisons, result)

if __name__ == '__main__':
	main()

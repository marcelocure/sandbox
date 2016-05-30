IO.puts "Hello world from Elixir"
add = fn a, b -> a + b end
a = add.(1,2)
IO.puts a
IO.puts "lists"

b = [true, false, 1, "abc"]
b
length b

c = ["a", "b", "c"]
c
d = b -- c
e = b ++ c

hd(d)
tl(d)


IO.puts "tuples"

myTuple = {:ok, "hello"}

IO.puts elem(myTuple, 1)


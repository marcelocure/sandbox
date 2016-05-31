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

people = File.read("/home/mcure/github/sandbox/elixir/people.json")
IO.puts elem(people, 1)

err = File.read("dsaisadoasdiojasd")
IO.puts elem(err, 1)


IO.puts "pattern matching"
{a, b, c} = {true, false, "77"}

IO.puts a
IO.puts b
IO.puts c

IO.puts "Advanced pattern matching"
case {1, 2, 3} do
   {4, 5, 6} -> IO.puts "This clause won't match"
   {1, x, 3} -> IO.puts "This clause will match and bind x to 2 in this clause"
   _ ->  IO.puts "This clause would match any value"
end

case {1, 2, 3} do
   {1, x, 3} when x > 0 -> IO.puts "Will match"
   _ -> IO.puts "Would match, if guard condition were not satisfied"
end

cond do
  2 + 2 == 5 -> IO.puts "This will not be true"
  2 * 2 == 3 -> IO.puts "Nor this"
  1 + 1 == 2 -> IO.puts "But this will"
end

if nil do
   IO.puts "false!"
else
   IO.puts "else is true"
end

unless true do
   IO.puts "This will never be seen"
end

if true, do: IO.puts "yeah yeah"

if false, do: IO.puts "if", else: IO.puts "else"

IO.puts "Maps"

map = %{:a => 1, 2 => :b}
IO.puts map[:a]
IO.puts map[2]
IO.puts map[:c]

IO.puts "Modules"
defmodule PeopleService do
  def get(id) do
    IO.puts id
  end
end

IO.puts PeopleService.get(1)

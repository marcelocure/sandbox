factorial :: Int -> Int
factorial n = 
	if n == 0 then 1 else n * factorial (n-1)

fibonnaci :: Int -> Int
fibonnaci n = 
	if n <= 1 then 1 else fibonnaci (n-1) + fibonnaci (n-2)

--main = print (factorial 6)
main = print (fibonnaci 40)
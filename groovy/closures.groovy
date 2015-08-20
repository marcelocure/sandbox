def sayHellYeah = {println "Hell Yeahh!!!"}
sayHellYeah()

def increment2 = {a -> return a+2}
println increment2(2)

def x = 5
def multiplyBy = { num -> num * x }
println multiplyBy(10)

def clos = { print it }
clos("heeeey")
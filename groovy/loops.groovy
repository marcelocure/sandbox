def x = 0
for (i in 0 .. 30) {
    x += i
}
println x

for( i in [5,3,2,1] ) {
    x += i
}
println x

array = (0..20).toArray()
x = 0
for (i in array) {
    x += i
}
println x

def map = ['1':'red', '2':'blue', '3':'green']
x = ""
for ( e in map ) {
    x += e.value + " "
}
println x
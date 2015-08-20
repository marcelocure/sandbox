def x = 3

if(x==1) {
    println "One"
} else if(x==2) {
    println "Two"
} else {
    println "X greater than Two"
}

def y = 10
x = (y > 1) ? "worked" : "failed"
assert x == "worked"
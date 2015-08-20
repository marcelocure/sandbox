def drugs = [:]
drugs = ["1":"paracetamol", "2":"vioxx", "3":"viagra", "4":"diazepan"]
drugs.each { println "$it.key: $it.value"}
drugs.eachWithIndex {it, i -> println "$i: $it"}
assert drugs.containsKey("3")
assert drugs.containsValue("vioxx")
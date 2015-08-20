def technologies = []
technologies.add("java")
technologies.clear()
println technologies
technologies.add("java")
technologies.add("python")
technologies.add("ruby")
technologies.add("Haskell")
technologies.add("C")
technologies.add("swift")
technologies << ".NET"
technologies.addAll(["f#", "scala"])
println technologies
technologies.each {println "Technology: $it"}
technologies.eachWithIndex {it, i -> println "$i, $it"}
println technologies.contains("scala")
technologies.sort()
println technologies
sortedTechnologies = technologies.sort( false )
Collections.replaceAll(technologies, "Haskell", "haskell")
println technologies
Collections.shuffle(technologies, new Random())
println technologies
technologies*.toUpperCase()
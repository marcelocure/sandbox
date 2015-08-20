class Person {
    final String name = "Marcelo"
    String lastName
    protected void setLastName(String lastName) { this.lastName = lastName }
    
    def sex
}

myself = new Person()
myself.setLastName("Cure")
myself.sex = 'M'

println myself
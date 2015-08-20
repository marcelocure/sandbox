class User {
    String username
    String password
}

def users = [new User(username: "john", password: "1111"), new User(password:"2222")]

//users.get(3)
def username1 = users.get(1).username
println users.get(1).username
println users.get(1).username?.ToString() //? avoids NPE
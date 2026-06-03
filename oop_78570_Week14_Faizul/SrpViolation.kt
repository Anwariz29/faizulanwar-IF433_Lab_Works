package oop_78570_Week14_Faizul

data class User(val name: String, val email: String, val age: Int)

class UserMAnager {
    //Business logic
    fun validateUSer(user: User): Boolean {
        return user.email.contains("@") && user.age >= 18
    }

    //Database access
    fun saveToDatabase(user: User) {
        println("INSERT INTO users VALUES ('${user.name}', '${user.email}')")
    }

    // Email notification
    fun sendWelcomeEmail(user: User) {
        println("sending email to: ${user.name}")

    }
}
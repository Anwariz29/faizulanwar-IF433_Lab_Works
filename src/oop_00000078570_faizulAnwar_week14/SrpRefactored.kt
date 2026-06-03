package oop_00000078570_faizulAnwar_week14

class UserRepostory {
    fun save (user: User) {
        println("Saving user: ${user.name} to Database")
    }
}

class EmailService {
    fun sendWelcome(user: User) {
        println("welcome email -> ${user.email}")
    }
}


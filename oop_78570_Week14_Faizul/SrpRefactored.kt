package oop_78570_Week14_Faizul

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


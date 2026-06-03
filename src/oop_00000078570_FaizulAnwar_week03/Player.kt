package oop_00000078570_FaizulAnwar_week03

class Player(val name: String) {
    var xp: Int = 0
        private set
    var level: Int = 1
        private set

    fun addXp(amount: Int) {
        if (amount > 0) {
            xp += amount
            checkLevelUp()
        }
    }

    private fun checkLevelUp() {
        while (xp >= level * 100) {
            level++
        }
    }
}

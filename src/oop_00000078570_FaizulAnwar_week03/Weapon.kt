package oop_00000078570_FaizulAnwar_week03

class Weapon(
    val name: String,
    damage: Int
) {

    var damage: Int = damage
        set(value) {
            if (value < 0) {
                println("Peringatan: Damage tidak boleh negatif! Nilai tidak diubah.")
            } else if (value > 1000) {
                println("Damage terlalu besar! Diset menjadi 1000.")
                field = 1000
            } else {
                field = value
            }
        }

    val tier: String
        get() = when {
            damage > 800 -> "Legendary"
            damage > 500 -> "Epic"
            else -> "Common"
        }
}
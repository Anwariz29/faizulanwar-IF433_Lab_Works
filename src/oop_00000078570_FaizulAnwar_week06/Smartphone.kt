package oop_00000078570_FaizulAnwar_week06

class Smartphone : Camera, Phone {
    override fun turnOn() {
        super<Phone>.turnOn()
        super<Camera>.turnOn()
        println("Sistem operasi Smartphone berhasil booting")
    }
}
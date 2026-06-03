package oop_00000078570_FaizulAnwar_week06

class SmartCCTV(
    override val id: String,
    override val name: String
) : SmartDevice, Switchable, Recordable {

    override fun turnOn() {
        println("$name dinyalakan.")
        startRecord()   // otomatis mulai merekam
    }

    override fun turnOff() {
        println("$name dimatikan.")
        stopRecord()    // menggunakan default function dari Recordable
    }

    override fun startRecord() {
        println("$name mulai merekam.")
    }
}
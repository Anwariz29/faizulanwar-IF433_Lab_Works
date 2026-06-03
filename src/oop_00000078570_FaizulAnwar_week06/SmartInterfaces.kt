package oop_00000078570_FaizulAnwar_week06

interface SmartDevice {
    val id: String
    val name: String
}

// Interface untuk perangkat yang bisa dinyalakan / dimatikan
interface Switchable {
    fun turnOn()
    fun turnOff()
}

// Interface untuk perangkat yang bisa merekam
interface Recordable {
    fun startRecord()

    // default function
    fun stopRecord() {
        println("Perekaman dihentikan dan disimpan ke Cloud.")
    }
}
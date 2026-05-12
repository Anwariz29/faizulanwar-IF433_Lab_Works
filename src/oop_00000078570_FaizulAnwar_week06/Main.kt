package oop_00000078570_FaizulAnwar_week06

fun processCheckout(method: PaymentMethod, amount: Double) {
    println("-> Memulai checkout...")
    method.pay(amount)
}

fun main() {
    val myWatch = Smartwatch()
    myWatch.showTime()

    val myPhone = Smartphone()
    myPhone.turnOn()

    val pay1 = Gopay()
    val pay2 = CreditCard()

    val hub = SmartHomeHub()

    // Instansiasi perangkat
    val lamp = SmartLamp("L001", "Ruang Tamu")
    val speaker = SmartSpeaker("S001", "Google Nest Dapur")
    val cctv = SmartCCTV("C001", "Ezviz Garasi")

    // Menambahkan perangkat ke SmartHomeHub
    hub.addDevice(lamp)
    hub.addDevice(speaker)
    hub.addDevice(cctv)


    println("\n=== Mengaktifkan Security Mode ===")
    hub.activateSecurityMode()

    println("\n=== Mematikan Semua Switchable Device ===")
    hub.turnOffAllSwitches()

    println("\n=== TESTING CHECKOUT ===")
    processCheckout(pay1, 50000.0)
    processCheckout(pay2, 150000.0)
}
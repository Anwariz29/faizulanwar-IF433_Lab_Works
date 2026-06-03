package oop_00000078570_FaizulAnwar_week05

fun main() {
    val dosen1 = Dosen("pak Alex", "0123456")
    val admin1 = Admin("Bu Siti")

    val daftarPegawai: List<Pegawai> = listOf(dosen1, admin1)

    println("=== AKTIVASI PEGAWAI ===")
    for (pegawai in daftarPegawai) {
        pegawai.bekerja()

        when (pegawai) {
            is Dosen -> {
                println("=> Terdeteksi sebagai DOsen (NIDN: ${pegawai.nidn}")
                pegawai.mengajar()
            }
            is Admin -> {
                println("=> Terdeteksi sebagai Admin")
                pegawai.doAdminWork()
            }
        }
        println("-------------------------")
    }

    val eWallet = EWallet("Faizul", 50000.0)
    val creditCard = CreditCard("Faizul", 100000.0)

    val paymentMethods: List<PaymentMethod> = listOf(eWallet, creditCard)

    for (method in paymentMethods) {

        println("Memproses pembayaran sebesar 75000.0")
        method.processPayment(75000.0)

        // Smart Casting menggunakan is
        if (method is EWallet) {
            println("Terdeteksi EWallet → Melakukan Top Up 50000.0")
            method.topUp(50000.0)

            println("Mencoba pembayaran lagi...")
            method.processPayment(75000.0)
        }

        println("-----------------------------")
    }
}
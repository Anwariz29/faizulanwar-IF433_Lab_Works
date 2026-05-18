package oop_00000078570_FaizulAnwar_week13

data class TradeRecord(
    val id: Int,
    val symbol: String,
    val type: String,
    val margin: Double,
    val pnl: Double
)

fun TradeRecord.toCsv(): String {
    return "$id,$symbol,$type,$margin,$pnl"
}

// Contoh fungsi main untuk mensimulasikan penggunaan model data
fun main() {
    println("=== Inisialisasi Log Transaksi Kripto ===")

    // Membuat contoh objek TradeRecord
    val trade1 = TradeRecord(1, "BTCUSDT", "LONG", 150.0, 45.25)
    val trade2 = TradeRecord(2, "ETHUSDT", "SHORT", 200.0, -12.50)

    // Menampilkan data ke konsol
    println(trade1)
    println(trade2)
}
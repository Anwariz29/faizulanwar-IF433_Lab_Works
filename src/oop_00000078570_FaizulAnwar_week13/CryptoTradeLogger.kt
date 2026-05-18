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

fun fromCsvTrade(line: String): TradeRecord? {
    return try {
        // Memisahkan string berdasarkan koma
        val tokens = line.split(",")

        // Validasi jumlah kolom (harus tepat 5 kolom sesuai struktur TradeRecord)
        if (tokens.size != 5) return null

        // Parsing setiap elemen dengan aman
        val id = tokens[0].trim().toInt()
        val symbol = tokens[1].trim()
        val type = tokens[2].trim()
        val margin = tokens[3].trim().toDouble()
        val pnl = tokens[4].trim().toDouble()

        // Mengembalikan objek TradeRecord jika semua berhasil
        TradeRecord(id, symbol, type, margin, pnl)
    } catch (e: Exception) {
        // Menangkap NumberFormatException atau error parsing lainnya tanpa merusak eksekusi aplikasi
        null
    }
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
package oop_00000078570_FaizulAnwar_week13
import java.io.File
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
        // Seluruh proses pemisahan teks berada di dalam blok try
        val tokens = line.split(",")

        // Memaksa pengecekan indeks secara manual atau membiarkan IndexOutOfBoundsException
        // terjadi jika kolom kurang, yang nantinya akan ditangkap oleh blok catch.
        val id = tokens[0].trim().toInt()
        val symbol = tokens[1].trim()
        val type = tokens[2].trim()
        val margin = tokens[3].trim().toDouble()
        val pnl = tokens[4].trim().toDouble()

        TradeRecord(id, symbol, type, margin, pnl)
    } catch (e: Exception) {
        // Menangkap segala bentuk Exception (NumberFormatException, IndexOutOfBoundsException, dll)
        println("(Log) Data korup diabaikan: $line")
        null
    }
}

fun saveTrades(trades: List<TradeRecord>, path: String) {
    try {
        // Membuka PrintWriter secara aman. File akan otomatis di-close setelah blok selesai.
        File(path).printWriter().use { writer ->
            trades.forEach { trade ->
                // Menulis hasil dari extension function toCsv() ke dalam file
                writer.println(trade.toCsv())
            }
        }
        println("(Log) Berhasil menyimpan ${trades.size} data transaksi ke $path")
    } catch (e: Exception) {
        println("(Log) Gagal menyimpan data ke file: ${e.message}")
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
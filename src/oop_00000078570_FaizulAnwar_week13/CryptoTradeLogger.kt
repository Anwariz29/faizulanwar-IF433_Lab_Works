package oop_00000078570_FaizulAnwar_week13
import java.io.File
import java.io.FileNotFoundException

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

fun loadTrades(path: String): List<TradeRecord> {
    return try {
        // 1. Membaca seluruh baris teks di dalam file
        // 2. Melakukan mapping dan otomatis mengabaikan nilai null (data korup)
        File(path).readLines().mapNotNull { line ->
            fromCsvTrade(line)
        }
    } catch (e: FileNotFoundException) {
        println("(Log) Peringatan: File $path tidak ditemukan. Membuat daftar kosong baru.")
        emptyList()
    } catch (e: Exception) {
        println("(Log) Gagal membaca file karena kesalahan sistem: ${e.message}")
        emptyList()
    }
}

// Contoh fungsi main untuk mensimulasikan penggunaan model data
fun main() {
    val filePath = "crypto_trades.csv"

    println("=== [1] INSIALISASI MOCK DATA ===")
    val mockTrades = listOf(
        TradeRecord(1, "BTCUSDT", "LONG", 250.0, 45.80),
        TradeRecord(2, "ETHUSDT", "SHORT", 150.0, -12.50)
    )

    // Simpan data awal yang valid
    saveTrades(mockTrades, filePath)
    println("--------------------------------------------------")

    // ==========================================================
    // 8. INJECTING MALFORMED DATA (Penyuntikan Data Kotor)
    // ==========================================================
    println("=== [2] INJECTING MALFORMED DATA ===")

    // Menyuntikkan baris data yang rusak total (Format ID salah, margin 'XX', pnl 'YY')
    File(filePath).appendText("CORRUPT_ID,DOGEUSDT,Hold,XX,YY\n")

    println("(Log) Baris kotor berhasil disuntikkan ke dalam file $filePath")
    println("--------------------------------------------------")

    println("=== [3] DEMONSTRASI KEANDALAN SISTEM (LOAD SYSTEM) ===")
    // Membaca kembali file yang kini telah terkontaminasi data rusak
    val loadedTrades = loadTrades(filePath)

    println("\n=== RINGKASAN DASHBOARD TRADING ===")
    println("Total transaksi valid yang berhasil dimuat: ${loadedTrades.size}")

    // Tampilkan data yang berhasil diselamatkan
    loadedTrades.forEach { println("Data Selamat -> $it") }

    // Melakukan kalkulasi aman
    val totalPnL = loadedTrades.sumOf { it.pnl }
    println("Total Net PnL dari data valid: $totalPnL USDT")
    println("==================================================")
}
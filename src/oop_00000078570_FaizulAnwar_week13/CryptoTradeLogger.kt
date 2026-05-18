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

    println("=== [1] MOCK DATA SETUP ===")
    // Mendefinisikan riwayat trade simulasi sesuai instruksi
    val mockTrades = listOf(
        TradeRecord(1, "BTCUSDT", "LONG", 250.0, 45.80),
        TradeRecord(2, "ETHUSDT", "SHORT", 150.0, -12.50),
        TradeRecord(3, "SOLUSDT", "LONG", 100.0, 28.20)
    )
    mockTrades.forEach { println("Simulasi Trade -> $it") }
    println("--------------------------------------------------")

    println("=== [2] EXECUTING SAVE SYSTEM ===")
    // Menyimpan data ke "crypto_trades.csv"
    saveTrades(mockTrades, filePath)
    println("--------------------------------------------------")

    // --- Simulasi Kontaminasi Data (Opsional untuk pembuktian Robustness) ---
    // Kita sengaja menyuntikkan data rusak ke dalam file di luar sistem aplikasi
    println("=== [3] INJECTING CORRUPTED DATA (SIMULATION) ===")
    File(filePath).appendText("\n4,BNBUSDT,LONG,CACAT_ANGGA,5.5\n")
    File(filePath).appendText("5,DOTUSDT,SHORT\n") // Kurang kolom
    File(filePath).appendText("6,ADAUSDT,LONG,50.0,12.40\n") // Valid kembali
    println("(Log) File $filePath telah dikontaminasi dengan 2 baris data rusak.")
    println("--------------------------------------------------")

    println("=== [4] EXECUTING LOAD SYSTEM & DASHBOARD RECAP ===")
    // Memuat kembali data transaksi (Sistem harus melakukan Safe Skip)
    val loadedTrades = loadTrades(filePath)

    println("\n=== DASHBOARD STRATEGI SCALPING ===")
    println("Total Posisi Terproses (Valid) : ${loadedTrades.size}")

    // Rekapitulasi total Margin dan PnL
    val totalMargin = loadedTrades.sumOf { it.margin }
    val totalPnL = loadedTrades.sumOf { it.pnl }
    val winRate = (loadedTrades.count { it.pnl > 0 }.toDouble() / loadedTrades.size) * 100

    println("Total Akumulasi Margin        : $totalMargin USDT")
    println("Net Profit & Loss (PnL)       : $totalPnL USDT")
    System.out.printf("Win Rate Strategi             : %.2f%%\n", winRate)
    println("==================================================")
}
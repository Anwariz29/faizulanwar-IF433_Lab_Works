package oop_00000078570_faizulAnwar_week14

class khs_mahasiswa {
    fun hitung_tugas(quiz: Double, tugasharian: Double): Double {
        return (quiz * 0.3) + (tugasharian * 0.7)
    }

    fun hitung_na(tugas: Double, uts: Double, uas: Double): Double {
        return (tugas * 0.3) + (uts * 0.3) + (uas * 0.4)
    }
}
class khs_db {
    fun simpan_nilai(nim:String, nama:String, na:Double): String {
        return "nilai $nim $nama dengan nilai $na berhasil disimpan";
    }
    fun load_nilai(nim:String): String {
        return "load nilai si $nim berhasil";
    }
}

fun main() {
    val khsMhs = khs_mahasiswa();
    val tugasMhs = khsMhs.hitung_tugas(quiz = 83.5, tugasharian = 90.78);
    val naMhs = khsMhs.hitung_na(tugasMhs, uts = 70.56, uas = 68.77);
    val kshDB = khs_db();
    val statSimpan = kshDB.simpan_nilai(nim ="123", nama = "Luffy",naMhs);
    println(statSimpan)
}
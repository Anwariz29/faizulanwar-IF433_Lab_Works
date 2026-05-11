package oop_00000078570_FaizulAnwar_week02

class Student (
    val name: String,
    val nim: String,
    var gpa: Double = 0.0,
    var major: String
){
    init {
        if (nim.length != 5) {
            println("WARNING: Objek tercipta dengan NIM ($nim) yang tidak valid!")
            println("Data mahasiswa $name mungkin akan bermasalah di sistem. ")
        } else {
            println("LOG: objek student $name berhasil dialokasikan di Memory.")
        }
    }
}
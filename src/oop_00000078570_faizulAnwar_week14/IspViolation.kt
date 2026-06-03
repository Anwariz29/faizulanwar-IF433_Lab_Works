package oop_00000078570_faizulAnwar_week14

interface MultifunctionDevice {
    fun print(doc: String)
    fun scan(doc: String): String
    fun fax(doc: String)
}

class SimplePrinter : MultifunctionDevice {
    override fun print(doc: String) = println("Printing: $doc")
    override fun scan(doc: String) = throw UnsupportedOperationException("No scanner")
    override fun fax(doc: String) = throw UnsupportedOperationException("No fax")
}
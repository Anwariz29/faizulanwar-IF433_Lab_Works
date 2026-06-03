package oop_78570_Week14_Faizul

open class Rectangle {
    open var width: Int = 0
    open var height: Int = 0
    fun area() = width * height
}

class square : Rectangle() {
    override var width: Int = 0
        set (value) { field = value; super.height = value }
    override var height: Int = 0
        set (value) { field = value; super.width = value }
}
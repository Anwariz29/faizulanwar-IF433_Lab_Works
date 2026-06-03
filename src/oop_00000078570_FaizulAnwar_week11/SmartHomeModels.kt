package oop_00000078570_FaizulAnwar_week11

data class SmartDevice(
    var name: String,
    var category: String,
    var isOnline: Boolean = false,
    var powerLoad: Int = 0
)

fun SmartDevice.diagnose(): String {
    val status = if (isOnline) "Online" else "Offline"
    return "[DIAGNOSTIK] $name | Kategori: $category | Status: $status | Daya: $powerLoad Watt"
}
package oop_00000078570_faizulAnwar_week14
import java.io.File



// =======================
// DATA CLASS
// =======================
data class Order(
    val itemName: String,
    val finalPrice: Double,
    val pricingType: String
)


// =======================
// PRICING STRATEGY (OCP)
// =======================
interface PricingStrategy {
    fun calculate(price: Double): Double
    fun getType(): String
}


// =======================
// REGULAR PRICING
// =======================
class RegularPricing : PricingStrategy {

    override fun calculate(price: Double): Double {
        return price
    }

    override fun getType(): String {
        return "REGULAR"
    }
}


// =======================
// VIP PRICING
// =======================
class VipPricing : PricingStrategy {

    override fun calculate(price: Double): Double {
        return price * 0.90
    }

    override fun getType(): String {
        return "VIP"
    }
}


// =======================
// ORDER REPOSITORY (DIP)
// =======================
interface OrderRepository {
    fun saveOrder(order: Order)
}


// =======================
// CSV ORDER REPOSITORY
// =======================
class CsvOrderRepository(
    private val fileName: String = "Orders.csv"
) : OrderRepository {

    override fun saveOrder(order: Order) {

        val file = File(fileName)

        // Safe Resource Handling menggunakan use
        file.outputStream().bufferedWriter().use { writer ->

            writer.append(
                "${order.itemName}," +
                        "${order.finalPrice}," +
                        "${order.pricingType}\n"
            )
        }
    }
}


// =======================
// NOTIFICATION SERVICE
// =======================
interface NotificationService {
    fun sendNotification(message: String)
}


// =======================
// EMAIL NOTIFIER
// =======================
class EmailNotifier : NotificationService {

    override fun sendNotification(message: String) {
        println("Email terkirim: $message")
    }
}


// =======================
// SAFE ORDER PROCESSOR
// =======================
class SafeOrderProcessor(
    private val repo: OrderRepository,
    private val notifier: NotificationService
) {

    fun processOrder(
        itemName: String,
        basePrice: Double,
        pricingStrategy: PricingStrategy
    ) {

        // Menggunakan strategy
        val finalPrice = pricingStrategy.calculate(basePrice)

        println(
            "Memproses pesanan $itemName " +
                    "seharga Rp$finalPrice"
        )

        val order = Order(
            itemName = itemName,
            finalPrice = finalPrice,
            pricingType = pricingStrategy.getType()
        )

        // Simpan ke repository
        repo.saveOrder(order)

        // Kirim notifikasi
        notifier.sendNotification(
            "Pesanan $itemName Anda telah dikonfirmasi"
        )
    }
}


// =======================
// MAIN
// =======================
fun main() {

    val repository = CsvOrderRepository()
    val notifier = EmailNotifier()

    val processor = SafeOrderProcessor(
        repo = repository,
        notifier = notifier
    )

    // REGULAR
    processor.processOrder(
        itemName = "Keyboard Mechanical",
        basePrice = 500000.0,
        pricingStrategy = RegularPricing()
    )

    println()

    // VIP
    processor.processOrder(
        itemName = "Laptop Gaming",
        basePrice = 15000000.0,
        pricingStrategy = VipPricing()
    )
}
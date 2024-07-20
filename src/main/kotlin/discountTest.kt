import kotlin.math.max

const val ERROR_LIMIT = -2
const val ERROR_TYPE = -1



fun main() {
    println(commission("Visa", 1000, 0, true))
}

fun commission(
    typeCard: String,
    transfer: Int,
    previous: Int,
    offer: Boolean
): Int {
    if (typeCard == "Vk pay") {
        return if (transfer > 15_000 || transfer + previous > 40_000) {
            ERROR_LIMIT
        } else {
            0
        }
    } else {
        if (transfer > 150_000 || transfer + previous > 500_000) {
            return ERROR_LIMIT
        } else {
            return when (typeCard) {
                "Visa", "Мир" -> max(35, (transfer * 0.0075).toInt())
                "Mastercard", "Maestro" -> if (offer && transfer + previous in 300..75000) {
                    0
                } else {
                    (transfer * 0.006 + 20).toInt()
                }

                else -> ERROR_TYPE
            }
        }
    }
}



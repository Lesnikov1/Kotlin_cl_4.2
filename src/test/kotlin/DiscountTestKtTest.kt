import org.junit.Test
import kotlin.test.assertEquals


class DiscountTestKtTest {

    @Test
    fun commissionLimit1Vk() {
        val typeCard: String = "Vk pay"
        val transfer: Int = 15_000
        val previous: Int = 15_000
        val offer: Boolean = true

        val result = commission(typeCard = typeCard, transfer = transfer, previous = previous, offer)

        assertEquals(100, result)
    }

    @Test
    fun commissionLimit2Vk() {
        val typeCard: String = "Vk pay"
        val transfer: Int = 16_000
        val previous: Int = 0
        val offer: Boolean = true

        val result = commission(typeCard = typeCard, transfer = transfer, previous = previous, offer)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun commissionNoLimitVk() {
        val typeCard: String = "Vk pay"
        val transfer: Int = 15_000
        val previous: Int = 30_000
        val offer: Boolean = true

        val result = commission(typeCard = typeCard, transfer = transfer, previous = previous, offer)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun commissionVisaMir() {
        val typeCard: String = "Visa"
        val transfer: Int = 100_000
        val previous: Int = 100_000
        val offer: Boolean = true

        val result = commission(typeCard = typeCard, transfer = transfer, previous = previous, offer)

        assertEquals(758, result)
    }

    @Test
    fun commissionVisaMirLimit1() {
        val typeCard: String = "Visa"
        val transfer: Int = 200_000
        val previous: Int = 0
        val offer: Boolean = true

        val result = commission(typeCard = typeCard, transfer = transfer, previous = previous, offer)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun commissionVisaMirLimit2() {
        val typeCard: String = "Visa"
        val transfer: Int = 0
        val previous: Int = 600_000
        val offer: Boolean = true

        val result = commission(typeCard = typeCard, transfer = transfer, previous = previous, offer)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun noCommissionMastercardMaestro() {
        val typeCard: String = "Mastercard"
        val transfer: Int = 300
        val previous: Int = 300
        val offer = true

        val result = commission(typeCard = typeCard, transfer = transfer, previous = previous, offer)

        assertEquals(0, result)
    }

    @Test
    fun CommissionMastercardMaestro1() {
        val typeCard: String = "Mastercard"
        val transfer: Int = 0
        val previous: Int = 0
        val offer = true

        val result = commission(typeCard = typeCard, transfer = transfer, previous = previous, offer)

        assertEquals(20, result)
    }

    @Test
    fun CommissionMastercardMaestro2() {
        val typeCard: String = "Mastercard"
        val transfer: Int = 40_000
        val previous: Int = 40_000
        val offer = true

        val result = commission(typeCard = typeCard, transfer = transfer, previous = previous, offer)

        assertEquals(260, result)
    }

    @Test
    fun CommissionMastercardMaestro3() {
        val typeCard: String = "Mastercard"
        val transfer: Int = 40_000
        val previous: Int = 40_000
        val offer = false

        val result = commission(typeCard = typeCard, transfer = transfer, previous = previous, offer)

        assertEquals(260, result)
    }

    @Test
    fun CommissionPay() {
        val typeCard: String = "Pay"
        val transfer: Int = 300
        val previous: Int = 300
        val offer = true

        val result = commission(typeCard = typeCard, transfer = transfer, previous = previous, offer)

        assertEquals(ERROR_TYPE, result)
    }


}
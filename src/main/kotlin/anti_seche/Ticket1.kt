package anti_seche

import java.time.LocalDateTime

class Ticket1(val immatriculation: String, val horloge: LocalDateTime) {
    var dateInterne: LocalDateTime? = null
    val horodatage: LocalDateTime?
        get() {
            return dateInterne
        }

    fun creer() {
//        dateInterne = LocalDateTime.now()
        dateInterne = horloge
    }

    fun Payer(i: Int) {

    }
}



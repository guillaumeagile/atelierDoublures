package exercice_1

import java.time.LocalDateTime

class Ticket1(val immatriculation: String, val horloge: LocalDateTime) {
    var dateInterne: LocalDateTime? = null
    val horodatage: LocalDateTime?
        get() {
            return dateInterne
        }

    fun imprime() {
//        dateInterne = LocalDateTime.now()
        dateInterne = horloge
    }
}



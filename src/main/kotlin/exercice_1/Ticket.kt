package exercice_1

import java.time.LocalDateTime

class Ticket(immatriculation: String) {

    var dateInterne : LocalDateTime? = null

    val horodatage : LocalDateTime?
        get() {
            return dateInterne
        }

    fun imprime() {
        dateInterne = LocalDateTime.now()
    }

}

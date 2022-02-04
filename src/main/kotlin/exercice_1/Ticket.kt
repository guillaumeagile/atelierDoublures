package exercice_1

import java.time.LocalDateTime

class Ticket(immatriculation: String) {

    val horodatage : LocalDateTime?
        get() {
            return LocalDateTime.now()
        }

    fun imprime() {

    }

}

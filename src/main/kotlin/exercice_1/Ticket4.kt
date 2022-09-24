package exercice_1

import exercice_1.behaviors.Horloge
import java.time.LocalDateTime

class Ticket4(val immatriculation: String,
               val horlogeExterne: Horloge = HorlogeExterne()
) {
    var dateInterne: LocalDateTime? = null
    val horodatage: LocalDateTime?
        get() {
            return dateInterne
        }

    fun imprime() {
        dateInterne = horlogeExterne.now()
    }
}
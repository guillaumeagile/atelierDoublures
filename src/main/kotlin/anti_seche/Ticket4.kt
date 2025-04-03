package anti_seche

import exercice_0.HorlogeSystème
import anti_seche.behaviors.Horloge
import java.time.LocalDateTime

class Ticket4(val immatriculation: String,
              val horlogeExterne: Horloge = HorlogeSystème()
) {
    var dateInterne: LocalDateTime? = null
    val horodatage: LocalDateTime?
        get() {
            return dateInterne
        }

    fun creer() {
        dateInterne = horlogeExterne.maintenant()
    }
}
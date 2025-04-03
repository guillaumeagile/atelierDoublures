package anti_seche

import anti_seche.behaviors.Horloge
import anti_seche.services.FausseHorloge
import exercice_0.HorlogeSystème
import java.time.LocalDateTime

class Ticket3(val immatriculation: String) {

    private var horlogeExterne: Horloge = HorlogeSystème() //  // point de départ vers une abstraction

    var dateInterne: LocalDateTime? = null

    fun imprime() {
        dateInterne = horlogeExterne.maintenant()
    }

    fun environementDeTest() {
        horlogeExterne = FausseHorloge()
    }
}
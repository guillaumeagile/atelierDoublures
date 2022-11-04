package anti_seche

import exercice_0.HorlogeSysteme
import anti_seche.behaviors.Horloge
import anti_seche.services.StubHorloge
import java.time.LocalDateTime

class Ticket3(val immatriculation: String) {

    private var horlogeExterne: Horloge = HorlogeSysteme()  // point de départ vers une abstraction

    var dateInterne: LocalDateTime? = null

    fun imprime() {
        dateInterne = horlogeExterne.maintenant()
    }

    fun environementDeTest() {
        horlogeExterne = StubHorloge()
    }
}
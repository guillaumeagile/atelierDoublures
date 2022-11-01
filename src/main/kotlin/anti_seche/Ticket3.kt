package anti_seche

import exercice_0.HorlogeExterne
import anti_seche.behaviors.Horloge
import anti_seche.services.StubHorloge
import java.time.LocalDateTime

class Ticket3(val immatriculation: String) {

    private var horlogeExterne: Horloge = HorlogeExterne()  // point de départ vers une abstraction

    var dateInterne: LocalDateTime? = null
    val horodatage: LocalDateTime?
        get() {
            return dateInterne
        }

    fun imprime() {
        dateInterne = horlogeExterne.now()
    }

    fun environementDeTest() {
        horlogeExterne = StubHorloge()
    }
}
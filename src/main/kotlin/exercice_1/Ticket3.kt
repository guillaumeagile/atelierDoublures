package exercice_1

import exercice_1.behaviors.Horloge
import exercice_1.services.StubHorloge
import java.time.LocalDateTime

class Ticket3(val immatriculation: String) {
    private var horlogeExterne: Horloge = HorlogeExterne()  // valeur par défaut
    var dateInterne: LocalDateTime? = null
    val horodatage: LocalDateTime?
        get() {
            return dateInterne
        }

    fun imprime() {
        dateInterne = horlogeExterne.now()
    }

    // etonnant... du code de test en prod???
    fun environementDeTest() {
        horlogeExterne = StubHorloge()
    }
}
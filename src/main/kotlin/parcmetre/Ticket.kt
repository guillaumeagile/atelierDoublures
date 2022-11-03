package parcmetre

import parcmetre.behaviors.Horloge
import java.time.LocalDateTime

class Ticket(val sommePayeeEnEuros: Double, val horloge: Horloge  ) {
    fun  CalculerDateSortie() {
        dateSortieMaximum = horloge.maintenant().plusMinutes(dureeDeStationnementEnMinutes)
    }

    lateinit var  dateSortieMaximum: LocalDateTime

    val dureeDeStationnementEnMinutes: Long = (sommePayeeEnEuros * 2 * 60).toLong()
}



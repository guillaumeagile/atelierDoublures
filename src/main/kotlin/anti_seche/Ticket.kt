package anti_seche

import java.time.LocalDateTime

class Ticket(val immatriculation: String) {

    val tempsDeStationnementEnMinutes: Int
        get() {
            TODO()
        }

    var dateInterne: LocalDateTime? = null
    val horodatage: LocalDateTime?
        get() {
            return dateInterne
        }

    fun dater() {
       dateInterne = LocalDateTime.now()
    }

    fun Payer(i: Int) {
        TODO()
    }
}



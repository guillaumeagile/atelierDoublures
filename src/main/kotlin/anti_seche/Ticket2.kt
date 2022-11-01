package anti_seche

import java.time.LocalDateTime

class Ticket2(val immatriculation: String) {
    private var estEnCoursDeTest: Boolean = false
    var dateInterne: LocalDateTime? = null
    val horodatage: LocalDateTime?
        get() {
            return dateInterne
        }

    fun creer() {
        dateInterne = when {
            estEnCoursDeTest -> LocalDateTime.MIN
            else -> LocalDateTime.now()
        }
        // etonnant... du code de test en prod???
    }

    fun environementDeTest(actif: Boolean) {
        this.estEnCoursDeTest = actif
    }
}
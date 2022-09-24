package exercice_1

import java.time.LocalDateTime

class Ticket2(val immatriculation: String) {
    private var estEnCoursDeTest: Boolean = false
    var dateInterne: LocalDateTime? = null
    val horodatage: LocalDateTime?
        get() {
            return dateInterne
        }

    fun imprime() {
        dateInterne = when {
            estEnCoursDeTest -> LocalDateTime.MIN
            else -> LocalDateTime.now()
        }
    }

    fun environementDeTest(actif: Boolean) {
        this.estEnCoursDeTest = actif
    }
}
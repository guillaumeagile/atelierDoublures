package exercice_1

import java.time.LocalDateTime

class Ticket(val immatriculation: String, val horloge: LocalDateTime) {
    var dateInterne: LocalDateTime? = null
    val horodatage: LocalDateTime?
        get() {
            return dateInterne
        }

    fun imprime() {
//        dateInterne = LocalDateTime.now()
        dateInterne = horloge
    }
}


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

    fun environementDeTest() {
        horlogeExterne = StubHorloge()
    }
}

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
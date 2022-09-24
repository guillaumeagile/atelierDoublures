package exercice_2

import exercice_1.*
import exercice_1.services.StubHorloge
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.comparables.shouldBeLessThan
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import java.time.LocalDateTime

class `1_TestThatTicketParking` : StringSpec({


    //premier pas vers un contrôle du temps
    "Maitrisons le temps, heure fixe sur MIN".config(enabled=false) {
        // Arrange
        val ticket = Ticket1(immatriculation = "AA-000-XX", horloge = LocalDateTime.MIN)

        // Act
        ticket.imprime() // Ici le temps est probablement calculé quelque au sein de cette méthode
        // Et si nous pouvions être les maitres du temps ?

        // Assert
        ticket.horodatage shouldBe LocalDateTime.MIN
    }

    // conclusion partielle,
    // ca passe mais on a du changer notre code de prod
    // çà ne fait plus le taf attendu
//    fun imprime() {
//        dateInterne = LocalDateTime.now()
//        dateInterne = horloge
//    }
    // on veut pouvoir garder l'appel sur une horloge avec un now()
    // est-ce quelqu'un a une idée ?
    // si on créé une objet respectant ce contrat ?
})
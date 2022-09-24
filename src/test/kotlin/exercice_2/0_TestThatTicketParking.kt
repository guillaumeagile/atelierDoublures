package exercice_2

import exercice_1.*
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDateTime

class `0_TestThatTicketParking` : StringSpec({

    "Test vraiment peu fiable => test fragile".config(enabled=false) {
        // Arrange
        val ticket = Ticket(immatriculation = "AA-000-XX")

        // Act
        ticket.imprime() // Ici le temps est probablement calculé quelque au sein de cette méthode
        // Et si nous pouvions être les maitres du temps ?

        // Assert
        ticket.horodatage shouldBe LocalDateTime.now()
    }

})
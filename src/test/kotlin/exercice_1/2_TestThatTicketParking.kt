package exercice_1

import anti_seche.Ticket2
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDateTime

class `2_TestThatTicketParking` : StringSpec({

    "un flag de test" {
        // Arrange
        val ticket = Ticket2(immatriculation = "AA-000-XX")

        // Act
        ticket.environementDeTest(actif=true)
        ticket.creer()

        // Assert
        ticket.horodatage shouldBe LocalDateTime.MIN
    }
    // conclusion: est ce une bonne chose de modifier le code de prod pour faire passer le test?
    // conclusion bis: le code ne doit pas bouger si on est en mode test ou en mode prod

    // ce qui change, c'est la facon de retourner le temps: il faut un temps de test, et un temps de prod
})
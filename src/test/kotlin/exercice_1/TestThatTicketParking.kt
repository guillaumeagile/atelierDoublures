package exercice_1

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDateTime

class TestThatTicketParking : StringSpec({

    "Should not pass" {
        // Arrange
        val ticket = Ticket(immatriculation = "AA-000-XX")

        // Act
        ticket.imprime()

        // Assert
        ticket.horodatage shouldBe LocalDateTime.now()
    }

})
package exercice_1

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TestThatTicketParking : StringSpec({

    "Should not pass" {
        val ticket = new Ticket(immatriculation = "AA-000-XX")
        ticket.imprime()
        ticket.horodatage shouldBe LocalDateTime.now()
    }

})
package exercice_1.regles_metier

import anti_seche.Ticket
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DureeStationnement : StringSpec({

    "Si on paye des cacahuetes, on  a des singes".config(enabled=false) {
        // Arrange
        val ticket = Ticket(immatriculation = "AA-000-XX")

        ticket.Payer(0)

        // Assert
        ticket.tempsDeStationnementEnMinutes shouldBe 0
    }

})
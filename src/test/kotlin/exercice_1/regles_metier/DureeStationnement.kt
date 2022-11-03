package exercice_1.regles_metier

import exercice_1.FausseHorloge
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import parcmetre.Ticket
import java.time.LocalDateTime

class DureeStationnement : StringSpec({
    var fausseHorloge = FausseHorloge()
    "Si je met 0€ alors j'ai 0 minutes de temps de stationnement".config(enabled = true) {
        // Arrange
        val ticket = Ticket(sommePayeeEnEuros = 0.0, fausseHorloge);

        // Assert
        ticket.dureeDeStationnementEnMinutes shouldBe 0
    }

    "Si je met 0,5€ alors j'ai 60 minutes de temps de stationnement".config(enabled = true) {
        // Arrange
        val ticket = Ticket(sommePayeeEnEuros = 0.5, fausseHorloge);
        // Assert
        ticket.dureeDeStationnementEnMinutes shouldBe 60
    }

    "Si je met 2€ alors j'ai 240 minutes de temps de stationnement".config(enabled = true) {
        // Arrange
        val ticket = Ticket(sommePayeeEnEuros = 2.0, fausseHorloge);
        // Assert
        ticket.dureeDeStationnementEnMinutes shouldBe 240
    }

    "Si je met 1,33333€ alors j'ai 160 minutes de temps de stationnement".config(enabled = true) {
        // Arrange
        val ticket = Ticket(sommePayeeEnEuros = 1.3333333333333333333333333, fausseHorloge);
        // Assert
        ticket.dureeDeStationnementEnMinutes shouldBe 160
    }


})
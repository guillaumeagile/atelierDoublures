package exercice_1

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import parcmetre.Ticket
import java.time.LocalDateTime

class `1_TestThatTicketParking` : StringSpec({
    var fausseHorloge = FausseHorloge()

    "Quand je rentre et que je met 0€ alors je dois sortir à ?".config(enabled = true) {
        // Arrange
        val ticket = Ticket(sommePayeeEnEuros = 0.0, fausseHorloge);
        //Act
         ticket.CalculerDateSortie()
        // Assert
        ticket.dateSortieMaximum shouldBe LocalDateTime.MIN
    }

    "Quand je rentre et que je met 0,5€ alors je dois sortir à ?".config(enabled = true) {
        // Arrange
        val ticket = Ticket(sommePayeeEnEuros = 0.5,fausseHorloge);
        //Act
        ticket.CalculerDateSortie()
        // Assert
        ticket.dateSortieMaximum shouldBe LocalDateTime.MIN.plusHours(1)
    }
})
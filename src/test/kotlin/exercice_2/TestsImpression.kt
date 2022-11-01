package exercice_2

import anti_seche.Ticket5
import anti_seche.services.StubHorloge
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TestsImpression {


    class `TestThatTicketParking` : StringSpec({

        "Maitrisons le temps, sans toucher au métier" {
            // ARRANGE
            val ticket = Ticket5(immatriculation = "AA-000-XX", horlogeExterne = StubHorloge())
            ticket.payer(1)
           // ticket.dater()  // le datage est à faire directement au moment de payer

            // ACT
            // ticket.imprime()
            //ou
            // ticket.imprime(imprimante)

            // ASSERT
            //faut il écrire ceci ?
            // ticket.correctementImprimé shouldBe true ?

            // ou bien cela
            // imprimante.ticketCorrectementImprimé shouldBe true
        }
    })
}
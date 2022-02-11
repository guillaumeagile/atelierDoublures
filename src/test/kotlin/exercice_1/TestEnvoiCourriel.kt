
package exercice_1

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TestEnvoiCourriel : StringSpec({
    "Test vraiment inutile et code trop complexe => test fragile" {
        // Arrange
        val ticket1 = TicketAvecMail(immatriculation = "AA-000-XX"  )

        // Act
        ticket1.imprime()

        // Assert
        // on veut savoir si le mail est parti.......
        //  irréaliste
    }

    "Test inteliigent avec une doublure" {
        // Arrange
        val serviceEmail = spyEmail()
        val ticket1 = TicketQuiInvoqueUnServiceEmail(immatriculation = "AA-000-XX", serviceEmail  )

        // Act
        ticket1.imprime()

        // Assert
        // on veut savoir si le mail est parti.......
        serviceEmail.isMailSent shouldBe true
    }
})

class spyEmail(var isMailSent: Boolean = false) : IDoublureEmail {
    override fun sendMail(subject: String, body: String, to: String) {
        isMailSent = true
    }
}

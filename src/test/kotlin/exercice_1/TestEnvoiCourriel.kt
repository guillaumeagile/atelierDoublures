
package exercice_1

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.comparables.shouldBeLessThan
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import java.time.LocalDateTime

class TestEnvoiCourriel : StringSpec({
    "Test vraiment peu fiable => test fragile" {
        // Arrange
        val horlogeUnique = FakeHorloge()
        val ticket1 = TicketAvecMail(immatriculation = "AA-000-XX"  )

        // Act
        ticket1.imprime()

        // Assert
        // on veut savoir si le mail est parti.......
        //  irréaliste
    }
})

//

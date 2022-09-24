package exercice_2

import exercice_1.*
import exercice_1.services.StubHorloge
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.comparables.shouldBeLessThan
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import java.time.LocalDateTime

class `2_TestThatTicketParking` : StringSpec({

    "un flag de test" {
        // Arrange
        val ticket = Ticket2(immatriculation = "AA-000-XX")

        // Act
        ticket.environementDeTest(actif=true)
        ticket.imprime()

        // Assert
        ticket.horodatage shouldBe LocalDateTime.MIN
    }
    // conclusion: est ce une bonne chose de modifier le code de prod pour faire passer le test?
    // conclusion bis: le code ne doit pas bouger si on est en mode test ou en mode prod

    // ce qui change, c'est la facon de retourner le temps: il faut un temps de test, et un temps de prod


    "Maitrisons le temps, sans toucher au métier" {
        // Arrange
        val ticket = Ticket4(immatriculation = "AA-000-XX", horlogeExterne = StubHorloge() )

        // Act
        ticket.imprime() // Ici le temps est  uniquement obtenu au sein de cette méthode
        // nous sommes les maitres du temps dans le Stub

        // Assert
        ticket.horodatage shouldBe StubHorloge().now()
    }

    "Testons le tout avec le temps en production" {
        // Arrange
        val ticket = Ticket4(immatriculation = "AA-000-XX", horlogeExterne = HorlogeExterne() )

        // Act
        ticket.imprime() // Ici le temps est  uniquement obtenu au sein de cette méthode
        // nous sommes les maitres du temps dans le Stub

        // Assert
        ticket.horodatage!! shouldBeLessThan  HorlogeExterne().now()
        // le test est fragile mais il fonctionne
    }

    "Isolons et testons juste l'horloge en production" {
        HorlogeExterne().now() shouldNotBe HorlogeExterne().now()
    }

    "Pour être sûr que le stub se comporte bien, testons juste l'horloge de stub" {
        StubHorloge().now() shouldBe StubHorloge().now()
        //pour cette fausse horloge, le temps ne bouge pas
    }

    "Pour une meilleure simulation du comportement, testons une horloge fake plus évoluée" {
        val horlogeUnique = FakeHorloge()
        horlogeUnique.now() shouldBeLessThan  horlogeUnique.now()
    }

    "Avec l'horloge fake, il est facile de tester que Deux tickets sont émis séquentiellement" {
        // Arrange
        val horlogeUnique = FakeHorloge()
        val ticket1 = Ticket4(immatriculation = "AA-000-XX", horlogeExterne =  horlogeUnique)
        val ticket2 = Ticket4(immatriculation = "AA-000-XX", horlogeExterne = horlogeUnique )

        // Act
        ticket1.imprime() // Ici le temps est  uniquement obtenu au sein de cette méthode
        ticket2.imprime()

        // Assert
        ticket1.horodatage!! shouldBeLessThan  ticket2.horodatage!!
    }

})
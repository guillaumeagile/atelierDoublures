package exercice_1

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.comparables.shouldBeLessThan
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import java.time.LocalDateTime

class TestThatTicketParking : StringSpec({

//    "Test vraiment peu fiable => test fragile" {
//        // Arrange
//        val ticket = Ticket(immatriculation = "AA-000-XX")
//
//        // Act
//        ticket.imprime() // Ici le temps est probablement calculé quelque au sein de cette méthode
//        // Et si nous pouvions être les maitres du temps ?
//
//        // Assert
//        ticket.horodatage shouldBe LocalDateTime.now()
//    }


    //premier pas vers un contrôle du temps
    "Maitrisons le temps, heure fixe sur MIN" {
        // Arrange
        val ticket = Ticket(immatriculation = "AA-000-XX", horloge = LocalDateTime.MIN)

        // Act
        ticket.imprime() // Ici le temps est probablement calculé quelque au sein de cette méthode
        // Et si nous pouvions être les maitres du temps ?

        // Assert
        ticket.horodatage shouldBe LocalDateTime.MIN
    }

    // conclusion partielle,
    // mais on du changer notre code de prod
    // çà ne fait plus le taf attendu
//    fun imprime() {
//        dateInterne = LocalDateTime.now()
//        dateInterne = horloge
//    }
    // on veut pouvoir garder l'appel sur une horloge avec un now()
    // est-ce quelqu'un a une idée ?
    // si on créé une objet respectant ce contrat ?


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


    "Maitrisons le temps" {
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
    }

    "testons juste l'horloge' en production" {
        HorlogeExterne().now() shouldNotBe HorlogeExterne().now()
    }

    "testons juste l'horloge de stub" {
        StubHorloge().now() shouldBe StubHorloge().now()
    }

    "testons juste l'horloge' fake" {
        val horlogeUnique = FakeHorloge()
        horlogeUnique.now() shouldBeLessThan  horlogeUnique.now()
    }

    "Deux tickets sont émis séquentiellement" {
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
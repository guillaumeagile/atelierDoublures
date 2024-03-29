package exercice_1

import anti_seche.`Ticket4🤞`
import exercice_0.*
import anti_seche.services.StubHorloge
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.comparables.shouldBeLessThan
import io.kotest.matchers.shouldBe

class `4_TestThatTicketParking` : StringSpec({

    "Maitrisons le temps, sans toucher au métier" {
        // Arrange
        val ticket = `Ticket4🤞`(immatriculation = "AA-000-XX", horlogeExterne = StubHorloge() )

        // Act
        ticket.creer() // Ici le temps est  uniquement obtenu au sein de cette méthode
        // nous sommes les maitres du temps dans le Stub

        // Assert
        ticket.horodatage shouldBe StubHorloge().maintenant()
    }

    "Testons le tout avec le temps en production" {
        // Arrange
        val ticket = `Ticket4🤞`(immatriculation = "AA-000-XX", horlogeExterne = HorlogeSysteme() )

        // Act
        ticket.creer() // Ici le temps est  uniquement obtenu au sein de cette méthode
        // nous sommes les maitres du temps dans le Stub

        // Assert
        ticket.horodatage!! shouldBeLessThan  HorlogeSysteme().maintenant()
        // le test est fragile mais il fonctionne
    }


    "Pour être sûr que le stub se comporte bien, testons juste l'horloge de stub" {
        StubHorloge().maintenant() shouldBe StubHorloge().maintenant()
        //pour cette fausse horloge, le temps ne bouge pas...
    // ceci est juste pour démontrer la différence entre Stub et Fake / on ne fera pas ceci en production
    }

    // les tests de la FakeHorloge et de la HorlogeSysteme étant identiques,
    // ils sont maintenant dans exercice_1/invariantBehaviors/AnyHorlogeShouldBehave.kt

    "Avec l'horloge fake, il est facile de tester que Deux tickets sont émis séquentiellement" {
        // Arrange
        val horlogeUnique = FakeHorloge()
        val ticket1 = `Ticket4🤞`(immatriculation = "AA-000-XX", horlogeExterne =  horlogeUnique)
        val ticket2 = `Ticket4🤞`(immatriculation = "AA-000-XX", horlogeExterne = horlogeUnique )

        // Act
        ticket1.creer() // Ici le temps est  uniquement obtenu au sein de cette méthode
        ticket2.creer()

        // Assert
        ticket1.horodatage!! shouldBeLessThan  ticket2.horodatage!!

        // ATTENTION: ce test ne sert à rien, puisque'on a déjà démontré que la fakeHorloge fait vraiment avancer le temps
    }

})
package exercice_1

import anti_seche.Ticket4
import exercice_0.*
import anti_seche.services.FausseHorloge
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.comparables.shouldBeLessThan
import io.kotest.matchers.shouldBe

class `4_TesterQueLeTicketParking` : StringSpec({

    "peut etre daté avec une fausse horloge" {
        // Arrange
        val ticket = Ticket4(immatriculation = "AA-000-XX", horlogeExterne = FausseHorloge() )

        // Act
        ticket.creer() // Ici le temps est  uniquement obtenu au sein de cette méthode

        // Assert
        ticket.horodatage shouldBe FausseHorloge().maintenant()
        // nous sommes les maitres du temps dans le Stub
    }

    "peut etre daté avec l'horloge du système" {
        // Arrange
        val ticket = Ticket4(immatriculation = "AA-000-XX", horlogeExterne = HorlogeSystème() )

        // Act
        ticket.creer() // Ici le temps est uniquement obtenu au sein de cette méthode

        // Assert
        ticket.horodatage!! shouldBeLessThan  HorlogeSystème().maintenant()
        // le test est fragile, car le vrai temps ne s'arrête pas ... mais il fonctionne
    }


    "Pour être sûr que le stub se comporte bien, testons juste l'horloge de stub" {
        FausseHorloge().maintenant() shouldBe FausseHorloge().maintenant()
        //pour cette fausse horloge, le temps ne bouge pas...
    // ceci est juste pour démontrer la différence entre Stub et Fake / on ne fera pas ceci en production
    }

    // les tests de la FakeHorloge et de la HorlogeSysteme étant identiques,
    // ils sont maintenant dans exercice_1/invariantBehaviors/AnyHorlogeShouldBehave.kt

    "Avec l'horloge fake, il est facile de tester que Deux tickets sont émis séquentiellement" {
        // Arrange
        val horlogeUnique = DoublureHorloge()
        val ticket1 = Ticket4(immatriculation = "AA-000-XX", horlogeExterne =  horlogeUnique)
        val ticket2 = Ticket4(immatriculation = "AA-000-XX", horlogeExterne = horlogeUnique )

        // Act
        ticket1.creer() // Ici le temps est  uniquement obtenu au sein de cette méthode
        ticket2.creer()

        // Assert
        ticket1.horodatage!! shouldBeLessThan  ticket2.horodatage!!

        // ATTENTION: ce test ne sert à rien, puisque'on a déjà démontré que la fakeHorloge fait vraiment avancer le temps
    }

})
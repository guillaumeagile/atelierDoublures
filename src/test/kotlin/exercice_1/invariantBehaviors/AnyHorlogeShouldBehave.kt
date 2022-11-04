package exercice_1.invariantBehaviors

import anti_seche.behaviors.Horloge
import exercice_0.HorlogeSysteme
import exercice_1.FakeHorloge
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.funSpec
import io.kotest.matchers.comparables.shouldBeLessThan
import io.kotest.matchers.shouldNotBe

fun horlogTestFactory(horloge: Horloge) = funSpec {
    // nous avons une interface, et maintenant nous avons déterminé le comportement de cet interface
    // on va aller plus loin, on va implémenter ce comportement par défaut dans l'interface (merci Kotlin)

    test("Toute horloge doit avancer dans le temps") {
        horloge.maintenant() shouldBeLessThan horloge.maintenant()
    }

   test( "on est d'accord, c'est la même chose que le test précédent") {
        HorlogeSysteme().maintenant() shouldNotBe HorlogeSysteme().maintenant()
    }
}

class FakeHorlogeTest : FunSpec({
    include(horlogTestFactory(horloge = FakeHorloge()))
})

class HorlogeSystemeTest : FunSpec({
    include(horlogTestFactory(horloge = HorlogeSysteme()))
})




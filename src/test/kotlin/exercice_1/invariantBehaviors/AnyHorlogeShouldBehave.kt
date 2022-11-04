package exercice_1.invariantBehaviors

import anti_seche.behaviors.Horloge
import exercice_0.HorlogeSysteme
import exercice_1.FakeHorloge
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.funSpec
import io.kotest.matchers.comparables.shouldBeLessThan

fun horlogTestFactory(horloge: Horloge) = funSpec {
    test("Pour une meilleure simulation du comportement, toute horloge doit avancer dans le temps") {
        horloge.now() shouldBeLessThan horloge.now()
    }
}

class FakeHorlogeTest : FunSpec({
    include(horlogTestFactory(horloge = FakeHorloge()))
})

class HorlogeSystemeTest : FunSpec({
    include(horlogTestFactory(horloge = HorlogeSysteme()))
})




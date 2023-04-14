package exercice_1.invariantBehaviors

import anti_seche.behaviors.Horloge
import exercice_0.HorlogeSysteme
import exercice_1.FakeHorloge
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.funSpec
import io.kotest.matchers.comparables.shouldBeLessThan
import io.kotest.matchers.shouldNotBe
import java.time.LocalDateTime

fun horlogTestFactory(horloge: Horloge) = funSpec {  // ceci est une factory de tests

    test("Toute horloge doit avancer dans le temps, version triviale") {
        horloge.maintenant() shouldNotBe horloge.maintenant()
        // n'a d'interêt que pour l'exercice
    }
    // comme nous avons une interface, nous avons déterminé le comportement de cette interface

    // on va aller plus loin, on va implémenter ce comportement par défaut dans l'interface (merci Kotlin)

    test("Toute horloge doit avancer dans le temps") {
        // on utilise le comportement codé par défaut dans l'interface, comme ca tout est au même endroit
        horloge.lHorlologeDoitAvancerDansLeTemps(horloge) { date1, date2 -> date1 shouldBeLessThan date2 }
        // les assertions restent ici, car on ne veut pas que le code de prod contiennent des refs
        // au framework de test
        // on ira contraindre le comportement dans l'interface
    }
}

// >>>>>>>>>> INJECTION DE DEPENDANCE DANS LES TESTS AVEC KOTLIN/funSpec <<<<<<<<<<<<
class FakeHorlogeTest : FunSpec({
    include(horlogTestFactory(horloge = FakeHorloge()))
})

class HorlogeSystemeTest : FunSpec({
    include(horlogTestFactory(horloge = HorlogeSysteme()))
})




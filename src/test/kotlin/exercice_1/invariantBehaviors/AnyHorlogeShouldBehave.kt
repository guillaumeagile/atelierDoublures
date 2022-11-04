package exercice_1.invariantBehaviors

import anti_seche.behaviors.Horloge
import exercice_0.HorlogeSysteme
import exercice_1.FakeHorloge
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.funSpec
import io.kotest.matchers.comparables.shouldBeLessThan
import io.kotest.matchers.shouldNotBe
import java.time.LocalDateTime

fun horlogTestFactory(horloge: Horloge) = funSpec {
    // nous avons une interface, et maintenant nous avons déterminé le comportement de cet interface
    // on va aller plus loin, on va implémenter ce comportement par défaut dans l'interface (merci Kotlin)

    test("Toute horloge doit avancer dans le temps") {
        //on utilise le comportement codé par défaut dans l'interface, comme ca tout est au même endroit
        horloge.lHorlologeDoitAvancerDansLeTemps(horloge) { date1, date2 -> date1 shouldBeLessThan date2 }
        //ici ce n'est plus que de la tuyauterie de test...  on s'en fout!
        //ou presque, parce que les assertions restent ici, car je veux pas que le code de prod contiennent des refs
        //au framework de test :(
        //on ira coder le comportement dans l'interface
        //on verra l'utilité dans l'exerice 3 et 4
    }

    test("on est d'accord, c'est la même chose que le test précédent") {
        horloge.maintenant() shouldNotBe horloge.maintenant()
        //version triviale, qui n'a d'interêt que pour l'exercice
    }
}

class FakeHorlogeTest : FunSpec({
    include(horlogTestFactory(horloge = FakeHorloge()))
})

class HorlogeSystemeTest : FunSpec({
    include(horlogTestFactory(horloge = HorlogeSysteme()))
})




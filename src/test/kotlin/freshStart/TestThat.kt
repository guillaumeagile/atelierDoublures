package freshStart

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TestThat : StringSpec({

    "Should return the fist letter " {
        val actual = Accum.calculate("Z")
        actual shouldBe "Z"
    }

    "Should return the fist letter uppercase" {
        val actual = Accum.calculate("z")
        actual shouldBe "Z"
    }

    "Should return the fist letter uppercase for a string a 2 letters" {
        val actual = Accum.calculate("za")
        actual shouldBe "Z-Aa"
    }

    "Should return the fist letter uppercase for a string a 3 letters" {
        val actual = Accum.calculate("zaQ")
        actual shouldBe "Z-Aa-Qqq"
    }

})
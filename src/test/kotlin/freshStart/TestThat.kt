package freshStart

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe


class TestThat : StringSpec({

    "Should return the first letter " {
        val actual = "Z"
        actual shouldBe "Z"
    }

    "Should return the first letter capitalized " {
        val actual = Acummulator.accum( input =  "z")
        actual shouldBe "Z"
    }

    "Should return the first letter capitalized on a 2 characters input" {
        val actual = Acummulator.accum( input =  "za")
        actual shouldBe "Z-Aa"
    }

    "Should return the first letter capitalized on a 3 characters input" {
        val actual = Acummulator.accum( input =  "RqaEzty")
        actual shouldBe "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
    }

})
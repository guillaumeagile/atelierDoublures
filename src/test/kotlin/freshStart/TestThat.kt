package freshStart

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TestThat : StringSpec({

    "Should return the fist letter " {
        val actual = "z"
        actual shouldBe "Z"
    }
})
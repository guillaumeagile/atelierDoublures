package freshStart

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TestThat : StringSpec({

    "Should not pass" {
        
        false shouldBe true
    }

    

})
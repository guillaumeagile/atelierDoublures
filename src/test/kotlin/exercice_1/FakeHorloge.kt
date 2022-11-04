package exercice_1

import anti_seche.behaviors.Horloge
import java.time.LocalDateTime

class FakeHorloge : Horloge {
    private var internalDateTime: LocalDateTime = LocalDateTime.MIN
    override fun maintenant(): LocalDateTime {
        internalDateTime =  internalDateTime.plusSeconds(1)
        return internalDateTime
    }

}

package exercice_1

import parcmetre.behaviors.Horloge
import java.time.LocalDateTime

class FausseHorloge : Horloge {
    override fun maintenant(): LocalDateTime {
        return LocalDateTime.MIN
    }
}

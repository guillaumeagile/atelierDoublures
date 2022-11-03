package exercice_0

import parcmetre.behaviors.Horloge
import java.time.LocalDateTime

class HorlogeExterne : Horloge {
   override  fun maintenant(): LocalDateTime {
       return LocalDateTime.now()
    }
}


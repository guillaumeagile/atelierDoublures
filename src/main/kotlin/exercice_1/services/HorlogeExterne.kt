package exercice_1

import exercice_1.behaviors.Horloge
import java.time.LocalDateTime

class HorlogeExterne : Horloge {
   override  fun now(): LocalDateTime {
       return LocalDateTime.now()
    }
}


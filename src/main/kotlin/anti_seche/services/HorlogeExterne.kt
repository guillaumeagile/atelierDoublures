package exercice_0

import anti_seche.behaviors.Horloge
import java.time.LocalDateTime

class HorlogeExterne : Horloge {
   override  fun now(): LocalDateTime {
       return LocalDateTime.now()
    }
}


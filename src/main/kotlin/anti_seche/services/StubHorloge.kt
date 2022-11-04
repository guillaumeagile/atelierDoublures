package anti_seche.services

import anti_seche.behaviors.Horloge
import java.time.LocalDateTime

class StubHorloge : Horloge
{
    override fun maintenant(): LocalDateTime {
      return LocalDateTime.MAX
    }
}
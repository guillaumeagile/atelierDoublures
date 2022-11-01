package anti_seche.services

import anti_seche.behaviors.Horloge
import java.time.LocalDateTime

class StubHorloge : Horloge
{
    override fun now(): LocalDateTime {
      return LocalDateTime.MAX
    }
}
package parcmetre.services

import parcmetre.behaviors.Horloge
import java.time.LocalDateTime

class StubHorloge : Horloge
{
    override fun now(): LocalDateTime {
      return LocalDateTime.MAX
    }
}
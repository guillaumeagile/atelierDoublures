package parcmetre.services

import parcmetre.behaviors.Horloge
import java.time.LocalDateTime

class StubHorloge : Horloge
{
    override fun maintenant(): LocalDateTime {
      return LocalDateTime.MAX
    }
}
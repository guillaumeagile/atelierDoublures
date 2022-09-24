package exercice_1.services

import exercice_1.behaviors.Horloge
import java.time.LocalDateTime

class StubHorloge : Horloge
{
    override fun now(): LocalDateTime {
      return LocalDateTime.MAX
    }
}
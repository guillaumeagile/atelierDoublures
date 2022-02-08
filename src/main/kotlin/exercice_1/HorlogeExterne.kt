package exercice_1

import java.time.LocalDateTime

class HorlogeExterne : Horloge {
   override  fun now(): LocalDateTime {
       return LocalDateTime.now()
    }
}

interface Horloge {
    fun now(): LocalDateTime
}

class StubHorloge : Horloge
{
    override fun now(): LocalDateTime {
      return LocalDateTime.MAX
    }
}

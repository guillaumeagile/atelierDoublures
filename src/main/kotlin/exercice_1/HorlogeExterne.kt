package exercice_1

import java.time.LocalDateTime

class HorlogeExterne : Horloge {
   override  fun now(): LocalDateTime {
        TODO("Not yet implemented")
    }
}

interface Horloge {
    fun now(): LocalDateTime
}

class StubHorloge : Horloge
{
    override fun now(): LocalDateTime {
        TODO("Not yet implemented")
    }
}
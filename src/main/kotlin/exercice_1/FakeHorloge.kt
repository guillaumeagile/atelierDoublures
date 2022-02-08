package exercice_1

import java.time.LocalDateTime

class FakeHorloge : Horloge {
    private var internalDateTime: LocalDateTime = LocalDateTime.MIN
    override fun now(): LocalDateTime {
        internalDateTime =  internalDateTime.plusSeconds(1)
        return internalDateTime
    }

}

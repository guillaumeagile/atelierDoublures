package parcmetre.behaviors

import java.time.LocalDateTime

interface Horloge {
    fun now(): LocalDateTime
}
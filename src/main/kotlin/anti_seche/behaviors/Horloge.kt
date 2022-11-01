package anti_seche.behaviors

import java.time.LocalDateTime

interface Horloge {
    fun now(): LocalDateTime
}
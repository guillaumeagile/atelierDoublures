package freshStart

import java.util.*

object Acummulator {
    fun accum(input: String): String {
        return input.lowercase().toList()
            .mapIndexed { index, value -> value.toString().repeat(index + 1)
                .replaceFirstChar { it.uppercase()  } }
            .joinToString("-")
    }
}

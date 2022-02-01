package freshStart

object Accum {
    fun calculate(s: String): String {
        return s.toList().mapIndexed { idx, it ->
            it.lowercaseChar().toString().repeat(idx + 1)
                .replaceFirstChar { it.uppercase() }
        }
            .joinToString("-") { it }
    }
}

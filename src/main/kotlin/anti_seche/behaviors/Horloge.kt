package anti_seche.behaviors

import java.time.LocalDateTime

interface Horloge {
    fun maintenant(): LocalDateTime

    //implémentation de la vérification dans l'interface elle même, merci Kotlin
    fun lHorlologeDoitAvancerDansLeTemps(horloge: Horloge, verification: (LocalDateTime, LocalDateTime) -> Unit) {
        verification(horloge.maintenant(), horloge.maintenant())
        // je suis d'accord, ca pourrait être plus expressif :/
        // mais c'est pour pas dépendre du mécanisme d'assertion de Kotest à cet endroit
        // on pourrait mettre des assertions de type PRECOND/POST COND
        // c'est pas mal, mais moins pratique que les assertions Kotest (surtout en cas de test qui fail)
        // à essayer quand même!
    }

}
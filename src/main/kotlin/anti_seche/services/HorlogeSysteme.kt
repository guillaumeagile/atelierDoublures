package exercice_0

import anti_seche.behaviors.Horloge
import java.time.LocalDateTime

class HorlogeSysteme : Horloge {
   override  fun maintenant(): LocalDateTime {
       return LocalDateTime.now()
       //return LocalDateTime.MAX
   // vérifiez que si le systeme ne se comporte pas bien, on a bien un test qui échoue
    }
}


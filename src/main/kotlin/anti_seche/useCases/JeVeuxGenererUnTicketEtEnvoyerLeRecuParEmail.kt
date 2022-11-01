package anti_seche.useCases

import anti_seche.services.ServiceEmail
import anti_seche.TicketQuiInvoqueUnServiceEmail

class JeVeuxGenererUnTicketEtEnvoyerLeRecuParEmail {
    fun main() {
        val serviceEmail = ServiceEmail()
        val ticket1 = TicketQuiInvoqueUnServiceEmail(immatriculation = "AA-000-XX", serviceEmail)
        ticket1.imprime()
    }
}
package exercice_1.useCases

import exercice_1.services.ServiceEmail
import exercice_1.TicketQuiInvoqueUnServiceEmail

class JeVeuxGenererUnTicketEtEnvoyerLeRecuParEmail {
    fun main() {
        val serviceEmail = ServiceEmail()
        val ticket1 = TicketQuiInvoqueUnServiceEmail(immatriculation = "AA-000-XX", serviceEmail)
        ticket1.imprime()
    }
}
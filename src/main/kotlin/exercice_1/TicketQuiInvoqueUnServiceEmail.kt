package exercice_1

class TicketQuiInvoqueUnServiceEmail(val immatriculation: String, val serviceEmail: IDoublureEmail) {
    fun imprime() {
        serviceEmail.sendMail(subject = "facture$immatriculation", body = "voici votre facture", to = "test@test.com")
    }
}

interface IDoublureEmail {
    fun sendMail(subject: String, body: String, to: String)
}


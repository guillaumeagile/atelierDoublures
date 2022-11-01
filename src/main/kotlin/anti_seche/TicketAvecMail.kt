package anti_seche


class TicketAvecMail(
        val immatriculation: String
    ) {
        fun imprime() {
            sendMail(subject = "facture$immatriculation", body = "voici votre facture", to = "test@test.com")
        }

    private fun sendMail(subject: String, body: String, to: String) {
    }
}


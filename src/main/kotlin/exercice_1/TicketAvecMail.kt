package exercice_1

import java.util.*
import javax.mail.Message
import javax.mail.MessagingException
import javax.mail.PasswordAuthentication
import javax.mail.Session
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage


class TicketAvecMail(
        val immatriculation: String
    ) {
        fun imprime() {
            sendMail(subject = "facture$immatriculation", body = "voici votre facture", to = "test@test.com")
        }

    private fun sendMail(subject: String, body: String, to: String) {
    }
}


package anti_seche.services

import anti_seche.IDoublureEmail
import java.util.*
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

class ServiceEmail() : IDoublureEmail {
    override fun sendMail(subject: String, body: String, to: String) {
        val props = Properties()
        val userName = "bar"
        val password = "foo"
        putIfMissing(props, "mail.smtp.host", "smtp.office365.com")
        putIfMissing(props, "mail.smtp.port", "587")
        putIfMissing(props, "mail.smtp.auth", "true")
        putIfMissing(props, "mail.smtp.starttls.enable", "true")

        val session = Session.getDefaultInstance(props, object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication(userName, password)
            }
        })
        try {
            val mimeMessage = MimeMessage(session)
            mimeMessage.setFrom(InternetAddress("company@foo"))
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false))
            mimeMessage.setText(body)
            mimeMessage.subject = subject
            mimeMessage.sentDate = Date()

            val smtpTransport = session.getTransport("smtp")
            smtpTransport.connect()
            smtpTransport.sendMessage(mimeMessage, mimeMessage.allRecipients)
            smtpTransport.close()
        } catch (messagingException: MessagingException) {
            messagingException.printStackTrace()
        }
    }

    private fun putIfMissing(props: Properties, key: String, value: String) {
        if (!props.containsKey(key)) {
            props[key] = value
        }
    }

}
package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.contact.formular.system.domain.mail;

import lombok.NonNull;
import lombok.Value;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.contact.formular.system.domain.ContactMessage;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.email.management.system.domain.EmailAddress;
import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.email.management.system.domain.mail.MessageTemplate;

@Value(staticConstructor = "of")
public class ContactMessageMail implements MessageTemplate {

    @NonNull
    ContactMessage contactMessage;

    @Override
    public EmailAddress getReceiver() {
        return EmailAddress.of("jeremy.krueger@jkrprojects.de");
    }

    @Override
    public String getSubject() {
        return "Eingehende Kontaktnachricht über jkrprojects.de: " + contactMessage.getSubject();
    }

    @Override
    public String getContent() {
        return "Name des Absenders: „" + contactMessage.getSubmitter().getName() + "“\n" +
                "E-Mail-Adresse des Absenders: „" + contactMessage.getSubmitter().getEmailAddress().getAddress() + "“\n" +
                "\n" +
                "Betreff der Nachricht: „" + contactMessage.getSubject() + "“\n" +
                "Inhalt der Nachricht: \n" +
                contactMessage.getContent();
    }

}

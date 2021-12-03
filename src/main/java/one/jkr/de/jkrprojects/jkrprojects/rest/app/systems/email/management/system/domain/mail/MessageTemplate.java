package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.email.management.system.domain.mail;

import one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.email.management.system.domain.EmailAddress;

public interface MessageTemplate {

    EmailAddress getReceiver();

    String getSubject();

    String getContent();

}

//adding customizing Gmail notification
package org.traccar.notificators;

import org.traccar.Context;
import org.traccar.model.Event;
import org.traccar.model.Position;
import org.traccar.notification.NotificationMessage;
import org.traccar.notification.MessageException;
import org.traccar.notification.NotificationFormatter;

import javax.mail.MessagingException;

public final class NotificatorMail extends Notificator {

    @Override
    public void sendSync(long userId, Event event, Position position) throws MessageException {
        try {
            NotificationMessage fullMessage = NotificationFormatter.formatMessage(userId, event, position, "full");
            Context.getMailManager().sendMessage(userId, fullMessage.getSubject(), fullMessage.getBody());
        } catch (MessagingException e) {
            throw new MessageException(e);
        }
    }

}

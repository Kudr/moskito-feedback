package net.anotheria.moskito.feedback.biz.mail;

import net.anotheria.moskito.feedback.biz.common.FormContent;

/**
 * @author andriiskrypnyk
 */
public interface MailNotificator {

    void notificate(FormContent formContent);
}

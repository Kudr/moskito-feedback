package net.anotheria.moskito.feedback.biz.mail;

import net.anotheria.moskito.feedback.biz.common.FormContent;
import org.configureme.ConfigurationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author andriiskrypnyk
 */
@Component
public class MailNotificatorImpl implements MailNotificator {

    private static final Logger LOG = LoggerFactory.getLogger(MailNotificatorImpl.class);

    private static final String SUBJECT = "MoskitorizeMe";

    private static MailConfig config;

    @Autowired
    private ContentLoader contentLoader;

    private Session session;

    private String username;

    static {
        config = new MailConfig();
        try {
            ConfigurationManager.INSTANCE.configure(config);
        } catch (IllegalArgumentException e) {
            LOG.error("Configuration not found", e);
        }
    }

    public MailNotificatorImpl() {
        initSession();
    }

    @Override
    public void notificate(FormContent formContent) {
        if (formContent == null) {
            throw new IllegalArgumentException("FormContent is null");
        }

        String htmlContent = contentLoader.createHTMLEmailContent(formContent);

        try {
            Transport.send(createMessage(htmlContent));

        } catch (MessagingException e) {
            LOG.error("Error occurred while sending message", e);
        }

    }

    private void initSession() {
        Properties props = new Properties();

        props.put("mail.smtp.auth", config.isSmtpAuth());
        props.put("mail.smtp.starttls.enable", config.isSmtpStarttls());
        props.put("mail.smtp.host", config.getSmtpHost());
        props.put("mail.smtp.port", config.getSmtpPort());
        props.put("mail.smtp.ssl.trust", config.getSmtpHost());

        username = config.getUsername();

        session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, config.getPassword());
                    }
                });
    }

    private Message createMessage(String content) {

        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(config.getUsername()));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(config.getEmailToNotificate()));
            message.setSubject(SUBJECT);
            message.setContent(content, "text/html; charset=utf-8");
        } catch (MessagingException e) {
            LOG.error("Error during message creating", e);
        }
        return message;
    }

}

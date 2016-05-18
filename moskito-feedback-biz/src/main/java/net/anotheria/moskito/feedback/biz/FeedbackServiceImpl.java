package net.anotheria.moskito.feedback.biz;

import net.anotheria.moskito.feedback.biz.common.FormContent;
import net.anotheria.moskito.feedback.biz.mail.MailNotificator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author andriiskrypnyk
 */

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private static final Logger LOG = LoggerFactory.getLogger(FeedbackServiceImpl.class);

    @Autowired
    private MailNotificator mailNotificator;

    @Override
    public void handleFeedback(final FormContent formContent) throws FeedbackServiceException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mailNotificator.notificate(formContent);
                LOG.info("Notification was sent: " + formContent);
            }
        }).start();

    }
}

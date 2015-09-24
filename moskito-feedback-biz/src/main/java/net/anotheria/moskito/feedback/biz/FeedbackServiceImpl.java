package net.anotheria.moskito.feedback.biz;

import net.anotheria.moskito.feedback.biz.common.FormContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * @author andriiskrypnyk
 */

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final Logger log = LoggerFactory.getLogger(FeedbackServiceImpl.class);

    @Override
    public void handleFeedback(FormContent formContent) throws FeedbackServiceException {

        System.out.println("++++++++ " + formContent);

        log.debug("WORKED");

    }
}

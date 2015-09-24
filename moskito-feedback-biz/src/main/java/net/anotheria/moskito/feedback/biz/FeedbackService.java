package net.anotheria.moskito.feedback.biz;

import net.anotheria.moskito.feedback.biz.common.FormContent;

/**
 * @author andriiskrypnyk
 */
public interface FeedbackService {

    void handleFeedback(FormContent formContent) throws FeedbackServiceException;
}

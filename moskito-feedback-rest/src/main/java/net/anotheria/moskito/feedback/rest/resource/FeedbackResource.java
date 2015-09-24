package net.anotheria.moskito.feedback.rest.resource;


import net.anotheria.moskito.feedback.biz.FeedbackService;
import net.anotheria.moskito.feedback.biz.FeedbackServiceException;
import net.anotheria.moskito.feedback.biz.common.FormContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author askrypnyk
 */

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Component
@Scope
public class FeedbackResource {

    @Autowired
    private FeedbackService service;

    @POST
    public ReplyObject handleFormContent(FormContent formContent) {
        try {
            service.handleFeedback(formContent);
            return ReplyObject.success();
        } catch (FeedbackServiceException e) {
            return ReplyObject.error(e);
        }

    }

}

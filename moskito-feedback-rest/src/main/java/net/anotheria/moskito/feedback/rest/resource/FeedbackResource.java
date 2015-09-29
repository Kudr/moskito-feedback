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
@Component
@Scope
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FeedbackResource {

    @Autowired
    private FeedbackService service;

    @POST
    public ReplyObject handleFormContentJSON(FormContent formContent) {
        try {
            service.handleFeedback(formContent);
            return ReplyObject.success();
        } catch (FeedbackServiceException e) {
            return ReplyObject.error(e);
        }

    }


    @POST
    @Path("/submit")
    public ReplyObject handleFormContentSubmit(@FormParam("fName") String fName,
                                               @FormParam("lName") String lName,
                                               @FormParam("cEmail") String email,
                                               @FormParam("cCompany") String company,
                                               @FormParam("Note") String note) {

        FormContent formContent = new FormContent();
        formContent.setfName(fName);
        formContent.setlName(lName);
        formContent.setcEmail(email);
        formContent.setcCompany(company);
        formContent.setNote(note);

        try {
            service.handleFeedback(formContent);
            return ReplyObject.success();
        } catch (FeedbackServiceException e) {
            return ReplyObject.error(e);
        }

    }

}

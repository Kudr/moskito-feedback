package net.anotheria.moskito.feedback.biz.mail;

import net.anotheria.moskito.feedback.biz.common.FormContent;
import net.anotheria.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * @author andriiskrypnyk
 */

@Component
public class MailContentLoader implements ContentLoader {

    private static final Logger LOG = LoggerFactory.getLogger(MailContentLoader.class);

    private static final String FIRST_NAME = "${fName}";
    private static final String LAST_NAME = "${lName}";
    private static final String EMAIL = "${email}";
    private static final String COMPANY = "${company}";
    private static final String TYPE_REQUEST = "${request}";
    private static final String NOTE = "${note}";


    private String template;

    public MailContentLoader() {
        loadHtmlTemplate();
    }


    public String createHTMLEmailContent(FormContent formContent) {
        String htmlEmailContent = template;
        htmlEmailContent = htmlEmailContent.replace(FIRST_NAME, formContent.getfName())
                .replace(LAST_NAME, formContent.getlName())
                .replace(EMAIL, formContent.getcEmail())
                .replace(COMPANY, formContent.getcCompany()).
                        replace(TYPE_REQUEST, formContent.getTypeRequest() != null
                                ? formContent.getTypeRequest() : "Was skipped")
                .replace(NOTE, formContent.getNote());
        return htmlEmailContent;
    }

    private void loadHtmlTemplate() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("email_form.html").getFile());
            template = IOUtils.readFileAtOnceAsString(file);
        } catch (NullPointerException | IOException e) {
            LOG.error("Can't load email template", e);
        }

    }
}

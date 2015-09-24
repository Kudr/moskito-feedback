package net.anotheria.moskito.feedback.rest.resource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
import java.util.HashMap;

/**
 * ReplyObject is a holder object for all rest api replies. It contains some status info and additional objects
 * with requested information.
 *
 * @author lrosenberg
 */
@XmlRootElement(name = "reply")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReplyObject {
    /**
     * True if the call was successful.
     */
    @XmlElement
    private boolean success;
    /**
     * Optional message in case call failed (exception message).
     */
    @XmlElement(required = false, nillable = false)
    private String message;

    /**
     * Map with results object.
     */
    @XmlElement
    private HashMap<String, Object> results = new HashMap<String, Object>();

    /**
     * Creates a new empty result object.
     */
    public ReplyObject() {

    }

    /**
     * Creates a new result object with one result.
     *
     * @param name   name of the result bean.
     * @param result object for the first result bean.
     */
    public ReplyObject(String name, Object result) {
        results.put(name, result);
    }

    /**
     * Creates a new result object with one result.
     *
     * @param result object for the first result bean.
     */
    public ReplyObject(Object result) {
        results.put(guessResultName(result), result);
    }

    public ReplyObject(Class pattern, Collection<?> result) {
        results.put(guessListResultName(pattern), result);
    }

    /**
     * Adds
     *
     * @param name
     * @param result
     */
    public void addResult(String name, Object result) {
        results.put(name, result);
    }

    /**
     * Factory method that creates a new reply object for successful request.
     *
     * @param name
     * @param result
     * @return
     */
    public static ReplyObject success(String name, Object result) {
        ReplyObject ret = new ReplyObject(name, result);
        ret.success = true;
        return ret;
    }

    /**
     * Factory method that creates a new reply object for successful request.
     *
     * @return
     */
    public static ReplyObject success() {
        ReplyObject ret = new ReplyObject();
        ret.success = true;
        return ret;
    }

    public static ReplyObject success(Object result) {
        ReplyObject ret = new ReplyObject(result);
        ret.success = true;
        return ret;
    }

    public static ReplyObject success(Class pattern, Collection<?> result) {
        ReplyObject ret = new ReplyObject(pattern, result);
        ret.success = true;
        return ret;
    }

    /**
     * Factory method that creates a new erroneous reply object.
     *
     * @param message
     * @return
     */
    public static ReplyObject error(String message) {
        ReplyObject ret = new ReplyObject();
        ret.success = false;
        ret.message = message;
        return ret;
    }

    public static ReplyObject error(Throwable exc) {
        ReplyObject ret = new ReplyObject();
        ret.success = false;
        ret.message = exc.getClass().getSimpleName() + ": " + exc.getMessage();
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("ReplyObject ");
        ret.append("Success: ").append(success);
        if (message != null) {
            ret.append(", Message: ").append(message);
        }
        ret.append(", Results: ").append(results);
        return ret.toString();
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public HashMap getResults() {
        return results;
    }

    private static String guessResultName(Object result) {
        return result.getClass().getSimpleName().toLowerCase();
    }

    private static String guessListResultName(Class pattern) {
        return pattern.getSimpleName().toLowerCase() + "s";
    }

}

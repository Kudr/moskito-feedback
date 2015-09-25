package net.anotheria.moskito.feedback.biz.mail;

import org.configureme.annotations.ConfigureMe;

/**
 * @author andriiskrypnyk
 */
@ConfigureMe(name = "mail-config", allfields = true)
public class MailConfig {

    private boolean smtpAuth;

    private boolean smtpStarttls;

    private String smtpHost;

    private int smtpPort;

    private String username;

    private String password;

    private String emailToNotificate;

    public boolean isSmtpAuth() {
        return smtpAuth;
    }

    public void setSmtpAuth(boolean smtpAuth) {
        this.smtpAuth = smtpAuth;
    }

    public boolean isSmtpStarttls() {
        return smtpStarttls;
    }

    public void setSmtpStarttls(boolean smtpStarttls) {
        this.smtpStarttls = smtpStarttls;
    }

    public String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    public int getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(int smtpPort) {
        this.smtpPort = smtpPort;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailToNotificate() {
        return emailToNotificate;
    }

    public void setEmailToNotificate(String emailToNotificate) {
        this.emailToNotificate = emailToNotificate;
    }

    @Override
    public String toString() {
        return "MailConfig{" +
                "smtpAuth=" + smtpAuth +
                ", smtpStarttls=" + smtpStarttls +
                ", smtpHost='" + smtpHost + '\'' +
                ", smtpPort=" + smtpPort +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", emailToNotificate='" + emailToNotificate + '\'' +
                '}';
    }
}

package ro.itschool.email;

public interface EmailSender {
    void sendEmail(String toEmail, String subject, String body);
}

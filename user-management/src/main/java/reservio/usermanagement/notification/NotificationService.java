//package reservio.usermanagement.notification;
//
//import jakarta.mail.MessagingException;
//import jakarta.mail.internet.MimeMessage;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class NotificationService{
//
//    private final JavaMailSender mailSender;
//
//    public void send(String to, String email) throws MessagingException {
//        try {
//            MimeMessage mimeMessage = mailSender.createMimeMessage();
//            MimeMessageHelper helper =
//                    new MimeMessageHelper(mimeMessage, "utf-8");
//            helper.setText(email, true);
//            helper.setTo(to);
//            helper.setSubject("Confirm your email");
//            helper.setFrom("hello@amigoscode.com");
//            mailSender.send(mimeMessage);
//        } catch (MessagingException e) {
//            log.error("failed to send email", e);
//            throw new IllegalStateException("failed to send email");
//        }
//    }
//
//}

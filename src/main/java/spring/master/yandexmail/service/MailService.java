package spring.master.yandexmail.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import spring.master.yandexmail.payload.SendMailModel;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSenderImpl javaMailSender;

    public void send(SendMailModel sendMailModel, String subject) throws MessagingException {
        log.info(sendMailModel.toString());
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
        mimeMessageHelper.setTo(sendMailModel.getTargetEmail());
        mimeMessageHelper.setFrom("set-your-email");
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(sendMailModel.getMessage(), false);
        javaMailSender.send(mimeMessage);
    }
}

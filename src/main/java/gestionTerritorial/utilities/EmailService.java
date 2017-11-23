package gestionTerritorial.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

  private JavaMailSender javaMailSender;

  @Autowired
  public EmailService(JavaMailSender javaMailSender) {
    this.javaMailSender = javaMailSender;
  }

  @Async
  public void sendMail(String contacto) {
    SimpleMailMessage mail = new SimpleMailMessage();
    mail.setTo(contacto);
    mail.setFrom("xxxx-@gmail.com");
    mail.setSubject("Asunto del mail");
    mail.setText("Contenido del mail");
    javaMailSender.send(mail);
    System.out.println("Email enviado!");
  }
}

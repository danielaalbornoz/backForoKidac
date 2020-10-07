package com.example.foro.services;

import com.example.foro.entities.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class CorreoServiceImpl implements CorreoService{

    private static final Logger LOGGER = LoggerFactory.getLogger(CorreoServiceImpl.class);

    @Autowired
    private JavaMailSender sender;

    @Override
    public void sendCorreo(Usuario user) {
        String email= user.getCorreo();
        String textMessage = "Saludos queridx "+ user.getNombre() +" "+ user.getApellidoP() +" tu dirección de correo: "+user.getCorreo()+", ha sido registrado exitosamente en nuestra página, gracias por formar parte de la comunidad de Kidac.";
        String subject = "¡Registro exitoso! Bienvenido a KIDAC";

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(email);
            helper.setText(textMessage, true);
            helper.setSubject(subject);
            sender.send(message);
            LOGGER.info("Correo enviado exitosamente!");
        } catch (MessagingException e) {
            LOGGER.error("Hubo un error al enviar el mail: {}", e);
        }
    }
}

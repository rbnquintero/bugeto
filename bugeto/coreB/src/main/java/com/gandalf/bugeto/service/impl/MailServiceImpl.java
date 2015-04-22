package com.gandalf.bugeto.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gandalf.bugeto.exception.ServiceException;
import com.gandalf.bugeto.service.MailService;
import com.gandalf.bugeto.util.Properties;

@Service
public class MailServiceImpl implements MailService {
	private static final Logger _log = LoggerFactory.getLogger(MailServiceImpl.class);

	@Autowired
	private Properties properties;

	@Autowired
	private Session session;

	@Override
	public void sendMail(String to, String subject, String content, boolean isHtml) throws ServiceException {
		try {
			MimeMessage message = new MimeMessage(session);

			try {
				message.setFrom(new InternetAddress(properties.getProperty("mail.smtp.from"), properties.getProperty("mail.smtp.fromName")));
			} catch (UnsupportedEncodingException e) {
				message.setFrom(new InternetAddress(properties.getProperty("mail.smtp.from")));
			}

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject, properties.getProperty("mail.smtp.encoding"));
			message.setSentDate(new Date());
			if (isHtml) {
				message.setText(content, properties.getProperty("mail.smtp.encoding"), "html");
			} else {
				message.setText(content);
			}

			Transport.send(message);
			_log.debug("Ya se envió el mensaje");
		} catch (MessagingException me) {
			throw new ServiceException("No se pudo mandar el correo", me);
		}
	}
}

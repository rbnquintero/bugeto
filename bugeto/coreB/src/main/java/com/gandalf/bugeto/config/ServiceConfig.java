package com.gandalf.bugeto.config;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.gandalf.bugeto.util.Properties;

@Configuration
public class ServiceConfig {
	@Autowired
	private Properties props;

	@Lazy
	@Bean
	public Session getMailSession() {
		final String username = props.getProperty("mail.smtp.user");
		final String password = props.getProperty("mail.smtp.pass");

		java.util.Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.auth", props.getProperty("mail.smtp.auth"));
		properties.setProperty("mail.smtp.starttls.enable", props.getProperty("mail.smtp.starttls.enable"));
		properties.setProperty("mail.smtp.host", props.getProperty("mail.smtp.host"));
		properties.setProperty("mail.smtp.port", props.getProperty("mail.smtp.port"));

		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		return session;
		// InitialContext ic;
		// try {
		// ic = new InitialContext();
		// Session session = (Session) ic.lookup("cablevisionMailSession");
		// return session;
		// } catch (NamingException e) {
		// e.printStackTrace();
		// return null;
		// }
	}
}

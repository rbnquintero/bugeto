package com.gandalf.bugeto.service;

import com.gandalf.bugeto.exception.ServiceException;

public interface MailService {
	public void sendMail(String to, String subject, String content, boolean isHtml) throws ServiceException;
}

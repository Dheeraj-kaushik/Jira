package org.fullstack.dheeraj.service;

import org.fullstack.dheeraj.dto.RequestCompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(String to , String body , String topic) {
		System.out.println("Mail service working.......");
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("Dheeraj-JIRA@gmail.com");
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(topic);
		simpleMailMessage.setText(body);
		javaMailSender.send(simpleMailMessage);
		System.out.println("mail is sent............");
	}
	
}

package cs544.project.onlineshoppingstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTaskServiceImpl implements ScheduledTaskService {

	@Autowired
	private MailSender mailSender;
	
	@Override
	public void sendEmail(String emailAddress) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(emailAddress);
		message.setSubject("AJM : Thank you for ordering with us");
		message.setText("We have recived your order : /n ");
		mailSender.send(message);

	}

}

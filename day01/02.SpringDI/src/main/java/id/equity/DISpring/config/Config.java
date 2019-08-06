package id.equity.DISpring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import id.equity.DISpring.service.EmailService;
import id.equity.DISpring.service.MessageService;
import id.equity.DISpring.service.SMSService;

@Configuration
@ComponentScan(value= {"id.equity.DISpring.consumer"})
public class Config {

	@Bean
	@Primary
	public MessageService getEmailService() {
		return new EmailService();
	}
	
	@Bean
	public MessageService getSMSService() {
		return new SMSService();
	}
}

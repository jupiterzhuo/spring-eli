package id.equity.DISpring.consumer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import id.equity.DISpring.service.MessageService;

@Component
public class Consumer{
	
	@Autowired
	//@Qualifier("getSMSService")
	@Qualifier("getEmailService")
	private MessageService messageService;
	
	public void processMessage(String msg, String rec) {
		this.messageService.sendMessage(msg, rec);
	}
}

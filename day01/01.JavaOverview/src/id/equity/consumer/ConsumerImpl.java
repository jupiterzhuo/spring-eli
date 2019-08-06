package id.equity.consumer;

import id.equity.service.MessageService;

public class ConsumerImpl implements Consumer {
	private MessageService messageService;
	
	
	// Inject using constructor
	public ConsumerImpl(MessageService messageService) {
		this.messageService = messageService;
	}

	
	//Inject Using Setter 
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	


	@Override
	public void processMessage(String msg, String rec) {
		// TODO Auto-generated method stub
		this.messageService.sendMessage(msg, rec);
	}




}

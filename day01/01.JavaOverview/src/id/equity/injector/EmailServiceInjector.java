package id.equity.injector;

import id.equity.consumer.Consumer;
import id.equity.consumer.ConsumerImpl;
import id.equity.service.EmailService;

public class EmailServiceInjector implements MessageServiceInjector {

	@Override
	public Consumer getConsumer() {
		// TODO Auto-generated method stub
		return  new ConsumerImpl(new EmailService());
	}

}

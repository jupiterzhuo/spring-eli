import id.equity.consumer.Consumer;
import id.equity.injector.EmailServiceInjector;
import id.equity.injector.MessageServiceInjector;
import id.equity.injector.SMSServiceInjector;

public class MyServiceApplication {
	public static void main(String[] args) {
		String message = "Hello ini adalah message";
		String email = "jupiterc@gmail.com";
		String phone = "+6293299382828";
		
		MessageServiceInjector injector = null;
		Consumer app = null;
		
		//Send Email 
		injector =new EmailServiceInjector();
		app =injector.getConsumer();
		app.processMessage(message, email);
		
		//Send SMS
		injector =new SMSServiceInjector();
		app =injector.getConsumer();
		app.processMessage(message, phone);
		
	}
}

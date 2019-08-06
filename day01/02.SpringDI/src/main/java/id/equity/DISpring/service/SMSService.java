package id.equity.DISpring.service;

public class SMSService implements MessageService {

	@Override
	public void sendMessage(String message, String receiver) {
		// TODO Auto-generated method stub
		
		System.out.println("SMS sent to " + 
				receiver + " With Message : " + message);
	}

	@Override
	public void sendReport(String reportTo) {
		// TODO Auto-generated method stub
		
	}

}

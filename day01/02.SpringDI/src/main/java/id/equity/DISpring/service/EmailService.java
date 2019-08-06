package id.equity.DISpring.service;

public class EmailService implements MessageService {

	@Override
	public void sendMessage(String message, String receiver) {
		// TODO Auto-generated method stub
		System.out.println("email sent to " + 
		receiver + " With Message : " + message);
	}

	@Override
	public void sendReport(String reportTo) {
		// TODO Auto-generated method stub
		
	}

}

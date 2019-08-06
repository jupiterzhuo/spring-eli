package id.equity.DISpring.service;

public interface MessageService {
	void sendMessage(String message, String receiver);
	void sendReport(String reportTo);
}

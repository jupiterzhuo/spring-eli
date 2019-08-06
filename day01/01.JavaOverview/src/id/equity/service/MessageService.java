package id.equity.service;

public interface MessageService {
	void sendMessage(String message, String receiver);
	void sendReport(String reportTo);
}

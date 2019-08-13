package id.equity.jdbc.services;

import org.springframework.stereotype.Service;

import id.equity.jdbc.exceptions.TransferFundException;


public interface TransferFundService {
	public void addAmount(Long id, Double amount) 
    		throws TransferFundException;
    public void transferFund(Long fromAccount, Long toAccount,Double amount) 
    		throws TransferFundException;
}

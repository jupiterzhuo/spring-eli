package id.equity.jdbc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import id.equity.jdbc.exceptions.TransferFundException;
import id.equity.jdbc.form.TransferFund;
import id.equity.jdbc.models.BankAccount;
import id.equity.jdbc.repositories.BankAccountRepository;
import id.equity.jdbc.services.TransferFundService;

@Controller
public class BankAccountController {
	@Autowired
	private TransferFundService transferFundService;
	@Autowired
	private BankAccountRepository bankAccountRespository;
	@RequestMapping(value = {"/","/index"},method = RequestMethod.GET)
    public String listBankAccount (Model model){
        List<BankAccount> bankAccountList = 
        		(List<BankAccount>) bankAccountRespository.findByFirstNameLike("Ju%");
        model.addAttribute(bankAccountList);
        return "AccountListPage";
    }
	@RequestMapping(value = {"/transferFund"},method = RequestMethod.GET)
	public String transferFund(Model model){
        TransferFund transferFund =new TransferFund();
        model.addAttribute(transferFund);
        return "TransferFundPage";
    }
	
	 @RequestMapping(value = {"/transferFund"},method = RequestMethod.POST)
	    public String processTransfer(Model model,TransferFund transferFund){
	        try{
	        	transferFundService.transferFund(
	                   transferFund.getFromId(),
	                   transferFund.getToId(),
	                   transferFund.getBalance()
	           );
	        }
	        catch (TransferFundException e){
	            model.addAttribute("errorMessage","Error "+e.getMessage());
	            return "transferFundPage";
	        }
	        return "redirect:/";

	 }
	
}
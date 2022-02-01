package com.rajivgiri.runnables;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.concurrent.Callable;

import com.rajivgiri.beans.BankAccount;
import com.rajivgiri.beans.BankAccountTransaction;
import com.rajivgiri.dao.BankAccountDAO;

public class ReportsProcessor implements Callable<Boolean>{

	private BankAccount account;
	private BankAccountDAO dao;
	
	
	public ReportsProcessor(BankAccount account, BankAccountDAO dao) {
		super();
		this.account = account;
		this.dao = dao;
	}
	
	@Override
	public Boolean call() throws Exception {
		// TODO Auto-generated method stub
	boolean reportGenerated=false;	
	List<BankAccountTransaction> transactions = dao.getTransactionsForBankAccounts(account);
	File file = new File("/JavaEEConcurrency/Reports" + account.getAccNumber()+"_tx_report.txt");
	
	try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
	for(BankAccountTransaction transaction:transactions) {
		writer.write("Account Number: "+ transaction.getAccNUmber());
		writer.write("Transaction Type: "+ transaction.getTransType());
		writer.write("Transaction ID: "+ transaction.getTransId());
		writer.write("Transaction Date: "+ transaction.getTransDate());
		writer.write("Amount: "+ transaction.getAmount());
		writer.newLine();
		
		
		}
	    writer.flush();
		
		
	}
	reportGenerated=true;
	return reportGenerated;
	}
	
}

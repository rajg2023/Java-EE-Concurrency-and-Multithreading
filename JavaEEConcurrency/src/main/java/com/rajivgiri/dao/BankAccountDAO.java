package com.rajivgiri.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import com.rajivgiri.beans.BankAccount;
import com.rajivgiri.beans.BankAccountTransaction;

public class BankAccountDAO {

	private DataSource dataSource;
	
	public BankAccountDAO(DataSource dataSource) {
		
		this.dataSource=dataSource;
	}
	
	public List<BankAccount>getAllBankAccounts(){
		
		List<BankAccount>accounts = new ArrayList<>();
		BankAccount account = null;
		
		try {
			
		Connection conn = dataSource.getConnection();	
		Statement statement = conn.createStatement();		
		ResultSet set =statement.executeQuery("Select * from bank_account");
		while(set.next()) {
			account = new BankAccount();
			account.setAccNumber(set.getInt("acc_number"));
			account.setName(set.getString("acc_holder_name"));
			account.setEmail(set.getString("acc_holder_email"));
			account.setPhoneNumber(set.getInt("acc_phone_number"));
			account.setAddress(set.getString("acc_holder_address"));
			account.setZipCode(set.getInt("acc_zip_code"));
			account.setAccountType(set.getString("acc_type"));
			accounts.add(account);
		}
					
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return accounts;	
  }
 
	
	public List<BankAccountTransaction>getTransactionsForBankAccounts(BankAccount account){
	    BankAccountTransaction transaction =null;
		List<BankAccountTransaction>transactions = new ArrayList<>();
		
		try {			
		Connection conn = dataSource.getConnection();		
		PreparedStatement statement = conn.prepareStatement("Select * from bank_account_transaction where acc_number=?");
		statement.setInt(1, account.getAccNumber());
		ResultSet set = statement.executeQuery();
		while(set.next()) {
		transaction = new BankAccountTransaction();
		transaction.setAccNUmber(set.getInt("acc_number"));
		transaction.setAmount(set.getDouble("amount"));
		transaction.setTransDate(new Date(set.getDate("transaction_date").getTime()));
		transaction.setTransType(set.getString("transaction_type"));
		transaction.setTransId(set.getInt("transaction_id"));
		transactions.add(transaction);
		
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return transactions;
 }
}

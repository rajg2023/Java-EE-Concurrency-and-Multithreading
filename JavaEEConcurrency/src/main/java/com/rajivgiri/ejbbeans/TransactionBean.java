package com.rajivgiri.ejbbeans;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 * Session Bean implementation class TransactionBean
 */
@Stateless(name = "tx-bean")
public class TransactionBean {

	@Resource(name = "jdbc/bank_account_transaction_logs")
	private DataSource source1;

	@Resource(name = "jdbc/bank_account_transaction_logs")
	private DataSource source2;

	public void saveBankAccountTransaction() throws SQLException {

		Connection connection = source1.getConnection();
		Statement statement = connection.createStatement();
		statement.executeUpdate("insert into bank_account_transaction values (1,9101,'debit',400,'"
				+ new Date(System.currentTimeMillis()) + "')");
	}

	public void saveBankAccountTransactionLog() throws SQLException {
		Connection connection = source2.getConnection();
		Statement statement = connection.createStatement();
		statement.executeUpdate("insert into bank_account_transaction_logs values (4,1,'system','"
				+ new Date(System.currentTimeMillis()) + "')");

	}

}

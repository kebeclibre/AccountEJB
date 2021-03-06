package ejb.account.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	private int accountId;
	private double accountBalance;
	private double accountCreditLine;
	private String accountNumber;
	private List<User> users;

	public Account() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getAccountId() {
		return this.accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}


	public double getAccountBalance() {
		return this.accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}


	public double getAccountCreditLine() {
		return this.accountCreditLine;
	}

	public void setAccountCreditLine(double accountCreditLine) {
		this.accountCreditLine = accountCreditLine;
	}


	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="account", fetch=FetchType.EAGER)
	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setAccount(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setAccount(null);

		return user;
	}

}
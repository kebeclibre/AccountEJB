package ejb.account.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
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
	private List<Userstoaccount> userstoaccounts;
	public List<User> users;

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


	//bi-directional many-to-one association to Userstoaccount
	@OneToMany(mappedBy="account", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	public List<Userstoaccount> getUserstoaccounts() {
		return this.userstoaccounts;
	}

	public void setUserstoaccounts(List<Userstoaccount> userstoaccounts) {
		this.userstoaccounts = userstoaccounts;
	}

	public Userstoaccount addUserstoaccount(Userstoaccount userstoaccount) {
		getUserstoaccounts().add(userstoaccount);
		userstoaccount.setAccount(this);

		return userstoaccount;
	}

	public Userstoaccount removeUserstoaccount(Userstoaccount userstoaccount) {
		getUserstoaccounts().remove(userstoaccount);
		userstoaccount.setAccount(null);

		return userstoaccount;
	}
	
	public List<User> associatedUsers() {
		if (null!=userstoaccounts){
			users = new ArrayList<>();
		for (Userstoaccount uta : userstoaccounts) {
			users.add(uta.getUser());
		}}
		
		return users;
	}

}
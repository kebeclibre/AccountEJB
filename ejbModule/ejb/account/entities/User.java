package ejb.account.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private int userId;
	//private int accountId;
	private String password;
	private String username;
	private List<Userstoaccount> userstoaccounts;

	public User() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


//	public int getAccountId() {
//		return this.accountId;
//	}
//
//	public void setAccountId(int accountId) {
//		this.accountId = accountId;
//	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	//bi-directional many-to-one association to Userstoaccount
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	public List<Userstoaccount> getUserstoaccounts() {
		return this.userstoaccounts;
	}

	public void setUserstoaccounts(List<Userstoaccount> userstoaccounts) {
		this.userstoaccounts = userstoaccounts;
	}

	public Userstoaccount addUserstoaccount(Userstoaccount userstoaccount) {
		getUserstoaccounts().add(userstoaccount);
		userstoaccount.setUser(this);

		return userstoaccount;
	}

	public Userstoaccount removeUserstoaccount(Userstoaccount userstoaccount) {
		getUserstoaccounts().remove(userstoaccount);
		userstoaccount.setUser(null);

		return userstoaccount;
	}
	
	public List<Account> prendreAccounts() {
		List<Account> listAccount = new ArrayList<>();
		for (Userstoaccount uta : userstoaccounts) {
			listAccount.add(uta.getAccount());
		}
		
		return listAccount;
	}

}
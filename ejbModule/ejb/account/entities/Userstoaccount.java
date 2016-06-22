package ejb.account.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the userstoaccount database table.
 * 
 */
@Entity
@NamedQuery(name="Userstoaccount.findAll", query="SELECT u FROM Userstoaccount u")
public class Userstoaccount implements Serializable {
	private static final long serialVersionUID = 1L;
	private int utaid;
	private Account account;
	private User user;

	public Userstoaccount() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getUtaid() {
		return this.utaid;
	}

	public void setUtaid(int utaid) {
		this.utaid = utaid;
	}


	//bi-directional many-to-one association to Account
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="account_id")
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}


	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
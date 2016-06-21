package ejb.account.session;

import java.util.List;

import javax.ejb.Remote;

import ejb.account.entities.Account;

@Remote
public interface AccountSessionRemote {
	
	public void updateAcccount(Account a);
	
	public void removeAccount(Account a);
	
	public List<Account> searchAccountByNumber(String num);
	
	public List<Account> getAll();
	
	public void create(Account a);
	
	
	
	
}

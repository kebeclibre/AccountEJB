package ejb.account.session;

import java.util.List;

import javax.ejb.Remote;

import ejb.account.entities.Account;
import ejb.account.entities.User;

@Remote
public interface AccountSessionRemote {
	
	public void updateAccount(Account a);
	
	public void removeAccount(Account a);
	
	public List<Account> searchAccountByNumber(String num);
	
	public List<Account> getAll();
	
	public void create(Account a);
	
	public Account getAccountById(int id);
	

	
	
}

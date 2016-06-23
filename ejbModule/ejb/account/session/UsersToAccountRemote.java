package ejb.account.session;

import javax.ejb.Remote;

import ejb.account.entities.Account;
import ejb.account.entities.User;
import ejb.account.entities.Userstoaccount;

@Remote
public interface UsersToAccountRemote {
	public User getUserEntity(Userstoaccount rel);
	public Account getAccountEntity(Userstoaccount rel);
	public void updateAccount(Userstoaccount rel);
	public void updateUser(Userstoaccount rel);
	public void createRel(Userstoaccount rel);
	public void addAccountToUser(Account a, User u);
	public void addUserToAccount(Account a, User u);
	public void removeRel(Userstoaccount rel);
	
	
}

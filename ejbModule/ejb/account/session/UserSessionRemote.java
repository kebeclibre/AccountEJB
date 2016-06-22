package ejb.account.session;

import java.util.List;

import javax.ejb.Remote;
import ejb.account.entities.*;

@Remote
public interface UserSessionRemote {
	public void createMultipleUsers(List<User> ul);
	
	public void updateUser(User u);
	
	public void removeUser(User u);
	
	public List<User> searchUserByName(String name);
	
	public List<User> getAll();
	
	public void create(User ul);
	
	public User getUserWithCredentials(String username, String password);
	
	public User getUserById(int id);
	
	public void addAccountToUser(User u, Account a);
	
	public void persistRelation(Userstoaccount rel);
}

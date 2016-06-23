package ejb.account.session;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ejb.account.entities.Account;
import ejb.account.entities.User;
import ejb.account.entities.Userstoaccount;
import ejb.account.utils.*;

/**
 * Session Bean implementation class UsersToAccount
 */
@Stateless
@LocalBean
public class UsersToAccount implements UsersToAccountRemote {
	
	AccountSessionRemote accountSess = (AccountSessionRemote) GetLookUp.getSessionBean("AccountSession");
	UserSessionRemote UserSess = (UserSessionRemote) GetLookUp.getSessionBean("UserSession");
	
	@PersistenceContext(unitName="pu")
	private EntityManager em;
	
    public UsersToAccount() {
    }

	@Override
	public User getUserEntity(Userstoaccount rel) {
		return null;
	}

	@Override
	public Account getAccountEntity(Userstoaccount rel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAccount(Userstoaccount rel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(Userstoaccount rel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createRel(Userstoaccount rel) {
		em.merge(rel);	
	}

	@Override
	public void addAccountToUser(Account a, User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUserToAccount(Account a, User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeRel(Userstoaccount rel) {
		em.remove(rel);
		
	}
    
    

}

package ejb.account.session;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transaction;
import javax.transaction.TransactionSynchronizationRegistry;

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
	
	@Resource
	TransactionSynchronizationRegistry txReg;
	
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
		Userstoaccount fromDB = em.find(Userstoaccount.class, rel.getUtaid());
		em.remove(fromDB);
		
	}

	@Override
	public int removeRelByCombinedId(int userId, int accountId) {
		User u = em.find(User.class, userId);
		Account a = em.find(Account.class, accountId);
		
		List<Userstoaccount> list = em.createQuery("select uta from Userstoaccount uta where uta.account=:aid",Userstoaccount.class)				
				.setParameter("aid", a)
				.getResultList();
		
		
		
		int affectedRows = em.createQuery("delete from Userstoaccount uta where uta.account=:aid and uta.user=:uid")
				.setParameter("aid", a)
				.setParameter("uid", u)
				.executeUpdate();
		
		if (list.size()<=1) {
			int rmOrphanAccount = em.createQuery("delete from Account a where a=:aid")
			.setParameter("aid", a)
			.executeUpdate();
		}
		
		
		return affectedRows;
		
	}
	
    
    

}

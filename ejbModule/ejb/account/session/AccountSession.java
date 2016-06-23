package ejb.account.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;

import ejb.account.entities.Account;

/**
 * Session Bean implementation class AccountSession
 */
@Stateless
@LocalBean
public class AccountSession implements AccountSessionRemote {
	
	@PersistenceContext(unitName="pu")
    private EntityManager em;
	
    public AccountSession() {
    }

	@Override
	public void updateAccount(Account a) {
		em.merge(a);
		
	}

	@Override
	public void removeAccount(Account a) {
		em.remove(a);
		
	}

	@Override
	public List<Account> searchAccountByNumber(String num) {
		return em.createQuery("select a from Account a where a.accountNumber LIKE "+num+"", Account.class).getResultList();
	}

	@Override
	public List<Account> getAll() {
		return em.createNamedQuery("Account.findAll", Account.class).getResultList();
	}

	@Override
	public void create(Account a) {
		em.persist(a);
		
	}

	@Override
	public Account getAccountById(int id) {
		TypedQuery<Account> tq =  em.createQuery("select a from Account a where a.accountId=:aid",Account.class).setParameter("aid", id);
		if (null != tq) {
			return tq.getSingleResult();
		}
		
		return null;
	}
    
    
    
    
}

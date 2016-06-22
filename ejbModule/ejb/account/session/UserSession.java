package ejb.account.session;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;

import ejb.account.entities.Account;
import ejb.account.entities.User;
import ejb.account.entities.Userstoaccount;


/**
 * Session Bean implementation class UserSession
 */
@Stateless
@LocalBean
public class UserSession implements UserSessionRemote {
	@PersistenceContext(unitName="pu")
	private EntityManager em;
	
    public UserSession() {
    }

	@Override
	public void createMultipleUsers(List<User> ul) {			
			for (User u : ul) {
				em.persist(u);
			}
		
	}

	@Override
	public void updateUser(User u) {
		User usr = em.find(User.class, u.getUserId());
		em.merge(usr);		
	}
	
	@Override
	public void addAccountToUser(User u,Account a) {
		User usr = em.find(User.class, u.getUserId());
		usr.prendreAccounts().add(a);
		em.merge(usr);
	}

	@Override
	public void removeUser(User u) {
		em.remove(u);
		
	}

	@Override
	public List<User> searchUserByName(String name) {
		return em.createQuery("Select u From User u WHERE u.username LIKE "+name+"",User.class).getResultList();
	}

	@Override
	public List<User> getAll() {
			return em.createNamedQuery("User.findAll",User.class).getResultList();
	}
	
	public void create(User u) {
		em.persist(u);
	}

	public User getUserWithCredentials(String username, String password) {
		TypedQuery<User> tq = em.createQuery("select u from User u where u.username=:uname AND u.password=:upwd",User.class)
				.setParameter("uname", username)
				.setParameter("upwd",password);
		if (null != tq) {
			return tq.getSingleResult();
		}
		
		return null;
				
	}
	
	public User getUserById(int id) {
		TypedQuery<User> tq =  em.createQuery("select u from User u where u.userId=:aid",User.class).setParameter("aid", id);
		if (null != tq) {
			return tq.getSingleResult();
		}
		
		return null;
	}

	@Override
	public void persistRelation(Userstoaccount rel) {
		em.persist(rel);
		
	}
	

	
    
}

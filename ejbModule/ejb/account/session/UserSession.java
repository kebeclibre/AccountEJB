package ejb.account.session;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ejb.account.entities.User;


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
		usr.setAccount(u.getAccount());
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
    
}

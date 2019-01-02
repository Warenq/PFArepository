package beans;

import java.util.List;

import javax.ejb.Stateless;

import com.entity.Contact;

/**
 * Session Bean implementation class ContactBean
 */
@Stateless
public class ContactBean implements ContactBeanLocal {

    /**
     * Default constructor. 
     */
    public ContactBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void add(Contact c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Contact c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Contact> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

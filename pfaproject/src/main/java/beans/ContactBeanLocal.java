package beans;

import java.util.List;

import javax.ejb.Local;

import com.entity.Contact;

@Local
public interface ContactBeanLocal {

		void add(Contact c);
		void delete (Contact c);
		List<Contact> getAll();
		
}

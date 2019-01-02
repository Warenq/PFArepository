import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.emsi.dao.ContactDao;
import com.emsi.model.Contact;

public class JCase1 {
	ContactDao cd;
	@Before
	public void setUp() throws Exception {
		cd = new ContactDao();
	}

	@Test
	public void test() {
		if(cd.findall() == null)fail("The FindAll Function returns null !");
		// Testing the error
		try {
		List<Contact> lc = cd.findall();
		if(lc == null)fail("Findall's returned list just Can't be transfered to another List !");
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
	}

}

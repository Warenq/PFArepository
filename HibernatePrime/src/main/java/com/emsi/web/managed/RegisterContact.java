package com.emsi.web.managed;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.emsi.dao.ContactDao;
import com.emsi.model.Contact;

@ManagedBean
@SessionScoped
public class RegisterContact {
	private Contact contact = new Contact();

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public String register() {
		ContactDao dao = new ContactDao();
		dao.add(contact);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Contact " + this.contact.getNom() + " a été enregistré avec succés"));
		return "";
	}

}

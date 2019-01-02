package com.emsi.prime;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.emsi.dao.ContactDao;
import com.emsi.model.Contact;

@ManagedBean(name="dtBasicView")
@ViewScoped
public class BasicView implements Serializable {
     
     
	@ManagedProperty("#{ContactDao}")
    private ContactDao service;
    public List<Contact> cs;
 
    @PostConstruct
    public void init() {
    	service = new ContactDao();
        cs = getContacts();
    	}
     
    public List<Contact> getContacts() {
    	for(Contact c : service.findall()) {
    		cs.add(c);
    	}
    	return cs;
    }
 
    public void setService(ContactDao service) {
        this.service = service;
    }
}
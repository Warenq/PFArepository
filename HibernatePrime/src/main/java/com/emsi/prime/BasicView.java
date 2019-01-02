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
    @EJB
    private ContactDao service;
    public List<Contact> cs;
 
    @PostConstruct
    public void init() {
        cs = getContacts();
    	}
     
    public List<Contact> getContacts() {
    	return service.findall();
    }
 
    public void setService(ContactDao service) {
        this.service = service;
    }
}
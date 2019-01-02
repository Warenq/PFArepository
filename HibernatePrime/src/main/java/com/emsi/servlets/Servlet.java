package com.emsi.servlets;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emsi.dao.ContactDao;
import com.emsi.model.Contact;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	ContactDao cd = new ContactDao();

	public Servlet() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter w = response.getWriter();
		String tag1 = "<link href='lib/css/bootstrap.min.css' rel='stylesheet' type='text/css'/><script language='javascript' type='text/javascript' src='lib/js/bootstrap.min.js'></script>";
		w.println("<html><head><title>List</title></head>" + tag1 + "<body>");
		w.println("<table class='table table-dark'><tr><td>Nom</td><td>Numero</td></tr>");

		for (Contact c : cd.findall()) {
			// Show in table
			w.println("<tr><td>" + c.getNom() + "</td><td>" + c.getNum() + "</td></tr>");
			
			
			// Creating file or just writing on it
			String filename = Integer.toString(c.getId_contact());
			File f = new File("C:\\VCARDFILES\\"+filename+".vcard");
			try {
				FileWriter fw;
				if (f.exists()) {
					fw = new FileWriter(f, false);
				} else {
					f.createNewFile();
					fw = new FileWriter(f);
				}
				// Now we write in the VCARD FILE
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("BEGIN:VCARD");
				bw.newLine();
				bw.write("VERSION:3.0");
				bw.newLine();
				bw.write("TILE:"+c.getNom());
				bw.newLine();
				bw.write("TEL;TYPE=HOME,VOICE:"+c.getNum());
				bw.newLine();
				bw.write("END:VCARD");
				bw.close();
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		w.print("</table></body></html><br><span class='badge badge-info'>Verifier vos Vcard & n'oublier pas de créer un dossier VCARDFILES dans c:/ ...</span");
	}

}

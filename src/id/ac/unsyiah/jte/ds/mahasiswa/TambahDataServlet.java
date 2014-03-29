package id.ac.unsyiah.jte.ds.mahasiswa;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

@SuppressWarnings("serial")
public class TambahDataServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws IOException, ServletException 
	{
		resp.setContentType("text/html");
		RequestDispatcher jsp = req.getRequestDispatcher("tambah.jsp");
		jsp.forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException
	{
		String Nama = req.getParameter("txtNama");
		String NIM = req.getParameter("txtNIM");
		String email = req.getParameter("txtEmail");
		String noHP = req.getParameter("txtNoHP");
		String Aktif = req.getParameter("txtAktif");

		Entity entity = new Entity("DataMahasiswa");
		entity.setProperty("nama", Nama);
		entity.setProperty("NIM", NIM);
		entity.setProperty("email", email);
		entity.setProperty("noHP", noHP);
		entity.setProperty("aktif", Aktif);	
		DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
		datastoreService.put(entity);
		
		resp.sendRedirect("/");	
	}
}

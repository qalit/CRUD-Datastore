/**
 * HapusDataServlet.java Mar 29, 2014
 */
package id.ac.unsyiah.jte.ds.mahasiswa;

/**
 * @author Al Qalit
 *
 */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterPredicate;

@SuppressWarnings("serial")
public class HapusDataServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws IOException, ServletException 
	{
		// Ambil ID dari data yang mau ditampilkan
		long keyId = Long.valueOf(req.getParameter("id"));
		Key key = KeyFactory.createKey("DataMahasiswa", keyId);

		// Bangun query-nya
		FilterPredicate filter = new Query.FilterPredicate(Entity.KEY_RESERVED_PROPERTY,
				  										   Query.FilterOperator.EQUAL,
				  										   key); 
		Query query = new Query("DataMahasiswa");
		query.setFilter(filter);
		
		// Baca
		DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
		PreparedQuery preparedQuery = datastoreService.prepare(query);
		Entity data = preparedQuery.asSingleEntity();
		
		// Kirim ke halaman
		req.setAttribute("data", data);
		
		// Tampilkan halaman
		resp.setContentType("text/html");
		RequestDispatcher jsp = req.getRequestDispatcher("hapus.jsp");
		jsp.forward(req, resp);		
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException
	{
		// Ambil ID dari data yang mau ditampilkan
		long keyId = Long.valueOf(req.getParameter("hdnId"));
		Key key = KeyFactory.createKey("DataMahasiswa", keyId);
		
		// Baca
		DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
		datastoreService.delete(key);
		
		resp.sendRedirect("/");	
	}
}
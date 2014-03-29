package id.ac.unsyiah.jte.ds.mahasiswa;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

@SuppressWarnings("serial")
public class DaftarServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws IOException, ServletException 
	{
		Query query = new Query("DataMahasiswa");
		
		DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
		PreparedQuery preparedQuery = datastoreService.prepare(query);

		FetchOptions fetchOptions = FetchOptions.Builder.withOffset(0);
		List<Entity> daftar = preparedQuery.asList(fetchOptions);
		
		req.setAttribute("daftar", daftar);
		
		resp.setContentType("text/html");
		RequestDispatcher jsp = req.getRequestDispatcher("mahasiswa.jsp");
		jsp.forward(req, resp);		
	}
}

package loginmongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.UnknownHostException;

public class Login extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");

        String username = request.getParameter("txtUn"); 
        String password = request.getParameter("txtPw"); 

        try {
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("userName", username); // pass username 
            searchQuery.put("usrPass", password); // pass password 
            DBCursor cursor = MongoDBConListener.dbcoll.find(searchQuery); // send the query to the collection

            if (cursor.hasNext()) { 
                // check if query has a valid result
                response.sendRedirect("success.html");
            } else {
                response.sendRedirect("error.html");
            }
        } catch (UnknownHostException ex) {
            ex.printStackTrace();


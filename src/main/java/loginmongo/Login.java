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

        String username = request.getParameter("txtUn"); // get the name entered by user's input
        String password = request.getParameter("txtPw"); //get the password entered by user's input

        try {
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("userName", username); // Gives user name to the query
            searchQuery.put("usrPass", password); // Gives password to the query
            DBCursor cursor = MongoDBConListener.dbcoll.find(searchQuery); // send the query to the collection

            if (cursor.hasNext()) { // check whether the query has a result
                response.sendRedirect("success.html");
            } else {
                response.sendRedirect("error.html");
            }
        } catch (UnknownHostException ex) {
            ex.printStackTrace();


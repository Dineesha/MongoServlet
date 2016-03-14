package loginmongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.UnknownHostException;

public class MongoDBConListener implements ServletContextListener {

    static MongoClient cl = null;
    static DBCollection col = null;

    //@Override
    public void contextInitialized(ServletContextEvent sce) {
       
        try {
            ServletContext ctx = sce.getServletContext();

            cl = new MongoClient(ctx.getInitParameter("MONGO_HOST"),// Database host
                    Integer.parseInt(ctx.getInitParameter("MONGO_PORT"))); // Connecting port
            DB db = cl.getDB(ctx.getInitParameter("MONGO_DBNAME")); // get the database name
            col = db.getCollection(ctx.getInitParameter("MONGO_COLLECTION")); 

        } catch (UnknownHostException e) {

            throw new RuntimeException("MongoClient initialization failed");
        }
    }

    //@Override
    public void contextDestroyed(ServletContextEvent sce) {
        /**
         * Database connection closing
         */
        cl = (MongoClient) sce.getServletContext().getAttribute("MONGO_CLIENT");
        cl.close();
    }

}

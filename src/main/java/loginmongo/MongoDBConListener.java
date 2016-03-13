package loginmongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.UnknownHostException;

public class MongoDBConListener implements ServletContextListener {

    static MongoClient client = null;
    static DBCollection dbcoll = null;

    //@Override
    public void contextInitialized(ServletContextEvent sce) {
        /**
         * Database connection establishing
         */
        try {
            ServletContext ctx = sce.getServletContext();

            client = new MongoClient(ctx.getInitParameter("MONGO_HOST"),// Database host
                    Integer.parseInt(ctx.getInitParameter("MONGO_PORT"))); // Connecting port
            DB db = client.getDB(ctx.getInitParameter("MONGO_DBNAME")); // get the database name
            dbcoll = db.getCollection(ctx.getInitParameter("MONGO_COLLECTION")); // get the collection(table)

        } catch (UnknownHostException e) {

            throw new RuntimeException("MongoClient initialization failed");
        }
    }

    //@Override
    public void contextDestroyed(ServletContextEvent sce) {
        /**
         * Database connection closing
         */
        client = (MongoClient) sce.getServletContext().getAttribute("MONGO_CLIENT");
        client.close();
    }

}

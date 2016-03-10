/**
 * Created by hsenid on 3/10/16.
 */

    import javax.servlet.ServletContextEvent;
    import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {


        public void contextDestroyed(ServletContextEvent arg0) {
            System.out.println("MyServletContextListener destroyed");
        }

        //Run this before web application is started

        public void contextInitialized(ServletContextEvent arg0) {
            System.out.println("MyServletContextListener started");
        }
    }


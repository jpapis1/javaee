package app.config;


import app.domain.Parrot;
import app.service.ParrotService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Date;
import java.util.GregorianCalendar;

@WebListener
public class Config implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        // Do stuff during webapp's startup.
        ParrotService parrotService = new ParrotService();
        parrotService.addParrot(new Parrot("Nimfa",new GregorianCalendar(2015, 0, 1).getTime(),0.3,true));
        parrotService.addParrot(new Parrot("Columbidae",new GregorianCalendar(2011, 1, 20).getTime(),1.2,false));
        parrotService.addParrot(new Parrot("Pterocles",new GregorianCalendar(2009, 2, 11).getTime(),0.2,false));
        event.getServletContext().setAttribute("parrotService",parrotService);
    }

    public void contextDestroyed(ServletContextEvent event) {
        // Do stuff during webapp's shutdown.
    }

}

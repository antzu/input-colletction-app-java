package conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import dao.SetupDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class ApplicationInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext)
            throws ServletException {

        super.onStartup(servletContext);

        // Create schema here
        new SetupDao().createSchema();
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { SpringConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/api/*" };
    }
}

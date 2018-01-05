package conn.projectNew.core.servlets;

import conn.projectNew.core.models.UserAccount;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.commons.json.JSONArray;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import java.io.IOException;

@Component(service = Servlet.class,
        property = {
                Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
                "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                "sling.servlet.paths=" + "/bin/Shubhamkga"
        })

public class PrintConfigParam extends SlingSafeMethodsServlet {
    @Reference
    UserAccount userAccount;

    Logger logger = LoggerFactory.getLogger(SimpleServlet.class);



    @Override
    public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)throws IOException

    {
        logger.info("I am in info");
        logger.error("I am in error");
        response.getWriter().print(userAccount.getName()+"......."+userAccount.getPhysicalStatus()+"*********"+userAccount.getShubham());

    }

}

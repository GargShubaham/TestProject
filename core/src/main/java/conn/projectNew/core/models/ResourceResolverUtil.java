package conn.projectNew.core.models;

import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.HashMap;
import java.util.Map;

@Component(service = ResourceResolverUtil.class, immediate = true)
public class ResourceResolverUtil {
    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    public ResourceResolver getResourceResolver() {
        ResourceResolver resourceResolver = null;
        try {
            Map<String, Object> param = new HashMap<>();
            param.put(ResourceResolverFactory.SUBSERVICE, "getResourceResolver");
            resourceResolver = resourceResolverFactory.getServiceResourceResolver(param);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return resourceResolver;

    }
}




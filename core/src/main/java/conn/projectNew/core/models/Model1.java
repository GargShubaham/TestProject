package conn.projectNew.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class)
public class Model1 {
    @ValueMapValue(name = "linkURL", injectionStrategy = InjectionStrategy.OPTIONAL)
    private String path;

    @SlingObject
    private ResourceResolver resourceResolver;

    public String getLink() {
        Resource resource = resourceResolver.getResource(path);
        if (resource != null) {
            return path + ApplicationConstants.HTML;
        } else
            return path;
    }
}

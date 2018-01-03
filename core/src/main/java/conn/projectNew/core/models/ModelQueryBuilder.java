package conn.projectNew.core.models;


import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.jcr.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Model(adaptables = SlingHttpServletRequest.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ModelQueryBuilder {

    @OSGiService
    private QueryBuilder builder;

    @SlingObject
    private ResourceResolver resourceResolver;

    @ScriptVariable
    private PageManager pageManager;

    public List getList() {
        List<Page> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        try {
            Session session = resourceResolver.adaptTo(Session.class);
            map.put("path", "/content/we-retail");
            map.put("nodename", "jcr:content");
            map.put("1_property", "hideInNav");
            map.put("1_property.value", "true");
            map.put("2_property", "sling:resourceType");
            map.put("2_property.value", "weretail/components/structure/page");
            Query query = builder.createQuery(PredicateGroup.create(map), session);
            SearchResult result = query.getResult();
            List<Hit> hits = result.getHits();
            for (Hit hit : hits) {

                        Resource resource =  resourceResolver.getResource(hit.getPath());
                         Page page = resource.getParent().adaptTo(Page.class);
                list.add(page);
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }
}


package conn.projectNew.core.models;


import com.day.cq.tagging.Tag;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Model(adaptables = Resource.class)




public class ModelTags {
    @SlingObject
    private ResourceResolver resourceResolver;


    public List<Pojo1> getList()
    {
        List <Pojo1> list = new ArrayList<>();
        Resource resource = resourceResolver.getResource("/content/we-retail");
        Iterator<Resource> iterator = resource.listChildren();
        List<String> tagList;
        while (iterator.hasNext()) {
            Resource  child = iterator.next();

            tagList = new ArrayList<>();
            if(child.isResourceType("cq:Page")) {
                Page page = child.adaptTo(Page.class);
                // list.add(page);
                Pojo1 pojo = new Pojo1();

                pojo.setPath(page.getPath());


                for (Tag ta:page.getTags()) {
                    tagList.add(ta.getTitle());
                }
                pojo.setTags(tagList);
                list.add(pojo);
            }
        }
        return list;
    }


}


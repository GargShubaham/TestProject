package conn.projectNew.core.models;

import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.WorkItem;
import com.day.cq.workflow.exec.WorkflowData;
import com.day.cq.workflow.exec.WorkflowProcess;
import com.day.cq.workflow.metadata.MetaDataMap;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.jcr.Node;
import javax.jcr.Session;

@Component(service = WorkflowProcess.class, property = {"process.label= New Workflow1"})
public class Workflow implements WorkflowProcess {
    @Reference
    private ResourceResolverFactory resourceResolverFactory;
    @Reference
    ResourceResolverUtil resourceResolverUtil;

    @Override
    public void execute(WorkItem workitem, WorkflowSession wfsession, MetaDataMap metaDataMap) {

        System.out.println("I am new workflow");
        WorkflowData workflowData = workitem.getWorkflowData();
        String path = workflowData.getPayload().toString();
        if (path != null) {
            try {
//                Map<String, Object> param = new HashMap<>();
//                param.put(ResourceResolverFactory.SUBSERVICE, "getResourceResolver");
                //               ResourceResolver resourceResolver = resourceResolverFactory.getServiceResourceResolver(param);
                ResourceResolver resourceResolver = resourceResolverUtil.getResourceResolver();
                Session session = resourceResolver.adaptTo(Session.class);
                Resource resource = resourceResolver.getResource(path + "/jcr:content");
                Node node = resource.adaptTo(Node.class);
                if (node != null) {
                    node.setProperty("abc", "gfhjk");
                    session.save();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}



package conn.projectNew.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.ArrayList;
import java.util.List;

@Model(adaptables = Resource.class)
public class Multifield {
    @ValueMapValue
    private String[] myUserSubmenu;

    public List<PojoMultifield> getData() {
        List<PojoMultifield> list = new ArrayList<>();
        for (String item : myUserSubmenu) {
            PojoMultifield pojo = new PojoMultifield();
            try {
                JSONObject jsonObject = new JSONObject(item);
                pojo.setTitle(jsonObject.getString("title"));
                pojo.setLink(jsonObject.getString("link"));
                pojo.setFlag(jsonObject.getString("flag"));
                list.add(pojo);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}

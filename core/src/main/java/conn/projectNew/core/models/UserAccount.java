package conn.projectNew.core.models;


import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = UserAccount.class, immediate = true)
@Designate(ocd = UserConfig.class)
public class UserAccount {
    private String name;
    private Boolean isShubham;
    private String PhysicalStatus;

    @Activate
    @Modified
    protected void activate(final UserConfig userConfig) {
        name = userConfig.getName();
        isShubham = userConfig.checkIfShubham();
        PhysicalStatus = userConfig.infoPhysical();
    }

    public String getName() {
        return name;
    }

    public Boolean getShubham() {
        return isShubham;
    }

    public String getPhysicalStatus() {
        return PhysicalStatus;
    }

}

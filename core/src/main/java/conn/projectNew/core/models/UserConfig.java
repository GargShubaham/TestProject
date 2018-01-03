package conn.projectNew.core.models;

import org.apache.lucene.queryparser.flexible.core.util.StringUtils;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "new config shubham",description = "shubham is very intelligent")
public @interface UserConfig {

    @AttributeDefinition(name = "Name" ,description = "enter name")
    String getName() default "";


    @AttributeDefinition(name = "AreYouShubham" ,description ="lemme check")
    boolean checkIfShubham() default false;


    @AttributeDefinition(name = "Physical Standards" ,description = "give up the info" ,options = )
    String infoPhysical() default "";


}
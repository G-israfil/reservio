package reservio.common.util;


import lombok.NonNull;
import lombok.experimental.UtilityClass;
import reservio.common.models.RelatedEntity;

@UtilityClass
public class CommonUtils {

    static public void printHelloWorld(){
        System.out.println("Hello World");
    }

    static public RelatedEntity generateRelatedEntity(@NonNull final String name,@NonNull final String value,@NonNull final String type){
        RelatedEntity relatedEntity = new RelatedEntity();
        relatedEntity.setName(name);
        relatedEntity.setType(type);
        relatedEntity.setValue(value);
        return relatedEntity;
    }
}

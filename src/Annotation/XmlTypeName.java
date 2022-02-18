package Annotation;
import java.lang.annotation.*;
import java.lang.annotation.Target;



@Target(ElementType.TYPE)//выполняется над классом
@Retention(RetentionPolicy.RUNTIME)//может использоваться во время выполнения
public @interface XmlTypeName {
    String value();
}

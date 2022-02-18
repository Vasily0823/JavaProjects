package Annotation;
import java.lang.annotation.*;
import java.lang.annotation.Target;



@Target(ElementType.FIELD)//цель - поле класса
@Retention(RetentionPolicy.RUNTIME)//может использоваться во время выполнения
public @interface XmlName {
    String value();//команда за которую будет отвечать функция
}

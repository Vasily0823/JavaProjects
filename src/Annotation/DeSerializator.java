package Annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public abstract class DeSerializator {

    //преобразуем в формат xml полученную коллекцию
    public static String serialize(Collection<?> objects) throws IllegalAccessException{
      StringBuilder sb = new StringBuilder();
      for( Object object: objects){
          sb.append("</").append(getTypeName(object.getClass())).append(">\n");
          for(Field field:object.getClass().getDeclaredFields()){
              if (!field.isAnnotationPresent(XmlIgnore.class)) {
                  field.setAccessible(true);
                  sb.append("\t");
                  sb.append("<").append(getFieldName(field)).append(">");
                  sb.append((field.get(object)));
                  sb.append("</").append(getFieldName(field)).append(">\n");
              }
          }
          sb.append("<").append(getTypeName(object.getClass())).append(">\n");
      }
      return sb.toString();
   }


//получаем имя поля
  private static String getFieldName(Field field){
      if(field.isAnnotationPresent(XmlName.class)){
         XmlName annotation =field.getAnnotation(XmlName.class);
         return annotation.value();
      }
     return field.getName();
  }

  //получаем тип класса
   private static String getTypeName(Class<?> class1){
      if(class1.isAnnotationPresent(XmlTypeName.class)){
         XmlTypeName annotation =class1.getAnnotation(XmlTypeName.class);
         return annotation.value();
      }
      return class1.getSimpleName();
   }



//преобразование из XML
public static Collection<Object> deserealize(String serString, HashSet<Class> classes) throws IllegalAccessException, InstantiationException {
    Collection<Object> objects=new ArrayList<>();//создаем коллекцию, куда будет производится запись
    while (true) {
        Object newObject = new Object();//создали одиночный объект
        Field[] objectFields = new Field[0];//одно поле

        int sectionStart = serString.length();
        int sectionEnd = serString.length();

        boolean isObject = false; //переменная, "это объект". Проверяет является ли то, что мы получили объектом в формате xml
        for (Class clazz : classes) { //едем по всему HashSet
            String name = getTypeName(clazz); //в имя записали тип
            String tagStart = "<" + name + ">";//в начальный тэг записали тип класса
            String tagEnd = "</" + name + ">";//в конечный тэг записали тип класса
            if (serString.indexOf(tagStart) < sectionStart && serString.contains(tagEnd)) {//если мы не достигли конца полученной строки и есть закрывающий тег
                sectionStart = serString.indexOf(tagStart);//положили номер стартового тэга
                sectionEnd = serString.indexOf(tagEnd) + tagEnd.length(); //положили номер последнего элемента строки+длинну закрыввающего тега

                newObject = clazz.newInstance();// новый экземпляр класса
                objectFields = clazz.getDeclaredFields();//поля для этого класса
                isObject = true; //это объект стало истиной
            }
        }
        if (!isObject) {//собственно мы поняли что получили не объект
            break;
        }
        serString = serString.substring(sectionEnd);//перепсали первоначальную строку, положили в нее "остаток"
        for (Field field : objectFields) {//пока в классе есть поля
            String startTag = "<" + getFieldName(field) + ">";//в переменные записали откр и закр тэги
            String endTag = "</" + getFieldName(field) + ">";
           if ((serString.indexOf(startTag) + startTag.length())>serString.indexOf(endTag)) {
                continue;
           }
            field.setAccessible(true);//{хрень
            String fieldValue = serString.substring(serString.indexOf(startTag) + startTag.length(),
                    serString.indexOf(endTag));//сюда кладем то, что было в тэгах, далее выясняем что это было

            if (field.getType() == boolean.class || field.getType() == Boolean.class) {//если был boolean
                field.set(newObject, Boolean.valueOf(fieldValue));// то кладем boolean
                continue;
            }
            if (field.getType() == int.class || field.getType() == Integer.class) {//если был int
                field.set(newObject, Integer.valueOf(fieldValue));//кладем int
                continue;
            }
            if (field.getType() == double.class || field.getType() == Double.class) {//если был double
                field.set(newObject, Double.valueOf(fieldValue));//кладем double
                continue;
            }
            if (field.getType() == String.class) {//если это строка
                field.set(newObject, fieldValue);//то кладем значение строки
            }
        }
        objects.add(newObject);//добавили в коллекцию объект
    }
    return objects;//вернули коллекцию
    }


}







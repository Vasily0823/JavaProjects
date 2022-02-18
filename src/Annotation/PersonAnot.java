package Annotation;

import java.util.Objects;

@XmlTypeName("Человек")
public class PersonAnot {

    @XmlName("Имя")
    String firstName;

    @XmlName("Возраст")
    double age;

    @XmlIgnore("")
    String password;
    public PersonAnot(){}

    public PersonAnot(String firstName, double age, String password) {
        this.firstName = firstName;
        this.age = age;
        this.password = password;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonAnot that = (PersonAnot) o;
        return Double.compare(that.age, age) == 0 && Objects.equals(firstName, that.firstName) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, age, password);
    }

    @Override
    public String toString() {
        return "PersonAnot{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}

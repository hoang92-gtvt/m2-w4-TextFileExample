package customer;

import dateConvert.ConvertDate;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
    private String name;
    private String id;
    private Date birthDay;

    public Customer() {
    }

    public Customer(String name, String id, String birthDay) {
        this.name = name;
        this.id = id;
        this.birthDay = ConvertDate.toDate(birthDay);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "{ " +
                name + '\'' +
                id + '\'' +
                ConvertDate.toString(birthDay) +
                "}";
    }
}

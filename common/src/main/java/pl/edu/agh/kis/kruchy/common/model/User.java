package pl.edu.agh.kis.kruchy.common.model;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;

@Document(collection = "user")
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @org.springframework.data.annotation.Id
    private String id;

    private String name;

    @JoinColumn(name = "surname_id")
    @Cascade(value = CascadeType.ALL)
    @ManyToOne(targetEntity = Surname.class)
    private Surname surname;

    @ManyToOne(targetEntity = Address.class)
    @Cascade(value = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(targetEntity = PhoneNumber.class)
    @JoinColumn(name = "phone_id")
    @Cascade(value = CascadeType.ALL)

    private PhoneNumber phoneNumber;

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(String name, Surname surname, Address address, PhoneNumber phoneNumber, Integer age) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname.getSurname();
    }

    public void setSurname(Surname surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber.getNumber();
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        User user = (User) o;

        return name.equals(user.name) && surname.equals(user.surname) && address.equals(user.address) && (phoneNumber != null ? phoneNumber.equals(user.phoneNumber) : user.phoneNumber == null);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }


}

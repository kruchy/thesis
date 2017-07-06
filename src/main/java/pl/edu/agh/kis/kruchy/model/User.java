package pl.edu.agh.kis.kruchy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JoinColumn(name = "surname_id")
    @ManyToOne(targetEntity = Surname.class)
    private Surname surname;

    @ManyToOne(targetEntity = Address.class)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(targetEntity = PhoneNumber.class)
    @JoinColumn(name = "phone_id")
    private PhoneNumber phoneNumber;

    public User(String name, Surname surname, Address address, PhoneNumber phoneNumber)
    {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        User user = (User) o;

        return name.equals(user.name) && surname.equals(user.surname) && address.equals(user.address) && (phoneNumber != null ? phoneNumber.equals(user.phoneNumber) : user.phoneNumber == null);
    }

    @Override
    public int hashCode()
    {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Surname getSurname()
    {
        return surname;
    }

    public void setSurname(Surname surname)
    {
        this.surname = surname;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public PhoneNumber getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }



}

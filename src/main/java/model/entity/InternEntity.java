package model.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "INTERN", schema = "tutordb", catalog = "")
public class InternEntity {
    private int id;
    private String lastname;
    private String firstname;
    private String phone;
    private String address;
    private String postalcode;
    private String city;
    private String email;
    private Collection<InternshipEntity> internshipsById;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "LASTNAME", nullable = true, length = 25)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "FIRSTNAME", nullable = true, length = 25)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "PHONE", nullable = true, length = 10)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "ADDRESS", nullable = true, length = 150)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "POSTALCODE", nullable = true, length = 15)
    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    @Basic
    @Column(name = "CITY", nullable = true, length = 25)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "EMAIL", nullable = true, length = 25)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InternEntity that = (InternEntity) o;
        return id == that.id && Objects.equals(lastname, that.lastname) && Objects.equals(firstname, that.firstname) && Objects.equals(phone, that.phone) && Objects.equals(address, that.address) && Objects.equals(postalcode, that.postalcode) && Objects.equals(city, that.city) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastname, firstname, phone, address, postalcode, city, email);
    }

    @OneToMany(mappedBy = "internByIdIntern", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    public Collection<InternshipEntity> getInternshipsById() {
        return internshipsById;
    }

    public void setInternshipsById(Collection<InternshipEntity> internshipsById) {
        this.internshipsById = internshipsById;
    }
}

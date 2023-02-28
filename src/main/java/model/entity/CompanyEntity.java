package model.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "COMPANY", schema = "tutordb", catalog = "")
public class CompanyEntity {
    private int id;
    private String name;
    private String address;
    private String postalcode;
    private String city;
    private Collection<InternshipEntity> internshipsById;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = true, length = 25)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "ADDRESS", nullable = true, length = 25)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "POSTALCODE", nullable = true, length = 25)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyEntity that = (CompanyEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(postalcode, that.postalcode) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, postalcode, city);
    }

    @OneToMany(mappedBy = "companyByIdCompany")
    public Collection<InternshipEntity> getInternshipsById() {
        return internshipsById;
    }

    public void setInternshipsById(Collection<InternshipEntity> internshipsById) {
        this.internshipsById = internshipsById;
    }
}

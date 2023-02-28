package model.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TUTOR", schema = "tutordb", catalog = "")
public class TutorEntity {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
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
    @Column(name = "FIRSTNAME", nullable = true, length = 25)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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
    @Column(name = "EMAIL", nullable = true, length = 25)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "PASSWORD", nullable = true, length = 25)
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
        TutorEntity that = (TutorEntity) o;
        return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(email, that.email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, email, password);
    }

    @OneToMany(mappedBy = "tutorByIdTutor")
    public Collection<InternshipEntity> getInternshipsById() {
        return internshipsById;
    }

    public void setInternshipsById(Collection<InternshipEntity> internshipsById) {
        this.internshipsById = internshipsById;
    }
}

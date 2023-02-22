package model.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "MAKE_INTERNSHIP", schema = "tutordb", catalog = "")
public class MakeInternshipEntity {
    private int id;
    private String noteTech;
    private String noteCom;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NOTE_TECH", nullable = true, length = 10)
    public String getNoteTech() {
        return noteTech;
    }

    public void setNoteTech(String noteTech) {
        this.noteTech = noteTech;
    }

    @Basic
    @Column(name = "NOTE_COM", nullable = true, length = 10)
    public String getNoteCom() {
        return noteCom;
    }

    public void setNoteCom(String noteCom) {
        this.noteCom = noteCom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MakeInternshipEntity that = (MakeInternshipEntity) o;
        return id == that.id && Objects.equals(noteTech, that.noteTech) && Objects.equals(noteCom, that.noteCom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, noteTech, noteCom);
    }
}

package spring.jpa;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Антон on 04.05.2016.
 */
@Entity
@Table(name = "teachers", schema = "university", catalog = "postgres")
public class TeachersEntity {
    private String name;
    private int id;
    private Collection<DisciplinesEntity> disciplines;
    private DepartmentsEntity department;
    private Collection<TeachersMailsEntity> mails;

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeachersEntity that = (TeachersEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }

    @OneToMany(mappedBy = "teacher")
    public Collection<DisciplinesEntity> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(Collection<DisciplinesEntity> disciplines) {
        this.disciplines = disciplines;
    }

    @ManyToOne
    @JoinColumn(name = "id_department", referencedColumnName = "id", nullable = false)
    public DepartmentsEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentsEntity department) {
        this.department = department;
    }

    @OneToMany(mappedBy = "teacher")
    public Collection<TeachersMailsEntity> getMails() {
        return mails;
    }

    public void setMails(Collection<TeachersMailsEntity> mails) {
        this.mails = mails;
    }

    @Override
    public String toString() {
        return "TeachersEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}

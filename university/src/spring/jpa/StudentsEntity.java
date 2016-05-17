package spring.jpa;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Антон on 04.05.2016.
 */
@Entity
@Table(name = "students", schema = "university", catalog = "postgres")
public class StudentsEntity {
    private int id;
    private String name;
    private Collection<GradesEntity> grades;
    private Collection<DisciplinesEntity> disciplines;
    private GroupsEntity group;
    private Collection<StudentsMailsEntity> mails;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentsEntity that = (StudentsEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "student")
    public Collection<GradesEntity> getGrades() {
        return grades;
    }

    public void setGrades(Collection<GradesEntity> grades) {
        this.grades = grades;
    }

    @ManyToMany
    @JoinTable(name = "grades", catalog = "postgres", schema = "university", joinColumns = @JoinColumn(name = "id_student", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "id_discipline", referencedColumnName = "id", nullable = false))
    public Collection<DisciplinesEntity> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(Collection<DisciplinesEntity> disciplines) {
        this.disciplines = disciplines;
    }

    @ManyToOne
    @JoinColumn(name = "id_group", referencedColumnName = "id", nullable = false)
    public GroupsEntity getGroup() {
        return group;
    }

    public void setGroup(GroupsEntity group) {
        this.group = group;
    }

    @OneToMany(mappedBy = "student")
    public Collection<StudentsMailsEntity> getMails() {
        return mails;
    }

    public void setMails(Collection<StudentsMailsEntity> mails) {
        this.mails = mails;
    }

    @Override
    public String toString() {
        return "StudentsEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}

package spring.jpa;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Антон on 04.05.2016.
 */
@Entity
@Table(name = "groups", schema = "university", catalog = "postgres")
public class GroupsEntity {
    private int id;
    private String name;
    private CoursesEntity course;
    private SpecializationsEntity specialization;
    private Collection<StudentsEntity> students;

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

        GroupsEntity that = (GroupsEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "id_course", referencedColumnName = "id", nullable = false)
    public CoursesEntity getCourse() {
        return course;
    }

    public void setCourse(CoursesEntity course) {
        this.course = course;
    }

    @ManyToOne
    @JoinColumn(name = "id_specialization", referencedColumnName = "id", nullable = false)
    public SpecializationsEntity getSpecialization() {
        return specialization;
    }

    public void setSpecialization(SpecializationsEntity specialization) {
        this.specialization = specialization;
    }

    @OneToMany(mappedBy = "group")
    public Collection<StudentsEntity> getStudents() {
        return students;
    }

    public void setStudents(Collection<StudentsEntity> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "GroupsEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}

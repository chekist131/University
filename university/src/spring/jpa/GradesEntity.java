package spring.jpa;

import javax.persistence.*;

/**
 * Created by Антон on 04.05.2016.
 */
@Entity
@Table(name = "grades", schema = "university", catalog = "postgres")
public class GradesEntity {
    private int id;
    private int value;
    private DisciplinesEntity discipline;
    private StudentsEntity student;

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
    @Column(name = "value", nullable = false)
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GradesEntity that = (GradesEntity) o;

        if (id != that.id) return false;
        if (value != that.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + value;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_discipline", referencedColumnName = "id", nullable = false)
    public DisciplinesEntity getDiscipline() {
        return discipline;
    }

    public void setDiscipline(DisciplinesEntity discipline) {
        this.discipline = discipline;
    }

    @ManyToOne
    @JoinColumn(name = "id_student", referencedColumnName = "id", nullable = false)
    public StudentsEntity getStudent() {
        return student;
    }

    public void setStudent(StudentsEntity student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "GradesEntity{" +
                "value=" + value +
                '}';
    }
}

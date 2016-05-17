package spring.jpa;

import javax.persistence.*;

/**
 * Created by Антон on 04.05.2016.
 */
@Entity
@Table(name = "students_mails", schema = "university", catalog = "postgres")
public class StudentsMailsEntity {
    private int id;
    private String value;
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
    @Column(name = "value", nullable = false, length = 50)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentsMailsEntity that = (StudentsMailsEntity) o;

        if (id != that.id) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_students", referencedColumnName = "id", nullable = false)
    public StudentsEntity getStudent() {
        return student;
    }

    public void setStudent(StudentsEntity student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "StudentsMailsEntity{" +
                "value='" + value + '\'' +
                '}';
    }
}

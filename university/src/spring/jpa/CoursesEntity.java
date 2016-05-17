package spring.jpa;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Антон on 04.05.2016.
 */
@Entity
@Table(name = "courses", schema = "university", catalog = "postgres")
public class CoursesEntity {
    private int id;
    private String name;
    private Collection<GroupsEntity> groups;

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

        CoursesEntity that = (CoursesEntity) o;

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

    @OneToMany(mappedBy = "course")
    public Collection<GroupsEntity> getGroups() {
        return groups;
    }

    public void setGroups(Collection<GroupsEntity> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "CoursesEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}

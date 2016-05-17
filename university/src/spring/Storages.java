package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import spring.repositories.*;

/**
 * Created by Антон on 12.05.2016.
 */
@Service
@Scope("singleton")
public class Storages {

    public final CoursesRepository coursesRepository;
    public final DepartmentsRepository departmentsRepository;
    public final DisciplinesRepository disciplinesRepository;
    public final GradesRepository gradesRepository;
    public final GroupsRepository groupsRepository;
    public final SpecializationsRepository specializationsRepository;
    public final StudentsMailsRepository studentsMailsRepository;
    public final StudentsRepository studentsRepository;
    public final TeachersMailsRepository teachersMailsRepository;
    public final TeachersRepository teachersRepository;

    @Autowired
    public Storages(CoursesRepository coursesRepository, DepartmentsRepository departmentsRepository, DisciplinesRepository disciplinesRepository, GradesRepository gradesRepository, GroupsRepository groupsRepository, SpecializationsRepository specializationsRepository, StudentsMailsRepository studentsMailsRepository, StudentsRepository studentsRepository, TeachersMailsRepository teachersMailsRepository, TeachersRepository teachersRepository) {
        this.coursesRepository = coursesRepository;
        this.departmentsRepository = departmentsRepository;
        this.disciplinesRepository = disciplinesRepository;
        this.gradesRepository = gradesRepository;
        this.groupsRepository = groupsRepository;
        this.specializationsRepository = specializationsRepository;
        this.studentsMailsRepository = studentsMailsRepository;
        this.studentsRepository = studentsRepository;
        this.teachersMailsRepository = teachersMailsRepository;
        this.teachersRepository = teachersRepository;
    }
}

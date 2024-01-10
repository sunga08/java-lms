package nextstep.courses.domain.session;

import nextstep.users.domain.NsUser;

import java.util.Objects;

public class Enrollment {

    private final Students students;
    private Integer capacity;

    public Enrollment(Students students, Integer capacity) {
        this.students = students;
        if(students != null && capacity != null) {
            students.isOverCapacity(capacity);
        }
        this.capacity = capacity;
    }

    public void enroll(NsUser student) {
        students.addStudent(student);
        if(capacity != null) {
            students.isOverCapacity(capacity);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enrollment that = (Enrollment) o;
        return Objects.equals(students, that.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(students);
    }
}

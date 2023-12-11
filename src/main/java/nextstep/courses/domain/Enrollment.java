package nextstep.courses.domain;

import nextstep.courses.exception.EnrollmentException;
import nextstep.courses.exception.PaymentException;
import nextstep.courses.exception.SessionException;
import nextstep.users.domain.NsUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Enrollment {
    private List<NsUser> students = new ArrayList<>();
    private Integer maxPersonnel;

    private Enrollment(Integer maxPersonnel) {
        this(maxPersonnel, new ArrayList<>());
    }

    public static Enrollment freeEnrollment() {
        return new Enrollment(null);
    }

    public static Enrollment paidEnrollment(Integer maxPersonnel) {
        return new Enrollment(maxPersonnel);
    }

    public Enrollment(Integer maxPersonnel, List<NsUser> students) {
        this.maxPersonnel = maxPersonnel;
        this.students = students;
    }

    public void enrollPaidSession(NsUser user) {
        if(students.size() >= maxPersonnel) {
            throw new EnrollmentException("최대 수강 인원을 초과하였습니다.");
        }

        students.add(user);
    }

    public void enrollFreeSession(NsUser user) {
        students.add(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enrollment that = (Enrollment) o;
        return Objects.equals(students, that.students) && Objects.equals(maxPersonnel, that.maxPersonnel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(students, maxPersonnel);
    }
}

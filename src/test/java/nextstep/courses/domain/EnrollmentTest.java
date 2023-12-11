package nextstep.courses.domain;

import nextstep.courses.exception.EnrollmentException;
import nextstep.courses.exception.SessionException;
import nextstep.users.domain.NsUserTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class EnrollmentTest {

    @Test
    @DisplayName("유료강의에 수강신청을 할 수 있다.")
    void 유료강의_수강신청() {
        Enrollment enrollment = Enrollment.paidEnrollment(10);
        enrollment.enrollPaidSession(NsUserTest.JAVAJIGI);

        Assertions.assertThat(enrollment.equals(new Enrollment(10, List.of(NsUserTest.JAVAJIGI)))).isTrue();
    }

    @Test
    @DisplayName("무료강의에 수강신청을 할 수 있다.")
    void 무료강의_수강신청() {
        Enrollment enrollment = Enrollment.freeEnrollment();
        enrollment.enrollFreeSession(NsUserTest.JAVAJIGI);

        Assertions.assertThat(enrollment.equals(new Enrollment(null, List.of(NsUserTest.JAVAJIGI)))).isTrue();
    }

    @Test
    @DisplayName("유료강의 최대 인원을 초과하면 예외가 발생한다.")
    void 유료강의_인원_초과() {
        Enrollment enrollment = new Enrollment(2, List.of(NsUserTest.JAVAJIGI, NsUserTest.SANJIGI));

        assertThatThrownBy(() -> enrollment.enrollPaidSession(NsUserTest.JAVAJIGI))
                .isInstanceOf(EnrollmentException.class);
    }
}
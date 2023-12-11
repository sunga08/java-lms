package nextstep.courses.domain;

import nextstep.courses.exception.PaymentException;
import nextstep.courses.exception.SessionException;
import nextstep.payments.domain.Payment;
import nextstep.users.domain.NsUserTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class SessionTest {
    public static final SessionPeriod todayAfterStartDate = new SessionPeriod(LocalDate.now().minusDays(1), LocalDate.now().plusDays(5));
    public static final SessionPeriod todayBeforeStartDate = new SessionPeriod(LocalDate.now().plusDays(3), LocalDate.now().plusDays(10));
    public static final SessionPeriod todayAfterEndDate = new SessionPeriod(LocalDate.now().minusDays(10), LocalDate.now().minusDays(3));

    @Test
    @DisplayName("모집중인 무료 강의는 최대 수강 인원 제한 없이 수강 신청을 할 수 있다.")
    void 무료강의_수강신청() {
        Session session = Session.recruitingSession(0L, SessionType.FREE, SessionState.RECRUITING,null, new ArrayList<>(), 15);
        session.enrollStudent(NsUserTest.JAVAJIGI, null);

        assertThat(session.equals(Session.recruitingSession(0L, SessionType.FREE, SessionState.RECRUITING,null, List.of(NsUserTest.JAVAJIGI), 16))).isTrue();
    }

    @Test
    @DisplayName("모집중인 유료강의에 수강신청 시 최대 수강 인원을 초과하면 예외가 발생한다.")
    void 유료강의_수강신청() {
        Session session = Session.recruitingSession(0L, SessionType.PAID, SessionState.RECRUITING,10, new ArrayList<>(), 10);

        assertThatThrownBy(() -> session.enrollStudent(NsUserTest.JAVAJIGI, null))
                .isInstanceOf(SessionException.class);
    }

    @Test
    @DisplayName("강의 상태가 모집중일 때 수강신청을 할 수 있다.")
    void 수강신청_모집중_상태() {
        Session session = new Session(0L, SessionState.RECRUITING,  todayBeforeStartDate);
        session.enrollStudent(NsUserTest.JAVAJIGI, null);

        assertThat(session.getEnrollCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("강의 상태가 준비중일 때 수강신청을 하면 예외가 발생한다.")
    void 수강신청_준비중_상태() {
        Session session = new Session(0L, SessionState.PREPARING, todayBeforeStartDate);

        assertThatThrownBy(() -> session.enrollStudent(NsUserTest.JAVAJIGI, null))
                .isInstanceOf(SessionException.class);
    }

    @Test
    @DisplayName("강의 상태가 종료일 때 수강신청을 하면 예외가 발생한다.")
    void 수강신청_종료_상태() {
        Session session = new Session(0L, SessionState.END, todayAfterEndDate);

        assertThatThrownBy(() -> session.enrollStudent(NsUserTest.JAVAJIGI, null))
                .isInstanceOf(SessionException.class);
    }

    @Test
    @DisplayName("강의 생성시 이미지 형식 제한에 맞는 강의 커버 이미지 정보를 가진다.")
    void 이미지_형식_제한에_맞는_강의_커버_이미지() {
        ImageInfo imageInfo = new ImageInfo("JPG", 0.5, 300, 200);
        assertThatCode(() -> new Session(0L, SessionState.PREPARING, imageInfo, todayBeforeStartDate))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("수강생이 결제한 금액과 모집중인 유료 강의의 수강료가 일치하지 않으면 예외가 발생한다.")
    void 수강료와_결제금액_일치하지_않으면_예외_발생() {
        Session session = Session.recruitingPaidSession(0L, SessionType.PAID, SessionState.RECRUITING, 10, 20000L);
        Payment payment = new Payment("ID", 0L, 0L, 10000L);

        assertThatThrownBy(() -> session.enrollStudent(NsUserTest.JAVAJIGI, payment))
                .isInstanceOf(PaymentException.class);
    }

    @Test
    @DisplayName("수강생이 결제한 금액과 모집중인 유료강의의 수강료가 일치하면 수강신청이 완료된다.")
    void 수강료와_결제금액_일치시_수강신청_완료() {
        Session session = Session.recruitingPaidSession(0L, SessionType.PAID, SessionState.RECRUITING, 10, 10000L);
        Payment payment = new Payment("ID", 0L, 0L, 10000L);
        session.enrollStudent(NsUserTest.JAVAJIGI, payment);

        assertThat(session.equals(Session.recruitingSession(0L, SessionType.PAID, SessionState.RECRUITING,10, List.of(NsUserTest.JAVAJIGI), 1)));
    }
}
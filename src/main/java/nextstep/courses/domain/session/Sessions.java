package nextstep.courses.domain.session;

import nextstep.courses.domain.course.Course;

import java.util.List;
import java.util.Objects;

public class Sessions {

    private final List<Session> sessions;

    public Sessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public void addSession(Session session) {
        this.sessions.add(session);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sessions sessions1 = (Sessions) o;
        return Objects.equals(sessions, sessions1.sessions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessions);
    }

    @Override
    public String toString() {
        return "Sessions{" +
                "sessions=" + sessions +
                '}';
    }
}

package nextstep.qna.domain;

import nextstep.qna.CannotDeleteException;
import nextstep.users.domain.NsUser;

import java.util.ArrayList;
import java.util.List;

public class Answers {

    private List<Answer> answers = new ArrayList<>();

    public Answers(List<Answer> answers){
        this.answers = answers;
    }

    // 삭제가능한지 확인
    public void checkAnswer(NsUser loginUser) throws CannotDeleteException {
        for (Answer answer : answers) {
            answer.isDeletableAnswer(loginUser);
        }
    }


}

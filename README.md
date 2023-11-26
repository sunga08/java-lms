# 학습 관리 시스템(Learning Management System)
## 진행 방법
* 학습 관리 시스템의 수강신청 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 기능 요구사항
* 질문 데이터를 완전히 삭제하는 것이 아니라 데이터의 상태를 삭제 상태(deleted - boolean type)로 변경한다.
* 로그인 사용자와 질문한 사람이 같은 경우 삭제 가능하다.
* 답변이 없는 경우 질문 삭제가 가능하다.
* 질문자와 답변글의 모든 답변자가 같은 경우 삭제가 가능하다.
* 질문을 삭제할 때 답변 또한 삭제해야 하며, 답변의 삭제 또한 삭제 상태(deleted)를 변경
한다.
* 질문자와 답변자가 다른 경우 답변을 삭제할 수 없다.
* 질문과 답변 삭제 이력에 대한 정보를 DeleteHistory를 활용해 남긴다.

## TO-DO
### Answer
* [X] 답변을 삭제할 수 있다.
  * [X] 삭제를 할 경우 답변의 삭제 상태를 변경한다.
  * [X] 질문자와 답변자가 같은 경우 삭제가 가능하다.
  * [X] 질문자와 답변자가 다른 경우 예외를 반환한다.

### Answers
* [X] 답변들을 삭제할 수 있다.
  * [X] 삭제를 할 경우 답변들의 삭제 상태를 변경한다.

### Question
* [ ] 답변이 없는 질문을 삭제할 수 있다.
  * [ ] 로그인 사용자와 질문한 사람이 같은 경우 삭제 가능하다.
  * [ ] 로그인 사용자와 질문한 사람이 다른 경우 예외를 반환한다.
  * [ ] 삭제를 할 경우 질문의 삭제 상태를 변경한다.
####
* [ ] 답변이 있는 질문을 삭제할 수 있다.
  * [ ] 로그인 사용자와 질문한 사람이 같은 경우 삭제 가능하다.
  * [ ] 로그인 사용자와 질문한 사람이 다른 경우 예외를 반환한다.
  * [ ] 답변이 있을 경우 질문자와 답변글의 모든 답변자가 같으면 삭제한다.
  * [ ] 답변이 있을 경우 질문자와 답변글의 모든 답변자 같지 않은 경우 예외를 반환한다.
  * [ ] 삭제를 할 경우 질문과 답변의 삭제 상태를 변경한다.
  
### DeleteHistory
* [ ] 질문과 답변 삭제 이력을 객체로 저장한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

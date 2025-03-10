# ManagementSystem

## 프로젝트 소개
ManagementSystem은 학생과 직원의 정보를 쉽고 편리하게 관리할 수 있는 시스템입니다. Java와 MySQL로 개발되었으며, 명령줄 인터페이스(CLI)를 통해 간단하고 직관적인 사용 환경을 제공합니다.

---

## 주요 기능

### 학생 관리
- 학생 정보의 추가, 수정, 삭제, 조회 가능

### 직원 관리
- 정규직 직원의 성과 평가와 급여 관리
- 파트타임 직원의 시급 및 근무시간을 통한 급여 자동 계산

### 데이터베이스 관리
- MySQL 데이터베이스 연동
- 저장 프로시저(Stored Procedure)를 이용한 효율적인 데이터 처리

---

## 설치 방법

### 요구 사항
- Java 8 이상
- MySQL 5.7 이상

### 프로젝트 다운로드
```bash
git clone https://github.com/your-repo/ManagementSystem.git
cd ManagementSystem
```

### 데이터베이스 설정

#### dbinfo 파일 설정
다음과 같이 `util/dbinfo.properties` 파일을 생성하고, 본인의 데이터베이스 설정에 맞게 YOURDATA 부분을 변경하세요.

```properties
driver=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/YOURDATA?serverTimezone=YOURDATA
user=YOURDATA
password=YOURDATA
```

#### 테이블 생성

**학생 테이블**
```sql
CREATE TABLE Student (
    sno VARCHAR(20) PRIMARY KEY,
    name VARCHAR(20),
    korean INT,
    english INT,
    math INT,
    science INT
);
```

**정규직 직원 테이블**
```sql
CREATE TABLE Fulltime (
    empno VARCHAR(20) PRIMARY KEY,
    name VARCHAR(20),
    result INT,
    basicsalary INT
);
```

**파트타임 직원 테이블**
```sql
CREATE TABLE Parttime (
    empno VARCHAR(20) PRIMARY KEY,
    name VARCHAR(20),
    hourwage INT,
    workhour INT
);
```

#### 저장 프로시저 생성 예시
**학생 정보 추가 프로시저**
```sql
DELIMITER $$
CREATE PROCEDURE STUDENT_INSERT (
    IN sno VARCHAR(20), IN name VARCHAR(20),
    IN korean INT, IN english INT, IN math INT, IN science INT,
    OUT RTN_CODE INT
)
BEGIN
    INSERT INTO Student VALUES(sno, name, korean, english, math, science);
    SET RTN_CODE = 200;
END$$
DELIMITER ;
```
그 외 프로시저의 생성 예시는 [저장 프로시저](https://github.com/psns0122/ms_DBProcedure)를 참고하세요.

---

## 실행 방법
```bash
javac -d bin $(find . -name "*.java")
java -cp bin view.MainMenu
```

---

## 프로젝트 구조

```
ManagementSystem/
├── controller/        # 사용자 요청을 처리하여 모델과 뷰를 연결
├── model/             # 데이터베이스 접근 및 관리
├── util/              # 공통 유틸리티
├── view/              # 사용자 인터페이스 (CLI)
├── vo/                # 데이터 전송 객체(Value Objects)
├── .gitignore         # Git 버전 관리 제외 목록
├── LICENSE            # MIT 라이선스 정보
└── README.md          # 프로젝트 설명서
```

---

## 기여 방법
- GitHub에서 Issue를 등록하여 개선 사항을 제안할 수 있습니다.
- Repository를 Fork한 뒤, 수정 사항을 반영하여 Pull Request를 제출해 주세요.

---

## 제작자

- [정유진](https://github.com/yujini02): 사용자 인터페이스 담당 (yujinjeong76@gmail.com)
- [김성준](https://github.com/kimsj18): 학생 모델 담당 (kimsj0118@gmail.com)
- [김선민](https://github.com/seonmin12): 직원 모델 담당 (seonmin.kim1030@gmail.com)
- [박건희](https://github.com/psns0122): DB 모델링 담당 (psns0122@nave.com)

---

## 라이선스
본 프로젝트는 MIT 라이선스를 따릅니다. 자세한 내용은 [LICENSE](LICENSE)를 참고하세요.

---

## 참고 자료
- [MySQL 공식 문서](https://dev.mysql.com/doc/)
- [Java JDBC 튜토리얼](https://docs.oracle.com/javase/tutorial/jdbc/)
- [MySQL 저장 프로시저 가이드](https://www.mysqltutorial.org/getting-started-with-mysql-stored-procedures.aspx)

---

### 개선사항
* Enum 클래스, Exception 클래스 작성
* DB에 들어가는 정보 다양화 + DB 정규화 진행
* 옵셔널 적용
* void 함수에 리턴값 추가하기

### 다른 팀 보고 추가하면 좋을 것 같다고 느낀 점
* ** Optional.of() / Optional<객체 타입> => 사용하면 else가 사라진다. (return Optional.empty(), .isPresent(), .isEmpty(), .get()) => 람다식으로 작성할 경우 if도 사라진다.
* 객체지향 원칙에 입각해서
* ** 타겟(도메인)을 명확하게
* 팀웍 도중 나온 산출물 정리해서 발표자료 활용 (+성과분석, 향후 발전 과제)
* db우선 접근 방식
* 로그인 (관리자와 사용자를 나누고, 권한을 부여)
* 실행영상 찍기 (기능별로 나누기)
* 데이터의 유효성검사
* 이벤트 백업, 데이터 백업, 트리거를 사용
* 오류, 풀리퀘, 머지 횟수 기록하기 (발생했던 문제점과 그 해결법 기록하기 / 특정 기능을 적용했을 때, 적용하지 않았을 때의 전후 비교)
* json 데이터 입출력
* 암호화 모듈 잇시? ㅎㅎ 찾아보기
* 서브메뉴 (사용자 제어 강화)
* 리팩토링 (일관성 유지)
* 깃허브 링크 추가하기
* 사용자 단에서는 굳이 리턴이 없어도 되었을 것 같다
* 클래스마다 하나의 책임 / 메소드마다 하나의 기능
* 협업 전략 설정하기 (main(최종), dev(버전 확인용), feat(기능개발), hotfix(예기치못한 수정), refactor(완성된 기능에 대한 추가 수정))
* 커밋 메세지를 컨벤션에 맞춰서 작성한다
* 의존한다는게 뭘까
* 클래스를 기능? 에 따라 나눈다.
* 카프카, 마이크로서비스 설계?
* enum : 리터럴 생성
* 발생할 수 있는 모든 익셉션에 대해 명명 (여기까지 설계단계에서 생각할 필요가 있다)
* 강사님이 주신 TCP/IP 코드 참고하기
* 네트워크에 sql을 직접 담는것보다 프로시저를 사용하는 방법이 이점인 이유 : 미리 프로시저를 만들고 호출만 하면 된다? 프로시저가 더 빠르다. 항상 그렇진 않고
* 회의록 서기

### PPT 내용
* 프로젝트 목적
* 협업전략 (git flow 전략)
* 아키텍처 구조 (사용자 - 자바 - 데이터베이스 / 자바 - json)
* 클래스 다이어그램
* DTO(데이터를 옮길때 사용), VO(보증 필요, DB와 1:1 매칭)
* 입력값 체크(정규표현식) - 검증 / 객체의 NULL 체크 (optional) / 그 밖의 예외처리
* 의존성 주입 (생성자 - 메소드) DIConfig 메소드를 통해서 생성자를 주입한다. (getInstance랑 같은건가) / 컨테이너를 이용 ,, 리플렉션을 이용해서 꺼낸다
* 메소드의 체이닝 (.updateSalary(eno).getHistory() : return this?)
* 유지보수 측면 : 어디서 프로그램이 터진건지 알 수 없다.

### 강사님 피드백
1. 객체지향 원칙을 중시해서 한것이 좋았다
2. 진행 절차와 롤을 명확하게
3. 좋은 방법이 더 없을까 고민하고 리팩토링하기 (리팩토링 할때는 이슈보드 활용하기 선 동의 -> 후 작업)
4. 협업전략은 의견이 너무 많으면 안된다

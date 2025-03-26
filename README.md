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

## 향후 개선 방향 & 기술적 통찰

### 아키텍처 및 설계 개선
- Enum 클래스 및 Exception 클래스 명확히 정의하여 예외 처리 일관성 확보
- 클래스는 하나의 책임, 메소드는 하나의 기능만 수행하도록 구조 리팩토링
- 클래스 및 기능별 책임 구분을 통해 객체지향 원칙 강화
- 서브 메뉴 구성 등을 통해 사용자 제어 강화
- DTO/VO의 목적을 구분해 역할에 맞게 사용

### 데이터 처리 및 DB 전략
- DB 정규화 진행 및 데이터 다양화
- 데이터 유효성 검사(정규 표현식 등) 및 NULL 체크(예: Optional 활용)
- 유통기한 등 이벤트 기반 백업 및 트리거 자동화 설계
- JSON 데이터 입출력 및 암호화 모듈 도입 검토
- 절차형 SQL보다 프로시저 사용으로 네트워크 효율 및 성능 향상

### 개발 전략 및 협업
- Git Flow 전략 도입: `main`, `dev`, `feat`, `hotfix`, `refactor` 분기 운영
- 커밋 메시지 컨벤션 통일 (ex. `feat:`, `fix:`, `refactor:`)
- 이슈보드 기반 작업 동의 후 작업 진행, 머지/PR 이력 관리
- 오류 발생 및 해결법, 특정 기능 적용 전후 비교 기록
- 회의록 및 발표 자료 산출물화 (성과 분석, 향후 발전 과제 포함)

### 기술적 인사이트
- Optional 사용 시 불필요한 else 문 제거 가능 → 가독성 및 오류 방지
  - 예시: `Optional.of(obj).ifPresent()`  
- 메서드 체이닝을 통해 코드를 더 간결하게 구성 (`return this` 활용)
- 의존성 주입(DI)을 통한 객체 생성 관리: 생성자 주입 + DIConfig 클래스 활용
- 유지보수를 고려한 예외 로그 및 흐름 추적 필요
- 클래스/기능 설계 시 "의존한다는 것"의 의미를 깊이 이해하고 적용할 것

### 실행 및 배포
- 실행 영상 촬영 (기능별 구분)
- 관리자/사용자 권한 구분 구현
- 향후 Kafka 및 마이크로서비스 기반 설계도 검토 예정

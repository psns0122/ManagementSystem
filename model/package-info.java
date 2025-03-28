/**
 * 이 패키지는 데이터베이스 접근 및 관리 작업을 수행하는 클래스들을 포함합니다.
 * 주로 데이터 처리 로직과 비즈니스 로직이 구현되며, DAO(Data Access Object)와 다양한 데이터 관리 인터페이스를 제공합니다.
 * <p>
 * <strong>구성 요소:</strong>
 * <ul>
 *     <li>{@link model.DBCommon} - 데이터베이스와 상호작용하기 위한 공통 인터페이스로, 데이터를 입력, 수정, 삭제, 검색, 정렬하는 작업을 정의합니다.</li>
 *     <li>{@link model.Fulltime} - 정규직 직원 관리를 위한 인터페이스로, 월급 인상과 관련된 기능을 제공합니다.</li>
 *     <li>{@link model.FulltimeDAO} - 정규직 직원 데이터를 관리하는 DAO 클래스로, 데이터 추가, 삭제, 수정, 검색 및 월급 인상 로직이 포함됩니다.</li>
 *     <li>{@link model.Parttime} - 시간제 직원 관리를 위한 인터페이스.</li>
 *     <li>{@link model.ParttimeDAO} - 시간제 직원 데이터를 관리하는 DAO 클래스로, 데이터 추가, 삭제, 수정 및 임금 계산 로직이 포함됩니다.</li>
 *     <li>{@link model.Student} - 학생 관리를 위한 인터페이스로, 총점 계산, 평균 계산, 등급 계산 기능을 제공합니다.</li>
 *     <li>{@link model.StudentDAO} - 학생 데이터를 관리하는 DAO 클래스로, 데이터 추가, 삭제, 수정, 검색 및 학업 성적 계산 로직이 포함됩니다.</li>
 * </ul>
 * </p>
 *
 * <p>
 * 이 패키지의 목적은 애플리케이션에서 데이터베이스와의 상호작용을 처리하고,
 * 데이터를 관리할 수 있도록 다양한 기능을 제공하는 것입니다.
 * 클래스들은 Singleton 패턴으로 구현되어 데이터 접근 객체(DAO)의 효율성을 극대화합니다.
 * </p>
 *
 * <p>
 * <strong>주요 기능:</strong>
 * <ul>
 *     <li>학생, 정규직 직원, 시간제 직원 데이터를 CRUD(생성, 읽기, 수정, 삭제) 작업.</li>
 *     <li>데이터 정렬 및 검색 기능 제공 (이름순, ID순, 성적순 등).</li>
 *     <li>학생의 학업 성적(총점, 평균, 등급)을 계산.</li>
 *     <li>정규직 직원의 월급 인상 및 재계산.</li>
 *     <li>시간제 직원의 임금 계산 기능 제공.</li>
 * </ul>
 * </p>
 *
 * <p>
 * <strong>관련 패키지:</strong>
 * <ul>
 *     <li>{@link controller} - 이 패키지와 상호작용하여 사용자 요청과 데이터를 연결.</li>
 *     <li>{@link vo} - 데이터 전송 객체(Value Object)로, 모델과 컨트롤러 간 데이터 교환에 사용.</li>
 *     <li>{@link util} - 데이터베이스 작업을 지원하는 유틸리티 클래스 포함.</li>
 * </ul>
 * </p>
 *
 * @author 살려조(정유진, 김성준, 김선민, 박건희)
 * @version 1.0
 * @since 2025.3.10.
 */
package model;
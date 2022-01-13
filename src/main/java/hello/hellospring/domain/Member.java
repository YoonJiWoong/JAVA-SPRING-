package hello.hellospring.domain;

public class Member {

    /* 비지니스 요구 사항 정리
    데이터 : 회원 ID, 이름
    기능 : 회원 등록, 조회
    아직 데이터 저장소가 선정되지 않음. (가상의 시나리오)
     */

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

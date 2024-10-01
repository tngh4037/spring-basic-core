package hello.core.singleton;

public class SingletonService {

    // 1. static 영역에 객체를 딱 1개만 생성해준다.
    // : 자바가 뜰 때, static 영역인 아래에서, new SingletonService();을 실행 후 초기화.(=객체(자기자신)을 생성해서 instance에 참조로 넣어둔다.)
    private static final SingletonService instance = new SingletonService();

    // 2. public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다.
    // : 내부 instance를 꺼낼 수 있는 방법은 아래 getInstance() 밖에 없음.
    public static SingletonService getInstance() {
        return instance;
    }

    // 3. 생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    // 외부에서 SingletonService의 객체를 만들지 못하도록 생성자를 private으로 선언 (객체를 생성하려면 클래스내에서 생성자를 호출해야 함.)
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
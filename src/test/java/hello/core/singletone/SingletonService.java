package hello.core.singletone;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    // 이 메서드를 호출하면 항상 같은 인스턴스를 반환한다.
    public static SingletonService getInstance() {
        return instance;
    }

    // 외부에서 호춣하지 못하도록 생성자를 private로 선언
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}



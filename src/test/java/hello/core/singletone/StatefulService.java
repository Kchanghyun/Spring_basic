package hello.core.singletone;

public class StatefulService {

    private int price;

    // 이렇게 설계하면 ex). a, b 생성했을 때 a에서 10000, b에서 20000을 했을 떄 a 값을 얻어오려고 할 때 20000을 가지고 올 수 있음.
//    public void order(String name, int price) {
//        System.out.println("name = " + name + ", price = " + price);
//        this.price = price;
//    }

    public int order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        return price;
    }
}

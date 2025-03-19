package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    // 이 클래스에서도 ObjectProvider를 하는 이유는 스프링 컨테이너가 스프링을 띄울 때 @RequiredArgsConstructor를 통해 MyLogger를 빈으로 등록하면서 의존관계 주입을 할 수 없어서 오류가 난다.
    // 일반적인 의존성 주입은 애플리케이션 시작 시 모든 객체를 생성하지만, ObjectProvider, Provider.. 는 필요할 때 객체를 생성할 수 있다.
//    private final ObjectProvider<MyLogger> myLoggerProvider;
    private final MyLogger myLogger;

    public void logic(String id) {
//        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = " + id);
    }
}

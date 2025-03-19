package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    // 자바에서 제공하는 표준 서블릿 규악 -> 그걸 위한 HTTP request 정보를 받을 수 있음
    public String logDemo(HttpServletRequest request) {
        // 고객이 어떤 URL로 요청했는지 알 수 있음
        String requestURL = request.getRequestURL().toString();
//        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}

/**
 * myLoggerProvider.getObject()를 하는 시점에 MyLogger 클래스 객체가 생성이 됨.
 * MyLogger 객체가 생성되면서 @PostConstruct를 한 init 메서드가 실행되고 그 이후 logDemo 메서드 다음 내용인 URL 저장, controller test 출력, LogDemoService 클래스의 Service id : testId 출력
 * 이후 return "OK"를 통해 웹 화면에 OK 보여준 후, @PreDestroy 메서드인 close() 메서드를 통해 문자열 로그 출력
 */
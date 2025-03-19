package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")
// Qualifier("mainDiscountPolicy")를 직접 사용하면 문자 오타 같은 부분을 컴파일 때 잡아줄 수 있는 부분이 아니라 따로 어노테이션을 생성.
// Qualifier 어노테이션을 제외한 나머지 어노테이션은 Qualifier 어노테이션 내부에 있는 어노테이션을 복붙한거.
// 이렇게 하면 다른 클래스에서 사용할 때 @Qualifier("mainDiscountPolicy")를 사용하지 않고 @MainDiscountPolicy를 사용하면 됨.
public @interface MainDiscountPolicy {
}

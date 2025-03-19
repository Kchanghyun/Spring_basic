package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {
    AppConfig appConfig = new AppConfig();

    DiscountPolicy discountPolicy = appConfig.discountPolicy();
    OrderService orderService = appConfig.orderService();
    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        int discount = discountPolicy.discount(member, 20000);

        // then
        assertThat(discount).isEqualTo(2000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    void vip_x() {
        // given
        Member member = new Member(1L, "memberA", Grade.BASIC);

        // when
        int discount = discountPolicy.discount(member, 20000);

        // then
        assertThat(discount).isEqualTo(0);
    }

}
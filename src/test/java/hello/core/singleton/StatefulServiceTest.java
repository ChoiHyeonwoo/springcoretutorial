package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

class StatefulServiceTest {

    @Test // Singleton에는 공유되는 필드가 있으면 안됨 (Stateless 로 설계해야 함)
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);
        //ThreadA :  A사용자 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);

        //ThreadB :  B사용자 20000원 주문
        int userBPrice = statefulService2.order("userB", 20000);

        //ThreadA :  A사용자 주문금액조회
        System.out.println("price = " + userAPrice);
        assertThat(userAPrice).isEqualTo(10000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService (){
            return new StatefulService();
        }
    }
}
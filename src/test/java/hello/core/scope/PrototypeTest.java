package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {

    @Test
    void prototypeBeenTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(prototypeBeen.class);
        System.out.println("find prototypeBeen1");
        prototypeBeen prototypeBeen1 = ac.getBean(prototypeBeen.class);

        System.out.println("find prototypeBeen2");
        prototypeBeen prototypeBeen2 = ac.getBean(prototypeBeen.class);

        System.out.println("prototypeBeen1 = " + prototypeBeen1);
        System.out.println("prototypeBeen2 = " + prototypeBeen2);

        assertThat(prototypeBeen1).isNotSameAs(prototypeBeen2);

        prototypeBeen1.destroy();
        prototypeBeen2.destroy();
        ac.close();
    }

    @Scope("prototype")
    static class prototypeBeen {
        @PostConstruct
        public void init() {
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingletonBean.destroy");
        }
    }
}

import com.order.OrderServiceApplication;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

/**
 * 消息队列测试类
 */

@SpringBootTest(classes = OrderServiceApplication.class)
public class SpringAmqpTest {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void testSend() {
        String queueName = "simple.queue";
        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");

        amqpTemplate.convertAndSend(queueName,  map);

    }

    @Test
    public void testSend2() {
        amqpTemplate.convertAndSend("zl.topic", "china1.jinan", "济南");
    }


}

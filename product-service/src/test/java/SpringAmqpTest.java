import com.product.ProductServiceApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.concurrent.ListenableFutureCallback;


@Slf4j
@SpringBootTest(classes = ProductServiceApplication.class)
public class SpringAmqpTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;


}

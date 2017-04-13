package loobo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = "context1.xml")
public class SpringSingleContext {

    @Autowired
    BeanA beanA;

}

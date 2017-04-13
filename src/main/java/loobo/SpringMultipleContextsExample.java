package loobo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
        @ContextConfiguration("context2.xml"),
        @ContextConfiguration("context3.xml")})
public class SpringMultipleContextsExample extends SpringSingleContext {
    @Autowired
    private BeanB beanB;

    @Autowired
    private BeanC beanC;

    @Autowired
    private ApplicationContext context;

    @Test
    public void printAllContexts() {
        System.out.println("Print contexts " + context);
        ApplicationContext parent = context;
        while (parent != null) {
            System.out.println("Context: " + parent.getId());
            System.out.println("[");
            for (String beanName : parent.getBeanDefinitionNames()) {
                if (beanName.contains("bean")) {
                    System.out.println(beanName);
                }
            }
            System.out.println("]");
            parent = parent.getParent();
        }
    }

    @Test
    public void verifyBeans() {
        assertNotNull(beanA);
        assertNotNull(beanB);
        assertNotNull(beanC);
    }
}

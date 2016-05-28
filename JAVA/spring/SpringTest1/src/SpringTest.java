import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by crazyacking on 16-5-10.
 */
public class SpringTest {
    public static void main(String[] args){
        XmlBeanFactory factory=new XmlBeanFactory(
                new ClassPathResource("applicationContext.xml"));
        Cat cat1=(Cat)factory.getBean("acat");
        cat1.getCat();
//        IService hello=(IService)factory.getBean("service");
//        hello.service("Devin");
        factory.destroySingletons();
    }
}

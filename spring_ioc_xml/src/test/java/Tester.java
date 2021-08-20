import com.bjpowernode.pojo.Product;
import com.bjpowernode.service.ProductService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Tester {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    ProductService productService = context.getBean(ProductService.class);

    @Test
    public void test01() {
        Product product = new Product();
        product.setName("随便写！");
        productService.save(product);
    }

    @Test
    public void test02() {
        productService.delete("54");
    }

    @Test
    public void test03() {
        Product product = new Product();
        product.setName("随便写！???");
        product.setId("53");
        productService.update(product);
    }

    @Test
    public void test04() {
        Product product = productService.query(53);
        System.out.println(product);
    }

    @Test
    public void test05() {
        List<Product> products = productService.query();
        System.out.println(products);
    }
}

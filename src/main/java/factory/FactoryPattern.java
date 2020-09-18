package factory;

/**
 * @author Dongfanger
 * @date 2020/9/12
 * @deprecated 工厂模式
 *
 * 输出的产品是标准品，谁来做都可以。
 *
 * 优点：客户类和工厂类分开。消费者任何时候需要某种产品，只需向工厂请求即可。消费者无须修改就可以接纳新产品。
 *
 * 缺点：是当产品修改时，工厂类也要做相应的修改。
 */
public class FactoryPattern {

    public static void main(String[] args) {

        Factory factory = new ConcreteFactoryA();
        Product product = factory.createProduct();
        product.use();
    }
}

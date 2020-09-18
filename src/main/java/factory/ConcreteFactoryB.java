package factory;

/**
 * @author Dongfanger
 * @date 2020/9/12
 */
public class ConcreteFactoryB implements Factory {

    public Product createProduct() {
        System.out.println("具体工厂B生成->具体产品B");
        return new ConcreteProductB();
    }
}

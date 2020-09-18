package factory;

/**
 * @author Dongfanger
 * @date 2020/9/12
 */
public class ConcreteFactoryA implements Factory {

    public Product createProduct() {
        System.out.println("具体工厂A生成-->具体产品A");
        return new ConcreteProductA();
    }
}

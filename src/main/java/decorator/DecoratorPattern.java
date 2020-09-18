package decorator;

/**
 * @author Dongfanger
 * @date 2020/9/12
 * @deprecated 装饰模式
 *
 * 一个装饰类的接口必须与被装饰类的接口保持相同，对于客户端来说无论是装饰之前的对象还是装饰之后的对象都可以一致对待。
 *
 * 尽量保持具体构件类Component作为一个“轻”类，也就是说不要把太多的逻辑和状态放在具体构件类中，可以通过装饰类。
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component.operation();
        System.out.println("---------------------------------");
        Component decorator = new ConcreteDecorator(component);
        decorator.operation();

    }
}

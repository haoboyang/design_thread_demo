package decorator;

/**
 * @author Dongfanger
 * @date 2020/9/12
 */
public class ConcreteDecorator extends Decorator{

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addBehavior();
    }

    private void addBehavior() {
        System.out.println("为具体构件角色增加额外的功能addBehavior()");
    }
}

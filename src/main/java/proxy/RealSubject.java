package proxy;

/**
 * @author Dongfanger
 * @date 2020/9/13
 */
public class RealSubject implements Subject{

    @Override
    public void request() {
        System.out.println("访问真实主体方法...");
    }
}

package proxy;

/**
 * @author Dongfanger
 * @date 2020/9/13
 */
public class Proxy implements Subject{
    private RealSubject realSubject;

    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.request();
        afterRequest();
    }

    private void preRequest() {
        System.out.println("访问真实主体之前的预处理。");
    }

    private void afterRequest() {
        System.out.println("访问真实主体之前的预处理。");
    }

}

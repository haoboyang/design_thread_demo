package observer;

/**
 * @author Dongfanger
 * @date 2020/9/13
 */
public class OctalObserver extends Observer{

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {

    }
}

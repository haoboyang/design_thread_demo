package strategy;

/**
 * @author Dongfanger
 * @date 2020/9/12
 */
public class ConcreteStrategyB implements Strategy{
    @Override
    public void algorithm() {
        System.out.println("具体策略B的策略方法被访问！");
    }
}

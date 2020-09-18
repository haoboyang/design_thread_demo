package strategy;

/**
 * @author Dongfanger
 * @date 2020/9/12
 */
public class ConcreteStrategyA implements Strategy{
    @Override
    public void algorithm() {
        System.out.println("具体策略A的策略方法被访问！");
    }
}

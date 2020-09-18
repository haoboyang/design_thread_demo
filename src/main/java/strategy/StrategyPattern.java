package strategy;

/**
 * @author Dongfanger
 * @date 2020/9/12
 * @deprecated 策略模式
 *
 * 一个系统需要动态地在几种可替换算法中选择一种。不希望使用者关心算法细节，将具体算法封装进策略类中。
 *
 * 优缺点
 *
 * 优点：策略模式提供了对“开闭原则”的完美支持，用户可以在不修改原有系统的基础上选择算法或行为。干掉复杂难看的if-else。
 *
 * 缺点：调用时，必须提前知道都有哪些策略模式类，才能自行决定当前场景该使用何种策略。
 */
public class StrategyPattern {
    public static void main(String[] args) {
        Context context = new Context();
        Strategy strategyA = new ConcreteStrategyA();
        context.setStrategy(strategyA);
        context.algorithm();
        System.out.println("-----------------");
        Strategy strategyB = new ConcreteStrategyB();
        context.setStrategy(strategyB);
        context.algorithm();
    }
}

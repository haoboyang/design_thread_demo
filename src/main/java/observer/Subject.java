package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dongfanger
 * @date 2020/9/13
 */
class Subject {
    protected List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public List<Observer> getObservers() {
        return observers;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

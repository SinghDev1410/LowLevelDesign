package com.LowLevelDesign.SystemDesign.Design.BehaviouralDesignPattern.ObserverDp;


import java.util.ArrayList;
import java.util.List;

public class ObserverDp {
    public static void main(String[] args) {

        StocksObservable iphoneStockObservable = new IphoneObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("xyz1@gmail.com", iphoneStockObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("xyz2@gmail.com", iphoneStockObservable);
        NotificationAlertObserver observer3 = new EmailAlertObserverImpl("xyz3@gmail.com", iphoneStockObservable);

        iphoneStockObservable.add(observer1);
        iphoneStockObservable.add(observer2);
        iphoneStockObservable.add(observer3);

        iphoneStockObservable.setStockCount(10);

    }
}

interface StocksObservable{
    public void add (NotificationAlertObserver observer);
    public void remove(NotificationAlertObserver observer);
    public void notifySubscribers();
    public void setStockCount(int newStockAdded);
    public int getStockCount();
}

class IphoneObservableImpl implements StocksObservable{

    public List<NotificationAlertObserver> observersList = new ArrayList<>();
    public int stockCount = 0;

    @Override
    public void add(NotificationAlertObserver observer) {
        observersList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observersList.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for (NotificationAlertObserver observer : observersList){
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newStockAdded) {
        if (stockCount == 0){
            notifySubscribers();
        }
        stockCount = stockCount+newStockAdded;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}



// OBSERVER

interface NotificationAlertObserver{
    void update();
}



class EmailAlertObserverImpl implements NotificationAlertObserver {
    String emailId;
    StocksObservable observable;


    public EmailAlertObserverImpl(String emailId, StocksObservable observable) {
        this.emailId = emailId;
        this.observable = observable;
    }


    @Override
    public void update() {
        sendMail(emailId, "product is in stock hurry up!");
    }

    void sendMail(String emailId, String msg){
        System.out.println("mail sent to:" + emailId);
    }
}
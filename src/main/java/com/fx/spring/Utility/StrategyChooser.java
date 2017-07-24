package com.fx.spring.Utility;

import com.fx.spring.ModelFx.ClosedTradesTransaction;
import com.fx.spring.ModelFx.ClosedTradesTransactionStrategy1;
import com.fx.spring.ModelFx.ClosedTradesTransactionStrategy2;
import com.fx.spring.ModelFx.ClosedTradesTransactionStrategy3;
import com.fx.spring.ModelFx.ClosedTradesTransactionStrategy4;
import com.fx.spring.ModelFx.ClosedTradesTransactionStrategy5;
import com.fx.spring.ModelFx.ClosedTradesTransactionStrategy6;
import com.fx.spring.ModelFx.ClosedTradesTransactionStrategy7;
import com.fx.spring.ModelFx.ClosedTradesTransactionStrategy8;
import com.fx.spring.ModelFx.ClosedTradesTransactionStrategy9;
import com.fx.spring.ModelFx.ClosedTradesTransactionStrategy10;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 28/06/2017.
 */
public class StrategyChooser {

    List<String> listOfClosedTradesStrategiesResources;
    List<ClosedTradesTransaction> listOfClosedTradesStrategies;
    ClosedTradesTransactionStrategy1 closedTradesTransactionStrategy1;
    ClosedTradesTransactionStrategy2 closedTradesTransactionStrategy2;
    ClosedTradesTransactionStrategy3 closedTradesTransactionStrategy3;
    ClosedTradesTransactionStrategy4 closedTradesTransactionStrategy4;
    ClosedTradesTransactionStrategy5 closedTradesTransactionStrategy5;
    ClosedTradesTransactionStrategy6 closedTradesTransactionStrategy6;
    ClosedTradesTransactionStrategy7 closedTradesTransactionStrategy7;
    ClosedTradesTransactionStrategy8 closedTradesTransactionStrategy8;
    ClosedTradesTransactionStrategy9 closedTradesTransactionStrategy9;
    ClosedTradesTransactionStrategy10 closedTradesTransactionStrategy10;

    public StrategyChooser() {
        listOfClosedTradesStrategiesResources=new ArrayList<>();
        listOfClosedTradesStrategies=new ArrayList<>();
        closedTradesTransactionStrategy1=new ClosedTradesTransactionStrategy1();
        closedTradesTransactionStrategy2=new ClosedTradesTransactionStrategy2();
        closedTradesTransactionStrategy3=new ClosedTradesTransactionStrategy3();
        closedTradesTransactionStrategy4=new ClosedTradesTransactionStrategy4();
        closedTradesTransactionStrategy5=new ClosedTradesTransactionStrategy5();
        closedTradesTransactionStrategy6=new ClosedTradesTransactionStrategy6();
        closedTradesTransactionStrategy7=new ClosedTradesTransactionStrategy7();
        closedTradesTransactionStrategy8=new ClosedTradesTransactionStrategy8();
        closedTradesTransactionStrategy9=new ClosedTradesTransactionStrategy9();
        closedTradesTransactionStrategy10=new ClosedTradesTransactionStrategy10();
    }

    public List<String> getListOfClosedTradesStrategiesResources(){
        listOfClosedTradesStrategiesResources.add("/Transactions/closedTradesStrategy1.csv");
        listOfClosedTradesStrategiesResources.add("/Transactions/closedTradesStrategy2.csv");
        return listOfClosedTradesStrategiesResources;
    }

    public List<ClosedTradesTransaction> getListOfClosedTradesStrategies(){
        listOfClosedTradesStrategies.add(closedTradesTransactionStrategy1);
        listOfClosedTradesStrategies.add(closedTradesTransactionStrategy2);
        listOfClosedTradesStrategies.add(closedTradesTransactionStrategy3);
        listOfClosedTradesStrategies.add(closedTradesTransactionStrategy4);
        listOfClosedTradesStrategies.add(closedTradesTransactionStrategy5);
        listOfClosedTradesStrategies.add(closedTradesTransactionStrategy6);
        listOfClosedTradesStrategies.add(closedTradesTransactionStrategy7);
        listOfClosedTradesStrategies.add(closedTradesTransactionStrategy8);
        listOfClosedTradesStrategies.add(closedTradesTransactionStrategy9);
        listOfClosedTradesStrategies.add(closedTradesTransactionStrategy10);
        return listOfClosedTradesStrategies;
    }

    public ClosedTradesTransaction getClosedTradesStrategyReferenceByObjectType(ClosedTradesTransaction closedTradesTransaction){

        ClosedTradesTransaction closedTradesTransactionTemp=new ClosedTradesTransaction();

        if(closedTradesTransaction instanceof ClosedTradesTransactionStrategy1){
            closedTradesTransactionTemp=new ClosedTradesTransactionStrategy1();
        }
        if(closedTradesTransaction instanceof ClosedTradesTransactionStrategy2){
            closedTradesTransactionTemp=new ClosedTradesTransactionStrategy2();
        }
        if(closedTradesTransaction instanceof ClosedTradesTransactionStrategy3){
            closedTradesTransactionTemp=new ClosedTradesTransactionStrategy3();
        }
        if(closedTradesTransaction instanceof ClosedTradesTransactionStrategy4){
            closedTradesTransactionTemp=new ClosedTradesTransactionStrategy4();
        }
        if(closedTradesTransaction instanceof ClosedTradesTransactionStrategy5){
            closedTradesTransactionTemp=new ClosedTradesTransactionStrategy5();
        }
        if(closedTradesTransaction instanceof ClosedTradesTransactionStrategy6){
            closedTradesTransactionTemp=new ClosedTradesTransactionStrategy6();
        }
        if(closedTradesTransaction instanceof ClosedTradesTransactionStrategy7){
            closedTradesTransactionTemp=new ClosedTradesTransactionStrategy7();
        }
        if(closedTradesTransaction instanceof ClosedTradesTransactionStrategy8){
            closedTradesTransactionTemp=new ClosedTradesTransactionStrategy8();
        }
        if(closedTradesTransaction instanceof ClosedTradesTransactionStrategy9){
            closedTradesTransactionTemp=new ClosedTradesTransactionStrategy9();
        }
        if(closedTradesTransaction instanceof ClosedTradesTransactionStrategy10){
            closedTradesTransactionTemp=new ClosedTradesTransactionStrategy10();
        }
        return closedTradesTransactionTemp;
    }

    public ClosedTradesTransaction getClosedTradesStrategyNewObjectByChosenStrategyNumber(int closedTradesTransactionStrategyNumber){

        if(closedTradesTransactionStrategyNumber==1){
            return new ClosedTradesTransactionStrategy1();
        }
        if(closedTradesTransactionStrategyNumber==2){
            return new ClosedTradesTransactionStrategy2();
        }
        if(closedTradesTransactionStrategyNumber==3){
            return new ClosedTradesTransactionStrategy3();
        }
        if(closedTradesTransactionStrategyNumber==4){
            return new ClosedTradesTransactionStrategy4();
        }
        if(closedTradesTransactionStrategyNumber==5){
            return new ClosedTradesTransactionStrategy5();
        }
        if(closedTradesTransactionStrategyNumber==6){
            return new ClosedTradesTransactionStrategy6();
        }
        if(closedTradesTransactionStrategyNumber==7){
            return new ClosedTradesTransactionStrategy1();
        }
        if(closedTradesTransactionStrategyNumber==7){
            return new ClosedTradesTransactionStrategy1();
        }
        if(closedTradesTransactionStrategyNumber==8){
            return new ClosedTradesTransactionStrategy8();
        }
        if(closedTradesTransactionStrategyNumber==9){
            return new ClosedTradesTransactionStrategy9();
        }
        if(closedTradesTransactionStrategyNumber==10){
            return new ClosedTradesTransactionStrategy10();
        }
        if(closedTradesTransactionStrategyNumber>10){
            System.out.println("NO closedTradesTransactionStrategyNumber in scope!! from 'StrategyChooser' file");
            return null;
        }
        return null;
    }


}


//public class Main {
//
//    public static void main(String[] args) {
//        method(new Dog());
//        method(new Bird());
//    }
//    static void method(Object object){
//        if(object.getClass().getSimpleName().equals(Bird.class.getSimpleName()) ){
//            Animal bird=new Bird();
//            System.out.println(((Bird)bird).x);
//            bird.print();
//        }
//        if(object  instanceof Dog){
//            Animal dog=new Dog();
//            System.out.println(((Dog)dog).x);
//            dog.print();
//        }
//    }
//}
//
//class Animal{
//    String x="animal";
//    void print(){
//        System.out.println("text from Animal");
//    }
//}
//class Bird extends Animal{
//    String x="Bird";
//    void print(){
//        System.out.println("text from Bird");
//    }
//}
//class Dog extends Animal{
//    String x="Dog";
//    void print(){
//        System.out.println("text from Dog");
//    }
//}

/// answer

//Dog
//text from Dog
//Bird
//text from Bird
/**
 * Created by crazyacking on 16-5-12.
 */
package com.crazyacking;

public class Dao {
    Dao dao;
    public void Dao(Dao dao){
        this.dao=dao;
    }

    public void setDao(Dao dao){
        this.dao=dao;
    }

    public Dao getDao(){
        return dao;
    }

    public void sayHello(String name){
        System.out.println("Hello,"+name);
    }

}
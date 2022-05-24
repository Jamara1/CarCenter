/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author jamar
 */
public class Element<T> {
    private T data;
    
    public Element(){};
    
    public void setData(T t) {
        this.data = t;
    };
    
    public T getData() {
        return this.data;
    }
}

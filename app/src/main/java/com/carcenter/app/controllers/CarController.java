/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carcenter.app.controllers;

import com.carcenter.app.models.CarModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jamar
 */
public class CarController {
    private static List<CarModel> listCar = new ArrayList<CarModel>();
    private CarModel car = new CarModel();

    public List<CarModel> getListCar() {
        return listCar;
    }

    public void setListCar(List<CarModel> listCar) {
        CarController.listCar = listCar;
    }

    public CarModel getCar() {
        return car;
    }

    public void setCar(CarModel car) {
        this.car = car;
    }
    
    public void addCar() {
       CarController.listCar.add(this.car);
    }
    
    public void isCar(CarModel car) {
        CarController.listCar.remove(car);
    }
}

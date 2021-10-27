package com.ecs.exceptions;

public class CarDetailNotFoundException extends RuntimeException{
    public  CarDetailNotFoundException(){
        super();
    }
    public CarDetailNotFoundException(String message){
        super(message);
    }

}
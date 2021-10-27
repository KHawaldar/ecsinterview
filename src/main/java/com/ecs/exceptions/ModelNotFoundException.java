package com.ecs.exceptions;

public class ModelNotFoundException extends RuntimeException{
   public  ModelNotFoundException(){
       super();
   }
   public ModelNotFoundException(String message){
       super(message);
   }

}

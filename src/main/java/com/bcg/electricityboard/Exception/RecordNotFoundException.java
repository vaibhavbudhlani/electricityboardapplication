package com.bcg.electricityboard.Exception;

import org.springframework.stereotype.Component;

@Component
public class RecordNotFoundException extends Exception{

    public RecordNotFoundException(){

    }

    public RecordNotFoundException(String message){
        super(message);
    }

}

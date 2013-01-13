package com.example.samplebookmarks;

@SuppressWarnings("serial")
public class AppException extends RuntimeException {

    private Enum errorEnum;
    
    public AppException(Enum errorEnum){
        this.errorEnum = errorEnum;
    }
    
    public Enum getErrorEnum(){
        return this.errorEnum;
    }
    
    public String getErrorCode(){
        return this.errorEnum.name();
    }
    
    
}

package br.antony.sea.service.exception;

public class NullDataException extends  RuntimeException{

    public NullDataException(String msg){super(msg);}
    public NullDataException(String msg, Throwable cause){super(msg, cause);}
}

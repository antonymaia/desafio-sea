package br.antony.sea.service.exception;

public class DuplicidadeDadosException extends RuntimeException{

    public DuplicidadeDadosException(String msg){super(msg);}
    public DuplicidadeDadosException(String msg, Throwable cause){super(msg, cause);}
}

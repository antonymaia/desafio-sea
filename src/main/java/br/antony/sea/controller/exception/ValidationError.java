package br.antony.sea.controller.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
    private static final long serialVersionUID = 1L;

    private List<FieldMessage> erros = new ArrayList<>();

    public ValidationError(Integer statusHTTP, String msg, Long timeStamp) {
        super(statusHTTP, msg, timeStamp);
    }

    public List<FieldMessage> getErros() {
        return erros;
    }

    public void addError(String fieldName, String messagem){erros.add(new FieldMessage(fieldName, messagem));}
}

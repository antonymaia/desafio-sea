package br.antony.sea.controller.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer statusHTTP;
    private String msg;
    private Long timeStamp;

    public StandardError(Integer statusHTTP, String msg, Long timeStamp) {
        this.statusHTTP = statusHTTP;
        this.msg = msg;
        this.timeStamp = timeStamp;
    }

    public Integer getStatusHTTP() {
        return statusHTTP;
    }

    public void setStatusHTTP(Integer statusHTTP) {
        this.statusHTTP = statusHTTP;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}

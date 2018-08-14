package com.hitol.springboot.common;

public class BasicResult {
    private Integer code;
    private String msg;
    private Object data;

    public BasicResult(Integer code) {
        this.code = code;
    }

    public BasicResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BasicResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static  BasicResult success (){
        return new BasicResult(0,null,null);
    }

    public static  BasicResult success(Object data){
        return new BasicResult(0,null,data);
    }

    public static  BasicResult failure (String msg,Object data){
        return  new BasicResult(-1,msg,data);
    }


}

package cn.azzhu.myo2o.enums;

/**
 * @author:azzw
 * @date 2019-9-3 20:59
 */


public enum PersonInfoFlag {

    CUSTOMER(0,"普通用户"),SHOPOEMPLOYEE(1,"店主");

    private int code;
    private String msg;

    PersonInfoFlag() {
    }

    PersonInfoFlag(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.lanwon.kingdeemanage.model;

import org.springframework.http.HttpStatus;

public class R<T> {
    private Integer code;
    private String msg;
    private T data;

    public static R success() {
        return (new R()).setCode(HttpStatus.OK.value()).setMsg("success");
    }

    public static <T> R success(T data) {
        return success().setData(data);
    }

    public static R fail() {
        return (new R()).setCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).setMsg("fail");
    }

    public static <T> R fail(String msg) {
        return (new R()).setCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).setMsg(msg);
    }

    public static R fail(Integer errorCode, String msg) {
        return fail().setCode(errorCode).setMsg(msg);
    }

    public R() {
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public T getData() {
        return this.data;
    }

    public R<T> setCode(final Integer code) {
        this.code = code;
        return this;
    }

    public R<T> setMsg(final String msg) {
        this.msg = msg;
        return this;
    }

    public R<T> setData(final T data) {
        this.data = data;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof R)) {
            return false;
        } else {
            R<?> other = (R)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$code = this.getCode();
                    Object other$code = other.getCode();
                    if (this$code == null) {
                        if (other$code == null) {
                            break label47;
                        }
                    } else if (this$code.equals(other$code)) {
                        break label47;
                    }

                    return false;
                }

                Object this$msg = this.getMsg();
                Object other$msg = other.getMsg();
                if (this$msg == null) {
                    if (other$msg != null) {
                        return false;
                    }
                } else if (!this$msg.equals(other$msg)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof R;
    }



    public String toString() {
        return "R(code=" + this.getCode() + ", msg=" + this.getMsg() + ", data=" + this.getData() + ")";
    }
}

package com.nomad.app.model;

import java.io.Serializable;

public class Reply<T> implements Serializable {
    private int code;
    private String message;
    private T payload;

    public Reply() {
    }

    public int getCode() {
        return this.code;
    }

    public Reply<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public Reply<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getPayload() {
        return this.payload;
    }

    public Reply<T> setPayload(T payload) {
        this.payload = payload;
        return this;
    }

    public static <T> Reply<T> ok() {
        return (new Reply()).setCode(0).setMessage("OK");
    }

    public static <T> Reply<T> ok(T payload) {
        return (new Reply()).setCode(0).setMessage("OK").setPayload(payload);
    }

    public static <T> Reply<T> warning(int code, String message) {
        if (code >= 100 && code <= 999) {
            return (new Reply()).setCode(code).setMessage(message);
        } else {
            throw new IllegalArgumentException("Warning code must be between 100 and 999");
        }
    }

    public static <T> Reply<T> warning(int code, String message, T payload) {
        if (code >= 100 && code <= 999) {
            return (new Reply()).setCode(code).setMessage(message).setPayload(payload);
        } else {
            throw new IllegalArgumentException("Warning code must be between 100 and 999");
        }
    }

    public static <T> Reply<T> warning(int code, T payload) {
        if (code >= 100 && code <= 999) {
            return (new Reply()).setCode(code).setMessage("Completed with warning(s)").setPayload(payload);
        } else {
            throw new IllegalArgumentException("Warning code must be between 100 and 999");
        }
    }

    public static <T> Reply<T> error(int code, String message) {
        if (code >= 1000 && code <= 9999) {
            return (new Reply()).setCode(code).setMessage(message);
        } else {
            throw new IllegalArgumentException("Error code must be between 1000 and 9999");
        }
    }

    public static <T> Reply<T> error(int code, String message, T payload) {
        if (code >= 1000 && code <= 9999) {
            return (new Reply()).setCode(code).setMessage(message).setPayload(payload);
        } else {
            throw new IllegalArgumentException("Error code must be between 1000 and 9999");
        }
    }

    public static <T> Reply<T> error(int code, T payload) {
        if (code >= 1000 && code <= 9999) {
            return (new Reply()).setCode(code).setMessage("Error occurred").setPayload(payload);
        } else {
            throw new IllegalArgumentException("Error code must be between 1000 and 9999");
        }
    }
}

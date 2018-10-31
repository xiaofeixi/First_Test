package com.xl.exceptions;

/**
 * Created by  X.L on 2018/6/25.
 */
public class ShopOperationException extends RuntimeException {
    private static final long serialVersionUID = 2577363134463897930L;

    public ShopOperationException(String msg) {
        super(msg);
    }
}

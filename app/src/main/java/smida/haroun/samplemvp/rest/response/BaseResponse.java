package smida.haroun.samplemvp.rest.response;

import smida.haroun.samplemvp.rest.Error;

/**
 * Created by Haroun Smida on 29/07/17.
 * smida.haroun@gmail.com
 */

public class BaseResponse<T> {
    private boolean status;
    private T data;
    private Error error;

    public boolean isStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public Error getError() {
        return error;
    }
}

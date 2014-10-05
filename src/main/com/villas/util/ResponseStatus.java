package main.com.villas.util;

/**
 * Created by aboyarintsev on 05.10.2014.
 */
public class ResponseStatus {

    private int code;
    private String message;

    public ResponseStatus(){}

    public ResponseStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

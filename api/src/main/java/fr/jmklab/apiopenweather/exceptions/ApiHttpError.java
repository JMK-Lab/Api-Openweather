package fr.jmklab.apiopenweather.exceptions;

public class ApiHttpError extends Exception {

    public ApiHttpError(String s, Throwable cause) {
        super(s, cause);
    }
}

package org.kakara.core.exceptions;

public class IllegalModException extends Exception {
    public IllegalModException(String s) {
        super(s);
    }

    public IllegalModException(String s, Exception e) {
        super(s,e);
    }
}

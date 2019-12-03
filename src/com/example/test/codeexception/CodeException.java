package com.example.test.codeexception;

import javax.xml.crypto.dsig.TransformException;

public class CodeException extends Exception{
    int code;
    String msg;
    public CodeException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        try {
            process();
        }catch (CodeException exception) {
            response(exception);
        }

    }

    public static void process() throws CodeException{
        int num =1;
        if (num !=2) {
            throw new CodeException(11,"num error");
        }
    }
    public static void response(CodeException codeException) {
        System.out.println("code is "+ codeException.code +" , msg is "+ codeException.msg);
    }
}


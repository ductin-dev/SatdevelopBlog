package com.satellite.myblog.action;
//Author: Doan Duc Tin

import java.util.ArrayList;

public class Validation {

    public static boolean validateString(String a) throws Exception {
        if (a == null || a.equals("")) {
            throw new Exception("Không được để trống các trường");
        }
        if (!a.matches("[A-Za-z0-9@._-]+")) {
            throw new Exception("Không được nhập ký tự đặc biệt: " + a);
        }
        return true;
    }

    public static boolean validateEmpty(String a) throws Exception {
        if (a == null || a.equals("") || a.isEmpty()) {
            throw new Exception("Không được để trống các trường");
        }
        return true;
    }

    public static boolean validateNumber(String a, int min, int max) throws Exception {
        if (!a.matches("[0-9]+")) {
            throw new Exception("Chỉ được nhập số");
        }
        int temp = Integer.parseInt(a);
        if (temp < min || temp > max) {
            throw new Exception("Bạn đã nhập số quá lớn hoặc quá nhỏ so với giới hạn [" + min + " - " + max + "]");
        }
        return true;
    }

    public static boolean validateCannotClick(String s) throws Exception {
        if (s.contains("<") || s.contains(">") || s.contains("\"") || s.contains("\'") || s.contains("`")) {
            throw new Exception("Bạn không được nhập các ký tự [\",\"]|[\',\']|[<,>]");
        }
        return true;
    }

    public static boolean validateVarchar(String s, int length) throws Exception {
        if (s.length() > length) throw new Exception("Độ dài quá mức cho phép");
        if (s == null || s.equals("")) {
            throw new Exception("Không được để trống các trường");
        }
        if (!s.matches("[A-Za-z0-9@._-]+")) {
            throw new Exception("Không được nhập ký tự đặc biệt: " + s);
        }
        return true;
    }

    public static boolean validateNumberRange(int a, int min, int max) throws Exception {
        if (a < min || a > max) {
            throw new Exception("Bạn đã nhập số quá lớn hoặc quá nhỏ so với giới hạn [" + min + " - " + max + "]");
        }
        return true;
    }

}

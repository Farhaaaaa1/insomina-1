package com.company;

public class GetResponsRequirement {
    private static String time = null;
    private static String bytee = null;
    private static String code = null;
    private static String body = null;

    public GetResponsRequirement() {
    }

    public static void setTime(String time) {
        GetResponsRequirement.time = time;
    }

    public static void setBytee(String bytee) {
        GetResponsRequirement.bytee = bytee;
    }

    public static void setCode(String code) {
        GetResponsRequirement.code = code;
    }

    public static void setBody(String body) {
        GetResponsRequirement.body = body;
    }

    public static  String getTime() {
        return time;
    }

    public static String getBytee() {
        return bytee;
    }

    public static String getCode() {
        return code;
    }

    public static String getBody() {
        return body;
    }
}

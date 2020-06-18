package com.company;

import java.util.List;
import java.util.Map;

/**
 * in this class we get all thing we want
 * from what internet give to us
 */
public class GetResponsRequirement {
    private  String time = null;
    private  String bytee = null;
    private  int code = -1;
    private  String body = null;
    private Map<String, List<String>> headerMap = null ;
    public GetResponsRequirement() {
    }

    /**
     * getter and settersss
     */


    public void setTime(String time) {
        this.time = time;
    }

    public void setBytee(String bytee) {
        this.bytee = bytee;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, List<String>> getHeaderMap() {
        return headerMap;
    }

    public void setHeaderMap(Map<String, List<String>> headerMap) {
        this.headerMap = headerMap;
    }

    public String getTime() {
        return time;
    }

    public String getBytee() {
        return bytee;
    }

    public int getCode() {
        return code;
    }

    public String getBody() {
        return body;
    }
}

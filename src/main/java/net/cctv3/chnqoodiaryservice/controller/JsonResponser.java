package net.cctv3.chnqoodiaryservice.controller;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import net.cctv3.chnqoodiaryservice.constants.Status;

import java.util.HashMap;

public class JsonResponser {
    private String code;
    private Object data;

    public JsonResponser() {
        this.code = "0000";
        this.data = new Object();
    }

    public JsonResponser(String code) {
        this.code = code;
        this.data = new Object();
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private HashMap<String, Object> handle() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("code", code);
        String message = "";
        if(code.equals("0000")) {
            hashMap.put("success", true);
        }
        else {
            hashMap.put("success", false);
        }
        hashMap.put("data", data);
        hashMap.put("message", Status.getMessageByCode(this.code));
        return hashMap;
    }

    public String ok() {
        HashMap hashMap = handle();
        return new Gson().toJson(hashMap);
    }
}

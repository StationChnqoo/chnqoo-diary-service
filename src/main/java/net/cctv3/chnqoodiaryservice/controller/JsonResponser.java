package net.cctv3.chnqoodiaryservice.controller;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import net.cctv3.chnqoodiaryservice.constants.Status;

import java.util.HashMap;

public class JsonResponser {
    private String code;

    public JsonResponser() {
        this.code = "0000";
    }

    public JsonResponser(String code) {
        this.code = code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private HashMap<String, Object> handle() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("code", code);
        String message = "";
        if(this.code.equals("0000")) {
            hashMap.put("success", true);
        }
        else {
            hashMap.put("success", false);
        }
        hashMap.put("message", Status.getMessageByCode(this.code));
        return hashMap;
    }

    public String ok(Object data) {
        HashMap hashMap = handle();
        hashMap.put("data", data);
        return new Gson().toJson(hashMap);
    };

    public String ok() {
        HashMap hashMap = handle();
        return new Gson().toJson(hashMap);
    }
}

package net.cctv3.chnqoodiaryservice.entity;

import lombok.Data;

@Data
public class User {
    private String id;
    private String idQoo;
    private String idCard;
    private String mobile;
    private String email;
    private String smsCode;
    private String smsTime;
    private String name;
    private String nickname;
    private String password;
    private String avatar;
    private String motto;
    private String linkQq;
    private String linkWechat;
    private Boolean isDeleted;
    private String createTime;
    private String updateTime;

    public User(String id, String idQoo, String idCard, String mobile, String email, String smsCode, String smsTime, String name, String nickname, String password, String avatar, String motto, String linkQq, String linkWechat, Boolean isDeleted, String createTime, String updateTime) {
        this.id = id;
        this.idQoo = idQoo;
        this.idCard = idCard;
        this.mobile = mobile;
        this.email = email;
        this.smsCode = smsCode;
        this.smsTime = smsTime;
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.avatar = avatar;
        this.motto = motto;
        this.linkQq = linkQq;
        this.linkWechat = linkWechat;
        this.isDeleted = isDeleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
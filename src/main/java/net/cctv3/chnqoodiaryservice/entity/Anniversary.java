package net.cctv3.chnqoodiaryservice.entity;

import lombok.Data;

@Data
public class Anniversary {
    private String id;
    private String userId;
    private String title;
    private String message;
    private String images;
    private boolean isDelete;
    private boolean isPublic;
    private String happenedDate;
    private String createTime;
    private String updateTime;
}
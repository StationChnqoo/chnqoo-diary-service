package net.cctv3.chnqoodiaryservice.constants;

public enum Status {
    SUCCESS("0000", "操作成功"),
    TS_CHECKED_MD5("0001", "接口访问参数错误"),
    SMS_TIMEOUT("0002", "验证码已过期"),
    SMS_CHECKED("0003", "验证码错误");

    private String code;
    private String message;

    Status(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static String getMessageByCode(String code) {
        String message = "";
        for (Status status : values()) {
            if (status.getCode().equals(code)) {
                message = status.getMessage();
            }
        }
        return message;
    }
}
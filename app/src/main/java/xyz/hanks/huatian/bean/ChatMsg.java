package xyz.hanks.huatian.bean;

public class ChatMsg {
    public static final int TYPE_IMAGE = 0;
    public static final int TYPE_LOCATION = 1;
    public static final int TYPE_VOICE = 2;
    public static final int TYPE_TEXT = 3;

    public static final int STATUS_SEND_START = 4;
    public static final int STATUS_SEND_SUCCESS = 5;
    public static final int STATUS_SEND_FAIL = 6;
    public static final int STATUS_SEND_RECEIVERED = 7;

    private int msgType;
    private String belongId;
    private String belongAvatar;
    private String content;
    private int status;
    private long msgTime;

    public long getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(long msgTime) {
        this.msgTime = msgTime;
    }

    public String getBelongAvatar() {
        return belongAvatar;
    }

    public void setBelongAvatar(String belongAvatar) {
        this.belongAvatar = belongAvatar;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public String getBelongId() {
        return belongId;
    }

    public void setBelongId(String belongId) {
        this.belongId = belongId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}

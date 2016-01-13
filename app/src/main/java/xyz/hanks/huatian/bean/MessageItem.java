package xyz.hanks.huatian.bean;

/**
 * 消息界面的每天消息的实体类
 *
 * @author zyh
 * @version 1.0
 */
public class MessageItem {

    /**
     * 正常聊天
     */
    public final static int TYPE_MESSAGE = 0;
    /**
     * 有人赞了你
     */
    public final static int TYPE_PRAISE = 1;
    /**
     * 最近访问的
     */
    public final static int TYPE_VISITOR = 2;
    /**
     * 有人关注了你
     */
    public final static int TYPE_FOLLOW = 3;

    /**
     * 有人举报
     */
    public final static int TYPE_PEACH = 4;

    /**
     * 消息的ID
     */
    private int id;

    /**
     * 消息的类型,Type常量里的一种
     */
    private int type;

    /**
     * 消息的来源
     */
    private User userFrom;

    /**
     * 消息的内容
     */
    private String content;

    /**
     * 消息创建的时间
     */
    private long createAt;

    public MessageItem(int type, User userFrom, String content, long createAt) {
        this.type = type;
        this.userFrom = userFrom;
        this.content = content;
        this.createAt = createAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public User getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(User userFrom) {
        this.userFrom = userFrom;
    }

}

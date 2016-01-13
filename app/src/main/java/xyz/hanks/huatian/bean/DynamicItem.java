package xyz.hanks.huatian.bean;

public class DynamicItem {

    private int id;

    private User user;

    private String imageUrl;

    private String content;

    private long createTime;

    private int zan;

    private boolean isPraised;

    public DynamicItem(User user, String imageUrl, String content) {
        this.user = user;
        this.imageUrl = imageUrl;
        this.content = content;
        createTime = System.currentTimeMillis();
    }

    public int getZan() {
        return zan;
    }

    public void setZan(int zan) {
        this.zan = zan;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public boolean isPraised() {
        return isPraised;
    }

    public void setPraised(boolean isPraised) {
        this.isPraised = isPraised;
    }

}

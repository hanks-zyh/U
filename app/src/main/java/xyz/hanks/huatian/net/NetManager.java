package xyz.hanks.huatian.net;


import java.util.ArrayList;
import java.util.List;

import xyz.hanks.huatian.bean.ActivityItem;
import xyz.hanks.huatian.bean.CommunityItem;
import xyz.hanks.huatian.bean.DynamicItem;
import xyz.hanks.huatian.bean.EncounterItem;
import xyz.hanks.huatian.bean.MessageItem;
import xyz.hanks.huatian.bean.TopicItem;
import xyz.hanks.huatian.bean.User;

/**
 * 负责从服务器获取数据封装
 *
 * @author zyh
 * @version 1.0
 */
public class NetManager {

    /**
     * 获取首页里"动态"的list
     *
     * @return
     * @version 1.0
     * @author zyh
     */
    public static List<DynamicItem> getDynamicList() {
        List<DynamicItem> list = new ArrayList<DynamicItem>();
        // 模拟数据
        for (int i = 0; i < 50; i++) {
            list.add(new DynamicItem(new User("一个人的女王",
                    "http://att.bbs.duowan.com/forum/201304/25/045109czyubkby8b88ttz0.png", 23, 165,
                    39.942379, 116.413467),
                    "http://p4.qhimg.com/dmt/225_240_/d/_famous_onebox/pic/star/58186.jpg", "怎么不是雾霾天"));
            list.add(new DynamicItem(
                    new User("唯一", "http://att.bbs.duowan.com/forum/201304/25/0451010oag11nnkbnq021q.png",
                            20, 170, 29.942379, 126.413467),
                    "http://g.hiphotos.baidu.com/image/pic/item/472309f790529822a4686ac9d5ca7bcb0a46d465.jpg",
                    "阳光明媚的下午,回忆中是美好的,但仅仅是回忆,未来会更好"));
            list.add(new DynamicItem(
                    new User("MyBaby",
                            "http://att.bbs.duowan.com/forum/201304/25/0451020h1q9gcz3c6r5435.png", 25, 168,
                            19.942379, 136.413467),
                    "http://h.hiphotos.baidu.com/image/pic/item/10dfa9ec8a1363274db80d2b938fa0ec08fac755.jpg",
                    "秀色可餐!"));
            list.add(new DynamicItem(
                    new User("不懂人情冷暖",
                            "http://att.bbs.duowan.com/forum/201304/25/04505941prtlemtsu7otuv.png", 21, 155,
                            37.942379, 146.413467),
                    "http://e.hiphotos.baidu.com/image/pic/item/8694a4c27d1ed21b2200beecaf6eddc450da3fe9.jpg",
                    "公务员路过"));
        }
        return list;
    }

    /**
     * 获取首页里"活动"的list
     *
     * @return
     * @version 1.0
     * @author zyh
     */
    public static List<ActivityItem> getActivityList() {
        List<ActivityItem> list = new ArrayList<ActivityItem>();
        // 模拟数据
        for (int i = 0; i < 50; i++) {
            list.add(new ActivityItem(new User("一个人的女王",
                    "http://att.bbs.duowan.com/forum/201304/25/045109czyubkby8b88ttz0.png", 23, 165,
                    39.942379, 116.413467), "约会", "运动", "AA制", "周末", "深圳", "一个安静的下午..."));
            list.add(new ActivityItem(new User("唯一",
                    "http://att.bbs.duowan.com/forum/201304/25/0451010oag11nnkbnq021q.png", 20, 170,
                    29.942379, 126.413467), "约会", "看电影", "我豪爽我买单", "02月14日 10:00", "北京", "看看电影放松一下"));
            list.add(new ActivityItem(new User("MyBaby",
                    "http://att.bbs.duowan.com/forum/201304/25/0451020h1q9gcz3c6r5435.png", 25, 168,
                    19.942379, 136.413467), "约会", "K歌", "AA制", "周末", "上海", "新人第一次,约吗?"));
            list.add(new ActivityItem(new User("不懂人情冷暖",
                    "http://att.bbs.duowan.com/forum/201304/25/04505941prtlemtsu7otuv.png", 21, 155,
                    37.942379, 146.413467), "约会", "旅游", "我豪爽我买单", "02月14日 18:00", "北京", "我请你吃午饭,喝咖啡,都可以"));
        }
        return list;
    }

    /**
     * 获取邂逅的list
     *
     * @return
     * @version 1.0
     * @author zyh
     */
    public static List<EncounterItem> getEncounterList() {
        List<EncounterItem> list = new ArrayList<EncounterItem>();
        // 模拟数据
        for (int i = 0; i < 50; i++) {
            list.add(new EncounterItem(new User("一个人的女王",
                    "http://www.ineiyi.com/uploads/allimg/1401/78-140103162612.jpg", 23, 165, 39.942379,
                    116.413467, "大专", "6千-1万"), "交友条件:住在深圳,24-32岁,身高175厘米以上,月薪10000-20000的男生.", null));
            list.add(new EncounterItem(new User("晴子susie",
                    "http://www.ineiyi.com/uploads/allimg/1312/78-131210104141.jpg", 22, 160, 39.342379,
                    116.413467, "本科", "1万-2万"), "交友条件:性格开朗,北京,22-28岁,身高175厘米以上,男生.", null));
            list.add(new EncounterItem(new User("唯一",
                    "http://img5.pcpop.com/ArticleImages/500x375/2/2804/002804538.jpg", 24, 170, 38.342379,
                    116.413467, "博士", "2万-3万"),
                    "交友条件:我要他 高高的 瘦瘦的 很贴心 要对着我笑 爱我 嗯.... 善良 孝顺 可爱 阳光 大度 至于乐观 比我乐观就行! 不要气我的 我哭的时候会安慰我 ", null));
            list.add(new EncounterItem(new User("MyBaby",
                    "http://img5.iqilu.com/c/u/2012/1013/1350092783585.jpg", 20, 157, 39.342379, 116.313467,
                    "本科", "4千-8千"),
                    "交友条件:我的性格比较内向~~SO~我的他最好有点内向但是又偏外向一点点~~（太内向了~我们怎么交流咧~太外向了~我也接受不了~会让我感觉像个花蝴蝶~", null));
        }
        return list;
    }

    /**
     * 获取社区的list
     *
     * @return
     * @version 1.0
     * @author zyh
     */
    public static List<CommunityItem> getCommunityList() {
        List<CommunityItem> list = new ArrayList<CommunityItem>();
        // 模拟数据
        for (int i = 0; i < 50; i++) {
            list.add(new CommunityItem(56701, 900, "求助帖", "谁来帮帮我~~"));
            list.add(new CommunityItem(17468, 579, "贴图控", "我们长得丑,但是我们爱自拍"));
            list.add(new CommunityItem(7033, 355, "荐书影音", "学习娱乐两不误"));
            list.add(new CommunityItem(18756, 652, "吃货爱美食", "我要吃的饱饱哒~"));
            list.add(new CommunityItem(7568, 320, "游记攻略", "来和我一起环游世界"));
            list.add(new CommunityItem(113476, 242, "前任那些事", "你所见过的奇葩"));
        }
        return list;
    }

    /**
     * 获取邂逅的list
     *
     * @return
     * @version 1.0
     * @author zyh
     */
    public static List<MessageItem> getMessageList() {
        List<MessageItem> list = new ArrayList<MessageItem>();
        // 模拟数据
        for (int i = 0; i < 50; i++) {
            list.add(new MessageItem(MessageItem.TYPE_PRAISE, new User("晴子susie",
                    "http://www.ineiyi.com/uploads/allimg/1312/78-131210104141.jpg"), "有人赞了你的照片", System
                    .currentTimeMillis()));
            list.add(new MessageItem(MessageItem.TYPE_MESSAGE, new User("一个人的女王",
                    "http://www.ineiyi.com/uploads/allimg/1401/78-140103162612.jpg"), "好漂亮的地方", System
                    .currentTimeMillis()));
            list.add(new MessageItem(MessageItem.TYPE_MESSAGE, new User("晴子susie",
                    "http://www.ineiyi.com/uploads/allimg/1312/78-131210104141.jpg"), "头像很好看!", System
                    .currentTimeMillis()));
            list.add(new MessageItem(MessageItem.TYPE_MESSAGE, new User("MyBaby",
                    "http://img5.iqilu.com/c/u/2012/1013/1350092783585.jpg"), "你可真有才啊~", System
                    .currentTimeMillis()));
            list.add(new MessageItem(MessageItem.TYPE_VISITOR, null, "最近有人访问了你", System.currentTimeMillis()));

        }
        return list;
    }

    /**
     * 获取ID
     *
     * @param id 话题列表的ID
     * @return
     * @version 1.0
     * @author zyh
     */
    public static List<TopicItem> getTopicListById(int id) {
        List<TopicItem> list = new ArrayList<TopicItem>();

        ArrayList<String> imageList0 = new ArrayList<String>();
        ArrayList<String> imageList1 = new ArrayList<String>();
        ArrayList<String> imageList2 = new ArrayList<String>();
        ArrayList<String> imageList3 = new ArrayList<String>();
        imageList0
                .add("http://g.hiphotos.baidu.com/image/w%3D2048/sign=68d533b3cc1b9d168ac79d61c7e6b58f/a71ea8d3fd1f41348919a412271f95cad1c85eab.jpg");
        imageList0
                .add("http://d.hiphotos.baidu.com/image/w%3D2048/sign=de804594a586c91708035539fd0571cf/0824ab18972bd4077eb0729179899e510fb30962.jpg");
        imageList0
                .add("http://g.hiphotos.baidu.com/image/w%3D2048/sign=875deb626509c93d07f209f7ab05f9dc/d50735fae6cd7b89d01b9bef0d2442a7d9330e62.jpg");
        imageList1.add("http://imgsrc.baidu.com/forum/pic/item/ed1b9d16fdfaaf51ae8eba558f5494eef11f7aee.jpg");
        imageList1.add("http://imgsrc.baidu.com/forum/pic/item/50f082025aafa40ff5c8f537a864034f79f019c9.jpg");
        imageList1.add("http://imgsrc.baidu.com/forum/pic/item/faf9d72a6059252dca1026ee379b033b5ab5b9d0.jpg");
        imageList2
                .add("http://h.hiphotos.baidu.com/image/w%3D2048/sign=bdb1f685f0d3572c66e29bdcbe2b6227/8644ebf81a4c510f6e9943766259252dd42aa579.jpg");
        imageList3
                .add("http://b.hiphotos.baidu.com/image/w%3D2048/sign=4bb3c37013dfa9ecfd2e511756e8f603/1b4c510fd9f9d72ad939b171d62a2834349bbb79.jpg");
        imageList3
                .add("http://e.hiphotos.baidu.com/image/w%3D2048/sign=94b65792c1fdfc03e578e4b8e0078694/83025aafa40f4bfba7a73f38014f78f0f7361862.jpg");

        // 模拟数据
        for (int i = 0; i < 50; i++) {
            list.add(new TopicItem(new User("一个人的女王",
                    "http://att.bbs.duowan.com/forum/201304/25/045109czyubkby8b88ttz0.png"),
                    "1秒钟 测试你手机是不是水货", "只需输入一个符号，就是手机符号’£’，出来’拢’的是水货。不信自己试试……(酷)", null, System
                    .currentTimeMillis(), 23));
            list.add(new TopicItem(new User("唯一",
                    "http://att.bbs.duowan.com/forum/201304/25/0451010oag11nnkbnq021q.png"), "明天情人节了，所以..",
                    "，有来报名的吗，给老夫介绍别人也", imageList0, System.currentTimeMillis(), 20));

            list.add(new TopicItem(new User(",回忆",
                    "http://att.bbs.duowan.com/forum/201304/25/0451010oag11nnkbnq021q.png"),
                    "致未来的你，你好，我未来的男朋友", "怎么不我的小爪子来也~镇楼是雾霾天", imageList1, System.currentTimeMillis(), 18));
            list.add(new TopicItem(
                    new User(
                            "人情冷暖",
                            "http://h.hiphotos.baidu.com/image/h%3D360/sign=14dd71413a12b31bd86ccb2fb6183674/730e0cf3d7ca7bcb6d162a29bd096b63f624a843.jpg"),
                    "大神都喜欢用漫头你们发现了吗", "为什么嘞。", imageList2, System.currentTimeMillis(), 73));
            list.add(new TopicItem(
                    new User(
                            "明媚的下午",
                            "http://h.hiphotos.baidu.com/image/h%3D360/sign=f6d12fd975094b36c4921deb93cd7c00/810a19d8bc3eb135f48666bda51ea8d3fd1f4477.jpg"),
                    "我就想问是不是不爆照你们就不感兴趣", "如果是你告诉我我爆出来", imageList3, System.currentTimeMillis(), 8));
            // list.add(new DynamicItem(
            // new User("唯一",
            // "http://att.bbs.duowan.com/forum/201304/25/0451010oag11nnkbnq021q.png",
            // 20, 170, 29.942379, 126.413467),
            // "http://g.hiphotos.baidu.com/image/pic/item/472309f790529822a4686ac9d5ca7bcb0a46d465.jpg",
            // "阳光明媚的下午,回忆中是美好的,但仅仅是回忆,未来会更好"));
            // list.add(new DynamicItem(
            // new User("MyBaby",
            // "http://att.bbs.duowan.com/forum/201304/25/0451020h1q9gcz3c6r5435.png",
            // 25, 168,
            // 19.942379, 136.413467),
            // "http://h.hiphotos.baidu.com/image/pic/item/10dfa9ec8a1363274db80d2b938fa0ec08fac755.jpg",
            // "秀色可餐!"));
            // list.add(new DynamicItem(
            // new User("不懂人情冷暖",
            // "http://att.bbs.duowan.com/forum/201304/25/04505941prtlemtsu7otuv.png",
            // 21, 155,
            // 37.942379, 146.413467),
            // "http://e.hiphotos.baidu.com/image/pic/item/8694a4c27d1ed21b2200beecaf6eddc450da3fe9.jpg",
            // "公务员路过"));
        }
        return list;
    }

    /**
     * 通过id查询用户
     *
     * @param id
     * @return
     * @version 1.0
     * @author zyh
     */
    public static User getUserInfoById(int id) {
        User user = new User("混搭潮",
                "http://d.hiphotos.baidu.com/image/pic/item/6609c93d70cf3bc714f3caebd200baa1cc112ac1.jpg",
                21, 163, 39.342379, 116.313467, "本科", "4千-6千");
        user.setDescription("今天天气不错呀,么么哒~~");
        return user;
    }
}

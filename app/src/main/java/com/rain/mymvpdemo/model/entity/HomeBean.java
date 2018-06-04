package com.rain.mymvpdemo.model.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Author:rain
 * Date:2018/6/4 10:32
 * Description:
 */
public class HomeBean {

    private String newestIssueType;
    private String nextPageUrl;
    private long nextPublishTime;
    private List<IssueListBean> issueList;

    public String getNewestIssueType() {
        return newestIssueType;
    }

    public void setNewestIssueType(String newestIssueType) {
        this.newestIssueType = newestIssueType;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public long getNextPublishTime() {
        return nextPublishTime;
    }

    public void setNextPublishTime(long nextPublishTime) {
        this.nextPublishTime = nextPublishTime;
    }

    public List<IssueListBean> getIssueList() {
        return issueList;
    }

    public void setIssueList(List<IssueListBean> issueList) {
        this.issueList = issueList;
    }

    public static class IssueListBean {
        /**
         * count : 5
         * date : 1528074000000
         * itemList : [{"adIndex":-1,"data":{"author":{"approvedNotReadyVideoCount":0,"description":"有趣的人永远不缺童心","follow":{"followed":false,"itemId":2170,"itemType":"author"},"icon":"http://img.kaiyanapp.com/482c741c06644f5566c7218096dbaf26.jpeg","id":2170,"ifPgc":true,"latestReleaseTime":1528074001000,"link":"","name":"开眼动画精选","shield":{"itemId":2170,"itemType":"author","shielded":false},"videoNum":604},"category":"动画","collected":false,"consumption":{"collectionCount":0,"replyCount":0,"shareCount":0},"cover":{"blurred":"http://img.kaiyanapp.com/51111bc9bd90f35b89ef2c14a5c22308.png?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/86815430ffad48da76c1ff3973c76891.png?imageMogr2/quality/60/format/jpg","feed":"http://img.kaiyanapp.com/86815430ffad48da76c1ff3973c76891.png?imageMogr2/quality/60/format/jpg","homepage":"http://img.kaiyanapp.com/86815430ffad48da76c1ff3973c76891.png?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"dataType":"VideoBeanForClient","date":1528074000000,"description":"来自「百度机器猫吧」的粉丝自制动画。大雄和机器猫来到中国游玩，去了上海、南京、杭州、武汉、三峡、重庆、成都，最终到达珠穆朗玛，熟悉的旋律搭配堪比原作的动画水平，满满的童年回忆啊！From 百度机器猫吧","descriptionEditor":"来自「百度机器猫吧」的粉丝自制动画。大雄和机器猫来到中国游玩，去了上海、南京、杭州、武汉、三峡、重庆、成都，最终到达珠穆朗玛，熟悉的旋律搭配堪比原作的动画水平，满满的童年回忆啊！From 百度机器猫吧","descriptionPgc":"","duration":169,"id":107113,"idx":0,"ifLimitVideo":false,"labelList":[],"library":"DAILY","playInfo":[{"height":480,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=107113&resourceType=video&editionType=normal&source=aliyun","urlList":[{"name":"aliyun","size":18749530,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=107113&resourceType=video&editionType=normal&source=aliyun"},{"name":"qcloud","size":18749530,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=107113&resourceType=video&editionType=normal&source=qcloud"},{"name":"ucloud","size":18749530,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=107113&resourceType=video&editionType=normal&source=ucloud"}],"width":854},{"height":1080,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=107113&resourceType=video&editionType=high&source=aliyun","urlList":[{"name":"aliyun","size":60056253,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=107113&resourceType=video&editionType=high&source=aliyun"},{"name":"qcloud","size":60056253,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=107113&resourceType=video&editionType=high&source=qcloud"},{"name":"ucloud","size":60056253,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=107113&resourceType=video&editionType=high&source=ucloud"}],"width":1920}],"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=107113&resourceType=video&editionType=default&source=aliyun","played":false,"provider":{"alias":"bilibili","icon":"http://img.kaiyanapp.com/b968890a2b3e9ab5ae234175681f8cd4.png","name":"哔哩哔哩动画"},"releaseTime":1528074001000,"resourceType":"video","searchWeight":0,"slogan":"粉丝超强自制动画","subtitles":[],"tags":[{"actionUrl":"eyepetizer://tag/14/?title=%E5%8A%A8%E7%94%BB","bgPicture":"http://img.kaiyanapp.com/c4e5c0f76d21abbd23c9626af3c9f481.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/88da8548d31005032c37df4889d2104c.jpeg?imageMogr2/quality/100","id":14,"name":"动画","tagRecType":"IMPORTANT"},{"actionUrl":"eyepetizer://tag/496/?title=%E8%87%B4%E6%95%AC","bgPicture":"http://img.kaiyanapp.com/f9d6f16db9ea2e894f8e5e2ee7071d99.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/f9d6f16db9ea2e894f8e5e2ee7071d99.jpeg?imageMogr2/quality/60/format/jpg","id":496,"name":"致敬","tagRecType":"NORMAL"},{"actionUrl":"eyepetizer://tag/42/?title=%E7%B2%89%E4%B8%9D%E8%87%AA%E5%88%B6","bgPicture":"http://img.kaiyanapp.com/0cccd736b633bbd7fc638f6b64ad61e7.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/0cccd736b633bbd7fc638f6b64ad61e7.jpeg?imageMogr2/quality/60/format/jpg","id":42,"name":"粉丝自制","tagRecType":"NORMAL"}],"thumbPlayUrl":"","title":"童年回忆神还原：哆啦 A 梦来中国啦！","titlePgc":"","type":"NORMAL","webUrl":{"forWeibo":"http://www.eyepetizer.net/detail.html?vid=107113","raw":"http://www.eyepetizer.net/detail.html?vid=107113"}},"id":0,"type":"video"},{"adIndex":-1,"data":{"author":{"approvedNotReadyVideoCount":0,"description":"为广告人的精彩创意点赞","follow":{"followed":false,"itemId":2162,"itemType":"author"},"icon":"http://img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg","id":2162,"ifPgc":true,"latestReleaseTime":1528074006000,"link":"","name":"开眼广告精选","shield":{"itemId":2162,"itemType":"author","shielded":false},"videoNum":937},"category":"广告","collected":false,"consumption":{"collectionCount":0,"replyCount":0,"shareCount":0},"cover":{"blurred":"http://img.kaiyanapp.com/0bb986563ff715e0eec58c47e3f296ed.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/4d576fbf199c735e7c9cad0587846c4e.jpeg?imageMogr2/quality/60/format/jpg","feed":"http://img.kaiyanapp.com/4d576fbf199c735e7c9cad0587846c4e.jpeg?imageMogr2/quality/60/format/jpg","homepage":"http://img.kaiyanapp.com/4d576fbf199c735e7c9cad0587846c4e.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"dataType":"VideoBeanForClient","date":1528074000000,"description":"现在人们 90% 的时间都是在室内度过，我们也被称为「室内一代」，但长期呆在室内真的会利于健康吗？致力于将阳光和新鲜空气带入千家万户的丹麦品牌 VELUX 在短片中给出了答案。From The VELUX Group","descriptionEditor":"现在人们 90% 的时间都是在室内度过，我们也被称为「室内一代」，但长期呆在室内真的会利于健康吗？致力于将阳光和新鲜空气带入千家万户的丹麦品牌 VELUX 在短片中给出了答案。From The VELUX Group","duration":188,"id":106301,"idx":0,"ifLimitVideo":false,"labelList":[],"library":"DAILY","playInfo":[{"height":480,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=106301&resourceType=video&editionType=normal&source=aliyun","urlList":[{"name":"aliyun","size":9944440,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=106301&resourceType=video&editionType=normal&source=aliyun"},{"name":"qcloud","size":9944440,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=106301&resourceType=video&editionType=normal&source=qcloud"},{"name":"ucloud","size":9944440,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=106301&resourceType=video&editionType=normal&source=ucloud"}],"width":854},{"height":720,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=106301&resourceType=video&editionType=high&source=aliyun","urlList":[{"name":"aliyun","size":18074530,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=106301&resourceType=video&editionType=high&source=aliyun"},{"name":"qcloud","size":18074530,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=106301&resourceType=video&editionType=high&source=qcloud"},{"name":"ucloud","size":18074530,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=106301&resourceType=video&editionType=high&source=ucloud"}],"width":1280}],"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=106301&resourceType=video&editionType=default&source=aliyun","played":false,"provider":{"alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png","name":"YouTube"},"releaseTime":1528074006000,"resourceType":"video","searchWeight":0,"slogan":"走出家门，拥抱自然","subtitles":[],"tags":[{"actionUrl":"eyepetizer://tag/773/?title=%E8%84%91%E6%B4%9E%E5%A4%A7%E5%BC%80","bgPicture":"http://img.kaiyanapp.com/25f37613bb960c36438b7b335b40f690.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/25f37613bb960c36438b7b335b40f690.png?imageMogr2/quality/60/format/jpg","id":773,"name":"脑洞大开","tagRecType":"NORMAL"},{"actionUrl":"eyepetizer://tag/766/?title=%E8%84%91%E6%B4%9E%E5%B9%BF%E5%91%8A","bgPicture":"http://img.kaiyanapp.com/0c8b10bc4c62316ee75a63ede4bccea9.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/0c8b10bc4c62316ee75a63ede4bccea9.jpeg?imageMogr2/quality/60/format/jpg","id":766,"name":"脑洞广告","tagRecType":"NORMAL"},{"actionUrl":"eyepetizer://tag/758/?title=%E6%AC%A7%E7%BE%8E%E5%B9%BF%E5%91%8A","bgPicture":"http://img.kaiyanapp.com/c00a26667da2c0ddc4b91432443473fa.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/c00a26667da2c0ddc4b91432443473fa.jpeg?imageMogr2/quality/60/format/jpg","id":758,"name":"欧美广告","tagRecType":"NORMAL"},{"actionUrl":"eyepetizer://tag/763/?title=%E5%85%AC%E7%9B%8A%E5%B9%BF%E5%91%8A","bgPicture":"http://img.kaiyanapp.com/06a15d3edb5ab09be73920d4f6a1e500.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/06a15d3edb5ab09be73920d4f6a1e500.jpeg?imageMogr2/quality/60/format/jpg","id":763,"name":"公益广告","tagRecType":"NORMAL"},{"actionUrl":"eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A","bgPicture":"http://img.kaiyanapp.com/e41e74fe73882b552de00d95d56748d2.jpeg?imageMogr2/quality/60","headerImage":"http://img.kaiyanapp.com/3054658dbd559ac42c4c282e9cab7a32.jpeg?imageMogr2/quality/100","id":16,"name":"广告","tagRecType":"NORMAL"}],"title":"家真的是「避风港」吗？","type":"NORMAL","webUrl":{"forWeibo":"http://www.eyepetizer.net/detail.html?vid=106301","raw":"http://www.eyepetizer.net/detail.html?vid=106301"}},"id":0,"type":"video"},{"adIndex":-1,"data":{"author":{"approvedNotReadyVideoCount":0,"description":"发现世界的奇妙和辽阔","follow":{"followed":false,"itemId":2164,"itemType":"author"},"icon":"http://img.kaiyanapp.com/75bc791c5f6cc239d6056e0a52d077fd.jpeg?imageMogr2/quality/60/format/jpg","id":2164,"ifPgc":true,"latestReleaseTime":1527987610000,"link":"","name":"开眼旅行精选","shield":{"itemId":2164,"itemType":"author","shielded":false},"videoNum":492},"category":"旅行","collected":false,"consumption":{"collectionCount":249,"replyCount":3,"shareCount":91},"cover":{"blurred":"http://img.kaiyanapp.com/ed71be1d0005ab48ac2d3b7410bde20e.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/3f4eee313b412d5c7c3d41a287be0e17.jpeg?imageMogr2/quality/60/format/jpg","feed":"http://img.kaiyanapp.com/3f4eee313b412d5c7c3d41a287be0e17.jpeg?imageMogr2/quality/60/format/jpg","homepage":"http://img.kaiyanapp.com/3f4eee313b412d5c7c3d41a287be0e17.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"dataType":"VideoBeanForClient","date":1528074000000,"description":"通常情侣风光片，都是女生比风光好看，风光比摄影好看。这部来自「Amir Zakeri」的创意风光摄影，第一次实现了摄影比女生好看。From Amir Zakeri","descriptionEditor":"通常情侣风光片，都是女生比风光好看，风光比摄影好看。这部来自「Amir Zakeri」的创意风光摄影，第一次实现了摄影比女生好看。From Amir Zakeri","descriptionPgc":"","duration":60,"id":107157,"idx":0,"ifLimitVideo":false,"labelList":[],"library":"DAILY","playInfo":[{"height":480,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=107157&resourceType=video&editionType=normal&source=aliyun","urlList":[{"name":"aliyun","size":8480501,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=107157&resourceType=video&editionType=normal&source=aliyun"},{"name":"qcloud","size":8480501,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=107157&resourceType=video&editionType=normal&source=qcloud"},{"name":"ucloud","size":8480501,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=107157&resourceType=video&editionType=normal&source=ucloud"}],"width":854},{"height":720,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=107157&resourceType=video&editionType=high&source=aliyun","urlList":[{"name":"aliyun","size":16775963,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=107157&resourceType=video&editionType=high&source=aliyun"},{"name":"qcloud","size":16775963,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=107157&resourceType=video&editionType=high&source=qcloud"},{"name":"ucloud","size":16775963,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=107157&resourceType=video&editionType=high&source=ucloud"}],"width":1280}],"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=107157&resourceType=video&editionType=default&source=aliyun","played":false,"provider":{"alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png","name":"YouTube"},"releaseTime":1527897821000,"resourceType":"video","searchWeight":0,"slogan":"神灯，请赐我一位女神吧！","subtitles":[],"tags":[{"actionUrl":"eyepetizer://tag/52/?title=%E9%A3%8E%E5%85%89%E6%91%84%E5%BD%B1","bgPicture":"http://img.kaiyanapp.com/1d8a845e9def7b9af2e947afc858ee18.jpeg?imageMogr2/quality/100","desc":"","headerImage":"http://img.kaiyanapp.com/1d8a845e9def7b9af2e947afc858ee18.jpeg?imageMogr2/quality/100","id":52,"name":"风光摄影","tagRecType":"IMPORTANT"},{"actionUrl":"eyepetizer://tag/346/?title=%E7%BE%8E%E5%9B%BD","bgPicture":"http://img.kaiyanapp.com/19b625e7277199ed752fe61a56a596f2.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/19b625e7277199ed752fe61a56a596f2.jpeg?imageMogr2/quality/100","id":346,"name":"美国","tagRecType":"NORMAL"},{"actionUrl":"eyepetizer://tag/10/?title=%E6%97%85%E8%A1%8C","bgPicture":"http://img.kaiyanapp.com/c1e1357770cc194272e735f3b1469868.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/8ff732f275759b2cb3a0b7fc9ba1715f.jpeg?imageMogr2/quality/100","id":10,"name":"旅行","tagRecType":"NORMAL"}],"thumbPlayUrl":"","title":"沙漠看见女神，真实还是梦境？","titlePgc":"","type":"NORMAL","webUrl":{"forWeibo":"http://www.eyepetizer.net/detail.html?vid=107157","raw":"http://www.eyepetizer.net/detail.html?vid=107157"}},"id":0,"type":"video"},{"adIndex":-1,"data":{"author":{"approvedNotReadyVideoCount":0,"description":"来自汪星、喵星、蠢萌星的你","follow":{"followed":false,"itemId":2169,"itemType":"author"},"icon":"http://img.kaiyanapp.com/ac6971c1b9fc942c7547d25fc6c60ad2.jpeg","id":2169,"ifPgc":true,"latestReleaseTime":1528074009000,"link":"","name":"开眼萌宠精选","shield":{"itemId":2169,"itemType":"author","shielded":false},"videoNum":146},"category":"萌宠","collected":false,"consumption":{"collectionCount":0,"replyCount":0,"shareCount":0},"cover":{"blurred":"http://img.kaiyanapp.com/ef01fb5bc99221e096f217c6c6c67fd1.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/232943f80f7d5b7f2f259ddc30ea2997.jpeg?imageMogr2/quality/60/format/jpg","feed":"http://img.kaiyanapp.com/232943f80f7d5b7f2f259ddc30ea2997.jpeg?imageMogr2/quality/60/format/jpg","homepage":"http://img.kaiyanapp.com/232943f80f7d5b7f2f259ddc30ea2997.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"dataType":"VideoBeanForClient","date":1528074000000,"description":"上班族都知道办公室里总有那么些鸡毛蒜皮的烦心事，这次让傲娇的喵星人演出你的遭遇，代入感是不是很强？From AaronsAnimals","descriptionEditor":"上班族都知道办公室里总有那么些鸡毛蒜皮的烦心事，这次让傲娇的喵星人演出你的遭遇，代入感是不是很强？From AaronsAnimals","duration":105,"id":87282,"idx":0,"ifLimitVideo":false,"labelList":[],"library":"DAILY","playInfo":[{"height":480,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=87282&resourceType=video&editionType=normal&source=aliyun","urlList":[{"name":"aliyun","size":5691822,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=87282&resourceType=video&editionType=normal&source=aliyun"},{"name":"qcloud","size":5691822,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=87282&resourceType=video&editionType=normal&source=qcloud"},{"name":"ucloud","size":5691822,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=87282&resourceType=video&editionType=normal&source=ucloud"}],"width":854},{"height":720,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=87282&resourceType=video&editionType=high&source=aliyun","urlList":[{"name":"aliyun","size":11357351,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=87282&resourceType=video&editionType=high&source=aliyun"},{"name":"qcloud","size":11357351,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=87282&resourceType=video&editionType=high&source=qcloud"},{"name":"ucloud","size":11357351,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=87282&resourceType=video&editionType=high&source=ucloud"}],"width":1280}],"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=87282&resourceType=video&editionType=default&source=aliyun","played":false,"provider":{"alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png","name":"YouTube"},"releaseTime":1528074009000,"resourceType":"video","searchWeight":0,"slogan":"满屏的表情包还不快来看","subtitles":[],"tags":[{"actionUrl":"eyepetizer://tag/751/?title=%E8%B6%85%E8%90%8C%E5%8A%A8%E7%89%A9%E5%9C%A8%E5%93%AA%E9%87%8C","bgPicture":"http://img.kaiyanapp.com/9b3846ea47ba8916b19e4cf2b9c17e78.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/9b3846ea47ba8916b19e4cf2b9c17e78.jpeg?imageMogr2/quality/60/format/jpg","id":751,"name":"超萌动物在哪里","tagRecType":"IMPORTANT"},{"actionUrl":"eyepetizer://tag/538/?title=%E5%96%B5%E6%98%9F%E4%BA%BA","bgPicture":"http://img.kaiyanapp.com/e2b82549f60051d85ffb552d2efe8c07.jpeg?imageMogr2/quality/60/format/jpg","desc":"","headerImage":"http://img.kaiyanapp.com/e2b82549f60051d85ffb552d2efe8c07.jpeg?imageMogr2/quality/60/format/jpg","id":538,"name":"喵星人","tagRecType":"NORMAL"},{"actionUrl":"eyepetizer://tag/32/?title=%E8%90%8C%E5%AE%A0","bgPicture":"http://img.kaiyanapp.com/9eb744f260986b0eb5608595596425c5.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/27f9f96a319acacb32daed7b694ccb59.jpeg?imageMogr2/quality/100","id":32,"name":"萌宠","tagRecType":"NORMAL"}],"title":"上班族，你的喵大人也会玩办公室政治","type":"NORMAL","webUrl":{"forWeibo":"http://www.eyepetizer.net/detail.html?vid=87282","raw":"http://www.eyepetizer.net/detail.html?vid=87282"}},"id":0,"type":"video"},{"adIndex":-1,"data":{"author":{"approvedNotReadyVideoCount":0,"description":"持续推送新奇、有趣、大开眼界的欧美创意广告","follow":{"followed":false,"itemId":938,"itemType":"author"},"icon":"http://img.kaiyanapp.com/e44ed5fcfa424ba35761ce5f1339bc16.jpeg?imageMogr2/quality/60/format/jpg","id":938,"ifPgc":true,"latestReleaseTime":1527840949000,"link":"","name":"欧美广告精选","shield":{"itemId":938,"itemType":"author","shielded":false},"videoNum":348},"category":"广告","collected":false,"consumption":{"collectionCount":568,"replyCount":16,"shareCount":229},"cover":{"blurred":"http://img.kaiyanapp.com/9f0a9187691653ff887e11f6bc402975.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/58741e0f00412f06e9ab1d42749db6e7.jpeg?imageMogr2/quality/60/format/jpg","feed":"http://img.kaiyanapp.com/58741e0f00412f06e9ab1d42749db6e7.jpeg?imageMogr2/quality/60/format/jpg","homepage":"http://img.kaiyanapp.com/58741e0f00412f06e9ab1d42749db6e7.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"dataType":"VideoBeanForClient","date":1528074000000,"description":"Google 的使命是「收集世界各地的信息，并让它们可以便捷的被使用」。更加易用，更富人文关怀的设计，不仅改变了现代科技的方向，而且让更多的人享受科技的便利。From Google Design","descriptionEditor":"Google 的使命是「收集世界各地的信息，并让它们可以便捷的被使用」。更加易用，更富人文关怀的设计，不仅改变了现代科技的方向，而且让更多的人享受科技的便利。From Google Design","duration":152,"id":102128,"idx":0,"ifLimitVideo":false,"labelList":[],"library":"DAILY","playInfo":[{"height":480,"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=102128&resourceType=video&editionType=normal&source=aliyun","urlList":[{"name":"aliyun","size":13451826,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=102128&resourceType=video&editionType=normal&source=aliyun"},{"name":"qcloud","size":13451826,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=102128&resourceType=video&editionType=normal&source=qcloud"},{"name":"ucloud","size":13451826,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=102128&resourceType=video&editionType=normal&source=ucloud"}],"width":854},{"height":720,"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=102128&resourceType=video&editionType=high&source=aliyun","urlList":[{"name":"aliyun","size":21070277,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=102128&resourceType=video&editionType=high&source=aliyun"},{"name":"qcloud","size":21070277,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=102128&resourceType=video&editionType=high&source=qcloud"},{"name":"ucloud","size":21070277,"url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=102128&resourceType=video&editionType=high&source=ucloud"}],"width":1280}],"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=102128&resourceType=video&editionType=default&source=aliyun","played":false,"provider":{"alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png","name":"YouTube"},"releaseTime":1526643192000,"resourceType":"video","searchWeight":0,"slogan":"上天入地，无所不能","subtitles":[],"tags":[{"actionUrl":"eyepetizer://tag/748/?title=%E5%B9%BF%E5%91%8A%E7%B2%BE%E9%80%89","bgPicture":"http://img.kaiyanapp.com/431177a6b2177788aa4d8eff8073d9a7.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/431177a6b2177788aa4d8eff8073d9a7.jpeg?imageMogr2/quality/60/format/jpg","id":748,"name":"广告精选","tagRecType":"IMPORTANT"},{"actionUrl":"eyepetizer://tag/766/?title=%E8%84%91%E6%B4%9E%E5%B9%BF%E5%91%8A","bgPicture":"http://img.kaiyanapp.com/0c8b10bc4c62316ee75a63ede4bccea9.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/0c8b10bc4c62316ee75a63ede4bccea9.jpeg?imageMogr2/quality/60/format/jpg","id":766,"name":"脑洞广告","tagRecType":"NORMAL"},{"actionUrl":"eyepetizer://tag/770/?title=%E7%A7%91%E6%8A%80%E5%B9%BF%E5%91%8A","bgPicture":"http://img.kaiyanapp.com/ad50cc00738fecb7033b210e751bde52.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/ad50cc00738fecb7033b210e751bde52.jpeg?imageMogr2/quality/60/format/jpg","id":770,"name":"科技广告","tagRecType":"NORMAL"},{"actionUrl":"eyepetizer://tag/398/?title=%E5%93%81%E7%89%8C%E7%9F%AD%E7%89%87","bgPicture":"http://img.kaiyanapp.com/f30657af97e84d4edf5508ef3908f0b3.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/f30657af97e84d4edf5508ef3908f0b3.jpeg?imageMogr2/quality/60/format/jpg","id":398,"name":"品牌短片","tagRecType":"NORMAL"},{"actionUrl":"eyepetizer://tag/758/?title=%E6%AC%A7%E7%BE%8E%E5%B9%BF%E5%91%8A","bgPicture":"http://img.kaiyanapp.com/c00a26667da2c0ddc4b91432443473fa.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/c00a26667da2c0ddc4b91432443473fa.jpeg?imageMogr2/quality/60/format/jpg","id":758,"name":"欧美广告","tagRecType":"NORMAL"},{"actionUrl":"eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A","bgPicture":"http://img.kaiyanapp.com/e41e74fe73882b552de00d95d56748d2.jpeg?imageMogr2/quality/60","headerImage":"http://img.kaiyanapp.com/3054658dbd559ac42c4c282e9cab7a32.jpeg?imageMogr2/quality/100","id":16,"name":"广告","tagRecType":"NORMAL"}],"title":"在谷歌，我们用设计改变世界","type":"NORMAL","webUrl":{"forWeibo":"http://www.eyepetizer.net/detail.html?vid=102128","raw":"http://www.eyepetizer.net/detail.html?vid=102128"}},"id":0,"type":"video"}]
         * publishTime : 1528074000000
         * releaseTime : 1528074000000
         * type : morning
         */

        private int count;
        private long date;
        private long publishTime;
        private long releaseTime;
        private String type;
        private List<ItemListBean> itemList;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public long getDate() {
            return date;
        }

        public void setDate(long date) {
            this.date = date;
        }

        public long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<ItemListBean> getItemList() {
            return itemList;
        }

        public void setItemList(List<ItemListBean> itemList) {
            this.itemList = itemList;
        }

        public static class ItemListBean implements MultiItemEntity {

            private int adIndex;
            private DataBean data;
            private int id;
            private String type;

            public static final int type_textHeader = 0;
            public static final int type_video = 1;

            public int getAdIndex() {
                return adIndex;
            }

            public void setAdIndex(int adIndex) {
                this.adIndex = adIndex;
            }

            public DataBean getData() {
                return data;
            }

            public void setData(DataBean data) {
                this.data = data;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            @Override
            public int getItemType() {
                if ("textHeader".equals(type)) {
                    return type_textHeader;
                }
                return type_video;
            }

            public static class DataBean {

                private AuthorBean author;
                private String category;
                private boolean collected;
                private ConsumptionBean consumption;
                private CoverBean cover;
                private String dataType;
                private long date;
                private String description;
                private String descriptionEditor;
                private String descriptionPgc;
                private Long duration;
                private int id;
                private int idx;
                private boolean ifLimitVideo;
                private String library;
                private String playUrl;
                private boolean played;
                private ProviderBean provider;
                private long releaseTime;
                private String resourceType;
                private int searchWeight;
                private String slogan;
                private String thumbPlayUrl;
                private String title;
                private String titlePgc;
                private String type;
                private WebUrlBean webUrl;
                private List<?> labelList;
                private List<PlayInfoBean> playInfo;
                private List<?> subtitles;
                private List<TagsBean> tags;

                // todo 该bean的字段包含了各种类型的所有字段
                private String text; // 针对type类型为textHeader的字段

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public AuthorBean getAuthor() {
                    return author;
                }

                public void setAuthor(AuthorBean author) {
                    this.author = author;
                }

                public String getCategory() {
                    return category;
                }

                public void setCategory(String category) {
                    this.category = category;
                }

                public boolean isCollected() {
                    return collected;
                }

                public void setCollected(boolean collected) {
                    this.collected = collected;
                }

                public ConsumptionBean getConsumption() {
                    return consumption;
                }

                public void setConsumption(ConsumptionBean consumption) {
                    this.consumption = consumption;
                }

                public CoverBean getCover() {
                    return cover;
                }

                public void setCover(CoverBean cover) {
                    this.cover = cover;
                }

                public String getDataType() {
                    return dataType;
                }

                public void setDataType(String dataType) {
                    this.dataType = dataType;
                }

                public long getDate() {
                    return date;
                }

                public void setDate(long date) {
                    this.date = date;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getDescriptionEditor() {
                    return descriptionEditor;
                }

                public void setDescriptionEditor(String descriptionEditor) {
                    this.descriptionEditor = descriptionEditor;
                }

                public String getDescriptionPgc() {
                    return descriptionPgc;
                }

                public void setDescriptionPgc(String descriptionPgc) {
                    this.descriptionPgc = descriptionPgc;
                }

                public Long getDuration() {
                    return duration;
                }

                public void setDuration(Long duration) {
                    this.duration = duration;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getIdx() {
                    return idx;
                }

                public void setIdx(int idx) {
                    this.idx = idx;
                }

                public boolean isIfLimitVideo() {
                    return ifLimitVideo;
                }

                public void setIfLimitVideo(boolean ifLimitVideo) {
                    this.ifLimitVideo = ifLimitVideo;
                }

                public String getLibrary() {
                    return library;
                }

                public void setLibrary(String library) {
                    this.library = library;
                }

                public String getPlayUrl() {
                    return playUrl;
                }

                public void setPlayUrl(String playUrl) {
                    this.playUrl = playUrl;
                }

                public boolean isPlayed() {
                    return played;
                }

                public void setPlayed(boolean played) {
                    this.played = played;
                }

                public ProviderBean getProvider() {
                    return provider;
                }

                public void setProvider(ProviderBean provider) {
                    this.provider = provider;
                }

                public long getReleaseTime() {
                    return releaseTime;
                }

                public void setReleaseTime(long releaseTime) {
                    this.releaseTime = releaseTime;
                }

                public String getResourceType() {
                    return resourceType;
                }

                public void setResourceType(String resourceType) {
                    this.resourceType = resourceType;
                }

                public int getSearchWeight() {
                    return searchWeight;
                }

                public void setSearchWeight(int searchWeight) {
                    this.searchWeight = searchWeight;
                }

                public String getSlogan() {
                    return slogan;
                }

                public void setSlogan(String slogan) {
                    this.slogan = slogan;
                }

                public String getThumbPlayUrl() {
                    return thumbPlayUrl;
                }

                public void setThumbPlayUrl(String thumbPlayUrl) {
                    this.thumbPlayUrl = thumbPlayUrl;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getTitlePgc() {
                    return titlePgc;
                }

                public void setTitlePgc(String titlePgc) {
                    this.titlePgc = titlePgc;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public WebUrlBean getWebUrl() {
                    return webUrl;
                }

                public void setWebUrl(WebUrlBean webUrl) {
                    this.webUrl = webUrl;
                }

                public List<?> getLabelList() {
                    return labelList;
                }

                public void setLabelList(List<?> labelList) {
                    this.labelList = labelList;
                }

                public List<PlayInfoBean> getPlayInfo() {
                    return playInfo;
                }

                public void setPlayInfo(List<PlayInfoBean> playInfo) {
                    this.playInfo = playInfo;
                }

                public List<?> getSubtitles() {
                    return subtitles;
                }

                public void setSubtitles(List<?> subtitles) {
                    this.subtitles = subtitles;
                }

                public List<TagsBean> getTags() {
                    return tags;
                }

                public void setTags(List<TagsBean> tags) {
                    this.tags = tags;
                }

                public static class AuthorBean {

                    private int approvedNotReadyVideoCount;
                    private String description;
                    private FollowBean follow;
                    private String icon;
                    private int id;
                    private boolean ifPgc;
                    private long latestReleaseTime;
                    private String link;
                    private String name;
                    private ShieldBean shield;
                    private int videoNum;

                    public int getApprovedNotReadyVideoCount() {
                        return approvedNotReadyVideoCount;
                    }

                    public void setApprovedNotReadyVideoCount(int approvedNotReadyVideoCount) {
                        this.approvedNotReadyVideoCount = approvedNotReadyVideoCount;
                    }

                    public String getDescription() {
                        return description;
                    }

                    public void setDescription(String description) {
                        this.description = description;
                    }

                    public FollowBean getFollow() {
                        return follow;
                    }

                    public void setFollow(FollowBean follow) {
                        this.follow = follow;
                    }

                    public String getIcon() {
                        return icon;
                    }

                    public void setIcon(String icon) {
                        this.icon = icon;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public boolean isIfPgc() {
                        return ifPgc;
                    }

                    public void setIfPgc(boolean ifPgc) {
                        this.ifPgc = ifPgc;
                    }

                    public long getLatestReleaseTime() {
                        return latestReleaseTime;
                    }

                    public void setLatestReleaseTime(long latestReleaseTime) {
                        this.latestReleaseTime = latestReleaseTime;
                    }

                    public String getLink() {
                        return link;
                    }

                    public void setLink(String link) {
                        this.link = link;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public ShieldBean getShield() {
                        return shield;
                    }

                    public void setShield(ShieldBean shield) {
                        this.shield = shield;
                    }

                    public int getVideoNum() {
                        return videoNum;
                    }

                    public void setVideoNum(int videoNum) {
                        this.videoNum = videoNum;
                    }

                    public static class FollowBean {

                        private boolean followed;
                        private int itemId;
                        private String itemType;

                        public boolean isFollowed() {
                            return followed;
                        }

                        public void setFollowed(boolean followed) {
                            this.followed = followed;
                        }

                        public int getItemId() {
                            return itemId;
                        }

                        public void setItemId(int itemId) {
                            this.itemId = itemId;
                        }

                        public String getItemType() {
                            return itemType;
                        }

                        public void setItemType(String itemType) {
                            this.itemType = itemType;
                        }
                    }

                    public static class ShieldBean {

                        private int itemId;
                        private String itemType;
                        private boolean shielded;

                        public int getItemId() {
                            return itemId;
                        }

                        public void setItemId(int itemId) {
                            this.itemId = itemId;
                        }

                        public String getItemType() {
                            return itemType;
                        }

                        public void setItemType(String itemType) {
                            this.itemType = itemType;
                        }

                        public boolean isShielded() {
                            return shielded;
                        }

                        public void setShielded(boolean shielded) {
                            this.shielded = shielded;
                        }
                    }
                }

                public static class ConsumptionBean {
                    private int collectionCount;
                    private int replyCount;
                    private int shareCount;

                    public int getCollectionCount() {
                        return collectionCount;
                    }

                    public void setCollectionCount(int collectionCount) {
                        this.collectionCount = collectionCount;
                    }

                    public int getReplyCount() {
                        return replyCount;
                    }

                    public void setReplyCount(int replyCount) {
                        this.replyCount = replyCount;
                    }

                    public int getShareCount() {
                        return shareCount;
                    }

                    public void setShareCount(int shareCount) {
                        this.shareCount = shareCount;
                    }
                }

                public static class CoverBean {
                    /**
                     * blurred : http://img.kaiyanapp.com/51111bc9bd90f35b89ef2c14a5c22308.png?imageMogr2/quality/60/format/jpg
                     * detail : http://img.kaiyanapp.com/86815430ffad48da76c1ff3973c76891.png?imageMogr2/quality/60/format/jpg
                     * feed : http://img.kaiyanapp.com/86815430ffad48da76c1ff3973c76891.png?imageMogr2/quality/60/format/jpg
                     * homepage : http://img.kaiyanapp.com/86815430ffad48da76c1ff3973c76891.png?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim
                     */

                    private String blurred;
                    private String detail;
                    private String feed;
                    private String homepage;

                    public String getBlurred() {
                        return blurred;
                    }

                    public void setBlurred(String blurred) {
                        this.blurred = blurred;
                    }

                    public String getDetail() {
                        return detail;
                    }

                    public void setDetail(String detail) {
                        this.detail = detail;
                    }

                    public String getFeed() {
                        return feed;
                    }

                    public void setFeed(String feed) {
                        this.feed = feed;
                    }

                    public String getHomepage() {
                        return homepage;
                    }

                    public void setHomepage(String homepage) {
                        this.homepage = homepage;
                    }
                }

                public static class ProviderBean {

                    private String alias;
                    private String icon;
                    private String name;

                    public String getAlias() {
                        return alias;
                    }

                    public void setAlias(String alias) {
                        this.alias = alias;
                    }

                    public String getIcon() {
                        return icon;
                    }

                    public void setIcon(String icon) {
                        this.icon = icon;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }

                public static class WebUrlBean {
                    private String forWeibo;
                    private String raw;

                    public String getForWeibo() {
                        return forWeibo;
                    }

                    public void setForWeibo(String forWeibo) {
                        this.forWeibo = forWeibo;
                    }

                    public String getRaw() {
                        return raw;
                    }

                    public void setRaw(String raw) {
                        this.raw = raw;
                    }
                }

                public static class PlayInfoBean {

                    private int height;
                    private String name;
                    private String type;
                    private String url;
                    private int width;
                    private List<UrlListBean> urlList;

                    public int getHeight() {
                        return height;
                    }

                    public void setHeight(int height) {
                        this.height = height;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public int getWidth() {
                        return width;
                    }

                    public void setWidth(int width) {
                        this.width = width;
                    }

                    public List<UrlListBean> getUrlList() {
                        return urlList;
                    }

                    public void setUrlList(List<UrlListBean> urlList) {
                        this.urlList = urlList;
                    }

                    public static class UrlListBean {

                        private String name;
                        private int size;
                        private String url;

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public int getSize() {
                            return size;
                        }

                        public void setSize(int size) {
                            this.size = size;
                        }

                        public String getUrl() {
                            return url;
                        }

                        public void setUrl(String url) {
                            this.url = url;
                        }
                    }
                }

                public static class TagsBean {

                    private String actionUrl;
                    private String bgPicture;
                    private String headerImage;
                    private int id;
                    private String name;
                    private String tagRecType;

                    public String getActionUrl() {
                        return actionUrl;
                    }

                    public void setActionUrl(String actionUrl) {
                        this.actionUrl = actionUrl;
                    }

                    public String getBgPicture() {
                        return bgPicture;
                    }

                    public void setBgPicture(String bgPicture) {
                        this.bgPicture = bgPicture;
                    }

                    public String getHeaderImage() {
                        return headerImage;
                    }

                    public void setHeaderImage(String headerImage) {
                        this.headerImage = headerImage;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getTagRecType() {
                        return tagRecType;
                    }

                    public void setTagRecType(String tagRecType) {
                        this.tagRecType = tagRecType;
                    }
                }
            }
        }
    }
}

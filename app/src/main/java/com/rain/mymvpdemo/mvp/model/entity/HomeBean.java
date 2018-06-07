package com.rain.mymvpdemo.mvp.model.entity;

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

        private String nextPageUrl;
        private int count;
        private long date;
        private long publishTime;
        private long releaseTime;
        private String type;
        private List<ItemListBean> itemList;

        public String getNextPageUrl() {
            return nextPageUrl;
        }

        public void setNextPageUrl(String nextPageUrl) {
            this.nextPageUrl = nextPageUrl;
        }

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

                // follow list中的字段
                private HeaderBean header;



                private List<ItemListBean> itemList;

                private String text; // 针对type类型为textHeader的字段

                public HeaderBean getHeader() {
                    return header;
                }

                public void setHeader(HeaderBean header) {
                    this.header = header;
                }

                public List<ItemListBean> getItemList() {
                    return itemList;
                }

                public void setItemList(List<ItemListBean> itemList) {
                    this.itemList = itemList;
                }

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

                // followList中添加的字段
                public static class HeaderBean {
                    /**
                     * id : 1843
                     * icon : http://img.kaiyanapp.com/c6f75c129885b6c1592331734af13549.png?imageMogr2/quality/60/format/jpg
                     * iconType : round
                     * title : 四人厨
                     * subTitle : null
                     * description : 在这里总有一款美食适合你，其食很简单！
                     * actionUrl : eyepetizer://pgc/detail/1843/?title=%E5%9B%9B%E4%BA%BA%E5%8E%A8&userType=PGC&tabIndex=1
                     * adTrack : null
                     * follow : {"itemType":"author","itemId":1843,"followed":false}
                     * ifPgc : true
                     */

                    private int id;
                    private String icon;
                    private String iconType;
                    private String title;
                    private String subTitle;
                    private String description;
                    private String actionUrl;
                    private String adTrack;
                    private FollowBean follow;
                    private boolean ifPgc;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getIcon() {
                        return icon;
                    }

                    public void setIcon(String icon) {
                        this.icon = icon;
                    }

                    public String getIconType() {
                        return iconType;
                    }

                    public void setIconType(String iconType) {
                        this.iconType = iconType;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getSubTitle() {
                        return subTitle;
                    }

                    public void setSubTitle(String subTitle) {
                        this.subTitle = subTitle;
                    }

                    public String getDescription() {
                        return description;
                    }

                    public void setDescription(String description) {
                        this.description = description;
                    }

                    public String getActionUrl() {
                        return actionUrl;
                    }

                    public void setActionUrl(String actionUrl) {
                        this.actionUrl = actionUrl;
                    }

                    public String getAdTrack() {
                        return adTrack;
                    }

                    public void setAdTrack(String adTrack) {
                        this.adTrack = adTrack;
                    }

                    public FollowBean getFollow() {
                        return follow;
                    }

                    public void setFollow(FollowBean follow) {
                        this.follow = follow;
                    }

                    public boolean isIfPgc() {
                        return ifPgc;
                    }

                    public void setIfPgc(boolean ifPgc) {
                        this.ifPgc = ifPgc;
                    }

                    public static class FollowBean {
                        /**
                         * itemType : author
                         * itemId : 1843
                         * followed : false
                         */

                        private String itemType;
                        private int itemId;
                        private boolean followed;

                        public String getItemType() {
                            return itemType;
                        }

                        public void setItemType(String itemType) {
                            this.itemType = itemType;
                        }

                        public int getItemId() {
                            return itemId;
                        }

                        public void setItemId(int itemId) {
                            this.itemId = itemId;
                        }

                        public boolean isFollowed() {
                            return followed;
                        }

                        public void setFollowed(boolean followed) {
                            this.followed = followed;
                        }
                    }
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

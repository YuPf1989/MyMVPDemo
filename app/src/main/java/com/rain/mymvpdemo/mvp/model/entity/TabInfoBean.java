package com.rain.mymvpdemo.mvp.model.entity;

import java.util.List;

/**
 * Author:rain
 * Date:2018/6/7 15:08
 * Description:
 */
public class TabInfoBean {

    /**
     * tabInfo : {"tabList":[{"id":0,"name":"周排行","apiUrl":"http://baobab.kaiyanapp.com/api/v4/rankList/videos?strategy=weekly"},{"id":1,"name":"月排行","apiUrl":"http://baobab.kaiyanapp.com/api/v4/rankList/videos?strategy=monthly"},{"id":2,"name":"总排行","apiUrl":"http://baobab.kaiyanapp.com/api/v4/rankList/videos?strategy=historical"}],"defaultIdx":0}
     */

    private TabInfo tabInfo;

    public TabInfo getTabInfo() {
        return tabInfo;
    }

    public void setTabInfo(TabInfo tabInfo) {
        this.tabInfo = tabInfo;
    }

    public static class TabInfo {
        /**
         * tabList : [{"id":0,"name":"周排行","apiUrl":"http://baobab.kaiyanapp.com/api/v4/rankList/videos?strategy=weekly"},{"id":1,"name":"月排行","apiUrl":"http://baobab.kaiyanapp.com/api/v4/rankList/videos?strategy=monthly"},{"id":2,"name":"总排行","apiUrl":"http://baobab.kaiyanapp.com/api/v4/rankList/videos?strategy=historical"}]
         * defaultIdx : 0
         */

        private int defaultIdx;
        private List<TabListBean> tabList;

        public int getDefaultIdx() {
            return defaultIdx;
        }

        public void setDefaultIdx(int defaultIdx) {
            this.defaultIdx = defaultIdx;
        }

        public List<TabListBean> getTabList() {
            return tabList;
        }

        public void setTabList(List<TabListBean> tabList) {
            this.tabList = tabList;
        }

        public static class TabListBean {
            /**
             * id : 0
             * name : 周排行
             * apiUrl : http://baobab.kaiyanapp.com/api/v4/rankList/videos?strategy=weekly
             */

            private int id;
            private String name;
            private String apiUrl;

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

            public String getApiUrl() {
                return apiUrl;
            }

            public void setApiUrl(String apiUrl) {
                this.apiUrl = apiUrl;
            }
        }
    }
}

package com.shengxi.xxwork.entity;

import java.util.List;

public class HexBoxTabListInfo {


    /**
     * msg :
     * result : {"tags":[{"key":"-1","tag":"推荐"},{"image":"https://cdn.max-c.com/heybox/dailynews/img/6867848a914920a67c4d0596d65983da.png","key":"PUBG","mask":0,"order":"4","status":1,"tag":"绝地求生"},{"image":"https://cdn.max-c.com/heybox/dailynews/img/b583d3f0385f9aa090598249ecf6395c.png","key":"HotSpots","order":"3","status":1,"tag":"综盒频道"},{"image":"https://cdn.max-c.com/heybox/dailynews/img/82d1a775a50eefd434c7d1cade14aa87.png","key":"event ","order":"98","status":2,"tag":"硬件推荐"},{"image":"https://cdn.max-c.com/heybox/dailynews/img/378cbd67e948b2e03e4af0ccef436b59.png","key":"APEX","order":"72","status":1,"tag":"APEX英雄","wiki_id":900000058},{"image":"https://cdn.max-c.com/heybox/dailynews/img/3610e89a5204b0252ba8e200fd3dc77f.png","key":"evaluating","mask":0,"order":"2","status":1,"tag":"PC游戏"},{"image":"https://cdn.max-c.com/heybox/dailynews/img/482fb9b843e1c01925b3debbb8df9ed1.png","key":"DOTA_Piece","order":"32","status":1,"tag":"刀塔自走棋"},{"image":"https://cdn.max-c.com/heybox/dailynews/img/935919cf2a7cab4cd4475a8e5ae5dfc5.png","key":"lol","mask":0,"order":"97","status":2,"tag":"英雄联盟"},{"image":"https://cdn.max-c.com/heybox/dailynews/img/208cb7809f9e87071457d486fb4a46cd.png","key":"hs","mask":0,"order":"96","status":2,"tag":"炉石传说"},{"image":"https://cdn.max-c.com/heybox/dailynews/img/b01abc4c28c3ec087e825f7c4f7d76a0.png","key":"console","order":"31","status":1,"tag":"主机游戏"},{"image":"https://cdn.max-c.com/heybox/dailynews/img/8a4d3330f30746223decc94fb1e81aba.png","key":"R6","mask":0,"order":"5","status":1,"tag":"彩虹六号"},{"image":"https://cdn.max-c.com/heybox/dailynews/img/ca787fbf84b69d71b17b66b8cd7b7740.png","key":"dota2","mask":0,"order":"92","status":1,"tag":"刀塔2"},{"image":"https://cdn.max-c.com/heybox/dailynews/img/94a5bdec3df8ad33aa84b05a6d686ffe.png","key":"csgo","mask":0,"order":"93","status":1,"tag":"CS:GO"},{"image":"https://cdn.max-c.com/heybox/dailynews/img/7e05d5577d68a0627bb5863126975c5b.png","key":"Blizzard","mask":0,"order":"94","status":1,"tag":"守望先锋","wiki_id":900000012},{"image":"https://cdn.max-c.com/heybox/dailynews/img/43f572f14cd1f3863586a885079b1ba0.png","key":"Mobile","order":"91","status":1,"tag":"手机游戏"}]}
     * status : ok
     * version : 1.0
     */

    private String msg;
    private ResultBean result;
    private String status;
    private String version;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public static class ResultBean {
        private List<TagsBean> tags;

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public static class TagsBean {
            /**
             * key : -1
             * tag : 推荐
             * image : https://cdn.max-c.com/heybox/dailynews/img/6867848a914920a67c4d0596d65983da.png
             * mask : 0
             * order : 4
             * status : 1
             * wiki_id : 900000058
             */

            private String key;
            private String tag;
            private String image;
            private int mask;
            private String order;
            private int status;
            private int wiki_id;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getMask() {
                return mask;
            }

            public void setMask(int mask) {
                this.mask = mask;
            }

            public String getOrder() {
                return order;
            }

            public void setOrder(String order) {
                this.order = order;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getWiki_id() {
                return wiki_id;
            }

            public void setWiki_id(int wiki_id) {
                this.wiki_id = wiki_id;
            }
        }
    }
}

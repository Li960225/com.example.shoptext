package com.example.shoptext.home.bean;

import com.google.gson.annotations.SerializedName;

public class HomeDetailsBean {
    /**
     * errno : 0
     * errmsg :
     * data : {"brand":{"id":1001000,"name":"MUJI制造商","list_pic_url":"http://yanxuan.nosdn.127.net/1541445967645114dd75f6b0edc4762d.png","simple_desc":"严选精选了MUJI制造商和生产原料，\n用几乎零利润的价格，剔除品牌溢价，\n让用户享受原品牌的品质生活。","pic_url":"http://yanxuan.nosdn.127.net/4ea3f1e60dd77c45c218e503d721a1ed.jpg","sort_order":2,"is_show":1,"floor_price":12.9,"app_list_pic_url":"http://yanxuan.nosdn.127.net/1541445967645114dd75f6b0edc4762d.png","is_new":1,"new_pic_url":"http://yanxuan.nosdn.127.net/4ea3f1e60dd77c45c218e503d721a1ed.jpg","new_sort_order":2}}
     */

    @SerializedName("errno")
    private Integer errno;
    @SerializedName("errmsg")
    private String errmsg;
    @SerializedName("data")
    private DataBean data;

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * brand : {"id":1001000,"name":"MUJI制造商","list_pic_url":"http://yanxuan.nosdn.127.net/1541445967645114dd75f6b0edc4762d.png","simple_desc":"严选精选了MUJI制造商和生产原料，\n用几乎零利润的价格，剔除品牌溢价，\n让用户享受原品牌的品质生活。","pic_url":"http://yanxuan.nosdn.127.net/4ea3f1e60dd77c45c218e503d721a1ed.jpg","sort_order":2,"is_show":1,"floor_price":12.9,"app_list_pic_url":"http://yanxuan.nosdn.127.net/1541445967645114dd75f6b0edc4762d.png","is_new":1,"new_pic_url":"http://yanxuan.nosdn.127.net/4ea3f1e60dd77c45c218e503d721a1ed.jpg","new_sort_order":2}
         */

        @SerializedName("brand")
        private BrandBean brand;

        public BrandBean getBrand() {
            return brand;
        }

        public void setBrand(BrandBean brand) {
            this.brand = brand;
        }

        public static class BrandBean {
            /**
             * id : 1001000
             * name : MUJI制造商
             * list_pic_url : http://yanxuan.nosdn.127.net/1541445967645114dd75f6b0edc4762d.png
             * simple_desc : 严选精选了MUJI制造商和生产原料，
             用几乎零利润的价格，剔除品牌溢价，
             让用户享受原品牌的品质生活。
             * pic_url : http://yanxuan.nosdn.127.net/4ea3f1e60dd77c45c218e503d721a1ed.jpg
             * sort_order : 2
             * is_show : 1
             * floor_price : 12.9
             * app_list_pic_url : http://yanxuan.nosdn.127.net/1541445967645114dd75f6b0edc4762d.png
             * is_new : 1
             * new_pic_url : http://yanxuan.nosdn.127.net/4ea3f1e60dd77c45c218e503d721a1ed.jpg
             * new_sort_order : 2
             */

            @SerializedName("id")
            private Integer id;
            @SerializedName("name")
            private String name;
            @SerializedName("list_pic_url")
            private String listPicUrl;
            @SerializedName("simple_desc")
            private String simpleDesc;
            @SerializedName("pic_url")
            private String picUrl;
            @SerializedName("sort_order")
            private Integer sortOrder;
            @SerializedName("is_show")
            private Integer isShow;
            @SerializedName("floor_price")
            private Double floorPrice;
            @SerializedName("app_list_pic_url")
            private String appListPicUrl;
            @SerializedName("is_new")
            private Integer isNew;
            @SerializedName("new_pic_url")
            private String newPicUrl;
            @SerializedName("new_sort_order")
            private Integer newSortOrder;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getListPicUrl() {
                return listPicUrl;
            }

            public void setListPicUrl(String listPicUrl) {
                this.listPicUrl = listPicUrl;
            }

            public String getSimpleDesc() {
                return simpleDesc;
            }

            public void setSimpleDesc(String simpleDesc) {
                this.simpleDesc = simpleDesc;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public Integer getSortOrder() {
                return sortOrder;
            }

            public void setSortOrder(Integer sortOrder) {
                this.sortOrder = sortOrder;
            }

            public Integer getIsShow() {
                return isShow;
            }

            public void setIsShow(Integer isShow) {
                this.isShow = isShow;
            }

            public Double getFloorPrice() {
                return floorPrice;
            }

            public void setFloorPrice(Double floorPrice) {
                this.floorPrice = floorPrice;
            }

            public String getAppListPicUrl() {
                return appListPicUrl;
            }

            public void setAppListPicUrl(String appListPicUrl) {
                this.appListPicUrl = appListPicUrl;
            }

            public Integer getIsNew() {
                return isNew;
            }

            public void setIsNew(Integer isNew) {
                this.isNew = isNew;
            }

            public String getNewPicUrl() {
                return newPicUrl;
            }

            public void setNewPicUrl(String newPicUrl) {
                this.newPicUrl = newPicUrl;
            }

            public Integer getNewSortOrder() {
                return newSortOrder;
            }

            public void setNewSortOrder(Integer newSortOrder) {
                this.newSortOrder = newSortOrder;
            }
        }
    }
}

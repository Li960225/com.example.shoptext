package com.example.shoptext.detailslist.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AddShopBean {
    /**
     * errno : 0
     * errmsg :
     * data : {"cartList":[{"id":2444,"user_id":7,"session_id":"1","goods_id":1116011,"goods_sn":"1116011","product_id":167,"goods_name":"蔓越莓曲奇 200克","market_price":36,"retail_price":36,"number":1,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/767b370d07f3973500db54900bcbd2a7.png"},{"id":2495,"user_id":7,"session_id":"1","goods_id":1009024,"goods_sn":"1009024","product_id":16,"goods_name":"日式和风懒人沙发","market_price":599,"retail_price":599,"number":1,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/149dfa87a7324e184c5526ead81de9ad.png"}],"cartTotal":{"goodsCount":2,"goodsAmount":635,"checkedGoodsCount":2,"checkedGoodsAmount":635}}
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
         * cartList : [{"id":2444,"user_id":7,"session_id":"1","goods_id":1116011,"goods_sn":"1116011","product_id":167,"goods_name":"蔓越莓曲奇 200克","market_price":36,"retail_price":36,"number":1,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/767b370d07f3973500db54900bcbd2a7.png"},{"id":2495,"user_id":7,"session_id":"1","goods_id":1009024,"goods_sn":"1009024","product_id":16,"goods_name":"日式和风懒人沙发","market_price":599,"retail_price":599,"number":1,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/149dfa87a7324e184c5526ead81de9ad.png"}]
         * cartTotal : {"goodsCount":2,"goodsAmount":635,"checkedGoodsCount":2,"checkedGoodsAmount":635}
         */

        @SerializedName("cartTotal")
        private CartTotalBean cartTotal;
        @SerializedName("cartList")
        private List<CartListBean> cartList;

        public CartTotalBean getCartTotal() {
            return cartTotal;
        }

        public void setCartTotal(CartTotalBean cartTotal) {
            this.cartTotal = cartTotal;
        }

        public List<CartListBean> getCartList() {
            return cartList;
        }

        public void setCartList(List<CartListBean> cartList) {
            this.cartList = cartList;
        }

        public static class CartTotalBean {
            /**
             * goodsCount : 2
             * goodsAmount : 635
             * checkedGoodsCount : 2
             * checkedGoodsAmount : 635
             */

            @SerializedName("goodsCount")
            private Integer goodsCount;
            @SerializedName("goodsAmount")
            private Integer goodsAmount;
            @SerializedName("checkedGoodsCount")
            private Integer checkedGoodsCount;
            @SerializedName("checkedGoodsAmount")
            private Integer checkedGoodsAmount;

            public Integer getGoodsCount() {
                return goodsCount;
            }

            public void setGoodsCount(Integer goodsCount) {
                this.goodsCount = goodsCount;
            }

            public Integer getGoodsAmount() {
                return goodsAmount;
            }

            public void setGoodsAmount(Integer goodsAmount) {
                this.goodsAmount = goodsAmount;
            }

            public Integer getCheckedGoodsCount() {
                return checkedGoodsCount;
            }

            public void setCheckedGoodsCount(Integer checkedGoodsCount) {
                this.checkedGoodsCount = checkedGoodsCount;
            }

            public Integer getCheckedGoodsAmount() {
                return checkedGoodsAmount;
            }

            public void setCheckedGoodsAmount(Integer checkedGoodsAmount) {
                this.checkedGoodsAmount = checkedGoodsAmount;
            }
        }

        public static class CartListBean {
            /**
             * id : 2444
             * user_id : 7
             * session_id : 1
             * goods_id : 1116011
             * goods_sn : 1116011
             * product_id : 167
             * goods_name : 蔓越莓曲奇 200克
             * market_price : 36
             * retail_price : 36
             * number : 1
             * goods_specifition_name_value :
             * goods_specifition_ids :
             * checked : 1
             * list_pic_url : http://yanxuan.nosdn.127.net/767b370d07f3973500db54900bcbd2a7.png
             */

            @SerializedName("id")
            private Integer id;
            @SerializedName("user_id")
            private Integer userId;
            @SerializedName("session_id")
            private String sessionId;
            @SerializedName("goods_id")
            private Integer goodsId;
            @SerializedName("goods_sn")
            private String goodsSn;
            @SerializedName("product_id")
            private Integer productId;
            @SerializedName("goods_name")
            private String goodsName;
            @SerializedName("market_price")
            private Double marketPrice;
            @SerializedName("retail_price")
            private Double retailPrice;
            @SerializedName("number")
            private Integer number;
            @SerializedName("goods_specifition_name_value")
            private String goodsSpecifitionNameValue;
            @SerializedName("goods_specifition_ids")
            private String goodsSpecifitionIds;
            @SerializedName("checked")
            private Integer checked;
            @SerializedName("list_pic_url")
            private String listPicUrl;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Integer getUserId() {
                return userId;
            }

            public void setUserId(Integer userId) {
                this.userId = userId;
            }

            public String getSessionId() {
                return sessionId;
            }

            public void setSessionId(String sessionId) {
                this.sessionId = sessionId;
            }

            public Integer getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(Integer goodsId) {
                this.goodsId = goodsId;
            }

            public String getGoodsSn() {
                return goodsSn;
            }

            public void setGoodsSn(String goodsSn) {
                this.goodsSn = goodsSn;
            }

            public Integer getProductId() {
                return productId;
            }

            public void setProductId(Integer productId) {
                this.productId = productId;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }

            public Double getMarketPrice() {
                return marketPrice;
            }

            public void setMarketPrice(Double marketPrice) {
                this.marketPrice = marketPrice;
            }

            public Double getRetailPrice() {
                return retailPrice;
            }

            public void setRetailPrice(Double retailPrice) {
                this.retailPrice = retailPrice;
            }

            public Integer getNumber() {
                return number;
            }

            public void setNumber(Integer number) {
                this.number = number;
            }

            public String getGoodsSpecifitionNameValue() {
                return goodsSpecifitionNameValue;
            }

            public void setGoodsSpecifitionNameValue(String goodsSpecifitionNameValue) {
                this.goodsSpecifitionNameValue = goodsSpecifitionNameValue;
            }

            public String getGoodsSpecifitionIds() {
                return goodsSpecifitionIds;
            }

            public void setGoodsSpecifitionIds(String goodsSpecifitionIds) {
                this.goodsSpecifitionIds = goodsSpecifitionIds;
            }

            public Integer getChecked() {
                return checked;
            }

            public void setChecked(Integer checked) {
                this.checked = checked;
            }

            public String getListPicUrl() {
                return listPicUrl;
            }

            public void setListPicUrl(String listPicUrl) {
                this.listPicUrl = listPicUrl;
            }
        }
    }
}

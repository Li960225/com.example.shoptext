package com.example.shoptext.mine.bean;

import com.google.gson.annotations.SerializedName;

public class LoginBean {
    /**
     * errno : 0
     * errmsg :
     * data : {"code":200,"token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiN2I5NjU2NTYtNzBlYi00NzI2LWI0YTctYzUyMzY2ODYxNDg1IiwicmFuZG9tIjoicjVwOGswZGRrciIsImlhdCI6MTYwOTY1Mzk3Mn0.vBNThtIS5qNpM3U69qmVoqvegQ7kwfdoigOaSQeIIuk","userInfo":{"uid":"7b965656-70eb-4726-b4a7-c52366861485","username":"z1234","nickname":"李四1","gender":0,"avatar":"zxc","birthday":110022}}
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
         * code : 200
         * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiN2I5NjU2NTYtNzBlYi00NzI2LWI0YTctYzUyMzY2ODYxNDg1IiwicmFuZG9tIjoicjVwOGswZGRrciIsImlhdCI6MTYwOTY1Mzk3Mn0.vBNThtIS5qNpM3U69qmVoqvegQ7kwfdoigOaSQeIIuk
         * userInfo : {"uid":"7b965656-70eb-4726-b4a7-c52366861485","username":"z1234","nickname":"李四1","gender":0,"avatar":"zxc","birthday":110022}
         */

        @SerializedName("code")
        private Integer code;
        @SerializedName("token")
        private String token;
        @SerializedName("userInfo")
        private UserInfoBean userInfo;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public static class UserInfoBean {
            /**
             * uid : 7b965656-70eb-4726-b4a7-c52366861485
             * username : z1234
             * nickname : 李四1
             * gender : 0
             * avatar : zxc
             * birthday : 110022
             */

            @SerializedName("uid")
            private String uid;
            @SerializedName("username")
            private String username;
            @SerializedName("nickname")
            private String nickname;
            @SerializedName("gender")
            private Integer gender;
            @SerializedName("avatar")
            private String avatar;
            @SerializedName("birthday")
            private Integer birthday;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public Integer getGender() {
                return gender;
            }

            public void setGender(Integer gender) {
                this.gender = gender;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public Integer getBirthday() {
                return birthday;
            }

            public void setBirthday(Integer birthday) {
                this.birthday = birthday;
            }
        }
    }
}

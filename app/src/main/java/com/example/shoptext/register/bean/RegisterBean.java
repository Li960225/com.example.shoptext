package com.example.shoptext.register.bean;

import com.google.gson.annotations.SerializedName;

public class RegisterBean {
    /**
     * errno : 0
     * errmsg :
     * data : {"token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiODIwNWNkNDktMjNmNS00ZGMxLWFjZjktMWVkZDUyMWE0NjAyIiwiaWF0IjoxNjEwMzYxNDI0fQ.Eg0CtL_F9As401dHIcs9_SsTvE7_kJes_dGxf5UHJK0","userInfo":{"uid":"8205cd49-23f5-4dc1-acf9-1edd521a4602","username":"liyi","nickname":null,"gender":0,"avatar":"","birthday":0}}
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
         * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiODIwNWNkNDktMjNmNS00ZGMxLWFjZjktMWVkZDUyMWE0NjAyIiwiaWF0IjoxNjEwMzYxNDI0fQ.Eg0CtL_F9As401dHIcs9_SsTvE7_kJes_dGxf5UHJK0
         * userInfo : {"uid":"8205cd49-23f5-4dc1-acf9-1edd521a4602","username":"liyi","nickname":null,"gender":0,"avatar":"","birthday":0}
         */

        @SerializedName("token")
        private String token;
        @SerializedName("userInfo")
        private UserInfoBean userInfo;

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
             * uid : 8205cd49-23f5-4dc1-acf9-1edd521a4602
             * username : liyi
             * nickname : null
             * gender : 0
             * avatar :
             * birthday : 0
             */

            @SerializedName("uid")
            private String uid;
            @SerializedName("username")
            private String username;
            @SerializedName("nickname")
            private Object nickname;
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

            public Object getNickname() {
                return nickname;
            }

            public void setNickname(Object nickname) {
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

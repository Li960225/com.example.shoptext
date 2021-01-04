package com.example.shoptext.bean;

import com.google.gson.annotations.SerializedName;

public class RefreshTokenBean {
    /**
     * errno : 0
     * errmsg :
     * data : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiN2I5NjU2NTYtNzBlYi00NzI2LWI0YTctYzUyMzY2ODYxNDg1IiwicmFuZG9tIjoiMG5xdWpkYzVyaCIsImlhdCI6MTYwOTc1OTg2Nn0.3nUGmS-fnZvNm3LpgO0It-G0OlvmnvDUBTnw_Pep5ss
     */

    @SerializedName("errno")
    private Integer errno;
    @SerializedName("errmsg")
    private String errmsg;
    @SerializedName("data")
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

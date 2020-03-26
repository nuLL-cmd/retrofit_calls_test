
package com.automatodev.retrofitcallsteste;

import com.google.gson.annotations.SerializedName;

import retrofit2.http.Body;

public class CoinChild {

    @SerializedName("ask")
    private String mAsk;
    @SerializedName("bid")
    private String mBid;
    @SerializedName("code")
    private String mCode;
    @SerializedName("codein")
    private String mCodein;
    @SerializedName("create_date")
    private String mCreateDate;
    @SerializedName("high")
    private String mHigh;
    @SerializedName("low")
    private String mLow;
    @SerializedName("name")
    private String mName;
    @SerializedName("pctChange")
    private String mPctChange;
    @SerializedName("timestamp")
    private String mTimestamp;
    @SerializedName("varBid")
    private String mVarBid;

    public CoinChild() {
    }

    public CoinChild(String mAsk, String mBid, String mCode, String mCodein, String mCreateDate, String mHigh, String mLow, String mName, String mPctChange, String mTimestamp, String mVarBid) {
        this.mAsk = mAsk;
        this.mBid = mBid;
        this.mCode = mCode;
        this.mCodein = mCodein;
        this.mCreateDate = mCreateDate;
        this.mHigh = mHigh;
        this.mLow = mLow;
        this.mName = mName;
        this.mPctChange = mPctChange;
        this.mTimestamp = mTimestamp;
        this.mVarBid = mVarBid;
    }

    public String getAsk() {
        return mAsk;
    }

    public void setAsk(String ask) {
        mAsk = ask;
    }

    public String getBid() {
        return mBid;
    }

    public void setBid(String bid) {
        mBid = bid;
    }

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        mCode = code;
    }

    public String getCodein() {
        return mCodein;
    }

    public void setCodein(String codein) {
        mCodein = codein;
    }

    public String getCreateDate() {
        return mCreateDate;
    }

    public void setCreateDate(String createDate) {
        mCreateDate = createDate;
    }

    public String getHigh() {
        return mHigh;
    }

    public void setHigh(String high) {
        mHigh = high;
    }

    public String getLow() {
        return mLow;
    }

    public void setLow(String low) {
        mLow = low;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPctChange() {
        return mPctChange;
    }

    public void setPctChange(String pctChange) {
        mPctChange = pctChange;
    }

    public String getTimestamp() {
        return mTimestamp;
    }

    public void setTimestamp(String timestamp) {
        mTimestamp = timestamp;
    }

    public String getVarBid() {
        return mVarBid;
    }

    public void setVarBid(String varBid) {
        mVarBid = varBid;
    }

}

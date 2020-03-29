package com.automatodev.retrofitcallsteste.entity;

import com.google.gson.annotations.SerializedName;

public class CoinEntity {
    @SerializedName( "1. From_Currency Code")
    private String fromCode;
    @SerializedName("2. From_Currency Name")
    private String fromName;
    @SerializedName("3. To_Currency Code")
    private String toCode;
    @SerializedName("4. To_Currency Name")
    private String toName;
    @SerializedName("5. Exchange Rate")
    private String rate;
    @SerializedName("6. Last Refreshed")
    private String last_refresh;
    @SerializedName("7. Time Zone")
    private String timeZone;
    @SerializedName("8. Bid Price")
    private String bid;
    @SerializedName("9. Ask Price")
    private String price;

    public CoinEntity(String fromCode, String fromName, String toCode, String toName, String rate, String last_refresh, String timeZone, String bid, String price) {
        this.fromCode = fromCode;
        this.fromName = fromName;
        this.toCode = toCode;
        this.toName = toName;
        this.rate = rate;
        this.last_refresh = last_refresh;
        this.timeZone = timeZone;
        this.bid = bid;
        this.price = price;
    }

    public String getFromCode() {
        return fromCode;
    }

    public String getFromName() {
        return fromName;
    }

    public String getToCode() {
        return toCode;
    }

    public String getToName() {
        return toName;
    }

    public String getRate() {
        return rate;
    }

    public String getLast_refresh() {
        return last_refresh;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public String getBid() {
        return bid;
    }

    public String getPrice() {
        return price;
    }
}


package com.automatodev.retrofitcallsteste;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class CoinDaddy {

    @SerializedName("ARS")
    private CoinChild aRS;
    @SerializedName("AUD")
    private CoinChild aUD;
    @SerializedName("BTC")
    private CoinChild bTC;
    @SerializedName("CAD")
    private CoinChild cAD;
    @SerializedName("CHF")
    private CoinChild cHF;
    @SerializedName("CNY")
    private CoinChild cNY;
    @SerializedName("ETH")
    private CoinChild eTH;
    @SerializedName("EUR")
    private CoinChild eUR;
    @SerializedName("GBP")
    private CoinChild gBP;
    @SerializedName("ILS")
    private CoinChild iLS;
    @SerializedName("JPY")
    private CoinChild jPY;
    @SerializedName("LTC")
    private CoinChild lTC;
    @SerializedName("USD")
    private CoinChild uSD;
    @SerializedName("USDT")
    private CoinChild uSDT;
    @SerializedName("XRP")
    private CoinChild xRP;


    private List<CoinChild> coinChildrens;

    public CoinDaddy() {
        coinChildrens = new ArrayList<>();
    }

    public CoinChild getaRS() {
        return aRS;
    }

    public void setaRS(CoinChild aRS) {
        this.aRS = aRS;
        coinChildrens.add(aRS);
    }

    public CoinChild getaUD() {
        return aUD;
    }

    public void setaUD(CoinChild aUD) {
        this.aUD = aUD;
        coinChildrens.add(aUD);
    }

    public CoinChild getbTC() {
        return bTC;
    }

    public void setbTC(CoinChild bTC) {
        this.bTC = bTC;
        coinChildrens.add(bTC);
    }

    public CoinChild getcAD() {
        return cAD;
    }

    public void setcAD(CoinChild cAD) {
        this.cAD = cAD;
        coinChildrens.add(cAD);
    }

    public CoinChild getcHF() {
        return cHF;
    }

    public void setcHF(CoinChild cHF) {
        this.cHF = cHF;
        coinChildrens.add(cHF);
    }

    public CoinChild getcNY() {
        return cNY;
    }

    public void setcNY(CoinChild cNY) {
        this.cNY = cNY;
        coinChildrens.add(cNY);
    }

    public CoinChild geteTH() {
        return eTH;
    }

    public void seteTH(CoinChild eTH) {
        this.eTH = eTH;
        coinChildrens.add(eTH);
    }

    public CoinChild geteUR() {
        return eUR;
    }

    public void seteUR(CoinChild eUR) {
        this.eUR = eUR;
        coinChildrens.add(eUR);
    }

    public CoinChild getgBP() {
        return gBP;
    }

    public void setgBP(CoinChild gBP) {
        this.gBP = gBP;
        coinChildrens.add(gBP);
    }

    public CoinChild getiLS() {
        return iLS;
    }

    public void setiLS(CoinChild iLS) {
        this.iLS = iLS;
        coinChildrens.add(iLS);
    }

    public CoinChild getjPY() {
        return jPY;
    }

    public void setjPY(CoinChild jPY) {
        this.jPY = jPY;
        coinChildrens.add(jPY);
    }

    public CoinChild getlTC() {
        return lTC;
    }

    public void setlTC(CoinChild lTC) {
        this.lTC = lTC;
        coinChildrens.add(lTC);
    }

    public CoinChild getuSD() {
        return uSD;
    }

    public void setuSD(CoinChild uSD) {
        this.uSD = uSD;

    }

    public CoinChild getuSDT() {
        coinChildrens.add(this.uSD);
        return uSDT;
    }

    public void setuSDT(CoinChild uSDT) {
        this.uSDT = uSDT;
        coinChildrens.add(uSDT);
    }

    public CoinChild getxRP() {
        return xRP;
    }

    public void setxRP(CoinChild xRP) {
        this.xRP = xRP;
        coinChildrens.add(xRP);
    }

    public List<CoinChild> getCoinChildrens() {
        return coinChildrens;
    }
}

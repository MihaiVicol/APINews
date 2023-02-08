package com.example.apinews;

public class DataFE {
   private String keyword;
   private String dateST;
   private String dateND;
   private String country;
   private String category;

   public DataFE(){

   }

    public DataFE(String keyword, String dateST, String dateND) {
        this.keyword = keyword;
        this.dateST = dateST;
        this.dateND = dateND;
    }

    public DataFE(String country, String category) {
        this.country = country;
        this.category = category;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDateST() {
        return dateST;
    }

    public void setDateST(String dateST) {
        this.dateST = dateST;
    }

    public String getDateND() {
        return dateND;
    }

    public void setDateND(String dateND) {
        this.dateND = dateND;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

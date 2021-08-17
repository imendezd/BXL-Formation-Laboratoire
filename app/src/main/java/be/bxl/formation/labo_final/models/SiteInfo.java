package be.bxl.formation.labo_final.models;

import java.util.Arrays;

public class SiteInfo {
     private String category;
     private String desc;
     private String continent;
     private Double longitude;
     private Double latitude;
     private Double area;
     private String dateInscribed;

    public SiteInfo(String category, String desc, String continent, Double latitude, Double longitude, Double area, String dateInscribed) {
        this.category = category;
        this.desc = desc;
        this.continent = continent;
        this.latitude = latitude;
        this.longitude = longitude;
        this.area = area;
        this.dateInscribed = dateInscribed;
    }

    //Getters

    public String getCategory() {
        return category;
    }

    public String getDesc() {
        return desc;
    }

    public String getContinent() {
        return continent;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getArea() {
        return area;
    }

    public String getDateInscribed() {
        return dateInscribed;
    }

    //Setters

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public void setDateInscribed(String dateInscribed) {
        this.dateInscribed = dateInscribed;
    }

    //ToString

    @Override
    public String toString() {
        return category + '\'' + desc + '\'' + continent + '\'' + longitude + ',' + latitude + '\'' + area + '\'' + dateInscribed;
    }
}

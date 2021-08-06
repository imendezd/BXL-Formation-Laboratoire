package be.bxl.formation.labo_final.models;

import java.util.Arrays;

public class SiteInfo {
     private String category;
     private String desc;
     private String continent;
     private Double[] coords;
     private Double area;
     private String dateInscribed;

    public SiteInfo(String category, String desc, String continent, Double[] coords, Double area, String dateInscribed) {
        this.category = category;
        this.desc = desc;
        this.continent = continent;
        this.coords = coords;
        this.area = area;
        this.dateInscribed = dateInscribed;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Double[] getCoords() {
        return coords;
    }

    public void setCoords(Double[] coords) {
        this.coords = coords;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getDateInscribed() {
        return dateInscribed;
    }

    public void setDateInscribed(String dateInscribed) {
        this.dateInscribed = dateInscribed;
    }

    @Override
    public String toString() {
        return "SiteInfo{" +
                "category='" + category + '\'' +
                ", desc='" + desc + '\'' +
                ", continent='" + continent + '\'' +
                ", coords=" + Arrays.toString(coords) +
                ", area=" + area +
                ", dateInscribed='" + dateInscribed + '\'' +
                '}';
    }
}

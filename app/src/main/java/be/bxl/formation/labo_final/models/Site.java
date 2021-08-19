package be.bxl.formation.labo_final.models;

public class Site {
    private int siteId;
    private String name;
    private String country;
    private SiteInfo siteInfo;

    public Site (int siteId, String name, String country, SiteInfo siteInfo) {
        this.siteId = siteId;
        this.name = name;
        this.country = country;
        this.siteInfo = siteInfo;

    }
    //Getters
    public int getSiteId() {
        return siteId;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public SiteInfo getSiteInfo() {
        return siteInfo;
    }

    //Setters
    public void setName(String name) { this.name = name; }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setSiteInfo(SiteInfo siteInfo) {
        this.siteInfo = siteInfo;
    }

    @Override
    public String toString() {
        return name +" "+ country;
    }
}

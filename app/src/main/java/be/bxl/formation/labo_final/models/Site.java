package be.bxl.formation.labo_final.models;

public class Site {
    private int siteId;
    private String name;
    private String country;
    private SiteInfo siteInfo;

    public Site (int siteId, String name, String country) {
        this.siteId = siteId;
        this.name = name;
        this.country = country;
        this.siteInfo = siteInfo;

    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public SiteInfo getSiteInfo() {
        return siteInfo;
    }

    public void setSiteInfo(SiteInfo siteInfo) {
        this.siteInfo = siteInfo;
    }

    @Override
    public String toString() {
        return "Site{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

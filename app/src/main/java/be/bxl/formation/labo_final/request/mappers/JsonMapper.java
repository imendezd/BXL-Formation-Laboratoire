package be.bxl.formation.labo_final.request.mappers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import be.bxl.formation.labo_final.models.Site;
import be.bxl.formation.labo_final.models.SiteInfo;

public class JsonMapper {
    private JsonMapper() {};

    public static Site convertToSite(JSONObject json) {
        Site result = null;

       try {
           int id = json.getInt("recordid");
           String name = json.getString("name_en");
           String country = json.getString("country_en");

            JSONArray jsonInfo = json.getJSONArray("info");
            SiteInfo siteInfo = new SiteInfo(
                    jsonInfo.getJSONObject(0).getString("category"),
                    jsonInfo.getJSONObject(1).getString("short_description_en"),
                    jsonInfo.getJSONObject(2).getString("continent_en"),
                    jsonInfo.getJSONObject(3).getDouble("latitude"),
                    jsonInfo.getJSONObject(4).getDouble("longitude"),
                    jsonInfo.getJSONObject(5).getDouble("area_hectares"),
                    jsonInfo.getJSONObject(6).getString("date_inscribed")
                    );

            result = new Site(id, name, country, siteInfo);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }
}
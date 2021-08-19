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
            String name = json.getString("name");
            int id = json.getInt("id");
            String country = json.getString("country");

            JSONArray jsonInfo = json.getJSONArray("info");
            SiteInfo siteInfo = new SiteInfo(
                    jsonInfo.getJSONObject(0).getString(""),
                    jsonInfo.getJSONObject(1).getString(""),
                    jsonInfo.getJSONObject(2).getString(""),
                    jsonInfo.getJSONObject(3).getDouble(""),
                    jsonInfo.getJSONObject(4).getDouble(""),
                    jsonInfo.getJSONObject(5).getDouble(""),
                    jsonInfo.getJSONObject(6).getString("")
                    );

            result = new Site(id, name, country, siteInfo);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }
}
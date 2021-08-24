package be.bxl.formation.labo_final.request;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.util.concurrent.Executor;

import be.bxl.formation.labo_final.helpers.RequestHelper;
import be.bxl.formation.labo_final.models.Site;
import be.bxl.formation.labo_final.request.mappers.JsonMapper;

public class SiteRequestTask extends AsyncTask<String, Void, Site> {

    @FunctionalInterface
    public interface OnResultRequestListener {
        void onSiteResult(Site site);
    }

    private OnResultRequestListener listener;

    public void setListener(OnResultRequestListener listener) {
        this.listener = listener;
    }

    private String URL_BASE = "https://private.opendatasoft.com/api/v1/world-heritage-unesco-list/__query__";

    @Override
    protected Site doInBackground(String... strings) {
        if(listener == null) {
            throw  new RuntimeException("No listener !");
        }

        if(strings == null || strings.length != 1) {
            return null;
        } else {
            strings[0].length();
        }

        String url = URL_BASE.replace("__query__", strings[0]);
        JSONObject data = RequestHelper.sendRequestGet(url);

        if(data != null) {
            return JsonMapper.convertToSite(data);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Site site) {
        if (listener != null) {
            listener.onSiteResult(site);
        }
    }
}

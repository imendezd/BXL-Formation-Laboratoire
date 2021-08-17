package be.bxl.formation.labo_final.request;

import android.os.AsyncTask;

import org.json.JSONObject;

import be.bxl.formation.labo_final.helpers.RequestHelper;
import be.bxl.formation.labo_final.models.Site;
import be.bxl.formation.labo_final.request.mappers.JsonMapper;

public class SiteRequestTask extends AsyncTask<Integer, Void, Site> {

    @FunctionalInterface
    public interface OnResultRequestListener {
        void onSiteResult(Site site);
    }

    private OnResultRequestListener listener;

    public void setListener(OnResultRequestListener listener) {
        this.listener = listener;
    }

    //TODO Add API URL
    private String URL_BASE = "";

    @Override
    protected Site doInBackground(Integer... integers) {
        if(listener == null) {
            throw  new RuntimeException("No listener !");
        }

        if(integers == null || integers.length != 1 || integers[0] < 0) {
            return null;
        }

        String url = URL_BASE.replace("__query__", String.valueOf(integers[0]));
        JSONObject data = RequestHelper.sendRequestGet(url);

        if(data != null) {
            return JsonMapper.convertToSite(data);
        }
        return null;
    }


}

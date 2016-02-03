package com.umut.multiplechoicelistview;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by recep on 3.02.2016.
 */





public class ListFill extends AsyncTask<Void, Void, Void> {

    private ListViewAdapterFile adapter;
    private ProgressDialog pDialog;
    private ListView listView;
    private ArrayList<Case> caseArrayList;
    private Context context;


    public ListFill(Context context,ListViewAdapterFile adapter, ListView listView) {
        this.adapter = adapter;
        this.listView = listView;
        this.context = context;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(context);
        pDialog.setMessage("Lütfen bekleyin...");
        pDialog.setCancelable(true);
        pDialog.show();
    }

    @Override
    protected Void doInBackground(Void... arg0) {

        caseArrayList.add(new Case("424234TDSDFE", "QWE6457", "KONYA 3.ASLİYE HUKUK MAHKEMESİ", "1", "423"));
        caseArrayList.add(new Case("KJSDF2342343", "Rds234", "MERSIN 4. AİLE HAKİMLİĞİ", "2", "342"));
        caseArrayList.add(new Case("EWTVDDFGDDG", "EWRWERWER", "ANKARA 1. AĞIR CEZA MAHKEMESİ", "3", "324"));
        caseArrayList.add(new Case("424235464849498984879874", "Rds654165465446234", "Asliye Hukuk", "4", "43"));
        caseArrayList.add(new Case("424234TDSDFE", "QWE6457", "KONYA 3.ASLİYE HUKUK MAHKEMESİ", "5", "423"));
        caseArrayList.add(new Case("KJSDF2342343", "Rds234", "MERSIN 4. AİLE HAKİMLİĞİ", "6", "342"));
        caseArrayList.add(new Case("EWTVDDFGDDG", "EWRWERWER", "ANKARA 1. AĞIR CEZA MAHKEMESİ", "7", "324"));
        caseArrayList.add(new Case("424235464849498984879874", "Rds654165465446234", "Asliye Hukuk", "8", "43"));
        caseArrayList.add(new Case("424234TDSDFE", "QWE6457", "KONYA 3.ASLİYE HUKUK MAHKEMESİ", "9", "423"));
        caseArrayList.add(new Case("KJSDF2342343", "Rds234", "MERSIN 4. AİLE HAKİMLİĞİ", "10", "342"));
        caseArrayList.add(new Case("EWTVDDFGDDG", "EWRWERWER", "ANKARA 1. AĞIR CEZA MAHKEMESİ", "11", "324"));
        caseArrayList.add(new Case("424235464849498984879874", "Rds654165465446234", "Asliye Hukuk", "12", "43"));
        caseArrayList.add(new Case("424234TDSDFE", "QWE6457", "KONYA 3.ASLİYE HUKUK MAHKEMESİ", "12", "423"));
        caseArrayList.add(new Case("KJSDF2342343", "Rds234", "MERSIN 4. AİLE HAKİMLİĞİ", "14", "342"));
        caseArrayList.add(new Case("EWTVDDFGDDG", "EWRWERWER", "ANKARA 1. AĞIR CEZA MAHKEMESİ", "15", "324"));
        caseArrayList.add(new Case("424235464849498984879874", "Rds654165465446234", "Asliye Hukuk", "16", "43"));

        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        adapter.notifyDataSetChanged();
        if (pDialog.isShowing())
            pDialog.dismiss();

    }





}

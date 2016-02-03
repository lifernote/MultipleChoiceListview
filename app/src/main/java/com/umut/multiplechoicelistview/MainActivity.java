package com.umut.multiplechoicelistview;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Case> caseArrayList;
    private ListViewAdapterFile adapter;
    private ProgressDialog pDialog;
    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.list);
        caseArrayList = new ArrayList<Case>();
        adapter = new ListViewAdapterFile(this, R.layout.item_listview, caseArrayList);
        listView.setAdapter(adapter);

        new GetData().execute();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"postion =  "+ position, Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                TextView textView1 = (TextView) view.findViewById(R.id.textViewListitem1);
                TextView textView2 = (TextView) view.findViewById(R.id.textViewListitem2);
                TextView textView3 = (TextView) view.findViewById(R.id.textViewListitem3);
                TextView textView4 = (TextView) view.findViewById(R.id.textViewListitem4);


                AlertDialog.Builder builder =
                        new AlertDialog.Builder(MainActivity.this, R.style.AppCompatAlertDialogStyle);
                builder.setTitle("Detaylar");
                builder.setMessage(textView1.getText().toString() + "\n" + textView2.getText().toString() + "\n" + textView3.getText().toString() + "\n" + textView4.getText().toString());
                builder.setPositiveButton("Tamam", null);
                builder.show();
                return true;
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, ListViewAdapterFile.listPK.size() + " Item Selected", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent myIntent = new Intent(getApplicationContext(), Details.class);
                myIntent.putExtra("id", ListViewAdapterFile.listPK);
                startActivity(myIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private class GetData extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Lütfen bekleyin...");
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            caseArrayList.add(new Case("424234TDSDFE", "QWE6457", "KONYA 3.ASLİYE HUKUK MAHKEMESİ", "1", "423"));
            caseArrayList.add(new Case("KJSDF2342343", "Rds234", "MERSIN 4. AİLE HAKİMLİĞİ", "2", "342"));
            caseArrayList.add(new Case("EWTVDDFGDDG", "EWRWERWER", "ANKARA 1. AĞIR CEZA MAHKEMESİ", "3", "324"));
            caseArrayList.add(new Case("424238474", "Rds6ıu5434", "Asliye Hukuk Mahkemesi", "4", "43"));
            caseArrayList.add(new Case("424234TDSDFE", "QWE6457", "KONYA 3.ASLİYE HUKUK MAHKEMESİ", "5", "423"));
            caseArrayList.add(new Case("KJSDF2342343", "Rds234", "MERSIN 4. AİLE HAKİMLİĞİ", "6", "342"));
            caseArrayList.add(new Case("EWTVDDFGDDG", "EWRWERWER", "ANKARA 1. AĞIR CEZA MAHKEMESİ", "7", "324"));
            caseArrayList.add(new Case("424235469874", "Rds65446234", "Asliye Hukuk", "8", "43"));
            caseArrayList.add(new Case("424234TDSDFE", "QWE6457", "KONYA 3.ASLİYE HUKUK MAHKEMESİ", "9", "423"));
            caseArrayList.add(new Case("KJSDF2342343", "Rds234", "MERSIN 4. AİLE HAKİMLİĞİ", "10", "342"));
            caseArrayList.add(new Case("EWTVDDFGDDG", "EWRWERWER", "ANKARA 1. AĞIR CEZA MAHKEMESİ", "11", "324"));
            caseArrayList.add(new Case("4242354644", "Rds654134", "Asliye Hukuk", "12", "43"));
            caseArrayList.add(new Case("424234TDSDFE", "QWE6457", "KONYA 3.ASLİYE HUKUK MAHKEMESİ", "12", "423"));
            caseArrayList.add(new Case("KJSDF2342343", "Rds234", "MERSIN 4. AİLE HAKİMLİĞİ", "14", "342"));
            caseArrayList.add(new Case("EWTVDDFGDDG", "EWRWERWER", "ANKARA 1. AĞIR CEZA MAHKEMESİ", "15", "324"));
            caseArrayList.add(new Case("484879874", "Rds6546234", "Asliye Hukuk", "16", "43"));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
}

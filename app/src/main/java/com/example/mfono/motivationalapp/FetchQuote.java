package com.example.mfono.motivationalapp;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class FetchQuote extends AsyncTask<Void, Void, ArrayList<Quote>> {
    private static final String TAG = "FetchQuote";
    String quote = "";

    @Override
    protected ArrayList<Quote> doInBackground(Void... voids) {
        ArrayList<Quote> quotesArray = new ArrayList<>();
        try {
            URL url = new URL("https://api.myjson.com/bins/1gmpdk");
            Log.d(TAG, "Url called : " + url);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            Log.d(TAG, "Connection request code is : " + httpsURLConnection.getResponseCode());
            httpsURLConnection.setRequestMethod("GET");
            InputStream inputStream = httpsURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                quote = quote + line;
                Log.d(TAG, "Json Return value is : " + quote);
                JSONArray quotesJsonArray = new JSONArray(quote);
                for (int i = 0; i < quotesJsonArray.length(); i++) {
                    JSONObject quoteObject = quotesJsonArray.getJSONObject(i);
                    String quote = quoteObject.getString("quote");
                    String author = quoteObject.getString("author");
                    quotesArray.add(new Quote(quote, author));
                }

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return quotesArray;
    }

    @Override
    protected void onPostExecute(ArrayList<Quote> quotes) {
        super.onPostExecute(quotes);
        List_item.recyclerView.setAdapter(new RecyclerViewAdapter(quotes));

    }
}

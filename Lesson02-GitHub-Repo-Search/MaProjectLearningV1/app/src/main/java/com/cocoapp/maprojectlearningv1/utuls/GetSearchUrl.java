package com.cocoapp.maprojectlearningv1.utuls;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


/**
 * Created by mac on 18/08/2017.
 */

public class GetSearchUrl{

    final static String GITHUB_BASIC_URL= "https://api.github.com/search/repositories";
    final static String PARAM_QUERY = "q";
    final static String PARAM_SORT = "sort";
    final static String sortBy = "stars";

    public final static URL getUrlFromSearchBox(String searchText){


        Uri uri = Uri.parse(GITHUB_BASIC_URL).buildUpon()
                .appendQueryParameter(PARAM_QUERY, searchText)
                .appendQueryParameter(PARAM_SORT, sortBy)
                .build();

        URL url = null;

        try{

            url = new URL(uri.toString());

        }catch (MalformedURLException e){
            e.printStackTrace();
        }


        return url;
    }


    public static String getResponseFromInternet(URL url) throws IOException {


            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try{

            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            if (scanner.hasNext()){

                return scanner.next();

            }else{
                return null;
            }


        }finally {

        }



    }

}

package com.cocoapp.maprojectlearningv1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cocoapp.maprojectlearningv1.utuls.GetSearchUrl;

import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText SearchBox;
    TextView TitleBox;
    TextView ResultBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SearchBox = (EditText) findViewById(R.id.search_box);
        TitleBox = (TextView) findViewById(R.id.title_box);
        ResultBox = (TextView) findViewById(R.id.result_box);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Context context = MainActivity.this;

        if (id == R.id.first_button_menu){

            URL url = GetSearchUrl.getUrlFromSearchBox(SearchBox.getText().toString());
            TitleBox.setText(url.toString());


            String result = null;
            try{

                result = GetSearchUrl.getResponseFromInternet(url);

            }catch (IOException e) {
                e.printStackTrace();
            }

            return true;

        }

        return super.onOptionsItemSelected(item);
    }
}

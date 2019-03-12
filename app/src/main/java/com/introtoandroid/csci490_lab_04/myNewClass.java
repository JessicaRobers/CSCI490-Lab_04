package com.introtoandroid.csci490_lab_04;

import android.os.AsyncTask;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.awt.font.TextAttribute;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class myNewClass extends AsyncTask<String, Void, String> { //changed middle from void to string
    TextView newTask;

    myNewClass(TextView newTask) {
        this.newTask = newTask;
    }

    @Override
    protected String doInBackground(String... strings) {

            URL url = null;

            try {

                url = new URL(strings[3]); //added just to show that strings is an array

            } catch (MalformedURLException e) {

                e.printStackTrace();

            }

            URLConnection connection = null;

            try {

                connection = url.openConnection();

            } catch (IOException e) {

                e.printStackTrace();

            }

            InputStreamReader inputStreamReader = null;

            try {

                inputStreamReader = new InputStreamReader((connection.getInputStream()));

            } catch (IOException e) {

                e.printStackTrace();

            }
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line = null;

            try {

                line = bufferedReader.readLine();

            } catch (IOException e) {

                e.printStackTrace();

            }
            int i = 0;

            while (i < 20) {

                try {

                    line += bufferedReader.readLine();

                } catch (IOException e) {

                    e.printStackTrace();

                }

                i++;

            }

            return line;
        }

    protected void onPostExecute(String line) {
        String subString = line.substring(10,25);
        newTask.setText(subString);
    }


}





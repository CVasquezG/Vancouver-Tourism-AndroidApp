package com.camilovasquez.camilo.vancouverapp;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends ListFragment {
    public   List<Weather> weatherItems;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String url =  "http://api.openweathermap.org/data/2.5/forecast/daily?q=Vancouver&mode=xml&units=metric&cnt=7&appid=cebbfb0dde42b0ee4631c86f043194c3";

        WeatherData wd = new WeatherData();
        wd.execute(url);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        // remove the dividers from the ListView of the ListFragment
        getListView().setDivider(null);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // retrieve theListView item


    }



    class WeatherData extends AsyncTask<String,String  ,String> {

        @Override
        protected String doInBackground(String... params) {
            StringBuilder sb = new StringBuilder();
            URLConnection urlConn = null;
            InputStreamReader in = null;
            try {

                URL url = new URL(params[0]);
                urlConn = url.openConnection();
                if (urlConn != null && urlConn.getInputStream() != null) {
                    in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
                    BufferedReader bufferedReader = new BufferedReader(in);
                    if (bufferedReader != null) {
                        int cp;
                        while ((cp = bufferedReader.read()) != -1) {
                            sb.append((char) cp);
                        }
                        bufferedReader.close();
                    }
                }
                in.close();
            } catch (Exception e) {
                throw new RuntimeException("Exception while calling URL:" + params[0], e);
            }

            return sb.toString();

        }

        @Override
        protected void onPostExecute(String s) {

            try {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(new InputSource(new StringReader(s)));

                XPathFactory xPathfactory = XPathFactory.newInstance();
                XPath xpath = xPathfactory.newXPath();
                XPathExpression expr = xpath
                        .compile("/weatherdata/forecast/time/temperature/@day");
                XPathExpression expr2 = xpath
                        .compile("/weatherdata/forecast/time/clouds/@value");
                XPathExpression expr3 = xpath
                        .compile("/weatherdata/forecast/time/@day");



                Object numberOfDownloads = expr.evaluate(document, XPathConstants.NODESET);
                NodeList nodes = (NodeList) numberOfDownloads;

                Object numberOfDownloads2 = expr2.evaluate(document, XPathConstants.NODESET);
                NodeList nodes2 = (NodeList) numberOfDownloads2;

                Object numberOfDownloads3 = expr3.evaluate(document, XPathConstants.NODESET);
                NodeList nodes3 = (NodeList) numberOfDownloads3;

                weatherItems = new ArrayList<Weather>();


                String temp,clouds,time;


                for (int i = 0; i < nodes.getLength(); i++) {
                    String ans = nodes.item(i).getNodeValue();
                    temp = nodes.item(i).getNodeValue();
                    clouds = nodes2.item(i).getNodeValue();
                    time =nodes3.item(i).getNodeValue();

                    weatherItems.add(new Weather(temp,clouds,time));


                }


                setListAdapter(new WeatherListAdapter(getActivity(), weatherItems));

            } catch (Exception e) {
                e.printStackTrace();
            }

            super.onPostExecute(s);
        }





    }







}

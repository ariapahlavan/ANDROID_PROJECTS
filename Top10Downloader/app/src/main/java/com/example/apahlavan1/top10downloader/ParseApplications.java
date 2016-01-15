package com.example.apahlavan1.top10downloader;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by apahlavan1 on 1/1/2016.
 */
public class ParseApplications {
    private String xmlData;
    private ArrayList<Application> applications;

    public ParseApplications(String xmlData) {
        this.xmlData = xmlData;
        applications = new ArrayList<>();
    }

    public ArrayList<Application> getApplications() {
        return applications;
    }

    public boolean process(){
        boolean status = true;
        Application currRecord = null;
        boolean inEntry = false;
        String textValue = "";
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(this.xmlData));
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT){
                String tagName = xpp.getName();
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        if(tagName.equalsIgnoreCase("entry")){
                            inEntry = true;
                            currRecord = new Application();
                        }
//                        Log.d("ParseApplications", "Strting tag for " + tagName);
                        break;

                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if(inEntry){
                            if(tagName.equalsIgnoreCase("entry")){
                                applications.add(currRecord);
                                inEntry = false;
                            } else if(tagName.equalsIgnoreCase("name")){
                                currRecord.setName(textValue);
                            } else if(tagName.equalsIgnoreCase("artist")){
                                currRecord.setArtist(textValue);
                            } else if(tagName.equalsIgnoreCase("releaseDate")){
                                currRecord.setReleaseDate(textValue);
                            }
                        }
//                        Log.d("ParseApplications", "Ending tag for " + tagName);
                        break;
                    default:
                        //Nothing else to do
                }
                eventType = xpp.next();
            }


        }catch(Exception e){
            status = false;
            e.printStackTrace();
        }
        for (Application app : applications){
            Log.d("ParseApplications", "**************");
            Log.d("ParseApplications", "Name: " + app.getName());
            Log.d("ParseApplications", "Artist: " + app.getArtist());
            Log.d("ParseApplications", "Release date: " + app.getReleaseDate());
        }

        return true;
    }
}

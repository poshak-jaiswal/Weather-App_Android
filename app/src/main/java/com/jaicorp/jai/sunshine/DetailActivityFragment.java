package com.jaicorp.jai.sunshine;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
//import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.support.v7.widget.ShareActionProvider;
/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {
  private static final String LOG_TAG =DetailActivityFragment.class.getSimpleName();

    private static final String FORECAST_SHARE_HASHTAG ="SunshineApp ";
    private String mForeCastStr;
    public DetailActivityFragment() {
        setHasOptionsMenu(true);
    }



    @Override
    public void onCreateOptionsMenu(Menu menu,MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.detailfragment, menu);
        MenuItem menuItem =menu.findItem(R.id.action_share);
        ShareActionProvider mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);

        if(mShareActionProvider !=null){
            mShareActionProvider.setShareIntent(createShareForecastIntent());
        }
        else{
            System.out.println("Share Action provider is null?");
        }
        //getMenuInflater().inflate(R.menu.menu_detail, menu);

    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Intent intent  = getActivity().getIntent();
        View rootview = inflater.inflate(R.layout.fragment_detail,container,false);
        if(intent!=null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            mForeCastStr = intent.getStringExtra(intent.EXTRA_TEXT);
            ((TextView)rootview.findViewById(R.id.detail_text))
            .setText(mForeCastStr);
        }
        return rootview;
    }

    private Intent createShareForecastIntent(){
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT,mForeCastStr+FORECAST_SHARE_HASHTAG);
        return shareIntent;
    }
}

package com.example.gaurav.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ScrollTest extends AppCompatActivity {
    ArrayList<UserModel> mListUser = new ArrayList<>();
    ArrayList<Integer> mListAds = new ArrayList<>();
    ArrayList<Object> mList = new ArrayList<>();
    RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_test);
        mRecyclerView=findViewById(R.id.rvForImage);
        Intent intent = new Intent();
        Intent myLauncherIntent = new Intent();
        myLauncherIntent.setClassName("com.example.gaurav.myapplication", "com.example.gaurav.myapplication.MainActivity");
        myLauncherIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, myLauncherIntent);
        intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "Application Name");
        intent.putExtra
                (
                        Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
                        Intent.ShortcutIconResource.fromContext
                                (
                                        getApplicationContext(),
                                        R.drawable.twitter_icon
                                )
                );
        intent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");

        getPackageManager().setComponentEnabledSetting(
                new ComponentName("com.example.gaurav.myapplication", "com.example.gaurav.myapplication.MainActivity"),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        for (int i = 0; i < 20; i++) {
            mListUser.add(new UserModel("Test","Delhi",i));

        }
        mListAds.add(R.drawable.ic_launcher_background);
        mListAds.add(R.drawable.ic_launcher_background);
        mListAds.add(R.drawable.ic_launcher_background);
        mListAds.add(R.drawable.ic_launcher_background);
        int j = 0, count = 1;
        while (true) {
            if (j >= mListUser.size())
                break;

            if (count == 4) {
                mList.add(mListAds.get(new Random().nextInt( mListAds.size())));
                count = 0;
            }else {
                mList.add(mListUser.get(j));
                j++;
            }
            count++;
        }
        mList.add(R.drawable.ic_launcher_background);


        ImageAdapter adapter=new ImageAdapter(mList,this);
        mRecyclerView.setAdapter(adapter);
    }
}

package com.example.gaurav.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> arraylist;
    ArrayList<DataModel> dataModels;
    DataModel data = new DataModel();

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arraylist = new ArrayList<>();
        arraylist.add(0,1);
        arraylist.add(1,2);
        arraylist.add(2,3);
        arraylist.add(3,4);
        dataModels = new ArrayList<>();
        for(int i=0;i<12;i++) {
            dataModels.add(new DataModel("abc "+i,"a "+i));

        }
        int length = arraylist.size()+dataModels.size();
       /* for(DataModel number: dataModels){
            if(dataModels.size() % 3 == 0){
                System.out.println(number.getName());
            }
        }*/

        for(int i=0;i<dataModels.size();i++)
        {
            if(i%3==0)
            {
                if (i<arraylist.size())
                {
                    System.out.println("arraylist "+i+ arraylist.get(i).toString());
                    continue;
                }

            }else {
                System.out.println("data "+i+ " "+ dataModels.get(i).getName());
            }
        }

    }
}

package com.example.ccetsports;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class eventActivity extends AppCompatActivity {

    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> laptopCollection;
    ExpandableListView expListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        createGroupList();

        createCollection();

        expListView = (ExpandableListView) findViewById(R.id.eventList);
        final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(
                this, groupList, laptopCollection);
        expListView.setAdapter(expListAdapter);

        //setGroupIndicatorToRight();

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                final String selected = (String) expListAdapter.getChild(
                        groupPosition, childPosition);
                Toast.makeText(getBaseContext(), selected, Toast.LENGTH_LONG)
                        .show();

                return true;
            }
        });
    }

    private void createGroupList() {
        groupList = new ArrayList<String>();
        groupList.add("Event 1");
        groupList.add("Event 2");
        groupList.add("Event 3");
        groupList.add("Event 4");
        groupList.add("Event 5");
        groupList.add("Event 6");
        groupList.add("Event 7");
        groupList.add("Event 8");
        groupList.add("Event 9");
        groupList.add("Event 10");
        groupList.add("Event 11");
        groupList.add("Event 12");
        groupList.add("Event 13");
        groupList.add("Event 14");
        groupList.add("Event 15");
        groupList.add("Event 16");
        groupList.add("Event 17");
    }

    private void createCollection() {
        // preparing laptops collection(child)
        String[] event1 = { "Long Jump, Boys", "Long Jump, Girls"};
        String[] event2 = { "1500M Final, Boys", "1500M Final, Girls" };
        String[] event3 = { "Shot Put, Boys", "Shot Put, Girls" };
        String[] event4 = { "Pole Vault, Boys", "Pole Vault, Girls" };
        String[] event5 = { "Hammer Throw Final, Boys", "Hammer Throw Final, Girls" };
        String[] event6 = { "Discuss Throw Final, Boys", "Discuss Throw Final, Girls" };
        String[] event7 = { "500M Final, Boys", "500M Final Final, Girls" };
        String[] event8 = { "110M Hurldes Final, Boys", "110M Hurldes Final, Girls" };
        String[] event9 = { "Triple Jump Final, Boys", "Triple Jump Final, Girls" };
        String[] event10 = { "800M Final, Boys", "800M Final, Girls" };
        String[] event11 = { "Javelin Throw Final, Boys", "Javelin Throw Final, Girls" };
        String[] event12 = { "400M Final, Boys", "400M Final, Girls" };
        String[] event13 = { "400M Hurdle Final, Boys", "400M Hurdle Final, Girls" };
        String[] event14 = { "High Jump Final, Boys", "High Jump Final, Girls" };
        String[] event15 = { "100M Final, Boys", "100M Final, Girls" };
        String[] event16 = { "200M Final, Boys", "200M Final, Girls" };
        String[] event17 = { "4 X 100 Relay, Boys", "4 X 100 Relay Final, Girls" };


        laptopCollection = new LinkedHashMap<String, List<String>>();

        for (String laptop : groupList) {
            if (laptop.equals("Event 1")) {
                loadChild(event1);
            }
            else if (laptop.equals("Event 2"))
                loadChild(event2);
            else if (laptop.equals("Event 3"))
                loadChild(event3);
            else if (laptop.equals("Event 4"))
                loadChild(event4);
            else if (laptop.equals("Event 5"))
                loadChild(event5);
            else if (laptop.equals("Event 6"))
                loadChild(event6);
            else if (laptop.equals("Event 7"))
                loadChild(event7);
            else if (laptop.equals("Event 8"))
                loadChild(event8);
            else if (laptop.equals("Event 9"))
                loadChild(event9);
            else if (laptop.equals("Event 10"))
                loadChild(event10);
            else if (laptop.equals("Event 11"))
                loadChild(event11);
            else if (laptop.equals("Event 12"))
                loadChild(event12);
            else if (laptop.equals("Event 13"))
                loadChild(event13);
            else if (laptop.equals("Event 14"))
                loadChild(event14);
            else if (laptop.equals("Event 15"))
                loadChild(event15);
            else if (laptop.equals("Event 16"))
                loadChild(event16);
            else if (laptop.equals("Event 17"))
                loadChild(event17);


            laptopCollection.put(laptop, childList);
        }
    }

    private void loadChild(String[] laptopModels) {
        childList = new ArrayList<String>();
        for (String model : laptopModels)
            childList.add(model);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }
}
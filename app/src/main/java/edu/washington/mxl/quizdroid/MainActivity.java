package edu.washington.mxl.quizdroid;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private List<HashMap<String, String>> topicID = new ArrayList<HashMap<String, String>>();
    private static List<HashMap<String, List<String>>> listOfQA = new ArrayList<HashMap<String,List<String>>>();
    private int numOfTopic = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HashMap<String, String> temp = new HashMap<String, String>();
        temp.put("topic", "Math");
        temp.put("descr", "We will only cover addition. 1 question total");
        topicID.add(temp);

        List<String> listOptions = new ArrayList<String>();
        listOptions.add("3");
        HashMap qA1 = new HashMap<String, List<String>>();
        qA1.put("1 + 2 = ?", listOptions);
        listOfQA.add(qA1);

        HashMap<String, String> temp1 = new HashMap<String, String>();
        temp1.put("topic", "Physics");
        temp1.put("descr", "We will only cover F = mA. 1 question total");
        topicID.add(temp1);

        List<String> listOptions2 = new ArrayList<String>();
        listOptions2.add("mA");
        HashMap qA2 = new HashMap<String, List<String>>();
        qA2.put("F = ?", listOptions2);
        listOfQA.add(qA2);

        HashMap<String, String> temp2 = new HashMap<String, String>();
        temp2.put("topic", "Marvel Super Heroes");
        temp2.put("descr", "We will only cover Kamala Khan. 1 question total");
        topicID.add(temp2);

        List<String> listOptions3 = new ArrayList<String>();
        listOptions.add("Kamala Khan");
        HashMap qA3 = new HashMap<String, List<String>>();
        qA3.put("Who is the best Marvel hero?", listOptions3);
        listOfQA.add(qA3);

        numOfTopic = listOfQA.size();

        // Keys used in Hashmap
        String[] from = { "topic" };
        int[] to = {R.id.topic};


        SimpleAdapter simpleAdpt = new SimpleAdapter(this, topicID, R.layout.topics_listview_layout, from, to);
        ListView listView = ( ListView ) findViewById(R.id.listView);
        listView.setAdapter(simpleAdpt);
        // React to user clicks on item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
                Intent descr = new Intent(MainActivity.this, Descr.class);
                //Log.i("id", "" + id);
                descr.putExtra("id", (int)id);
                descr.putExtra("descr", topicID.get((int) id).get("descr"));

                startActivity(descr);

//                Toast.makeText(MainActivity.this, "Item with id [" + id + "]" + " " + topicID.get((int)id).get("descr"), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void addTopic(String topic) {
        HashMap<String, String> temp = new HashMap<String, String>();
        temp.put("topic", topic);
        topicID.add(temp);
        numOfTopic++;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.example.assignmentmvvmretrofit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        ItemViewModel model = ViewModelProviders.of(this).get(ItemViewModel.class);

        model.getString().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                try {
                    JSONObject object = new JSONObject(s);
                    JSONArray array = object.getJSONArray("items");

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject o = array.getJSONObject(i);
                        JSONObject summary = o.getJSONObject("summary");
                        ListItem item = new ListItem(
                                o.getString("modelName"),
                                o.getString("color"),
                                o.getInt("quantity"),
                                summary.getInt("lowest"),
                                summary.getInt("totalBids"),
                                o.getInt("expectedPrice"),
                                o.getString("endsOn"),
                                o.getJSONArray("bidders")
                        );
                        listItems.add(item);
                    }
                    adapter = new MyAdapter(listItems,MainActivity.this);
                    recyclerView.setAdapter(adapter);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        });
    }
}


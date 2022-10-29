package com.dinhnt.deeplinkinandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.dinhnt.deeplinkinandroid.adapter.ListProductAdapter;
import com.dinhnt.deeplinkinandroid.models.Product;
import com.dinhnt.deeplinkinandroid.others.SampleData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        SampleData sampleData = new SampleData();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        ListProductAdapter adapter = new ListProductAdapter(this, sampleData.getAll());
        recyclerView.setAdapter(adapter);

        //deeplink - config trong androidmanifest
        uri = getIntent().getData();
        if (uri != null) {
            String id = uri.getQueryParameter("id");
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("id", id);
            startActivity(intent);
        }
    }
}
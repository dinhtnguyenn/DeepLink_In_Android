package com.dinhnt.deeplinkinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dinhnt.deeplinkinandroid.models.Product;
import com.dinhnt.deeplinkinandroid.others.SampleData;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView txtMasp = findViewById(R.id.txtMasp);
        TextView txtTensp = findViewById(R.id.txtTensp);
        TextView txtGiasp = findViewById(R.id.txtGiasp);
        TextView txtDVT = findViewById(R.id.txtDVT);
        TextView txtNSX = findViewById(R.id.txtNSX);
        Button btnShare = findViewById(R.id.btnShare);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        SampleData sampleData = new SampleData();
        Product product = sampleData.getDetail(id);

        txtMasp.setText(product.getMasp());
        txtTensp.setText(product.getTensp());
        txtGiasp.setText(String.valueOf(product.getGia()));
        txtDVT.setText(product.getDvt());
        txtNSX.setText(product.getNuocsx());

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GenerateLink(id);
            }
        });
    }

    private void GenerateLink(String id) {
        String link = "https://apis.dinhnt.com/san-pham?id=" + id;
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Copy nội dung", "Tớ gửi link này hay lắm nè: " + link);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(DetailActivity.this, "Đã copy link share", Toast.LENGTH_SHORT).show();
    }
}
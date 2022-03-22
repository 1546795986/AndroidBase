package com.myactivitybase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String key = intent.getStringExtra("key");
        TextView tv_key = (TextView) this.findViewById(R.id.tv_key);
        tv_key.setText(key);
        Button pass = (Button) this.findViewById(R.id.button_5);
        pass.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_5:
                Intent intent = new Intent();
                intent.putExtra("dada_return","我是来自activity2");
                setResult(RESULT_OK,intent);
        }
    }
}

package com.myactivitybase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button jump = (Button) this.findViewById(R.id.button_1);
        Button baidu = (Button) this.findViewById(R.id.button_2);
        Button call = (Button)this.findViewById(R.id.button_3);
        Button back = (Button)this.findViewById(R.id.button_4);

        baidu.setOnClickListener(this);
        jump.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_1:
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("key","这是从主界面传入的数据");
                startActivity(intent);
            case R.id.button_2:
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent1);
            case R.id.button_3:
                Intent intent2 = new Intent(Intent.ACTION_DIAL);
                intent2.setData(Uri.parse("tel:10086"));
                startActivity(intent2);
            case R.id.button_4:
                Intent intent3 = new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(intent3,1);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if (requestCode == RESULT_OK){
                    TextView textView_1 = (TextView)this.findViewById(R.id.textView_1);
                    String data_return = data.getStringExtra("data_return");
                    textView_1.setText(data_return);
                }
                break;
            default:

        }
    }
}
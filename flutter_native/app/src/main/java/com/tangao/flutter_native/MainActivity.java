package com.tangao.flutter_native;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.android.FlutterFragment;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /**
                * android里嵌套flutter页面
                */
                FragmentTransaction fragmentTransaction =
                        getSupportFragmentManager().beginTransaction();
                // 创建 FlutterFragment
                fragmentTransaction.replace(R.id.fl, FlutterFragment.createDefault());
                fragmentTransaction.commit();

            }

        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * android里跳转flutter页面
                 */
                Intent intent = FlutterActivity
                        .withNewEngine()
                        .initialRoute("Android 启动 FlutterActivity")
                        .build(MainActivity.this);
                //intent.putExtra("initParams", "Android 中 Activity 启动 Flutter");
                startActivity(intent);
            }
        });
    }
}
package com.qs.www.firstandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载布局
        setContentView(R.layout.activity_main);

        //获取布局中控件
        final EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.btnCall);

        //添加按钮点击监听事件
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View view) {
                String number = editText.getText().toString().trim();
                System.out.println("-->>测试一下");
                if ("".equals(number)) {
                    Toast.makeText(MainActivity.this, "number不能为空！", Toast.LENGTH_LONG);
                    return;
                }

                //创建意图对象
                Intent intent = new Intent();

                /**
                 * uri：统一资源标识符
                 */
                intent.setAction(Intent.ACTION_CALL).setData(Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });
    }
}

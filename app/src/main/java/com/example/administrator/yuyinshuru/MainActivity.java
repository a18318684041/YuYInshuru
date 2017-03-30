package com.example.administrator.yuyinshuru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sogou.speech.listener.RecognizerListener;
import com.sogou.speech.ui.RecognizerDialog;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity  {


    private Button btn_begin;
    private EditText edt_result;

    private RecognizerDialog mVoiceDialog;//语音识别的对话框
    private List<List<String>> mResultArray;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn_begin = (Button) findViewById(R.id.btn_begin);
        edt_result = (EditText) findViewById(R.id.edt_result);
        mVoiceDialog = new RecognizerDialog(this,"10000382","iQN3u99Y",true,false);
        mVoiceDialog.setlistener(new RecognizerListener() {
            @Override
            public void onResults(List<List<String>> list) {

                edt_result.setText(list.toString());
            }

            @Override
            public void onPartResults(List<List<String>> list) {
                edt_result.setText(list.toString());
            }

            @Override
            public void onError(int i) {
                edt_result.setText(String.valueOf(i));
            }

            @Override
            public void onQuitQuietly(int i) {
                edt_result.setText(String.valueOf(i));
            }
        });
        btn_begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //开始语音输入的方法
                mVoiceDialog.show();
            }
        });
    }



}

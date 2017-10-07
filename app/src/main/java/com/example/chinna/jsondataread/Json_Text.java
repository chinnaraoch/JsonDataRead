package com.example.chinna.jsondataread;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by CHINNA on 8/14/2017.
 */

public class Json_Text extends AppCompatActivity {
    EditText username,password;
    Button login;
    String root;
    File file;
    File myDir;
    Button click;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jsontext);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.btn);
        click=(Button)findViewById(R.id.click);
        myDir=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+getString(R.string.app_name));
        myDir.mkdirs();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard();
        long currentTime=System.currentTimeMillis();
                String filename="File_"+currentTime+".txt";
                file=new File(myDir,filename);
                try
                {  Toast.makeText(getApplicationContext(),""+file.getAbsolutePath(),Toast.LENGTH_SHORT).show();;
                    FileOutputStream out=new FileOutputStream(file.getAbsolutePath());
                    JSONObject jsonObject=new JSONObject();
                    jsonObject.put("user_name",username.getText().toString());
                    jsonObject.put("password ",password.getText().toString());
                    out.write(jsonObject.toString().getBytes());
                    out.flush();
                    out.close();;


                }catch(Exception e)
                {
                    e.printStackTrace();;
                }
            }
        });
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Json_Text.this,Json_datareading.class);
                startActivity(intent);
            }
        });
    }
    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}

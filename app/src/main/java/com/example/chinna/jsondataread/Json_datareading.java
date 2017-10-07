package com.example.chinna.jsondataread;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import static android.provider.Telephony.Mms.Part.TEXT;

/**
 * Created by CHINNA on 8/14/2017.
 */

public class Json_datareading extends AppCompatActivity {
    TextView jsontext;
    File myDir;
    String root;
    TextView jsontext1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_read);
        jsontext=(TextView)findViewById(R.id.jsontext);
        jsontext1=(TextView)findViewById(R.id.jsontext1);
        root= Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+getString(R.string.app_name);
        myDir=new File(root);
        File[] files=myDir.listFiles();
        for(File filename:files)
        {
            try {
                jsontext.setText(jsontext.getText().toString()+"\n"+filename);


                FileInputStream inputStream=new FileInputStream(filename);
               // inputStream.read()
                String jsonStr = null;
                try {
                    FileChannel fc = inputStream.getChannel();
                    MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());

                    jsonStr = Charset.defaultCharset().decode(bb).toString();
                    System.out.println("  Data "+jsonStr);
                   //
                   // JSONObject jsonObject=new JSONObject(jsonStr);
                    Log.e("first line ",""+jsontext1.getText().toString() + "\n "+jsonStr);

                    JSONParser parser = new JSONParser();

                    Log.e("second  line ",""+jsontext1.getText().toString() + "\n "+jsonStr);
                    JSONObject jsonObject = new JSONObject("jsonStr");

                    Log.e("third line ",""+jsontext1.getText().toString() + "\n "+jsonStr);
                    if(jsonObject!=null) {
                        //jsontext1.setText("notnnull");
                       // Toast.makeText()
                        jsontext1.setText("   "+jsontext1.getText().toString() + "\n "+jsonStr);

                        String username =(String) jsonObject.getString("user_name");
                        String password =(String) jsonObject.getString("password");


                    }else
                    {
                        jsontext1.setText("  firstline "+jsontext1.getText().toString() + "\n "+jsonStr);
                    }
                }
                catch(Exception e){
                    Log.e(" error","  error message "+e.getMessage());
                    e.printStackTrace();
                }
                finally {
                    inputStream.close();
                }


            } catch (Exception e) {
                e.printStackTrace();
            }



        }


    }
}

package com.example.mobiledemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener {

    Button send, reset;
    EditText editText1, editText2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        this.setTitle("Your Feedback");
        send = findViewById(R.id.send);
        reset = findViewById(R.id.reset);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        textView = findViewById(R.id.textView);
        send.setOnClickListener(this);
        reset.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
      if (v.getId()==R.id.send){
          String name=editText1.getText().toString();
          String message=editText1.getText().toString();

          Intent intent=new Intent(Intent.ACTION_SEND);
          intent.setType("text/email");
          intent.putExtra(Intent.EXTRA_EMAIL,new String[] {"mdriponsheikh14@gmail.com"});
          intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback from Mobile Viewer");
          intent.putExtra(Intent.EXTRA_TEXT,"Name: "+name+"\n Massage: "+message);
          startActivity(Intent.createChooser(intent,"Feedback with"));
          textView.setText("Thanks for your Feedback !");
      }else if (v.getId()==R.id.reset){
          editText1.setText("");
          editText2.setText("");
      }
    }
}

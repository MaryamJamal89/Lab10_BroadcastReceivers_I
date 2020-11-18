package com.example.lab10_broadcastreceivers_i;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    TextView textView;
    Button end;
    int intScore;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        textView = findViewById(R.id.textView);
        end = findViewById(R.id.end);
        Intent i = getIntent();
        name = i.getStringExtra("name");
        String score = i.getStringExtra("score");
        intScore = Integer.parseInt(score);

        textView.setText(name+":"+score);
        intScore-=41;
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("KEY", name+":"+intScore);
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }
}
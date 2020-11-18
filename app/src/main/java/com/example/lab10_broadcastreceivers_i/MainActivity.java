package com.example.lab10_broadcastreceivers_i;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nameScore;
    Button start;
    private int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameScore = findViewById(R.id.nameScore);
        start = findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameScoreString = nameScore.getText().toString();
                String[] separated = nameScoreString.split(":");
                String name = separated[0];
                String score = separated[1].trim();
                Intent i = new Intent(MainActivity.this,SubActivity.class);
                i.putExtra("name",name);
                i.putExtra("score",score);
                startActivityForResult(i, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                String s = data.getStringExtra("KEY");
                nameScore.setText(s);
            }
        }
    }
}
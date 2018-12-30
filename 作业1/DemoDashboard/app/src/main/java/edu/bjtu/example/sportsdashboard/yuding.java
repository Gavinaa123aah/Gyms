package edu.bjtu.example.sportsdashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class yuding extends AppCompatActivity {
    public Button bt;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yuding);
        Intent intent = getIntent();
        String data = intent.getStringExtra("amsg");
        bt=(Button)this.findViewById(R.id.button3);
        bt.setText("是否预订"+data);
    }
}

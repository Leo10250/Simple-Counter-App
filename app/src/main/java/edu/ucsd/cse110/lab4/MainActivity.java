package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

import java.util.Locale;
import java.util.Optional;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLaunchProfileClicked(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public void onShowCounterClicked(View view) {
        Intent intent = new Intent(this,  CounterActivity.class);
        TextView max_count = findViewById(R.id.max_count_view);
        String maxCountStr = max_count.getText().toString();

        Optional<Integer> maybeMaxCount = Utilities.parseCount(maxCountStr);

        if(!maybeMaxCount.isPresent()){
            Utilities.showError(this, "This isn't a number!");
            return;
        }

        int max_count_num = maybeMaxCount.get();
        if(max_count_num <= 0){
            Utilities.showError(this, "Please enter a positive number!");
            return;
        }

//        Utilities.showError(this, String.format(Locale.getDefault(),"I got the number %d", max_count_num));
        intent.putExtra("max_count", max_count_num);
        startActivity(intent);
    }

}
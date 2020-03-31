package com.example.lr4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id){
            case R.id.action_change :
                changeOrientation();
                return true;
            case R.id.action_next_activity:
                Intent intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                return true;
            case R.id.action_show:
                TextView text = (TextView) findViewById(R.id.textView);
                text.setText("Завдання виконала\nДьоміна А. І. (ІПЗ-17-1)");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @SuppressLint("SourceLockedOrientationActivity")
    public void changeOrientation(){
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_LANDSCAPE);

        }
        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

    }
    public void changeOrient(View view)
    {
        changeOrientation();
    }
    public void cat(View view) {
        TextView text = (TextView) findViewById(R.id.textView);
        text.setText("Meow, so tasty cookie");
    }
    public void clear(View view) {
        TextView text = (TextView) findViewById(R.id.textView);
        text.setText("");
    }
}


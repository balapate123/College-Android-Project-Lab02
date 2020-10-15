package Bhargav.Marsonia.c301108254;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;

public class MarsoniaCheckout extends MarsoniaActivity2 {
    private SharedPreferences myPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marsonia_checkout);


        myPreference = getSharedPreferences("info", MODE_PRIVATE);
        String programName = myPreference.getString("programName","");
        Set<String> courses = myPreference.getStringSet("courses",new HashSet<String>());
        TextView temp = (TextView)findViewById(R.id.bhargavSelection);
        ImageView iv=(ImageView)findViewById(R.id.bhargavAptImage1);
        temp.setText( "Selected Apartments:" + "\n");

        for( String strCourse : courses ){
            temp.setText(temp.getText().toString()+strCourse +"\n");
            iv=(ImageView)findViewById(R.id.bhargavAptImage1);
        }
    }
    public void Enter(View view)
    {
        Intent intent = new Intent(MarsoniaCheckout.this,MarsoniaProceedToCheckout.class);
        startActivity(intent);
    }
}
package Bhargav.Marsonia.c301108254;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class MarsoniaDetached extends MarsoniaActivity2 {


    Set<String> setApartments = new HashSet<String>();
    SharedPreferences myPref;

    SharedPreferences.Editor prefEditor;
    String[] availableCourses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marsonia_detached);
        availableCourses = getResources().getStringArray(R.array.available_courses);
        myPref = getSharedPreferences("info", MODE_PRIVATE);
        setApartments = myPref.getStringSet("courses",new HashSet<String>());
        for( String strApartment : setApartments ){
            Toast.makeText(this, "Selected Town Houses: "+strApartment, Toast.LENGTH_SHORT).show();
            if(strApartment.equals("Crescent Park"))
            {
                CheckBox checkBox1 = (CheckBox) findViewById(R.id.bhargavCB7);
                checkBox1.setChecked(true);

            }
            if(strApartment.equals("Gerrard Street"))
            {
                CheckBox checkBox1 = (CheckBox) findViewById(R.id.bhargavCB8);
                checkBox1.setChecked(true);

            }
            if(strApartment.equals("Ying Yang Road"))
            {
                CheckBox checkBox1 = (CheckBox) findViewById(R.id.bhargavCB9);
                checkBox1.setChecked(true);

            }
        }
        String myString = myPref.getString("program","");
        Toast.makeText(this, "Retrieving from shared preferences: "+myString, Toast.LENGTH_SHORT).show();
        prefEditor= myPref.edit();
    }

    public void onCheckboxClicked(View view)
    {

        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.bhargavCB7:
                if (checked) {
                    setApartments.add("Crescent Park");
                }
                else
                {
                    setApartments.remove("Crescent Park");
                }
                break;

            case R.id.bhargavCB8:
                if (checked) {
                    setApartments.add("Gerrard Street");
                }
                else
                {
                    setApartments.remove("Gerrard Street");
                }
                break;

            case R.id.bhargavCB9:
                if (checked)
                    setApartments.add("Ying Yang Road");
                else
                    setApartments.remove("Ying Yang Road");
                break;
             default:
                break;
        }

    }

    public void onClickNext(View view)
    {

        Toast.makeText(this, "Number of selected Town Houses: "+setApartments.size(), Toast.LENGTH_SHORT).show();
        for( String strApartment : setApartments ){
            Toast.makeText(this, "Selected Town Houses: "+strApartment, Toast.LENGTH_SHORT).show();
        }
        prefEditor.putStringSet("courses",setApartments);
        prefEditor.commit();
        Intent intent = new Intent(this, MarsoniaCheckout.class);
        startActivity(intent);
    }
}


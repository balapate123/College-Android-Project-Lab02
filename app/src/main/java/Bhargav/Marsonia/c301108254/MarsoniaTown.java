package Bhargav.Marsonia.c301108254;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class MarsoniaTown extends MarsoniaActivity2 {


    Set<String> setApartments = new HashSet<String>();
    SharedPreferences myPref;
    SharedPreferences.Editor prefEditor;
    String[] availableCourses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marsonia_town);

        availableCourses = getResources().getStringArray(R.array.available_courses);

        myPref = getSharedPreferences("info", MODE_PRIVATE);

        setApartments = myPref.getStringSet("courses",new HashSet<String>());
        for( String strApartment : setApartments ){
            Toast.makeText(this, "Selected Town Houses: "+strApartment, Toast.LENGTH_SHORT).show();

            if(strApartment.equals("Drownhill Road"))
            {
                CheckBox checkBox1 = (CheckBox) findViewById(R.id.bhargavCB13);
                checkBox1.setChecked(true);

            }
            if(strApartment.equals("Rough Hill"))
            {
                CheckBox checkBox1 = (CheckBox) findViewById(R.id.bhargavCB14);
                checkBox1.setChecked(true);

            }
            if(strApartment.equals("Scarborough Bluffs"))
            {
                CheckBox checkBox1 = (CheckBox) findViewById(R.id.bhargavCB15);
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
            case R.id.bhargavCB13:
                if (checked) {
                    setApartments.add("Drownhill Road");
                }
                else
                {
                    setApartments.remove("Drownhill Road");
                }
                break;

            case R.id.bhargavCB14:
                if (checked) {
                    setApartments.add("Rough Hill");
                }
                else
                {
                    setApartments.remove("Rough Hill");
                }
                break;

            case R.id.bhargavCB15:
                if (checked)
                    setApartments.add("Scarborough Bluffs");
                else
                    setApartments.remove("Scarborough Bluffs");
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


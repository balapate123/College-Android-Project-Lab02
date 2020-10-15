package Bhargav.Marsonia.c301108254;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class MarsoniaApartment extends MarsoniaActivity2 {
    Set<String> setApartments = new HashSet<String>();
    SharedPreferences myPref;
    SharedPreferences.Editor prefEditor;
    String[] availableCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marsonia_apartment);
        availableCourses = getResources().getStringArray(R.array.available_courses);
        myPref = getSharedPreferences("info", MODE_PRIVATE);
        setApartments = myPref.getStringSet("courses",new HashSet<String>());
        for( String strApartment : setApartments ){
            Toast.makeText(this, "Selected Apartments: "+strApartment, Toast.LENGTH_SHORT).show();

            if(strApartment.equals("Bournbourn Drive"))
            {
                CheckBox checkBox1 = (CheckBox) findViewById(R.id.bhargavCB1);
                checkBox1.setChecked(true);

            }
            if(strApartment.equals("Tuxedo Park"))
            {
                CheckBox checkBox1 = (CheckBox) findViewById(R.id.bhargavCB2);
                checkBox1.setChecked(true);

            }
            if(strApartment.equals("Tel Aviv Post"))
            {
                CheckBox checkBox1 = (CheckBox) findViewById(R.id.bhargavCB3);
                checkBox1.setChecked(true);

            }

        }

        String myString = myPref.getString("program","");
        Toast.makeText(this, "Retrieving from shared preferences: "+myString, Toast.LENGTH_SHORT).show();

        prefEditor= myPref.edit();


    }
    //
    public void onCheckboxClicked(View view)
    {

        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.bhargavCB1:
                if (checked) {
                    setApartments.add("Bournbourn Drive");
                }
                else
                {
                    setApartments.remove("Bournbourn Drive");
                }
                break;

            case R.id.bhargavCB2:
                if (checked) {
                    setApartments.add("Tuxedo Park");
                }
                else
                {
                    setApartments.remove("Tuxedo Park");
                }
                break;

            case R.id.bhargavCB3:
                if (checked)
                    setApartments.add("Tel Aviv Post");
                else
                    setApartments.remove("Tel Aviv Post");
                break;

            default:
                break;
        }
    }

    public void onClickNext(View view)
    {
        Toast.makeText(this, "Number of selected apartments: "+setApartments.size(), Toast.LENGTH_SHORT).show();

        for( String strApartment : setApartments ){
            Toast.makeText(this, "Selected apartments: "+strApartment, Toast.LENGTH_SHORT).show();
        }

        prefEditor.putStringSet("courses",setApartments);
        prefEditor.commit();

        Intent intent = new Intent(this, MarsoniaCheckout.class);
        startActivity(intent);
    }
}


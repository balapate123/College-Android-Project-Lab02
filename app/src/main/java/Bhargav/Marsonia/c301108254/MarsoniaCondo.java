package Bhargav.Marsonia.c301108254;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class MarsoniaCondo extends MarsoniaActivity2 {


    Set<String> setApartments = new HashSet<String>();
    SharedPreferences myPref;
    SharedPreferences.Editor prefEditor;

    String[] availableCourses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marsonia_condo);

        availableCourses = getResources().getStringArray(R.array.available_courses);
        myPref = getSharedPreferences("info", MODE_PRIVATE);
        setApartments = myPref.getStringSet("courses",new HashSet<String>());
        for( String strApartment : setApartments ){
            Toast.makeText(this, "Selected Town Houses: "+strApartment, Toast.LENGTH_SHORT).show();
            if(strApartment.equals("Park Street"))
            {
                CheckBox checkBox1 = (CheckBox) findViewById(R.id.bhargavCB4);
                checkBox1.setChecked(true);

            }
            if(strApartment.equals("China Town"))
            {
                CheckBox checkBox1 = (CheckBox) findViewById(R.id.bhargavCB5);
                checkBox1.setChecked(true);

            }
            if(strApartment.equals("Painted Post Drive"))
            {
                CheckBox checkBox1 = (CheckBox) findViewById(R.id.bhargavCB6);
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
            case R.id.bhargavCB4:
                if (checked) {
                    setApartments.add("Park Street");
                }
                else
                {
                    setApartments.remove("Park Street");
                }
                break;

            case R.id.bhargavCB5:
                if (checked) {
                    setApartments.add("China Town");
                }
                else
                {
                    setApartments.remove("China Town");
                }
                break;

            case R.id.bhargavCB6:
                if (checked)
                    setApartments.add("Painted Post Drive");
                else
                    setApartments.remove("Painted Post Drive");
                break;
            default:
                break;
        }
    }
    public void onClickNext(View view)
    {

        Toast.makeText(this, "Number of selected Condominium Apartments: "+setApartments.size(), Toast.LENGTH_SHORT).show();
        for( String strApartment : setApartments ){
            Toast.makeText(this, "Selected Condominium Apartments: "+strApartment, Toast.LENGTH_SHORT).show();
        }
        prefEditor.putStringSet("courses",setApartments);
        prefEditor.commit();
        Intent intent = new Intent(this, MarsoniaCheckout.class);
        startActivity(intent);
    }
}


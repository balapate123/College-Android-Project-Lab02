package Bhargav.Marsonia.c301108254;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class MarsoniaSemi extends MarsoniaActivity2 {
    //
    Set<String> setApartments = new HashSet<String>();
    //preferences data variable
    SharedPreferences myPref;
    //variable to modify preference data
    SharedPreferences.Editor prefEditor;
    //
    String[] availableCourses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marsonia_semi);
        //get available apartments from string array
        availableCourses = getResources().getStringArray(R.array.available_courses);
        //retrieving from shared preferences
        myPref = getSharedPreferences("info", MODE_PRIVATE);
        //check what's in shared preferences named apartments
        setApartments = myPref.getStringSet("courses",new HashSet<String>());
        for( String strApartment : setApartments ){
            Toast.makeText(this, "Selected Apartments: "+strApartment, Toast.LENGTH_SHORT).show();
            // restore the state of check boxes according to shared preferences values
            if(strApartment.equals("Longe Street"))
            {
                CheckBox checkBox1 = (CheckBox) findViewById(R.id.bhargavCB10);
                checkBox1.setChecked(true);

            }
            if(strApartment.equals("Brimorton Drive"))
            {
                CheckBox checkBox1 = (CheckBox) findViewById(R.id.bhargavCB11);
                checkBox1.setChecked(true);

            }
            if(strApartment.equals("Markham Road"))
            {
                CheckBox checkBox1 = (CheckBox) findViewById(R.id.bhargavCB12);
                checkBox1.setChecked(true);

            }

        }

        String myString = myPref.getString("program","");
        Toast.makeText(this, "Retrieving from shared preferences: "+myString, Toast.LENGTH_SHORT).show();
        // myPref.edit().remove("text").commit();
        prefEditor= myPref.edit();
        //   myPref.edit().clear().commit();

    }
    //
    public void onCheckboxClicked(View view)
    {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.bhargavCB10:
                if (checked) {
                    setApartments.add("Longe Street");
                }
                else
                {
                    setApartments.remove("Longe Street");
                }
                break;

            case R.id.bhargavCB11:
                if (checked) {
                    setApartments.add("Brimorton Drive");
                }
                else
                {
                    setApartments.remove("Brimorton Drive");
                }
                break;

            case R.id.bhargavCB12:
                if (checked)
                    setApartments.add("Markham Road");
                else
                    setApartments.remove("Markham Road");
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


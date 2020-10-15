package Bhargav.Marsonia.c301108254;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MarsoniaActivity2 extends AppCompatActivity {

    private SharedPreferences myPreference;

    SharedPreferences.Editor prefEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marsonia2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_type_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        Intent intent;
        switch(item.getItemId()){
            case R.id.bhargavApt:
                Toast.makeText(this, "Check out some APARTMENTS!", Toast.LENGTH_LONG).show();
                myPreference = getSharedPreferences("info", 0);
                prefEditor = myPreference.edit();
                prefEditor.putString("programName", "APARTMENT");
                prefEditor.commit();
                intent = new Intent(this, MarsoniaApartment.class);
                startActivity(intent);
                break;

            case R.id.bhargavCondo:
                Toast.makeText(this, "You selected CONDOMINIUM APARTMENT!", Toast.LENGTH_LONG).show();
                myPreference = getSharedPreferences("info", 0);
                prefEditor = myPreference.edit();
                prefEditor.putString("programName", "TOWN HOUSE");
                prefEditor.commit();
                intent = new Intent(this, MarsoniaCondo.class);
                startActivity(intent);
                break;

            case R.id.bhargavDer:
                Toast.makeText(this, "You selected DETACHED HOMES!", Toast.LENGTH_LONG).show();
                myPreference = getSharedPreferences("info", 0);
                prefEditor = myPreference.edit();
                prefEditor.putString("programName", "TOWN HOUSE");
                prefEditor.commit();
                intent = new Intent(this, MarsoniaDetached.class);
                startActivity(intent);
                break;

            case R.id.bhargavSemi:
                Toast.makeText(this, "You selected SEMI DETACHED HOMES!", Toast.LENGTH_LONG).show();
                myPreference = getSharedPreferences("info", 0);
                prefEditor = myPreference.edit();
                prefEditor.putString("programName", "TOWN HOUSE");
                prefEditor.commit();
                intent = new Intent(this, MarsoniaSemi.class);
                startActivity(intent);
                break;

            case R.id.bhargavTown:
                Toast.makeText(this, "You selected TOWN HOUSE!", Toast.LENGTH_LONG).show();
                myPreference = getSharedPreferences("info", 0);
                prefEditor = myPreference.edit();
                prefEditor.putString("programName", "TOWN HOUSE");
                prefEditor.commit();
                intent = new Intent(this, MarsoniaTown.class);
                startActivity(intent);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
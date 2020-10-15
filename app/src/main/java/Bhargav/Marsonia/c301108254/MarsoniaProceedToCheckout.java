package Bhargav.Marsonia.c301108254;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MarsoniaProceedToCheckout extends AppCompatActivity {
    RadioGroup rbg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marsonia_proceed_to_checkout);
        rbg=(RadioGroup)findViewById(R.id.bhargavrbg);

        rbg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id =rbg.getCheckedRadioButtonId();
                if(id==R.id.bhargavrb1)
                {
                    Intent in= new Intent(MarsoniaProceedToCheckout.this,MarsoniaLastScreen.class);
                    startActivity(in);
                }
                if(id==R.id.bhargavrb2)
                {
                    Intent in= new Intent(MarsoniaProceedToCheckout.this,MarsoniaLastScreen.class);
                    startActivity(in);
                }
                if(id==R.id.bhargavrb3)
                {
                    Intent in= new Intent(MarsoniaProceedToCheckout.this,MarsoniaLastScreen.class);
                    startActivity(in);
                }
            }
        });
    }


}

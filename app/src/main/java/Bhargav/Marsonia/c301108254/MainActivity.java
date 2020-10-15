package Bhargav.Marsonia.c301108254;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button= (Button) findViewById(R.id.bhargavEnter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitySelectHomeType();
            }
        });
    }
    public void openActivitySelectHomeType(){
        Intent intent = new Intent(this, MarsoniaActivity2.class);
        startActivity(intent);
    }

}
package android.bignerdranch.com.androidlab8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AutoCompleteTextView from = findViewById(R.id.edit_from);
        AdressFromAutoCompleteAdapter adressFromAutoCompleteAdapter = new AdressFromAutoCompleteAdapter(getApplicationContext());
        from.setAdapter(adressFromAutoCompleteAdapter);
        from.setThreshold(6);
        from.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = (String) parent.getItemAtPosition(position);
                from.setText(name);
            }
        });
        AdressFromAutoCompleteAdapter adressFromAutoCompleteAdapter1 = new AdressFromAutoCompleteAdapter(getApplicationContext());
        AutoCompleteTextView to = findViewById(R.id.edit_to);
        to.setThreshold(6);
        to.setAdapter(adressFromAutoCompleteAdapter);

        Button button = findViewById(R.id.map_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(from.getText().toString() == "" || to.getText().toString() == "")
                    return;
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                intent.putExtra("from", from.getText().toString());
                intent.putExtra("to", to.getText().toString());
                startActivity(intent);
            }
        });
    }
}
package com.example.roombazadanychbb2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {
    Button buttonDodaj;
    EditText editText;
    Spinner spinner;

    SzkolaDataBase szkolaDataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        szkolaDataBase = Room.databaseBuilder(
                getApplicationContext(), SzkolaDataBase.class, "szkola_db"
        )
                .allowMainThreadQueries()
                .build();

//        szkolaDataBase.getNauczycielDao().wstawNauczycielaDoBazy(
//                new Nauczyciel("Anna", "matematyka")
//        );

        buttonDodaj = findViewById(R.id.buttonDodaj);
        editText = findViewById(R.id.editTextText);
        spinner = findViewById(R.id.spinner);
        buttonDodaj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Nauczyciel nauczyciel = new Nauczyciel(
                                editText.getText().toString(),
                                spinner.getSelectedItem().toString()
                        );
                        szkolaDataBase.getNauczycielDao().wstawNauczycielaDoBazy(nauczyciel);
                    }
                }
        );

    }
}
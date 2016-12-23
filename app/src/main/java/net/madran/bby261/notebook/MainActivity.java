package net.madran.bby261.notebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    /*
    Ayrıntılı bilgiye aşağıdaki adresten ulaşabilirsiniz:
    https://developer.android.com/training/basics/data-storage/index.html
    */

    Button kaydetBtn;
    Button gosterBtn;
    EditText notesTxt;

    public static final String notes = "notes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kaydetBtn = (Button) findViewById(R.id.kaydetBtn);
        gosterBtn = (Button) findViewById(R.id.gosterBtn);
        notesTxt = (EditText)findViewById(R.id.notesTxt);

        kaydetBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = getSharedPreferences(notes, MODE_PRIVATE).edit();
                editor.putString("notesSaved", notesTxt.getText().toString());
                editor.commit();

            }
        });

        gosterBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences prefs = getSharedPreferences(notes, MODE_PRIVATE);
                Log.i("tag", prefs.getString("notesSaved", ""));
                notesTxt.setText(prefs.getString("notesSaved", ""));

            }
        });

    }
}

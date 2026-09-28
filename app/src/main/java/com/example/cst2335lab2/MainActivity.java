package com.example.cst2335lab2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear);

        TextView textView = findViewById(R.id.textView);
        EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        CheckBox checkBox = findViewById(R.id.checkBox);

        button.setOnClickListener(click -> {
            textView.setText(editText.getText().toString());
            Toast.makeText(this, getResources().getString(R.string.toast_message), Toast.LENGTH_SHORT).show();
        });

        checkBox.setOnCheckedChangeListener((cb, b) -> {
            String state = b ? getResources().getString(R.string.on) : getResources().getString(R.string.off);
            String message = getResources().getString(R.string.checkbox_now) + " " + state;
            Snackbar.make(cb, message, Snackbar.LENGTH_LONG)
                    .setAction(getResources().getString(R.string.undo), click -> cb.setChecked(!b))
                    .show();
        });
    }
}

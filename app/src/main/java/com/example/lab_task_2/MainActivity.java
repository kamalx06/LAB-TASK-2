package com.example.lab_task_2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtInput;
    private Spinner spinner;
    private TextView txtResult;
    private Button btnCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInput = findViewById(R.id.txtInput);
        spinner = findViewById(R.id.spinner);
        txtResult = findViewById(R.id.txtResult);
        btnCount = findViewById(R.id.btnCount);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.count_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = txtInput.getText().toString().trim();

                if (text.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.toast_empty_text, Toast.LENGTH_SHORT).show();
                    return;
                }

                WordCounter counter = new WordCounter();
                String selectedOption = spinner.getSelectedItem().toString();
                int result = 0;

                if (selectedOption.equals("Words")) {
                    result = counter.countWords(text);
                    txtResult.setText(getString(R.string.result_label) + result + " Words");
                } else if (selectedOption.equals("Characters")) {
                    result = counter.countCharacters(text);
                    txtResult.setText(getString(R.string.result_label) + result + " Characters");
                }
            }
        });
    }
}
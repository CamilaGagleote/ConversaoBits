/*
 *@author:<Camila Gagleote, 1110482312050>
 */

package br.edu.fateczl.conversaobits;



import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etNumBits;

    private Spinner spOptions;

    private Button btnConv;

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNumBits = findViewById(R.id.etNumBits);
        spOptions = findViewById(R.id.spOptions);
        btnConv = findViewById(R.id.btnConv);
        tvResult = findViewById(R.id.tvResult);
        
        preencheSpinner();
        btnConv.setOnClickListener(op -> converter());
    }

    private void converter() {
        StringBuffer buffer = new StringBuffer();
        double num = Double.parseDouble(etNumBits.getText().toString());
        double calc = 0;
       if(spOptions.getSelectedItem().equals("Bytes")){
            calc = num/8.0;
            buffer.append(calc);
       }
       else if(spOptions.getSelectedItem().equals("KB")){
           calc = num/0.000125;
           buffer.append(calc);
       }
       else if(spOptions.getSelectedItem().equals("MB")){
           calc = num/0.000000125;
           buffer.append(calc);
       }
       else if(spOptions.getSelectedItem().equals("GB")){
           calc = num/0.000000000125;
           buffer.append(calc);
       }
       else if(spOptions.getSelectedItem().equals("TB")){
           calc = num/0.000000000000125;
           buffer.append(calc);
       }

    }

    private void preencheSpinner() {

        String[] conversao = {"Bytes", "KB", "MB", "GB", "TB"};

        ArrayAdapter <String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, conversao);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spOptions.setAdapter(adapter);
    }
}
package ca.bcit.ass1.huwilson_laicalvin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner conversion_spinner = (Spinner) findViewById(R.id.conversion_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.conversion_options, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        conversion_spinner.setAdapter(adapter);
        //conversion_spinner.setOnItemSelectedListener(new SpinnerActivity());

        Button convert_button = (Button) findViewById(R.id.convert_button);
        convert_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onConvertClick(v);
            }
        });

    }

    protected void onConvertClick(View view) {

        Spinner conversion_spinner = (Spinner) findViewById(R.id.conversion_spinner);
        Intent convert_intent = new Intent(this, ReceivedActivity.class);

        EditText input_num_string = (EditText) findViewById(R.id.input_number);

        if (input_num_string.getText().toString().length() == 0) {
            convert_intent.putExtra("result", 0);
            startActivity(convert_intent);
        } else {
            Double input_number = Double.parseDouble(input_num_string.getText().toString());
            Double result = convert(conversion_spinner.getSelectedItemPosition(), input_number);

            convert_intent.putExtra("result", result);
            convert_intent.putExtra("choice", conversion_spinner.getSelectedItemPosition());
            convert_intent.putExtra("input", input_number);
            startActivity(convert_intent);
        }


    }

    /**
     *
     * @param conversion_selection
     * @param input_value
     * @return
     */
    protected static double convert(int conversion_selection, double input_value) {

        double calculated_value;

        switch (conversion_selection) {
            case 0: // Hectares to Acres
                calculated_value = input_value * 2.47105;
                break;
            case 1: // Acres to Hectares
                calculated_value = input_value * 0.0404686;
                break;
            case 2: // Hectares to SqFt
                calculated_value = input_value * 107639;
                break;
            case 3: // SqFt to Hectares
                calculated_value = input_value * 0.000009203;
                break;
            case 4: // SqMetres to SqFt
                calculated_value = input_value * 10.7639;
                break;
            case 5: // SqFt to SqMetres
                calculated_value =  input_value * 0.09290;
                break;
            default:
                calculated_value = 0;
                break;
        }
        return calculated_value;


    }
}

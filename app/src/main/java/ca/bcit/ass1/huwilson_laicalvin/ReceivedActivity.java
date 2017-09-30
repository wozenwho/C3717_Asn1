package ca.bcit.ass1.huwilson_laicalvin;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;

public class ReceivedActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_received);

        Button back_button = (Button) findViewById(R.id.activity_2_back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackClick(v);
            }
        });

        Bundle received_intent = getIntent().getExtras();

        TextView result_field = (TextView) findViewById(R.id.result_text);

        result_field.setText(generateOutput(received_intent.getInt("choice"),
                received_intent.getDouble("result"),
                received_intent.getDouble("input")));

    }

    protected String generateOutput(int choice, double result, double input) {

        DecimalFormat df = new DecimalFormat("#.##");
        String fResult = df.format(result);
        String fInput = df.format(input);

        switch (choice) {
            case 0: // Hectares to Acres
                return fInput + " Hectares is " + fResult + " Acres.";
            case 1: // Acres to Hectares
                return fInput + " Acres is " + fResult + " Hectares.";
            case 2: // Hectares to SqFt
                return fInput + " Hectares is " + fResult + " sqFeet.";
            case 3: // SqFt to Hectares
                return fInput + " sqFeet is " + fResult + " Hectares.";
            case 4: // SqMetres to SqFt
                return fInput + " sqMetres is " + fResult + " sqFeet.";
            case 5: // SqFt to SqMetres
                return fInput + " sqFeet is " + fResult + " sqMetres";
            default:
                return "welp.";
        }
    }

    protected void onBackClick(View view) {
        Intent return_intent = new Intent(this, MainActivity.class);
        startActivity(return_intent);
    }

}

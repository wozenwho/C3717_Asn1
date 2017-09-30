package ca.bcit.ass1.huwilson_laicalvin;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

/**
 * Created by BlackberryCosmos on 2017-09-22.
 */

public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Spinner conversion_spinner = (Spinner) findViewById(R.id.conversion_spinner);
        parent.getItemAtPosition(pos);
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }

}

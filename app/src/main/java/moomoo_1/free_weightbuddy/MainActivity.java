package moomoo_1.free_weightbuddy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

    EditText weightEdit;
    Button lbButton;
    Button kgButton;
    double weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightEdit = (EditText) findViewById(R.id.weightText);
        lbButton = (Button) findViewById(R.id.lb_button);
        kgButton = (Button) findViewById(R.id.kg_button);


        lbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightString = weightEdit.getText().toString();

                if (weightString == null || weightString.isEmpty()) {
                    weight = 0;
                } else {
                    weight = Double.parseDouble(weightString);
                    if (weight < 45) {
                        getErrorLb();
                    } else {
                        Intent intent = new Intent(MainActivity.this, weightDisplay.class);
                        intent.putExtra("weight", weight);
                        intent.putExtra("isMetric", false);
                        startActivity(intent);
                    }
                }
            }
        });

        kgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightString = weightEdit.getText().toString();

                if (weightString == null || weightString.isEmpty()) {
                    weight = 0;
                } else {
                    weight = Double.parseDouble(weightString);
                    if (weight < 20.4) {
                        getErrorKg();
                    } else {
                        Intent intent = new Intent(MainActivity.this, weightDisplay.class);
                        intent.putExtra("weight", weight);
                        intent.putExtra("isMetric", true);
                        startActivity(intent);
                    }
                }

            }
        });
    }

    public void getErrorKg() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Standard olympic bars weigh 20.4kg. If you want to lift a lighter weight, use a different piece of equipment.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    public void getErrorLb() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Standard olympic bars weigh 45lbs. If you want to lift a lighter weight, use a different piece of equipment.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

}

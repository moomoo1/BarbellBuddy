package moomoo_1.free_weightbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;


public class weightDisplay extends ActionBarActivity {

    boolean isMetric;
    int[] dispWeights;
    double weight;
    weightCalc wc;
    TextView num45, num25, num10, num5, num2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_display);
        wc = new weightCalc();
        num45 = (TextView) findViewById(R.id.num45);
        num25 = (TextView) findViewById(R.id.num25);
        num10 = (TextView) findViewById(R.id.num10);
        num5 = (TextView) findViewById(R.id.num5);
        num2 = (TextView) findViewById(R.id.num2);

        Intent intent = getIntent();
        isMetric = intent.getBooleanExtra("isMetric", true);
        weight = intent.getDoubleExtra("weight", 0);
        getWeights(isMetric);
        setWeights();
    }

    private void setWeights() {
        num45.setText(dispWeights[0] + "");
        num25.setText(dispWeights[1] + "");
        num10.setText(dispWeights[2] + "");
        num5.setText(dispWeights[3] + "");
        num2.setText(dispWeights[4] + "");
    }

    private void getWeights(boolean isMetric) {
        if (isMetric) {
            wc.setMetWeights(weight);
            dispWeights = wc.getMetWeights();
        }
        if (!isMetric) {
            wc.setImpWeights(weight);
            dispWeights = wc.getImpWeights();
        }
    }


}

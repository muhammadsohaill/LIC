package fyp.lic.com.lic;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Muhammad on 14/12/2017.
 */

public class DietPlan extends AppCompatActivity {

    private EditText et_age, et_weight;
    private Button btn_calculate;
    private TextView tv_result;
    private int glasses;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dietplan);

        et_age=findViewById(R.id.et_age);
        et_weight=findViewById(R.id.et_weight);

        btn_calculate=findViewById(R.id.buttone_alarm);
        tv_result=findViewById(R.id.calculation);

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!et_weight.getText().toString().equals("") && !et_age.getText().toString().equals("") ){
                    InputMethodManager inputManager = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);

                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
                    double weight= Double.parseDouble(et_weight.getText().toString());
                    double age= Double.parseDouble(et_age.getText().toString());
                   // Toast.makeText(DietPlan.this, weight+"", Toast.LENGTH_SHORT).show();

                    double result= (weight)*(0.67);
                    double temp=result*0.2;
                    glasses = (int)temp;
                    int tempResult=(int)result;
                    //Toast.makeText(DietPlan.this, glasses+"", Toast.LENGTH_SHORT).show();

                    tv_result.setText("You need to drink "+glasses+" glasses of water per day");
                }
            }
        });


    }
}

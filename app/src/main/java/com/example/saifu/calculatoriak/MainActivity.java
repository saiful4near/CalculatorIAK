package com.example.saifu.calculatoriak;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static java.lang.Double.parseDouble;


public class MainActivity extends AppCompatActivity {


    @BindView(R.id.et_input_1)
    EditText etInput1;
    @BindView(R.id.et_input_2)
    EditText etInput2;
    @BindView(R.id.btn_count)
    Button btnCount;
    @BindView(R.id.tv_result_division)
    TextView tvResultDivision;
    @BindView(R.id.tv_result_multiplication)
    TextView tvResultMultiplication;
    @BindView(R.id.tv_result_minus)
    TextView tvResultMinus;
    @BindView(R.id.tv_result_plus)
    TextView tvResultPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        final EditText input1 = etInput1;
        final EditText input2 = etInput2;
        final TextView resultDivision = tvResultDivision;
        final TextView resultMultiplication = tvResultMultiplication;
        final TextView resultMinus = tvResultMinus;
        final TextView resultPlus = tvResultPlus;

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringInput1 = etInput1.getText().toString();
                String stringInput2 = etInput2.getText().toString();
                if (TextUtils.isEmpty(stringInput1)) {
                    input1.setError("input number");
                    input1.requestFocus();
                } else if (TextUtils.isEmpty(stringInput2)) {
                    input2.setError("input number");
                    input2.requestFocus();
                } else {
                    Double doubleInput1 = parseDouble(stringInput1);
                    Double doubleInput2 = parseDouble(stringInput2);

                    Double doubleCountDivision = doubleInput1 / doubleInput2;
                    Double doubleCountMultiplication = doubleInput1 * doubleInput2;
                    Double doubleCountMinus = doubleInput1 - doubleInput2;
                    Double doubleCountPlus = doubleInput1 + doubleInput2;

                    resultDivision.setText("Result / : " + doubleCountDivision);
                    resultMultiplication.setText("Resul * : " + doubleCountMultiplication);
                    resultMinus.setText("Result - : " + doubleCountMinus);
                    resultPlus.setText("Result + : " + doubleCountPlus);
                }
            }
        });
    }
}

package com.example.calculatorlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    Button btnC, btnBrac, btnBrac2, btnBckSlash, btnSev, btnEight, btnNine, btnMulti,btnBackSpace,
            btnFour, btnFive, btnSix, btnMinus, btn1, btnTwo, btnThree, btnPlus, btnZero, btnPoint, btnEqual;

    EditText crunchEdtTxt;
    TextView crunchTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        crunchEdtTxt = findViewById(R.id.crunchEdtTxt);
        crunchTxtView = findViewById(R.id.crunchTxtView);

        btnBckSlash = findViewById(R.id.btnBckSlash);
        btnMulti = findViewById(R.id.btnMulti);
        btnMinus = findViewById(R.id.btnMinus);
        btnEqual = findViewById(R.id.btnEqual);
        btnPlus = findViewById(R.id.btnPlus);

        btnPoint = findViewById(R.id.btnPoint);
        btnC = findViewById(R.id.btnC);
        btnBrac = findViewById(R.id.btnBrac);
        btnBrac2 = findViewById(R.id.btnBrac2);
        btnBackSpace = findViewById(R.id.btnBackSpace);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            crunchEdtTxt.setShowSoftInputOnFocus(false);
        }

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchEdtTxt.setText("");
                crunchTxtView.setText("");
            }
        });

        btnBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cursorPos = crunchEdtTxt.getSelectionStart();
                int textLen = crunchEdtTxt.getText().length();
                if (cursorPos != 0 &&  textLen != 0){
                    SpannableStringBuilder sel =(SpannableStringBuilder) crunchEdtTxt.getText();
                    sel.replace(cursorPos-1, cursorPos,"");
                    crunchEdtTxt.setText(sel);
                    crunchEdtTxt.setSelection(cursorPos-1);
                }
            }
        });


        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String equalStr =  crunchEdtTxt.getText().toString();
                equalStr=equalStr.replaceAll("÷","/");
                equalStr=equalStr.replaceAll("×","*");


                Expression expression = new Expression(equalStr);
                String answer = String.valueOf(expression.calculate());

              //  crunchTxtView.setText(new DecimalFormat("0.######").format(answer).toString());
                crunchTxtView.setText(answer);

            }
        });
    }


    private void updateText(String strToAdd){
        String oldStr = crunchEdtTxt.getText().toString();
        int cursorPos = crunchEdtTxt.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        crunchEdtTxt.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        crunchEdtTxt.setSelection(cursorPos + strToAdd.length());
    }

    public void zeroBTNPush(View view){
        updateText(getResources().getString(R.string.zeroText));
    }

    public void oneBTNPush(View view){
        updateText(getResources().getString(R.string.oneText));
    }

    public void twoBTNPush(View view){
        updateText(getResources().getString(R.string.twoText));
    }

    public void threeBTNPush(View view){
        updateText(getResources().getString(R.string.threeText));
    }

    public void fourBTNPush(View view){
        updateText(getResources().getString(R.string.fourText));
    }

    public void fiveBTNPush(View view){
        updateText(getResources().getString(R.string.fiveText));
    }

    public void sixBTNPush(View view){
        updateText(getResources().getString(R.string.sixText));
    }

    public void sevenBTNPush(View view){
        updateText(getResources().getString(R.string.sevenText));
    }

    public void eightBTNPush(View view){
        updateText(getResources().getString(R.string.eightText));
    }

    public void nineBTNPush(View view){
        updateText(getResources().getString(R.string.nineText));
    }


    public void multiplyBTNPush(View view){
        updateText(getResources().getString(R.string.multiplyText));
    }

    public void divideBTNPush(View view){
        updateText(getResources().getString(R.string.divideText));
    }

    public void subtractBTNPush(View view){
        updateText(getResources().getString(R.string.subtractText));
    }

    public void addBTNPush(View view){
        updateText(getResources().getString(R.string.addText));
    }



    public void parOpenBTNPush(View view){
        updateText(getResources().getString(R.string.parOpenText));
    }

    public void parCloseBTNPush(View view){
        updateText(getResources().getString(R.string.parCloseText));
    }

    public void decimalBTNPush(View view){
        updateText(getResources().getString(R.string.decimalText));

    }

}
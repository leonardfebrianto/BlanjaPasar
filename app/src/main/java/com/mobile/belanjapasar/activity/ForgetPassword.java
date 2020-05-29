package com.mobile.belanjapasar.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.view.Window;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.mobile.belanjapasar.R;

public class ForgetPassword extends AppCompatActivity {

    AppCompatTextView lbl_title;
    AutoCompleteTextView ti_email;
    TextView lbl_forgetpassword;
    Button btn_confirm;


    /*============================================================================================*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgetpass_activity_main);

        lbl_title = (AppCompatTextView) findViewById(R.id.lbl_title);
        lbl_title.setText("Forget Password");
        lbl_title.setTextSize(20);

        ButtonListener();
    }

    /*============================================================================================*/
    public void ButtonListener()
    {
        btn_confirm = (Button) findViewById(R.id.btn_confirm);
        btn_confirm.setText("Confirm");
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    /*============================================================================================*/
   public void onBackPressed()
   {
       finish();
   }

    /*============================================================================================*/

}

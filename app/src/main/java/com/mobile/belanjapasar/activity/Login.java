package com.mobile.belanjapasar.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mobile.belanjapasar.R;
import com.mobile.belanjapasar.afterlogin.AfterLogin_Product;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    AppCompatTextView lbl_title;

    AutoCompleteTextView ti_userid;
    AutoCompleteTextView ti_password;

    TextView lbl_forgotpassword;
    TextView lbl_daftar;

    Button btn_login;

    /*============================================================================================*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_main);

        lbl_title = (AppCompatTextView) findViewById(R.id.lbl_title);
        lbl_title.setText("Login");
        lbl_title.setTextSize(20);

        underlineText();
        TextListener();
        ButtonListener();
    }

    /*============================================================================================*/
    public void underlineText()
    {
        lbl_forgotpassword = (TextView) findViewById(R.id.lbl_forgotpassword);
        lbl_daftar = (TextView) findViewById(R.id.lbl_daftar);

        lbl_forgotpassword.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        lbl_daftar.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

    }

    /*============================================================================================*/
    public void TextListener()
    {
        lbl_forgotpassword = (TextView) findViewById(R.id.lbl_forgotpassword);
        lbl_daftar = (TextView) findViewById(R.id.lbl_daftar);

        final ColorStateList defautlColors =  lbl_forgotpassword.getTextColors();

        lbl_forgotpassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
                    lbl_forgotpassword.setTextColor(Color.parseColor("#f97700"));
                    //Toast.makeText(getBaseContext(), "Pressed", Toast.LENGTH_SHORT).show();
                }
                else {
                    lbl_forgotpassword.setTextColor(defautlColors);
                    //Toast.makeText(getBaseContext(), "Release", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getBaseContext(), ForgetPassword.class);
                    startActivity(intent);
                }
                return true;
            }
        });

       /*-----------------------------------------------------------------------------------------*/
        lbl_daftar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
                    lbl_daftar.setTextColor(Color.parseColor("#f97700"));
                    //Toast.makeText(getBaseContext(), "Pressed", Toast.LENGTH_SHORT).show();
                } else {
                    lbl_daftar.setTextColor(defautlColors);
                    //Toast.makeText(getBaseContext(), "Release", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getBaseContext(), Register.class);
                    startActivity(intent);
                }
                return true;
            }
        });
    }

    /*============================================================================================*/
    public void ButtonListener()
    {
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setText("Masuk");
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AfterLogin_Product.class);
                startActivity(intent);
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

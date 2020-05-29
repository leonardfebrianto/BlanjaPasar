package com.mobile.belanjapasar.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mobile.belanjapasar.R;

public class Register extends AppCompatActivity {

    AppCompatTextView lbl_title;

    EditText ti_nama;
    EditText ti_nohp;
    EditText ti_email;
    EditText ti_alamat;
    EditText ti_userid;
    EditText ti_password;
    EditText ti_confirm_password;

    Button btn_alamat;
    Button btn_daftar;


    /*============================================================================================*/
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity_main);

        lbl_title = (AppCompatTextView) findViewById(R.id.lbl_title);
        lbl_title.setText("Sign Up");
        lbl_title.setTextSize(20);

        componentDeclare();
        getEditTextFormSession();
        onEditTextChanged();
        ButtonListener();
    }

    /*============================================================================================*/
    public void componentDeclare()
    {
        ti_nama = (EditText) findViewById(R.id.ti_nama);
        ti_nohp = (EditText) findViewById(R.id.ti_nohp);
        ti_email = (EditText) findViewById(R.id.ti_email);

        ti_alamat = (EditText) findViewById(R.id.ti_alamat);
        ti_alamat.setFocusable(false);
        ti_alamat.setFocusableInTouchMode(false);

        ti_userid = (EditText) findViewById(R.id.ti_userid);
        ti_password = (EditText) findViewById(R.id.ti_password);
        ti_confirm_password = (EditText) findViewById(R.id.ti_confirm_password);

        btn_alamat = (Button) findViewById(R.id.btn_alamat);
        btn_daftar = (Button) findViewById(R.id.btn_daftar);
    }


    /*============================================================================================*/
    public void getEditTextFormSession()
    {
        //setSession
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        String a = pref.getString("sNama", "").toString();
        String b = pref.getString("sNoHP","").toString();
        String c = pref.getString("sEmail","").toString();
        String d = pref.getString("sAlamat","").toString();
        String e = pref.getString("sUserID","").toString();
        String f = pref.getString("sPassword","").toString();
        String g = pref.getString("sConfirmPassword","").toString();

        ti_nama.setText(a);
        ti_nohp.setText(b);
        ti_email.setText(c);
        ti_alamat.setText(d);
        ti_userid.setText(e);
        ti_password.setText(f);
        ti_confirm_password.setText(g);

    }

    /*============================================================================================*/
    public void onEditTextChanged()
    {
        ti_nama.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ti_nama.getText();
                String a = ti_nama.getText().toString();
                System.out.println("[Register] Nama --> " + a);

                //setSession
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sNama", "" + a);
                editor.commit();

            }
        });
        /*----------------------------------------------------------------------------------------*/
        ti_nohp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ti_nohp.getText();
                String a = ti_nohp.getText().toString();
                System.out.println("[Register] No HP --> " + a);

                //setSession
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sNoHP", "" + a);
                editor.commit();

            }
        });
        /*----------------------------------------------------------------------------------------*/
        ti_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ti_email.getText();
                String a = ti_email.getText().toString();
                System.out.println("[Register] Email --> " + a);

                //setSession
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sEmail", "" + a);
                editor.commit();

            }
        });
        /*----------------------------------------------------------------------------------------*/
        ti_alamat.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ti_alamat.getText();
                String a = ti_alamat.getText().toString();
                System.out.println("[Register] Alamat --> " + a);

                //setSession
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sAlamat", "" + a);
                editor.commit();

            }
        });
        /*----------------------------------------------------------------------------------------*/
        ti_userid.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ti_userid.getText();
                String a = ti_userid.getText().toString();
                System.out.println("[Register] UserID --> " + a);

                //setSession
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sUserID", "" + a);
                editor.commit();

            }
        });
        /*----------------------------------------------------------------------------------------*/
        ti_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ti_password.getText();
                String a = ti_password.getText().toString();
                System.out.println("[Register] Password --> " + a);

                //setSession
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sPassword", "" + a);
                editor.commit();

            }
        });
        /*----------------------------------------------------------------------------------------*/
        ti_confirm_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ti_confirm_password.getText();
                String a = ti_confirm_password.getText().toString();
                System.out.println("[Register] Confirm Password --> " + a);

                //setSession
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sConfirmPassword", "" + a);
                editor.commit();
            }
        });

    }

    /*============================================================================================*/
    public void ButtonListener()
    {
        btn_alamat.setText("Alamat");
        btn_daftar.setText("Daftar");

        //btn_alamat.setBackgroundColor(Color.parseColor("#93ff4e"));

        btn_alamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Alamat.class);
                startActivity(intent);
                finish();
            }
        });

        btn_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.commit();
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

package com.mobile.belanjapasar.afterlogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.mobile.belanjapasar.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tommy on 10/02/2016.
 */
public class AfterLogin_AlamatPengiriman extends AppCompatActivity {

    AppCompatSpinner sp_product_category;

    AppCompatImageButton btn_cart;
    AppCompatImageButton btn_lacak;
    AppCompatImageButton btn_resep;

    private RadioButton rb_alamat_profile;
    private RadioButton rb_alamat_baru;
    private RadioGroup rg_alamat;
    private RadioButton radioButton;

    AppCompatButton btn_ok;

    ProgressBar progressBar1;

    public int count = 5;


    /*============================================================================================*/
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afterlogin_alamat_pengiriman_activity_main);

        navigationButtonListener();
        spinnerListAdapter_product();
    }

    /*============================================================================================*/
    public void navigationButtonListener()
    {
        rg_alamat = (RadioGroup) findViewById(R.id.rg_alamat);
        rb_alamat_baru = (RadioButton) findViewById(R.id.rb_alamat_baru);
        rb_alamat_profile = (RadioButton) findViewById(R.id.rb_alamat_profile);

        rb_alamat_profile.isChecked();

        btn_cart = (AppCompatImageButton) findViewById(R.id.btn_cart);
        btn_lacak = (AppCompatImageButton) findViewById(R.id.btn_lacak);
        btn_resep = (AppCompatImageButton) findViewById(R.id.btn_resep);
        btn_ok = (AppCompatButton) findViewById(R.id.btn_ok);



        btn_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AfterLogin_Cart.class);
                startActivity(intent);
            }
        });

        btn_lacak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AfterLogin_HistoryList.class);
                startActivity(intent);
            }
        });

        btn_resep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AfterLogin_Resep.class);
                startActivity(intent);
            }
        });

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = rg_alamat.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);

                String a = (String) radioButton.getText();
                System.out.println("TEST --> "+a);

                if(a.equals("Alamat lain"))
                {
                    Intent intent = new Intent(getBaseContext(), AfterLogin_Alamat.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getBaseContext(), AfterLogin_TanggalPengiriman.class);
                    startActivity(intent);
                }

            }
        });

    }

    /*============================================================================================*/
    public void spinnerListAdapter_product()
    {
        sp_product_category = (AppCompatSpinner) findViewById(R.id.sp_product_category);

        List<String> array = new ArrayList<String>();
        array.add("-- Pilih Produk --");
        array.add("Bumbu");
        array.add("Sayur");
        array.add("Daging");
        array.add("Seafood");

        ArrayAdapter<String> product = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,array);
        product.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_product_category.setAdapter(product);

        sp_product_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //setSession
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sp_product_category", parent.getItemAtPosition(position).toString());
                editor.commit();

                String productItemSelected = parent.getItemAtPosition(position).toString();
                if(productItemSelected.equals("-- Pilih Produk --"))
                {
                    //do nothing
                }
                else
                {
                    Intent intent = new Intent(parent.getContext(), AfterLogin_Product.class);
                    startActivity(intent);
                    finish();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /*============================================================================================*/
    public void onBackPressed()
    {
        Intent intent = new Intent(getBaseContext(), AfterLogin_Cart.class);
        startActivity(intent);
        finish();
    }

    /*============================================================================================*/
}

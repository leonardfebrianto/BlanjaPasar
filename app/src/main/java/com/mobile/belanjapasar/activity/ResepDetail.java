package com.mobile.belanjapasar.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.mobile.belanjapasar.R;

import java.util.ArrayList;
import java.util.List;

public class ResepDetail extends AppCompatActivity {

    Spinner sp_product_category;
    Button btn_login;
    Button btn_promo;
    Button btn_resep;

    AppCompatImageView img_resep1;


    /*============================================================================================*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resep_detail_activity_main);

        img_resep1 = (AppCompatImageView) findViewById(R.id.img_resep1);

        ButtonListener();
        getResepFromSession();
        spinnerListAdapter_product();
    }

    /*============================================================================================*/
    public void getResepFromSession()
    {
        //getSession
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        pref.getString("sResep", "0");

        String sResep = (pref.getString("sResep", "0")).toString();

        if(sResep.equals("resep1"))
        {
            img_resep1.setImageResource(R.drawable.resep_detail1);
        }
        else
        {
            img_resep1.setImageResource(R.drawable.resep_detail2);
        }
    }

    /*============================================================================================*/
    public void ButtonListener()
    {
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_promo = (Button) findViewById(R.id.btn_promo);
        btn_resep = (Button) findViewById(R.id.btn_resep);

        btn_login.setText("Login");
        btn_promo.setText("Promo");
        btn_resep.setText("Resep");

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Login.class);
                startActivity(intent);
            }
        });

        btn_promo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Promo.class);
                startActivity(intent);
            }
        });

        btn_resep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Resep.class);
                startActivity(intent);
            }
        });

    }
    /*============================================================================================*/
    public void spinnerListAdapter_product()
    {
        sp_product_category = (Spinner) findViewById(R.id.sp_product_category);

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
                    Intent intent = new Intent(parent.getContext(), Product.class);
                    //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
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
        finish();
    }


}

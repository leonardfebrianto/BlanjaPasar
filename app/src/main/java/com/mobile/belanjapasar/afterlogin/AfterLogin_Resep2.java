package com.mobile.belanjapasar.afterlogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.mobile.belanjapasar.R;
import com.mobile.belanjapasar.activity.Resep;

import java.util.ArrayList;
import java.util.List;

public class AfterLogin_Resep2 extends AppCompatActivity {

    Spinner sp_product_category;
    Spinner sp_resep_category;

    AppCompatImageButton btn_cart;
    AppCompatImageButton btn_lacak;
    AppCompatImageButton btn_resep;

    AppCompatImageView img_resep1;
    AppCompatImageView img_resep2;

    private AutoCompleteTextView ti_search;
    private ImageButton btn_searchproduct;


    /*============================================================================================*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afterlogin_resep2_activity_main);

        ti_search = (AutoCompleteTextView) findViewById(R.id.ti_search);
        ti_search.setFocusable(false);
        ti_search.setFocusableInTouchMode(false);

        img_resep1 = (AppCompatImageView) findViewById(R.id.img_resep1);
        img_resep2 = (AppCompatImageView) findViewById(R.id.img_resep2);

        getCategoryResep();
        navigationButtonListener();
        focusableSearch();
        imageListener();
        spinnerListAdapter_product();
        //spinnerListAdapter_resep();
    }

    /*============================================================================================*/
    public void navigationButtonListener()
    {
        btn_cart = (AppCompatImageButton) findViewById(R.id.btn_cart);
        btn_lacak = (AppCompatImageButton) findViewById(R.id.btn_lacak);
        btn_resep = (AppCompatImageButton) findViewById(R.id.btn_resep);


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
                finish();
            }
        });

    }

    /*============================================================================================*/
    public void focusableSearch()
    {
        ti_search = (AutoCompleteTextView) findViewById(R.id.ti_search);
        ti_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ti_search.setFocusable(true);
                ti_search.setFocusableInTouchMode(true);
                ti_search.requestFocus();
            }
        });
    }

    /*============================================================================================*/
    public void getCategoryResep()
    {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        String sResep = (pref.getString("sResep", "0")).toString();

        if(sResep.equals("ayam"))
        {
            img_resep1.setImageResource(R.drawable.resep_ayam1);
            img_resep2.setImageResource(R.drawable.resep_ayam2);
        }
        else if(sResep.equals("sapi"))
        {
            img_resep1.setImageResource(R.drawable.resep_sapi1);
            img_resep2.setImageResource(R.drawable.resep_sapi2);
        }
        else if(sResep.equals("seafood"))
        {
            img_resep1.setImageResource(R.drawable.resep_seafood1);
            img_resep2.setImageResource(R.drawable.resep_seafood2);
        }
    }

    /*============================================================================================*/
    public void imageListener()
    {
        img_resep1 = (AppCompatImageView) findViewById(R.id.img_resep1);
        img_resep2 = (AppCompatImageView) findViewById(R.id.img_resep2);

        img_resep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setSession
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sResep", "resep1");
                editor.commit();

                Intent intent = new Intent(getBaseContext(), AfterLogin_ResepDetail.class);
                startActivity(intent);
            }
        });

        img_resep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setSession
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sResep", "resep2");
                editor.commit();

                Intent intent = new Intent(getBaseContext(), AfterLogin_ResepDetail.class);
                startActivity(intent);
            }
        });

    }
    /*============================================================================================*/
    public void spinnerListAdapter_product()
    {
        sp_product_category = (Spinner) findViewById(R.id.sp_product_category);

        List<String> array = new ArrayList<String>();
        array.add("-Pilih Produk-");
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
                if (productItemSelected.equals("-Pilih Produk-")) {
                    //do nothing
                } else {
                    Intent intent = new Intent(parent.getContext(), AfterLogin_Product.class);
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

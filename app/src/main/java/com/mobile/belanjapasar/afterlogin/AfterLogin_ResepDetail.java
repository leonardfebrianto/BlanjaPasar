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
import android.widget.Button;
import android.widget.Spinner;

import com.mobile.belanjapasar.R;
import com.mobile.belanjapasar.activity.ResepDetail;

import java.util.ArrayList;
import java.util.List;

public class AfterLogin_ResepDetail extends AppCompatActivity {

    Spinner sp_product_category;
    AppCompatImageButton btn_cart;
    AppCompatImageButton btn_lacak;
    AppCompatImageButton btn_resep;
    Button btn_copy;

    AppCompatImageView img_resep1;


    /*============================================================================================*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afterlogin_resep_detail_activity_main);

        img_resep1 = (AppCompatImageView) findViewById(R.id.img_resep1);

        //getSession
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        String sResep = (pref.getString("sResep", "0")).toString();
        if(sResep.equals("resep1")) {
            img_resep1.setImageResource(R.drawable.resep_detail1);
        }
        else {
            img_resep1.setImageResource(R.drawable.resep_detail2);
        }

        navigationButtonListener();
        //imageListener();
        //getResepFromSession();
        spinnerListAdapter_product();
    }

    /*============================================================================================*/
    public void getResepFromSession()
    {
        System.out.println("getResepFromSession --> RUN");

        //getSession
        final SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        final SharedPreferences.Editor editor = pref.edit();
        pref.getString("sResep", "0");

        String sResep = (pref.getString("sResep", "0")).toString();

        if(sResep.equals("resep1"))
        {
            System.out.println("IF RESEP1 --> RUN");
            img_resep1.setImageResource(R.drawable.resep_detail1);

            Integer a1 = 3;
            Integer b1 = a1 + Integer.parseInt(pref.getString("sCount_Apel", "0"));
            editor.putString("sCount_Apel", "" + b1);

            Integer a2 = 2;
            Integer b2 = a2 + Integer.parseInt(pref.getString("sCount_Pisang", "0"));
            editor.putString("sCount_Pisang", ""+b2);

            Integer a3 = 1;
            Integer b3 = a3 + Integer.parseInt(pref.getString("sCount_Tomat", "0"));
            editor.putString("sCount_Tomat", ""+b3);

            Integer a4 = 0;
            Integer b4 = a4 + Integer.parseInt(pref.getString("sCount_Bawang_Merah", "0"));
            editor.putString("sCount_Bawang_Merah", ""+b4);

            Integer a5 = 0;
            Integer b5 = a5 + Integer.parseInt(pref.getString("sCount_Ikan", "0"));
            editor.putString("sCount_Ikan", ""+b5);

            Integer a6 = 0;
            Integer b6 = a6 + Integer.parseInt(pref.getString("sCount_Sapi", "0"));
            editor.putString("sCount_Sapi", ""+b6);

            Integer a7 = 0;
            Integer b7 = a7 + Integer.parseInt(pref.getString("sTotalHarga", "0"));
            editor.putString("sTotalHarga", ""+b7);
            editor.commit();

            System.out.println("sCount_Apel ---> " + pref.getString("sCount_Apel", "0"));
            System.out.println("sCount_Pisang ---> " + pref.getString("sCount_Pisang", "0"));
            System.out.println("sCount_Tomat ---> " + pref.getString("sCount_Tomat", "0"));
            System.out.println("sCount_Bawang_Merah ---> " + pref.getString("sCount_Bawang_Merah", "0"));
            System.out.println("sCount_Ikan ---> " + pref.getString("sCount_Ikan", "0"));
            System.out.println("sCount_Sapi ---> " + pref.getString("sCount_Sapi", "0"));
        }
        else if(sResep.equals("resep2"))
        {
            System.out.println("IF RESEP2 --> RUN");
            img_resep1.setImageResource(R.drawable.resep_detail2);

            Integer a1 = 0;
            Integer b1 = a1 + Integer.parseInt(pref.getString("sCount_Apel", "0"));
            editor.putString("sCount_Apel", "" + b1);

            Integer a2 = 0;
            Integer b2 = a2 + Integer.parseInt(pref.getString("sCount_Pisang", "0"));
            editor.putString("sCount_Pisang", ""+b2);

            Integer a3 = 1;
            Integer b3 = a3 + Integer.parseInt(pref.getString("sCount_Tomat", "0"));
            editor.putString("sCount_Tomat", ""+b3);

            Integer a4 = 2;
            Integer b4 = a4 + Integer.parseInt(pref.getString("sCount_Bawang_Merah", "0"));
            editor.putString("sCount_Bawang_Merah", ""+b4);

            Integer a5 = 0;
            Integer b5 = a5 + Integer.parseInt(pref.getString("sCount_Ikan", "0"));
            editor.putString("sCount_Ikan", ""+b5);

            Integer a6 = 1;
            Integer b6 = a6 + Integer.parseInt(pref.getString("sCount_Sapi", "0"));
            editor.putString("sCount_Sapi", ""+b6);

            Integer a7 = 0;
            Integer b7 = a7 + Integer.parseInt(pref.getString("sTotalHarga", "0"));
            editor.putString("sTotalHarga", ""+b7);
            editor.commit();

            System.out.println("sCount_Apel ---> " + pref.getString("sCount_Apel", "0"));
            System.out.println("sCount_Pisang ---> " + pref.getString("sCount_Pisang", "0"));
            System.out.println("sCount_Tomat ---> " + pref.getString("sCount_Tomat", "0"));
            System.out.println("sCount_Bawang_Merah ---> " + pref.getString("sCount_Bawang_Merah", "0"));
            System.out.println("sCount_Ikan ---> " + pref.getString("sCount_Ikan", "0"));
            System.out.println("sCount_Sapi ---> " + pref.getString("sCount_Sapi", "0"));
        }
    }

    /*============================================================================================*/
    public void navigationButtonListener()
    {
        btn_cart = (AppCompatImageButton) findViewById(R.id.btn_cart);
        btn_lacak = (AppCompatImageButton) findViewById(R.id.btn_lacak);
        btn_resep = (AppCompatImageButton) findViewById(R.id.btn_resep);
        btn_copy = (Button) findViewById(R.id.btn_copy);

        btn_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AfterLogin_Cart.class);
                startActivity(intent);
                finish();
            }
        });

        btn_lacak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AfterLogin_HistoryList.class);
                startActivity(intent);
                finish();
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

        btn_copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getResepFromSession();
                Intent intent = new Intent(getBaseContext(), AfterLogin_HistoryOrder.class);
                startActivity(intent);
                finish();
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

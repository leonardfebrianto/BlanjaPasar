package com.mobile.belanjapasar.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.mobile.belanjapasar.R;
import com.mobile.belanjapasar.utility.ImageAdapter;

import java.util.ArrayList;
import java.util.List;

public class Product extends AppCompatActivity {

    Spinner sp_product_category;
    Button btn_login;
    Button btn_promo;
    Button btn_resep;

    ImageView product1;
    ImageView product2;
    ImageView product3;
    ImageView product4;
    ImageView product5;
    ImageView product6;


    /*============================================================================================*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_activity_main);

//        GridView gridview = (GridView) findViewById(R.id.gridview);
//        gridview.setAdapter(new ImageAdapter(this));
//
//        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener()
//        {
//            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
//            {
//                Toast.makeText(Product.this, "" + position, Toast.LENGTH_SHORT).show();
//            }
//        });

        ButtonListener();
        productImageListener();
        spinnerListAdapter_product();
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
                finish();
            }
        });

        btn_promo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Promo.class);
                startActivity(intent);
                finish();
            }
        });

        btn_resep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Resep.class);
                startActivity(intent);
                finish();
            }
        });


    }

    /*============================================================================================*/
    public void productImageListener()
    {
        product1 = (ImageView) findViewById(R.id.product1);
        product2 = (ImageView) findViewById(R.id.product2);
        product3 = (ImageView) findViewById(R.id.product3);
        product4 = (ImageView) findViewById(R.id.product4);
        product5 = (ImageView) findViewById(R.id.product5);
        product6 = (ImageView) findViewById(R.id.product6);

        product1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set Session
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sProduct", "Apel");
                editor.commit();

                Intent intent = new Intent(getBaseContext(), ProductDetail.class);
                startActivity(intent);
            }
        });

        product2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set Session
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sProduct", "Pisang");
                editor.commit();

                Intent intent = new Intent(getBaseContext(), ProductDetail.class);
                startActivity(intent);
            }
        });

        product3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set Session
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sProduct", "Tomat");
                editor.commit();

                Intent intent = new Intent(getBaseContext(), ProductDetail.class);
                startActivity(intent);
            }
        });

        product4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set Session
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sProduct", "Bawang Merah");
                editor.commit();

                Intent intent = new Intent(getBaseContext(), ProductDetail.class);
                startActivity(intent);
            }
        });

        product5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set Session
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sProduct", "Ikan");
                editor.commit();

                Intent intent = new Intent(getBaseContext(), ProductDetail.class);
                startActivity(intent);
            }
        });

        product6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set Session
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sProduct", "Sapi");
                editor.commit();

                Intent intent = new Intent(getBaseContext(), ProductDetail.class);
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
                    //Intent intent = new Intent(parent.getContext(), Product.class);
                    //startActivity(intent);
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

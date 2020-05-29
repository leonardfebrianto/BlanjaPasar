package com.mobile.belanjapasar.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.mobile.belanjapasar.R;

import java.util.ArrayList;
import java.util.List;

public class ProductDetail extends AppCompatActivity {

    Spinner sp_product_category;
    Button btn_login;
    Button btn_promo;
    Button btn_resep;

    TextView lbl_namaproduct;
    TextView lbl_harga;
    ImageView img_product;

    FloatingActionButton btn_minus;
    FloatingActionButton btn_plus;


    /*============================================================================================*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail_activity_main);

        btn_minus = (FloatingActionButton) findViewById(R.id.btn_minus);
        btn_plus = (FloatingActionButton) findViewById(R.id.btn_plus);

        btn_minus.setVisibility(View.GONE);
        btn_plus.setVisibility(View.GONE);

        imageProductAdapter();
        ButtonListener();
        spinnerListAdapter_product();
    }

    /*============================================================================================*/
    public void imageProductAdapter()
    {
        img_product = (ImageView) findViewById(R.id.img_product);
        lbl_harga = (TextView) findViewById(R.id.lbl_harga);
        lbl_namaproduct = (TextView) findViewById(R.id.lbl_namaproduct);

        //getSession
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        String sProduct = pref.getString("sProduct", null);

        if(sProduct.equals("Apel"))
        {
            img_product.setImageResource(R.drawable.product_apel);
            lbl_namaproduct.setText("Apel Super");
            lbl_harga.setText("Rp 30.000");
        }
        if(sProduct.equals("Pisang"))
        {
            img_product.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct.setText("Pisang Raja");
            lbl_harga.setText("Rp 20.000");
        }
        if(sProduct.equals("Tomat"))
        {
            img_product.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct.setText("Tomat");
            lbl_harga.setText("Rp 10.000");
        }
        if(sProduct.equals("Bawang Merah"))
        {
            img_product.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct.setText("Bawang Merah");
            lbl_harga.setText("Rp 10.000");
        }
        if(sProduct.equals("Ikan"))
        {
            img_product.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct.setText("Ikan Kakap");
            lbl_harga.setText("Rp 50.000");
        }
        if(sProduct.equals("Sapi"))
        {
            img_product.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct.setText("Sapi Import");
            lbl_harga.setText("Rp 100.000");
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
           finish();
    }


}

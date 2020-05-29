package com.mobile.belanjapasar.afterlogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatSpinner;
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

/**
 * Created by Tommy on 10/02/2016.
 */
public class AfterLogin_HistoryList extends AppCompatActivity {

    TextView lbl_no_order1;
    TextView lbl_no_order2;
    TextView lbl_no_order3;
    TextView lbl_no_order4;

    TextView lbl_status1;

    AppCompatImageButton btn_cart;
    AppCompatImageButton btn_lacak;
    AppCompatImageButton btn_resep;

    AppCompatSpinner sp_product_category;


    /*============================================================================================*/
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afterlogin_history_list_activity_main);

        underlineText();
        navigationButtonListener();
        spinnerListAdapter_product();
        addListenerOnButton();
    }

    /*============================================================================================*/
    public void underlineText()
    {
        lbl_no_order1 = (TextView) findViewById(R.id.lbl_no_order1);
        lbl_no_order2 = (TextView) findViewById(R.id.lbl_no_order2);
        lbl_no_order3 = (TextView) findViewById(R.id.lbl_no_order3);
        lbl_no_order4 = (TextView) findViewById(R.id.lbl_no_order4);
        lbl_status1 = (TextView) findViewById(R.id.lbl_status1);

        lbl_no_order1.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        lbl_no_order2.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        lbl_no_order3.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        lbl_no_order4.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        lbl_status1.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);


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
                /*Intent intent = new Intent(getBaseContext(), Promo.class);
                startActivity(intent);*/
            }
        });

        btn_resep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AfterLogin_Resep.class);
                startActivity(intent);
            }
        });
    }

    /*============================================================================================*/

    public void addListenerOnButton()
    {
        lbl_no_order1 = (TextView) findViewById(R.id.lbl_no_order1);
        lbl_no_order1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setSession
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sResep", "resep2");
                editor.commit();

                System.out.println("sCount_Apel ---> " + pref.getString("sCount_Apel", "0"));
                System.out.println("sCount_Pisang ---> " + pref.getString("sCount_Pisang", "0"));
                System.out.println("sCount_Tomat ---> " + pref.getString("sCount_Tomat", "0"));
                System.out.println("sCount_Bawang_Merah ---> " + pref.getString("sCount_Bawang_Merah", "0"));
                System.out.println("sCount_Ikan ---> " + pref.getString("sCount_Ikan", "0"));
                System.out.println("sCount_Sapi ---> " + pref.getString("sCount_Sapi", "0"));

                Intent intent = new Intent(getBaseContext(), AfterLogin_HistoryOrder.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        lbl_no_order2 = (TextView) findViewById(R.id.lbl_no_order2);
        lbl_no_order2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setSession
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sResep", "resep2");
                editor.commit();

                Intent intent = new Intent(getBaseContext(), AfterLogin_HistoryOrder.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        lbl_no_order3 = (TextView) findViewById(R.id.lbl_no_order3);
        lbl_no_order3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setSession
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sResep", "resep2");
                editor.commit();

                Intent intent = new Intent(getBaseContext(), AfterLogin_HistoryOrder.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        lbl_no_order4 = (TextView) findViewById(R.id.lbl_no_order4);
        lbl_no_order4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setSession
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sResep", "resep2");
                editor.commit();

                Intent intent = new Intent(getBaseContext(), AfterLogin_HistoryOrder.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        lbl_status1 = (TextView) findViewById(R.id.lbl_status1);
        lbl_status1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), AfterLogin_LacakDriver.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
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
        Intent intent = new Intent(getBaseContext(), AfterLogin_Product.class);
        startActivity(intent);
        finish();
    }

    /*============================================================================================*/
}

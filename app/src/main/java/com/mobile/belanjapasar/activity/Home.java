package com.mobile.belanjapasar.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.mobile.belanjapasar.R;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity  {

    Spinner sp_product_category;
    Button btn_login;
    Button btn_promo;
    Button btn_resep;


    /*============================================================================================*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_main);

        ButtonListener();
        spinnerListAdapter_product();
    }

    /*============================================================================================*/
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    /*============================================================================================*/
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

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

    /*============================================================================================*/
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        System.exit(0);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

}

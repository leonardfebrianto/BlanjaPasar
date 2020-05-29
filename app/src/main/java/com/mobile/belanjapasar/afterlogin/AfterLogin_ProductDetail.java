package com.mobile.belanjapasar.afterlogin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatSpinner;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobile.belanjapasar.R;
import com.mobile.belanjapasar.activity.ProductDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tommy on 10/02/2016.
 */
public class AfterLogin_ProductDetail extends AppCompatActivity {

    AppCompatSpinner sp_product_category;

    AppCompatImageButton btn_cart;
    AppCompatImageButton btn_lacak;
    AppCompatImageButton btn_resep;

    TextView lbl_qty;
    TextView lbl_namaproduct;
    TextView lbl_harga;
    ImageView img_product;

    Button btn_min;
    Button btn_plus;

    Integer sCount_Apel;
    Integer sCount_Pisang;
    Integer sCount_Tomat;
    Integer sCount_Bawang_Merah;
    Integer sCount_Ikan;
    Integer sCount_Sapi;

    EditText ti_search;

    AppCompatImageButton btn_searchproduct;

    public int count = 5;


    /*============================================================================================*/
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afterlogin_product_detail_activity_main);

        ti_search = (EditText) findViewById(R.id.ti_search);
        ti_search.setFocusable(false);
        ti_search.setFocusableInTouchMode(false);

        navigationButtonListener();
        getProductFromSession();
        spinnerListAdapter_product();
        imageProductAdapter();
        productButtonListener();
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
    }

    /*============================================================================================*/
    public void getProductFromSession()
    {
        //getSession
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode

        sCount_Apel = Integer.parseInt(pref.getString("sCount_Apel", "0"));
        sCount_Pisang = Integer.parseInt(pref.getString("sCount_Pisang", "0"));
        sCount_Tomat = Integer.parseInt(pref.getString("sCount_Tomat", "0"));
        sCount_Bawang_Merah = Integer.parseInt(pref.getString("sCount_Bawang_Merah", "0"));
        sCount_Ikan = Integer.parseInt(pref.getString("sCount_Ikan", "0"));
        sCount_Sapi = Integer.parseInt(pref.getString("sCount_Sapi", "0"));

        System.out.println("[product] sCount_Apel ---> " + sCount_Apel);
        System.out.println("[product] sCount_Pisang ---> " + sCount_Pisang);
        System.out.println("[product] sCount_Tomat ---> " + sCount_Tomat);
        System.out.println("[product] sCount_Bawang_Merah ---> " + sCount_Bawang_Merah);
        System.out.println("[product] sCount_Ikan ---> " + sCount_Ikan);
        System.out.println("[product] sCount_Sapi ---> " + sCount_Sapi);
    }

    /*============================================================================================*/
    public void imageProductAdapter()
    {
        img_product = (ImageView) findViewById(R.id.img_product);
        lbl_harga = (TextView) findViewById(R.id.lbl_harga);
        lbl_namaproduct = (TextView) findViewById(R.id.lbl_namaproduct);
        lbl_qty = (TextView) findViewById(R.id.lbl_qty);

        //getSession
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        String sProduct = pref.getString("sProduct", "0");
        String sCount = pref.getString("sCount", "0");

        System.out.println(""+sProduct);

        if(sProduct.equals("Apel"))
        {
            img_product.setImageResource(R.drawable.product_apel);
            lbl_namaproduct.setText("Apel Super");
            lbl_harga.setText("Rp 30.000");
            lbl_qty.setText(sCount);

            lbl_qty.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    Integer a = Integer.parseInt(lbl_qty.getText().toString());
                    Integer b = a + sCount_Apel;

                    //setSession
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("sCount_Apel", "" + b);
                    editor.commit();

                    System.out.println("[product] qty1 a --> " + a);
                    System.out.println("[product] sCount_Apel --> " + sCount_Apel);
                    System.out.println("[product] qty1 b --> " + b);
                }
            });
        }
        if(sProduct.equals("Pisang"))
        {
            img_product.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct.setText("Pisang Raja");
            lbl_harga.setText("Rp 20.000");
            lbl_qty.setText(sCount);

            lbl_qty.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    Integer a = Integer.parseInt(lbl_qty.getText().toString());
                    Integer b = a + sCount_Pisang;

                    //setSession
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("sCount_Pisang", "" + b);
                    editor.commit();

                    System.out.println("[product] qty2 a --> " + a);
                    System.out.println("[product] sCount_Pisang --> " + sCount_Pisang);
                    System.out.println("[product] qty2 b --> " + b);
                }
            });
        }
        if(sProduct.equals("Tomat"))
        {
            img_product.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct.setText("Tomat");
            lbl_harga.setText("Rp 10.000");
            lbl_qty.setText(sCount);

            lbl_qty.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    Integer a = Integer.parseInt(lbl_qty.getText().toString());
                    Integer b = a + sCount_Tomat;

                    //setSession
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("sCount_Tomat", "" + b);
                    editor.commit();

                    System.out.println("[product] qty3 a --> " + a);
                    System.out.println("[product] sCount_Tomat --> " + sCount_Tomat);
                    System.out.println("[product] qty3 b --> " + b);
                }
            });
        }
        if(sProduct.equals("Bawang Merah"))
        {
            img_product.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct.setText("Bawang Merah");
            lbl_harga.setText("Rp 10.000");
            lbl_qty.setText(sCount);

            lbl_qty.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    Integer a = Integer.parseInt(lbl_qty.getText().toString());
                    Integer b = a + sCount_Bawang_Merah;

                    //setSession
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("sCount_Bawang_Merah", "" + b);
                    editor.commit();

                    System.out.println("[product] qty4 a --> " + a);
                    System.out.println("[product] sCount_Bawang_Merah --> " + sCount_Bawang_Merah);
                    System.out.println("[product] qty4 b --> " + b);
                }
            });
        }
        if(sProduct.equals("Ikan"))
        {
            img_product.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct.setText("Ikan Kakap");
            lbl_harga.setText("Rp 50.000");
            lbl_qty.setText(sCount);

            lbl_qty.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    Integer a = Integer.parseInt(lbl_qty.getText().toString());
                    Integer b = a + sCount_Ikan;

                    //setSession
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("sCount_Ikan", "" + b);
                    editor.commit();

                    System.out.println("[product] qty5 a --> " + a);
                    System.out.println("[product] sCount_Ikan --> " + sCount_Ikan);
                    System.out.println("[product] qty5 b --> " + b);
                }
            });
        }
        if(sProduct.equals("Sapi"))
        {
            img_product.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct.setText("Sapi Import");
            lbl_harga.setText("Rp 100.000");
            lbl_qty.setText(sCount);

            lbl_qty.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    Integer a = Integer.parseInt(lbl_qty.getText().toString());
                    Integer b = a + sCount_Sapi;

                    //setSession
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("sCount_Sapi", "" + b);
                    editor.commit();

                    System.out.println("[product] qty6 a --> " + a);
                    System.out.println("[product] sCount_Sapi --> " + sCount_Sapi);
                    System.out.println("[product] qty6 b --> " + b);
                }
            });
        }

    }

    /*============================================================================================*/
    public void productButtonListener()
    {
        btn_min = (Button) findViewById(R.id.btn_min);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        lbl_qty = (TextView) findViewById(R.id.lbl_qty);

        /* ------------------------------------------------------------------------------------- */
        btn_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = Integer.parseInt((String) lbl_qty.getText());

                if (count == 0) {
                    lbl_qty.setText("0");
                } else {
                    count--;
                    lbl_qty.setText("" + count);
                }
            }
        });

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count = Integer.parseInt((String) lbl_qty.getText());
                count++;
                lbl_qty.setText("" + count);

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
        Intent intent = new Intent(getBaseContext(), AfterLogin_Product.class);
        startActivity(intent);
        finish();
    }

    /*============================================================================================*/
}

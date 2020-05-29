package com.mobile.belanjapasar.afterlogin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatSpinner;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mobile.belanjapasar.R;
import com.mobile.belanjapasar.activity.ForgetPassword;
import com.mobile.belanjapasar.activity.Home;
import com.mobile.belanjapasar.activity.Login;
import com.mobile.belanjapasar.activity.ProductDetail;
import com.mobile.belanjapasar.activity.Promo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tommy on 10/02/2016.
 */
public class AfterLogin_Product extends AppCompatActivity {

    AppCompatSpinner sp_product_category;

    ImageButton btn_cart;
    ImageButton btn_lacak;
    ImageButton btn_resep;
    ImageButton btn_logout;

    ImageView product1;
    ImageView product2;
    ImageView product3;
    ImageView product4;
    ImageView product5;
    ImageView product6;

    TextView lbl_namaproduct1;
    TextView lbl_namaproduct2;
    TextView lbl_namaproduct3;
    TextView lbl_namaproduct4;
    TextView lbl_namaproduct5;
    TextView lbl_namaproduct6;

    TextView lbl_hargaproduct1;
    TextView lbl_hargaproduct2;
    TextView lbl_hargaproduct3;
    TextView lbl_hargaproduct4;
    TextView lbl_hargaproduct5;
    TextView lbl_hargaproduct6;

    Button btn_min1, btn_min2, btn_min3, btn_min4, btn_min5, btn_min6;
    Button btn_plus1, btn_plus2, btn_plus3, btn_plus4, btn_plus5, btn_plus6;
    TextView lbl_qty1, lbl_qty2, lbl_qty3, lbl_qty4, lbl_qty5, lbl_qty6;

    LinearLayout layout_1;
    LinearLayout layout_2;
    LinearLayout layout_3;
    LinearLayout layout_4;
    LinearLayout layout_5;
    LinearLayout layout_6;

    String cari;

    String nama1;
    String nama2;
    String nama3;
    String nama4;
    String nama5;
    String nama6;

    Integer sCount_Apel;
    Integer sCount_Pisang;
    Integer sCount_Tomat;
    Integer sCount_Bawang_Merah;
    Integer sCount_Ikan;
    Integer sCount_Sapi;

    private EditText ti_search;
    private ImageButton btn_searchproduct;

    public int count = 5;


    /*============================================================================================*/
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afterlogin_product_activity_main);

        ti_search = (EditText) findViewById(R.id.ti_search);
        ti_search.setFocusable(false);
        ti_search.setFocusableInTouchMode(false);

        componentDeclare();
        getProductFromSession();
        focusableSearch();
        navigationButtonListener();
        spinnerListAdapter_product();
        productButtonListener();
        productImageListener();
        addToCart();
    }
    /*============================================================================================*/
    public void componentDeclare()
    {
        btn_cart = (ImageButton) findViewById(R.id.btn_cart);
        btn_lacak = (ImageButton) findViewById(R.id.btn_lacak);
        btn_resep = (ImageButton) findViewById(R.id.btn_resep);
        btn_logout = (ImageButton) findViewById(R.id.btn_logout);
        btn_searchproduct = (ImageButton) findViewById(R.id.btn_searchproduct);

        layout_1 = (LinearLayout) findViewById(R.id.layout_1);
        layout_2 = (LinearLayout) findViewById(R.id.layout_2);
        layout_3 = (LinearLayout) findViewById(R.id.layout_3);
        layout_4 = (LinearLayout) findViewById(R.id.layout_4);
        layout_5 = (LinearLayout) findViewById(R.id.layout_5);
        layout_6 = (LinearLayout) findViewById(R.id.layout_6);

        layout_1.setVisibility(View.VISIBLE);
        layout_2.setVisibility(View.VISIBLE);
        layout_3.setVisibility(View.VISIBLE);
        layout_4.setVisibility(View.VISIBLE);
        layout_5.setVisibility(View.VISIBLE);
        layout_6.setVisibility(View.VISIBLE);

        product1 = (ImageView) findViewById(R.id.product1);
        product2 = (ImageView) findViewById(R.id.product2);
        product3 = (ImageView) findViewById(R.id.product3);
        product4 = (ImageView) findViewById(R.id.product4);
        product5 = (ImageView) findViewById(R.id.product5);
        product6 = (ImageView) findViewById(R.id.product6);

        lbl_namaproduct1 = (TextView) findViewById(R.id.lbl_namaproduct1);
        lbl_namaproduct2 = (TextView) findViewById(R.id.lbl_namaproduct2);
        lbl_namaproduct3 = (TextView) findViewById(R.id.lbl_namaproduct3);
        lbl_namaproduct4 = (TextView) findViewById(R.id.lbl_namaproduct4);
        lbl_namaproduct5 = (TextView) findViewById(R.id.lbl_namaproduct5);
        lbl_namaproduct6 = (TextView) findViewById(R.id.lbl_namaproduct6);

        lbl_hargaproduct1 = (TextView) findViewById(R.id.lbl_hargaproduct1);
        lbl_hargaproduct2 = (TextView) findViewById(R.id.lbl_hargaproduct2);
        lbl_hargaproduct3 = (TextView) findViewById(R.id.lbl_hargaproduct3);
        lbl_hargaproduct4 = (TextView) findViewById(R.id.lbl_hargaproduct4);
        lbl_hargaproduct5 = (TextView) findViewById(R.id.lbl_hargaproduct5);
        lbl_hargaproduct6 = (TextView) findViewById(R.id.lbl_hargaproduct6);

        lbl_qty1 = (TextView) findViewById(R.id.lbl_qty1);
        lbl_qty2 = (TextView) findViewById(R.id.lbl_qty2);
        lbl_qty3 = (TextView) findViewById(R.id.lbl_qty3);
        lbl_qty4 = (TextView) findViewById(R.id.lbl_qty4);
        lbl_qty5 = (TextView) findViewById(R.id.lbl_qty5);
        lbl_qty6 = (TextView) findViewById(R.id.lbl_qty6);

        btn_min1 = (Button) findViewById(R.id.btn_min1);
        btn_min2 = (Button) findViewById(R.id.btn_min2);
        btn_min3 = (Button) findViewById(R.id.btn_min3);
        btn_min4 = (Button) findViewById(R.id.btn_min4);
        btn_min5 = (Button) findViewById(R.id.btn_min5);
        btn_min6 = (Button) findViewById(R.id.btn_min6);

        btn_plus1 = (Button) findViewById(R.id.btn_plus1);
        btn_plus2 = (Button) findViewById(R.id.btn_plus2);
        btn_plus3 = (Button) findViewById(R.id.btn_plus3);
        btn_plus4 = (Button) findViewById(R.id.btn_plus4);
        btn_plus5 = (Button) findViewById(R.id.btn_plus5);
        btn_plus6 = (Button) findViewById(R.id.btn_plus6);

    }

    /*============================================================================================*/
    public void focusableSearch()
    {
        ti_search = (EditText) findViewById(R.id.ti_search);
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
    public void navigationButtonListener()
    {
        //setSession
        final SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        final SharedPreferences.Editor editor = pref.edit();

        btn_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if(a.equals("0") && b.equals("0") && c.equals("0") &&
//                        d.equals("0") && e.equals("0") && f.equals("0"))
//                {
//                    Toast.makeText(getApplication().getBaseContext(),"Keranjang anda kosong!",Toast.LENGTH_LONG).show();
//                    editor.clear();
//                    editor.commit();
//                }
//                else {
                    //product1
                    editor.putString("sCount_Apel", "" + pref.getString("sCount_Apel", ""+sCount_Apel));
                    editor.putString("sCount_Pisang", "" + pref.getString("sCount_Pisang",""+sCount_Pisang));
                    editor.putString("sCount_Tomat", "" + pref.getString("sCount_Tomat",""+sCount_Tomat));
                    editor.putString("sCount_Bawang_Merah", "" + pref.getString("sCount_Bawang_Merah",""+sCount_Bawang_Merah));
                    editor.putString("sCount_Ikan", "" + pref.getString("sCount_Ikan",""+sCount_Ikan));
                    editor.putString("sCount_Sapi", "" + pref.getString("sCount_Sapi",""+sCount_Sapi));
                    editor.commit();


                    Intent intent = new Intent(getBaseContext(), AfterLogin_Cart.class);
                    startActivity(intent);
                    finish();
//                }
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

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_searchproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                searchProduct();

            }
        });

    }

    /*============================================================================================*/
    public void searchProduct()
    {
        cari = ti_search.getText().toString().toUpperCase();

        nama1 = lbl_namaproduct1.getText().toString().toUpperCase();
        nama2 = lbl_namaproduct2.getText().toString().toUpperCase();
        nama3 = lbl_namaproduct3.getText().toString().toUpperCase();
        nama4 = lbl_namaproduct4.getText().toString().toUpperCase();
        nama5 = lbl_namaproduct5.getText().toString().toUpperCase();
        nama6 = lbl_namaproduct6.getText().toString().toUpperCase();

        System.out.println("cari --> " + cari);
        System.out.println("nama1 --> " + nama1);
        System.out.println("nama2 --> " + nama2);
        System.out.println("nama3 --> " + nama3);
        System.out.println("nama4 --> " + nama4);
        System.out.println("nama5 --> " + nama5);
        System.out.println("nama6 --> " + nama6);

        if(cari.isEmpty()||cari.equals("")||cari==""||cari.equals(null)||cari==null)
        {
            layout_1.setVisibility(View.INVISIBLE);
            layout_2.setVisibility(View.INVISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            lbl_qty1.setText("0");
            lbl_qty2.setText("0");
            lbl_qty3.setText("0");
            lbl_qty4.setText("0");
            lbl_qty5.setText("0");
            lbl_qty6.setText("0");

            ti_search.setFocusable(false);
            ti_search.setFocusableInTouchMode(false);

        }
        else if(nama1.contains(""+cari))
        {
            System.out.println("if 1 --> Run");
            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText("0");
            lbl_qty2.setText("0");
            lbl_qty3.setText("0");
            lbl_qty4.setText("0");
            lbl_qty5.setText("0");
            lbl_qty6.setText("0");

            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.INVISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            ti_search.setFocusable(false);
            ti_search.setFocusableInTouchMode(false);

        } else if(nama2.contains(""+cari)) {
            System.out.println("if 2 --> Run");
            product1.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct1.setText("Pisang Raja");
            lbl_hargaproduct1.setText("Rp 20.000");
            lbl_qty1.setText("0");
            lbl_qty2.setText("0");
            lbl_qty3.setText("0");
            lbl_qty4.setText("0");
            lbl_qty5.setText("0");
            lbl_qty6.setText("0");

            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.INVISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            ti_search.setFocusable(false);
            ti_search.setFocusableInTouchMode(false);
        }
        else if(nama3.contains(cari))
        {
            System.out.println("if 3 --> Run");
            product1.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct1.setText("Tomat");
            lbl_hargaproduct1.setText("Rp 10.000");
            lbl_qty1.setText("0");
            lbl_qty2.setText("0");
            lbl_qty3.setText("0");
            lbl_qty4.setText("0");
            lbl_qty5.setText("0");
            lbl_qty6.setText("0");

            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.INVISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            ti_search.setFocusable(false);
            ti_search.setFocusableInTouchMode(false);

        }
        else if(nama4.contains(cari))
        {
            product1.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct1.setText("Bawang Merah");
            lbl_hargaproduct1.setText("Rp 10.000");
            lbl_qty1.setText("0");
            lbl_qty2.setText("0");
            lbl_qty3.setText("0");
            lbl_qty4.setText("0");
            lbl_qty5.setText("0");
            lbl_qty6.setText("0");

            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.INVISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            ti_search.setFocusable(false);
            ti_search.setFocusableInTouchMode(false);

        }
        else if(nama5.contains(cari))
        {
            product1.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct1.setText("Ikan Kakap");
            lbl_hargaproduct1.setText("Rp 50.000");
            lbl_qty1.setText("0");
            lbl_qty2.setText("0");
            lbl_qty3.setText("0");
            lbl_qty4.setText("0");
            lbl_qty5.setText("0");
            lbl_qty6.setText("0");

            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.INVISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            ti_search.setFocusable(false);
            ti_search.setFocusableInTouchMode(false);

        }
        else if(nama6.contains(cari))
        {
            product1.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct1.setText("Sapi Import");
            lbl_hargaproduct1.setText("Rp 100.000");
            lbl_qty1.setText("0");
            lbl_qty2.setText("0");
            lbl_qty3.setText("0");
            lbl_qty4.setText("0");
            lbl_qty5.setText("0");
            lbl_qty6.setText("0");

            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.INVISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            ti_search.setFocusable(false);
            ti_search.setFocusableInTouchMode(false);

        }

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
    public void productButtonListener()
    {

        btn_min1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count = Integer.parseInt( lbl_qty1.getText().toString());

                if(count == 0) {
                    lbl_qty1.setText("0");
                }
                else {
                    count--;
                    lbl_qty1.setText("" + count);
                }
            }
        });

        btn_plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = Integer.parseInt( lbl_qty1.getText().toString());
                count++;
                lbl_qty1.setText(""+count);
            }
        });

        /* ------------------------------------------------------------------------------------- */
        btn_min2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = Integer.parseInt( lbl_qty2.getText().toString());

                if(count == 0){
                    lbl_qty2.setText("0");
                }
                else {
                    count--;
                    lbl_qty2.setText(""+count);
                }
            }
        });

        btn_plus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count = Integer.parseInt( lbl_qty2.getText().toString());
                count++;
                lbl_qty2.setText(""+count);

            }
        });

        /* ------------------------------------------------------------------------------------- */
        btn_min3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = Integer.parseInt( lbl_qty3.getText().toString());

                if(count == 0){
                    lbl_qty3.setText("0");
                }
                else {
                    count--;
                    lbl_qty3.setText(""+count);
                }
            }
        });

        btn_plus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count = Integer.parseInt( lbl_qty3.getText().toString());
                count++;
                lbl_qty3.setText(""+count);

            }
        });

        /* ------------------------------------------------------------------------------------- */
        btn_min4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = Integer.parseInt( lbl_qty4.getText().toString());

                if (count == 0) {
                    lbl_qty4.setText("0");
                } else {
                    count--;
                    lbl_qty4.setText("" + count);
                }
            }
        });

        btn_plus4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count = Integer.parseInt( lbl_qty4.getText().toString());
                count++;
                lbl_qty4.setText("" + count);

            }
        });

        /* ------------------------------------------------------------------------------------- */
        btn_min5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = Integer.parseInt( lbl_qty5.getText().toString());

                if (count == 0) {
                    lbl_qty5.setText("0");
                } else {
                    count--;
                    lbl_qty5.setText("" + count);
                }
            }
        });

        btn_plus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count = Integer.parseInt(lbl_qty5.getText().toString());
                count++;
                lbl_qty5.setText("" + count);

            }
        });

        /* ------------------------------------------------------------------------------------- */
        btn_min6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = Integer.parseInt((String) lbl_qty6.getText());

                if (count == 0) {
                    lbl_qty6.setText("0");
                } else {
                    count--;
                    lbl_qty6.setText("" + count);
                }
            }
        });

        btn_plus6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count = Integer.parseInt(lbl_qty6.getText().toString());
                count++;
                lbl_qty6.setText("" + count);

            }
        });
        /* ------------------------------------------------------------------------------------- */

    }

    /*============================================================================================*/
    public void addToCart()
    {
        lbl_qty1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                Integer a = Integer.parseInt(lbl_qty1.getText().toString());
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

        lbl_qty2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                Integer a = Integer.parseInt(lbl_qty2.getText().toString());
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

        lbl_qty4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                Integer a = Integer.parseInt(lbl_qty4.getText().toString());
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

        lbl_qty5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                Integer a = Integer.parseInt(lbl_qty5.getText().toString());
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

        lbl_qty6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                Integer a = Integer.parseInt(lbl_qty6.getText().toString());
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

        lbl_qty3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                Integer a = Integer.parseInt(lbl_qty3.getText().toString());
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

    /*============================================================================================*/
    public void productImageListener()
    {
        product1 = (ImageView) findViewById(R.id.product1);
        product2 = (ImageView) findViewById(R.id.product2);
        product3 = (ImageView) findViewById(R.id.product3);
        product4 = (ImageView) findViewById(R.id.product4);
        product5 = (ImageView) findViewById(R.id.product5);
        product6 = (ImageView) findViewById(R.id.product6);

        lbl_qty1 = (TextView) findViewById(R.id.lbl_qty1);
        lbl_qty2 = (TextView) findViewById(R.id.lbl_qty2);
        lbl_qty3 = (TextView) findViewById(R.id.lbl_qty3);
        lbl_qty4 = (TextView) findViewById(R.id.lbl_qty4);
        lbl_qty5 = (TextView) findViewById(R.id.lbl_qty5);
        lbl_qty6 = (TextView) findViewById(R.id.lbl_qty6);

        product1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count = lbl_qty1.getText().toString();

                //set Session
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sProduct", "Apel");
                editor.putString("sCount", count);
                editor.commit();

                Intent intent = new Intent(getBaseContext(), AfterLogin_ProductDetail.class);
                startActivity(intent);
            }
        });

        product2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count = (String) lbl_qty2.getText().toString();
                //set Session
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sProduct", "Pisang");
                editor.putString("sCount", count);
                editor.commit();

                Intent intent = new Intent(getBaseContext(), AfterLogin_ProductDetail.class);
                startActivity(intent);
            }
        });

        product3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count = (String) lbl_qty3.getText().toString();
                //set Session
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sProduct", "Tomat");
                editor.putString("sCount", count);
                editor.commit();

                Intent intent = new Intent(getBaseContext(), AfterLogin_ProductDetail.class);
                startActivity(intent);
            }
        });

        product4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count = (String) lbl_qty4.getText().toString();
                //set Session
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sProduct", "Bawang Merah");
                editor.putString("sCount", count);
                editor.commit();

                Intent intent = new Intent(getBaseContext(), AfterLogin_ProductDetail.class);
                startActivity(intent);
            }
        });

        product5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count = (String) lbl_qty5.getText().toString();
                //set Session
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sProduct", "Ikan");
                editor.putString("sCount", count);
                editor.commit();

                Intent intent = new Intent(getBaseContext(), AfterLogin_ProductDetail.class);
                startActivity(intent);
            }
        });

        product6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count = (String) lbl_qty6.getText().toString();
                //set Session
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sProduct", "Sapi");
                editor.putString("sCount", count);
                editor.commit();

                Intent intent = new Intent(getBaseContext(), AfterLogin_ProductDetail.class);
                startActivity(intent);
            }
        });
    }

    /*============================================================================================*/
    public void spinnerListAdapter_product()
    {
        lbl_namaproduct1 = (TextView) findViewById(R.id.lbl_namaproduct1);
        lbl_hargaproduct1 = (TextView) findViewById(R.id.lbl_hargaproduct1);
        lbl_qty1 = (TextView) findViewById(R.id.lbl_qty1);

        product1 = (ImageView) findViewById(R.id.product1);
        product2 = (ImageView) findViewById(R.id.product2);
        product3 = (ImageView) findViewById(R.id.product3);
        product4 = (ImageView) findViewById(R.id.product4);
        product5 = (ImageView) findViewById(R.id.product5);
        product6 = (ImageView) findViewById(R.id.product6);

        layout_1 = (LinearLayout) findViewById(R.id.layout_1);
        layout_2 = (LinearLayout) findViewById(R.id.layout_2);
        layout_3 = (LinearLayout) findViewById(R.id.layout_3);
        layout_4 = (LinearLayout) findViewById(R.id.layout_4);
        layout_5 = (LinearLayout) findViewById(R.id.layout_5);
        layout_6 = (LinearLayout) findViewById(R.id.layout_6);

        sp_product_category = (AppCompatSpinner) findViewById(R.id.sp_product_category);

        List<String> array = new ArrayList<String>();
        array.add("-Pilih Produk-");
        array.add("Bumbu");
        array.add("Sayur");
        array.add("Daging");
        array.add("Seafood");

        final ArrayAdapter<String> product = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,array);
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
                if(productItemSelected.equals("-Pilih Produk-"))
                {
                    layout_1.setVisibility(View.VISIBLE);
                    layout_2.setVisibility(View.VISIBLE);
                    layout_3.setVisibility(View.VISIBLE);
                    layout_4.setVisibility(View.VISIBLE);
                    layout_5.setVisibility(View.VISIBLE);
                    layout_6.setVisibility(View.VISIBLE);
                }
                else
                {
                    layout_1.setVisibility(View.VISIBLE);
                    layout_2.setVisibility(View.VISIBLE);
                    layout_3.setVisibility(View.VISIBLE);
                    layout_4.setVisibility(View.VISIBLE);
                    layout_5.setVisibility(View.VISIBLE);
                    layout_6.setVisibility(View.VISIBLE);
                }
                /*if(productItemSelected.equals("Bumbu"))
                {
                    layout_1.setVisibility(View.VISIBLE);
                    layout_2.setVisibility(View.INVISIBLE);
                    layout_3.setVisibility(View.INVISIBLE);
                    layout_4.setVisibility(View.INVISIBLE);
                    layout_5.setVisibility(View.INVISIBLE);
                    layout_6.setVisibility(View.INVISIBLE);

                    product1.setImageResource(R.drawable.product_bawang_merah);
                    lbl_namaproduct1.setText("Bawang Merah");
                    lbl_hargaproduct1.setText("Rp 10.000");
                }
                if(productItemSelected.equals("Sayur"))
                {
                    layout_1.setVisibility(View.VISIBLE);
                    layout_2.setVisibility(View.INVISIBLE);
                    layout_3.setVisibility(View.INVISIBLE);
                    layout_4.setVisibility(View.INVISIBLE);
                    layout_5.setVisibility(View.INVISIBLE);
                    layout_6.setVisibility(View.INVISIBLE);

                    product1.setImageResource(R.drawable.product_tomat);
                    lbl_namaproduct1.setText("Tomat");
                    lbl_hargaproduct1.setText("Rp 10.000");
                }
                if(productItemSelected.equals("Daging"))
                {
                    layout_1.setVisibility(View.VISIBLE);
                    layout_2.setVisibility(View.INVISIBLE);
                    layout_3.setVisibility(View.INVISIBLE);
                    layout_4.setVisibility(View.INVISIBLE);
                    layout_5.setVisibility(View.INVISIBLE);
                    layout_6.setVisibility(View.INVISIBLE);

                    product1.setImageResource(R.drawable.product_sapi);
                    lbl_namaproduct1.setText("Sapi Import");
                    lbl_hargaproduct1.setText("Rp 100.000");
                }
                if(productItemSelected.equals("Seafood"))
                {
                    layout_1.setVisibility(View.VISIBLE);
                    layout_2.setVisibility(View.INVISIBLE);
                    layout_3.setVisibility(View.INVISIBLE);
                    layout_4.setVisibility(View.INVISIBLE);
                    layout_5.setVisibility(View.INVISIBLE);
                    layout_6.setVisibility(View.INVISIBLE);

                    product1.setImageResource(R.drawable.product_ikan);
                    lbl_namaproduct1.setText("Ikan Kakap");
                    lbl_hargaproduct1.setText("Rp 50.000");
                }*/

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /*============================================================================================*/
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to logout?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(getBaseContext(), Home.class);
                                startActivity(intent);
                                AfterLogin_Product.this.finish();

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

    /*============================================================================================*/
}

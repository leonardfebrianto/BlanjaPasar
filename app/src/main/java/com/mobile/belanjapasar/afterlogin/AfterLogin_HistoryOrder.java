package com.mobile.belanjapasar.afterlogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mobile.belanjapasar.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tommy on 10/02/2016.
 */
public class AfterLogin_HistoryOrder extends AppCompatActivity {

    AppCompatSpinner sp_product_category;

    AppCompatImageButton btn_cart;
    AppCompatImageButton btn_lacak;
    AppCompatImageButton btn_resep;

    AppCompatTextView lbl_harga;

    LinearLayout layout_1;
    LinearLayout layout_2;
    LinearLayout layout_3;
    LinearLayout layout_4;
    LinearLayout layout_5;
    LinearLayout layout_6;

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

    Integer sCount_Apel;
    Integer sCount_Pisang;
    Integer sCount_Tomat;
    Integer sCount_Bawang_Merah;
    Integer sCount_Ikan;
    Integer sCount_Sapi;

    AppCompatButton btn_copy;

    public int total = 0;


    /*============================================================================================*/
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afterlogin_history_order_activity_main);

        componentDeclare();
        //getOrderedProduct();
        setProduct();
        //getProductFromSession();
        //getTotal();
        navigationButtonListener();
        spinnerListAdapter_product();
        //addToCart();
    }

    /*============================================================================================*/
    public void componentDeclare()
    {
        lbl_harga = (AppCompatTextView) findViewById(R.id.lbl_harga);
        btn_cart = (AppCompatImageButton) findViewById(R.id.btn_cart);
        btn_lacak = (AppCompatImageButton) findViewById(R.id.btn_lacak);
        btn_resep = (AppCompatImageButton) findViewById(R.id.btn_resep);
        btn_copy = (AppCompatButton) findViewById(R.id.btn_copy);

        layout_1 = (LinearLayout) findViewById(R.id.layout_1);
        layout_2 = (LinearLayout) findViewById(R.id.layout_2);
        layout_3 = (LinearLayout) findViewById(R.id.layout_3);
        layout_4 = (LinearLayout) findViewById(R.id.layout_4);
        layout_5 = (LinearLayout) findViewById(R.id.layout_5);
        layout_6 = (LinearLayout) findViewById(R.id.layout_6);

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
    public void getTotal()
    {
        int harga1 = 0;
        int harga2 = 0;
        int harga3 = 0;
        int harga4 = 0;
        int harga5 = 0;
        int harga6 = 0;

        int a = Integer.parseInt(lbl_qty1.getText().toString());
        int b = Integer.parseInt(lbl_qty2.getText().toString());
        int c = Integer.parseInt(lbl_qty3.getText().toString());
        int d = Integer.parseInt(lbl_qty4.getText().toString());
        int e = Integer.parseInt(lbl_qty5.getText().toString());
        int f = Integer.parseInt(lbl_qty6.getText().toString());

        String nama1 = lbl_namaproduct1.getText().toString();
        String nama2 = lbl_namaproduct2.getText().toString();
        String nama3 = lbl_namaproduct3.getText().toString();
        String nama4 = lbl_namaproduct4.getText().toString();
        String nama5 = lbl_namaproduct5.getText().toString();
        String nama6 = lbl_namaproduct6.getText().toString();

        /*----------------------------------------------------------------------------------------*/
        //nama1
        if(nama1.equals("Apel Super")) {
            harga1 = 30;
        }
        else if(nama1.equals("Pisang Raja")) {
            harga1 = 20;
        }
        else if(nama1.equals("Tomat")) {
            harga1 = 10;
        }
        else if(nama1.equals("Bawang Merah")) {
            harga1 = 10;
        }
        else if(nama1.equals("Ikan Kakap")) {
            harga1 = 50;
        }
        else if(nama1.equals("Sapi Import")) {
            harga1 = 100;
        }

        //nama2
        if(nama2.equals("Apel Super")) {
            harga2 = 30;
        }
        else if(nama2.equals("Pisang Raja")) {
            harga2 = 20;
        }
        else if(nama2.equals("Tomat")) {
            harga2 = 10;
        }
        else if(nama2.equals("Bawang Merah")) {
            harga2 = 10;
        }
        else if(nama2.equals("Ikan Kakap")) {
            harga2 = 50;
        }
        else if(nama2.equals("Sapi Import")) {
            harga2 = 100;
        }

        //nama3
        if(nama3.equals("Apel Super")) {
            harga3 = 30;
        }
        else if(nama3.equals("Pisang Raja")) {
            harga3 = 20;
        }
        else if(nama3.equals("Tomat")) {
            harga3 = 10;
        }
        else if(nama3.equals("Bawang Merah")) {
            harga3 = 10;
        }
        else if(nama3.equals("Ikan Kakap")) {
            harga3 = 50;
        }
        else if(nama3.equals("Sapi Import")) {
            harga3 = 100;
        }

        //nama4
        if(nama4.equals("Apel Super")) {
            harga4 = 30;
        }
        else if(nama4.equals("Pisang Raja")) {
            harga4 = 20;
        }
        else if(nama4.equals("Tomat")) {
            harga4 = 10;
        }
        else if(nama4.equals("Bawang Merah")) {
            harga4 = 10;
        }
        else if(nama4.equals("Ikan Kakap")) {
            harga4 = 50;
        }
        else if(nama4.equals("Sapi Import")) {
            harga4 = 100;
        }

        //nama5
        if(nama5.equals("Apel Super")) {
            harga5 = 30;
        }
        else if(nama5.equals("Pisang Raja")) {
            harga5 = 20;
        }
        else if(nama5.equals("Tomat")) {
            harga5 = 10;
        }
        else if(nama5.equals("Bawang Merah")) {
            harga5 = 10;
        }
        else if(nama5.equals("Ikan Kakap")) {
            harga5 = 50;
        }
        else if(nama5.equals("Sapi Import")) {
            harga5 = 100;
        }

        //nama6
        if(nama6.equals("Apel Super")) {
            harga6 = 30;
        }
        else if(nama6.equals("Pisang Raja")) {
            harga6 = 20;
        }
        else if(nama6.equals("Tomat")) {
            harga6 = 10;
        }
        else if(nama6.equals("Bawang Merah")) {
            harga6 = 10;
        }
        else if(nama6.equals("Ikan Kakap")) {
            harga6 = 50;
        }
        else if(nama6.equals("Sapi Import")) {
            harga6 = 100;
        }

        /*----------------------------------------------------------------------------------------*/
        total = (a * harga1) + (b * harga2) + (c * harga3) + (d * harga4) + (e * harga5) + (f * harga6);

        if(total==0)
        {
            lbl_harga.setText("Total: Rp 0,-");
        }
        else
        {
            lbl_harga.setText("Total: Rp "+total+".000,-");
        }

        /*----------------------------------------------------------------------------------------*/
    }

    /*============================================================================================*/
    public void getOrderedProduct()
    {
        //getSession
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode

        String sCount_Apel = pref.getString("sCount_Apel", "0");
        String sCount_Pisang = pref.getString("sCount_Pisang", "0");
        String sCount_Tomat = pref.getString("sCount_Tomat", "0");
        String sCount_Bawang_Merah = pref.getString("sCount_Bawang_Merah", "0");
        String sCount_Ikan = pref.getString("sCount_Ikan", "0");
        String sCount_Sapi = pref.getString("sCount_Sapi", "0");

        System.out.println("[cart] sCount_Apel ---> " + sCount_Apel);
        System.out.println("[cart] sCount_Pisang ---> " + sCount_Pisang);
        System.out.println("[cart] sCount_Tomat ---> " + sCount_Tomat);
        System.out.println("[cart] sCount_Bawang_Merah ---> " + sCount_Bawang_Merah);
        System.out.println("[cart] sCount_Ikan ---> " + sCount_Ikan);
        System.out.println("[cart] sCount_Sapi ---> " + sCount_Sapi);

        /*---------------------------------------------------------------------------------------*/
        if((sCount_Apel=="0" || sCount_Apel.equals("0")) &&
                (sCount_Pisang=="0" || sCount_Pisang.equals("0")) &&
                (sCount_Tomat=="0" || sCount_Tomat.equals("0")) &&
                (sCount_Bawang_Merah=="0" || sCount_Bawang_Merah.equals("0")) &&
                (sCount_Ikan=="0" || sCount_Ikan.equals("0")) &&
                (sCount_Sapi=="0" || sCount_Sapi.equals("0")))
        {
            System.out.println("if 0 --> run");
            layout_1.setVisibility(View.INVISIBLE);
            layout_2.setVisibility(View.INVISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);
            

        }
        else if(!sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 1 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.INVISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);
            
        }
        /*---------------------------------------------------------------------------------------*/
        else if(!sCount_Pisang.equals("0")
                && sCount_Apel.equals("0")
                && sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 2 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.INVISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct1.setText("Pisang Raja");
            lbl_hargaproduct1.setText("Rp 20.000");
            lbl_qty1.setText(sCount_Pisang);
            
        }
        /*---------------------------------------------------------------------------------------*/
        else if(!sCount_Tomat.equals("0")
                && sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 3 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.INVISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct1.setText("Tomat");
            lbl_hargaproduct1.setText("Rp 10.000");
            lbl_qty1.setText(sCount_Tomat);
            
        }
        /*---------------------------------------------------------------------------------------*/
        else if(!sCount_Bawang_Merah.equals("0")
                && sCount_Apel.equals("0")
                && sCount_Tomat.equals("0")
                && sCount_Pisang.equals("0")
                && sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 4 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.INVISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct1.setText("Bawang Merah");
            lbl_hargaproduct1.setText("Rp 10.000");
            lbl_qty1.setText(sCount_Bawang_Merah);
            
        }

        /*---------------------------------------------------------------------------------------*/
        else if(!sCount_Ikan.equals("0")
                && sCount_Apel.equals("0")
                && sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && sCount_Pisang.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 5 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.INVISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct1.setText("Ikan Kakap");
            lbl_hargaproduct1.setText("Rp 50.000");
            lbl_qty1.setText(sCount_Ikan);
            
        }

        /*---------------------------------------------------------------------------------------*/
        else if(!sCount_Sapi.equals("0")
                && sCount_Apel.equals("0")
                && sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && sCount_Pisang.equals("0")
                && sCount_Ikan.equals("0"))
        {
            System.out.println("if 6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.INVISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct1.setText("Sapi Import");
            lbl_hargaproduct1.setText("Rp 100.000");
            lbl_qty1.setText(sCount_Sapi);
            
        }

        // 1&2 - 1&6
        /*========================================================================================*/
        else if(!sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 1&2 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct2.setText("Pisang Raja");
            lbl_hargaproduct2.setText("Rp 20.000");
            lbl_qty2.setText(sCount_Pisang);
            
        }
        /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 1&3 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct2.setText("Tomat");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText(sCount_Tomat);
            

        }
         /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 1&4 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct2.setText("Bawang Merah");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText(sCount_Bawang_Merah);
            

        }
        /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 1&5 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct2.setText("Ikan Kakap");
            lbl_hargaproduct2.setText("Rp 50.000");
            lbl_qty2.setText(sCount_Ikan);
            

        }

        /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 1&6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct2.setText("Sapi Import");
            lbl_hargaproduct2.setText("Rp 100.000");
            lbl_qty2.setText(sCount_Sapi);
            

        }

        // 2&3 - 2&6
        /*========================================================================================*/
        else if(sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 2&3 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct1.setText("Pisang Raja");
            lbl_hargaproduct1.setText("Rp 20.000");
            lbl_qty1.setText(sCount_Pisang);

            product2.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct2.setText("Tomat");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText(sCount_Tomat);
            

        }

        /*----------------------------------------------------------------------------------------*/
        else if(sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 2&4 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct1.setText("Pisang Raja");
            lbl_hargaproduct1.setText("Rp 20.000");
            lbl_qty1.setText(sCount_Pisang);

            product2.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct2.setText("Bawang Merah");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText(sCount_Bawang_Merah);
            
        }

        /*----------------------------------------------------------------------------------------*/
        else if(sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 2&5 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct1.setText("Pisang Raja");
            lbl_hargaproduct1.setText("Rp 20.000");
            lbl_qty1.setText(sCount_Pisang);

            product2.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct2.setText("Ikan Kakap");
            lbl_hargaproduct2.setText("Rp 50.000");
            lbl_qty2.setText(sCount_Ikan);
            

        }

        /*----------------------------------------------------------------------------------------*/
        else if(sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 2&6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct1.setText("Pisang Raja");
            lbl_hargaproduct1.setText("Rp 20.000");
            lbl_qty1.setText(sCount_Pisang);

            product2.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct2.setText("Sapi Import");
            lbl_hargaproduct2.setText("Rp 100.000");
            lbl_qty2.setText(sCount_Sapi);
            

        }

        // 3&4 - 3&6
        /*========================================================================================*/
        else if(sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 3&4 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct1.setText("Tomat");
            lbl_hargaproduct1.setText("Rp 10.000");
            lbl_qty1.setText(sCount_Tomat);

            product2.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct2.setText("Bawang Merah");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText(sCount_Bawang_Merah);
            
        }
        /*----------------------------------------------------------------------------------------*/
        else if(sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 3&5 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct1.setText("Tomat");
            lbl_hargaproduct1.setText("Rp 10.000");
            lbl_qty1.setText(sCount_Tomat);

            product2.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct2.setText("Ikan Kakap");
            lbl_hargaproduct2.setText("Rp 50.000");
            lbl_qty2.setText(sCount_Ikan);
            
        }
        /*----------------------------------------------------------------------------------------*/
        else if(sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 3&6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct1.setText("Tomat");
            lbl_hargaproduct1.setText("Rp 10.000");
            lbl_qty1.setText(sCount_Tomat);

            product2.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct2.setText("Sapi Import");
            lbl_hargaproduct2.setText("Rp 100.000");
            lbl_qty2.setText(sCount_Sapi);
            
        }

        // 4&5 - 4&6
        /*========================================================================================*/
        else if(sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 4&5 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct1.setText("Bawang Merah");
            lbl_hargaproduct1.setText("Rp 10.000");
            lbl_qty1.setText(sCount_Bawang_Merah);

            product2.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct2.setText("Ikan Kakap");
            lbl_hargaproduct2.setText("Rp 50.000");
            lbl_qty2.setText(sCount_Ikan);
            

        }
        /*----------------------------------------------------------------------------------------*/
        else if(sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 4&6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct1.setText("Bawang Merah");
            lbl_hargaproduct1.setText("Rp 10.000");
            lbl_qty1.setText(sCount_Bawang_Merah);

            product2.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct2.setText("Sapi Import");
            lbl_hargaproduct2.setText("Rp 100.000");
            lbl_qty2.setText(sCount_Sapi);
            
        }

        // 5&6
        /*========================================================================================*/
        else if(sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 5&6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct1.setText("Ikan Kakap");
            lbl_hargaproduct1.setText("Rp 50.000");
            lbl_qty1.setText(sCount_Ikan);

            product2.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct2.setText("Sapi Import");
            lbl_hargaproduct2.setText("Rp 100.000");
            lbl_qty2.setText(sCount_Sapi);
            
        }

        // 1,2,3 - 1,5,6
        /*========================================================================================*/
        else if(!sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 1,2,3 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct2.setText("Pisang Raja");
            lbl_hargaproduct2.setText("Rp 20.000");
            lbl_qty2.setText(sCount_Pisang);

            product3.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct3.setText("Tomat");
            lbl_hargaproduct3.setText("Rp 10.000");
            lbl_qty3.setText(sCount_Tomat);
            

        }
        /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 1,2,4 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct2.setText("Pisang Raja");
            lbl_hargaproduct2.setText("Rp 20.000");
            lbl_qty2.setText(sCount_Pisang);

            product3.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct3.setText("Bawang Merah");
            lbl_hargaproduct3.setText("Rp 10.000");
            lbl_qty3.setText(sCount_Bawang_Merah);
            

        }
        /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 1,2,5 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct2.setText("Pisang Raja");
            lbl_hargaproduct2.setText("Rp 20.000");
            lbl_qty2.setText(sCount_Pisang);

            product3.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct3.setText("Ikan Kakap");
            lbl_hargaproduct3.setText("Rp 50.000");
            lbl_qty3.setText(sCount_Ikan);
            

        }
        /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 1,2,6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct2.setText("Pisang Raja");
            lbl_hargaproduct2.setText("Rp 20.000");
            lbl_qty2.setText(sCount_Pisang);

            product3.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct3.setText("Sapi Import");
            lbl_hargaproduct3.setText("Rp 100.000");
            lbl_qty3.setText(sCount_Sapi);
            

        }

        /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 1,3,4 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct2.setText("Tomat");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText(sCount_Tomat);

            product3.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct3.setText("Bawang Merah");
            lbl_hargaproduct3.setText("Rp 10.000");
            lbl_qty3.setText(sCount_Bawang_Merah);
            

        }
        /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 1,3,5 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct2.setText("Tomat");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText(sCount_Tomat);

            product3.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct3.setText("Ikan Kakap");
            lbl_hargaproduct3.setText("Rp 50.000");
            lbl_qty3.setText(sCount_Ikan);
            

        }
        /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 1,3,6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct2.setText("Tomat");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText(sCount_Tomat);

            product3.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct3.setText("Sapi Import");
            lbl_hargaproduct3.setText("Rp 100.000");
            lbl_qty3.setText(sCount_Sapi);
            
        }
        /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 1,4,5 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct2.setText("Bawang Merah");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText(sCount_Bawang_Merah);

            product3.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct3.setText("Ikan Kakap");
            lbl_hargaproduct3.setText("Rp 50.000");
            lbl_qty3.setText(sCount_Ikan);
            
        }
        /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 1,4,6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct2.setText("Bawang Merah");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText(sCount_Bawang_Merah);

            product3.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct3.setText("Sapi Import");
            lbl_hargaproduct3.setText("Rp 100.000");
            lbl_qty3.setText(sCount_Sapi);
            

        }
        /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 1,5,6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct2.setText("Ikan Kakap");
            lbl_hargaproduct2.setText("Rp 50.000");
            lbl_qty2.setText(sCount_Ikan);

            product3.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct3.setText("Sapi Import");
            lbl_hargaproduct3.setText("Rp 100.000");
            lbl_qty3.setText(sCount_Sapi);
            

        }

        /*========================================================================================*/
        else if(sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 2,3,4 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct1.setText("Pisang Raja");
            lbl_hargaproduct1.setText("Rp 20.000");
            lbl_qty1.setText(sCount_Pisang);

            product2.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct2.setText("Tomat");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText(sCount_Tomat);

            product3.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct3.setText("Bawang Merah");
            lbl_hargaproduct3.setText("Rp 10.000");
            lbl_qty3.setText(sCount_Bawang_Merah);
            
        }
        /*----------------------------------------------------------------------------------------*/
        else if(sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 2,3,5 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct1.setText("Pisang Raja");
            lbl_hargaproduct1.setText("Rp 20.000");
            lbl_qty1.setText(sCount_Pisang);

            product2.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct2.setText("Tomat");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText(sCount_Tomat);

            product3.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct3.setText("Ikan Kakap");
            lbl_hargaproduct3.setText("Rp 50.000");
            lbl_qty3.setText(sCount_Ikan);
            
        }
        /*----------------------------------------------------------------------------------------*/
        else if(sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 2,3,6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct1.setText("Pisang Raja");
            lbl_hargaproduct1.setText("Rp 20.000");
            lbl_qty1.setText(sCount_Pisang);

            product2.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct2.setText("Tomat");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText(sCount_Tomat);

            product3.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct3.setText("Sapi Import");
            lbl_hargaproduct3.setText("Rp 100.000");
            lbl_qty3.setText(sCount_Sapi);
            

        }

        /*========================================================================================*/
        else if(sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 2,4,5 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct1.setText("Pisang Raja");
            lbl_hargaproduct1.setText("Rp 20.000");
            lbl_qty1.setText(sCount_Pisang);

            product2.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct2.setText("Bawang Merah");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText(sCount_Bawang_Merah);

            product3.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct3.setText("Ikan Kakap");
            lbl_hargaproduct3.setText("Rp 50.000");
            lbl_qty3.setText(sCount_Ikan);
            
        }
        /*----------------------------------------------------------------------------------------*/
        else if(sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 2,4,6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct1.setText("Pisang Raja");
            lbl_hargaproduct1.setText("Rp 20.000");
            lbl_qty1.setText(sCount_Pisang);

            product2.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct2.setText("Bawang Merah");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText(sCount_Bawang_Merah);

            product3.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct3.setText("Sapi Import");
            lbl_hargaproduct3.setText("Rp 100.000");
            lbl_qty3.setText(sCount_Sapi);
            

        }
        /*----------------------------------------------------------------------------------------*/
        else if(sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 2,5,6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct1.setText("Pisang Raja");
            lbl_hargaproduct1.setText("Rp 20.000");
            lbl_qty1.setText(sCount_Pisang);

            product2.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct2.setText("Ikan Kakap");
            lbl_hargaproduct2.setText("Rp 50.000");
            lbl_qty2.setText(sCount_Ikan);

            product3.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct3.setText("Sapi Import");
            lbl_hargaproduct3.setText("Rp 100.000");
            lbl_qty3.setText(sCount_Sapi);
            

        }
        /*----------------------------------------------------------------------------------------*/
        else if(sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 3,4,5 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct1.setText("Tomat");
            lbl_hargaproduct1.setText("Rp 10.000");
            lbl_qty1.setText(sCount_Tomat);

            product2.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct2.setText("Bawang Merah");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText(sCount_Bawang_Merah);

            product3.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct3.setText("Ikan Kakap");
            lbl_hargaproduct3.setText("Rp 50.000");
            lbl_qty3.setText(sCount_Ikan);
            

        }
        /*----------------------------------------------------------------------------------------*/
        else if(sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 3,4,6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct1.setText("Tomat");
            lbl_hargaproduct1.setText("Rp 10.000");
            lbl_qty1.setText(sCount_Tomat);

            product2.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct2.setText("Bawang Merah");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText(sCount_Bawang_Merah);

            product3.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct3.setText("Sapi Import");
            lbl_hargaproduct3.setText("Rp 100.000");
            lbl_qty3.setText(sCount_Sapi);
            

        }
        /*----------------------------------------------------------------------------------------*/
        else if(sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 3,5,6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct1.setText("Tomat");
            lbl_hargaproduct1.setText("Rp 10.000");
            lbl_qty1.setText(sCount_Tomat);

            product2.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct2.setText("Ikan Kakap");
            lbl_hargaproduct2.setText("Rp 50.000");
            lbl_qty2.setText(sCount_Ikan);

            product3.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct3.setText("Sapi Import");
            lbl_hargaproduct3.setText("Rp 100.000");
            lbl_qty3.setText(sCount_Sapi);
            
        }
        /*----------------------------------------------------------------------------------------*/
        else if(sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 4,5,6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct1.setText("Bawang Merah");
            lbl_hargaproduct1.setText("Rp 10.000");
            lbl_qty1.setText(sCount_Bawang_Merah);

            product2.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct2.setText("Ikan Kakap");
            lbl_hargaproduct2.setText("Rp 50.000");
            lbl_qty2.setText(sCount_Ikan);

            product3.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct3.setText("Sapi Import");
            lbl_hargaproduct3.setText("Rp 100.000");
            lbl_qty3.setText(sCount_Sapi);
            

        }

        /*========================================================================================*/
        else if(!sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 1,2,3,4 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.VISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct2.setText("Pisang Raja");
            lbl_hargaproduct2.setText("Rp 20.000");
            lbl_qty2.setText(sCount_Pisang);

            product3.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct3.setText("Tomat");
            lbl_hargaproduct3.setText("Rp 10.000");
            lbl_qty3.setText(sCount_Tomat);

            product4.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct4.setText("Bawang Merah");
            lbl_hargaproduct4.setText("Rp 10.000");
            lbl_qty4.setText(sCount_Bawang_Merah);
            

        }
        /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 1,2,3,5 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.VISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct2.setText("Pisang Raja");
            lbl_hargaproduct2.setText("Rp 20.000");
            lbl_qty2.setText(sCount_Pisang);

            product3.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct3.setText("Tomat");
            lbl_hargaproduct3.setText("Rp 10.000");
            lbl_qty3.setText(sCount_Tomat);

            product4.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct4.setText("Ikan");
            lbl_hargaproduct4.setText("Rp 50.000");
            lbl_qty4.setText(sCount_Ikan);
            
        }
        /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 1,2,3,6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.VISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct2.setText("Pisang Raja");
            lbl_hargaproduct2.setText("Rp 20.000");
            lbl_qty2.setText(sCount_Pisang);

            product3.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct3.setText("Tomat");
            lbl_hargaproduct3.setText("Rp 10.000");
            lbl_qty3.setText(sCount_Tomat);

            product4.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct4.setText("Sapi Import");
            lbl_hargaproduct4.setText("Rp 100.000");
            lbl_qty4.setText(sCount_Sapi);
            

        }
        /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 1,2,4,5 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.VISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct2.setText("Pisang Raja");
            lbl_hargaproduct2.setText("Rp 20.000");
            lbl_qty2.setText(sCount_Pisang);

            product3.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct3.setText("Bawang Merah");
            lbl_hargaproduct3.setText("Rp 10.000");
            lbl_qty3.setText(sCount_Bawang_Merah);

            product4.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct4.setText("Ikan Kakap");
            lbl_hargaproduct4.setText("Rp 50.000");
            lbl_qty4.setText(sCount_Ikan);
            
        }
        /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 1,2,4,6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.VISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct2.setText("Pisang Raja");
            lbl_hargaproduct2.setText("Rp 20.000");
            lbl_qty2.setText(sCount_Pisang);

            product3.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct3.setText("Bawang Merah");
            lbl_hargaproduct3.setText("Rp 10.000");
            lbl_qty3.setText(sCount_Bawang_Merah);

            product4.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct4.setText("Sapi Import");
            lbl_hargaproduct4.setText("Rp 10.000");
            lbl_qty4.setText(sCount_Sapi);
            
        }

        /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 1,3,4,5 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.VISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct2.setText("Tomat");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText(sCount_Tomat);

            product3.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct3.setText("Bawang Merah");
            lbl_hargaproduct3.setText("Rp 10.000");
            lbl_qty3.setText(sCount_Bawang_Merah);

            product4.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct4.setText("Ikan Kakap");
            lbl_hargaproduct4.setText("Rp 50.000");
            lbl_qty4.setText(sCount_Ikan);
            
        }

        /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 1,3,4,6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.VISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct2.setText("Tomat");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText(sCount_Tomat);

            product3.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct3.setText("Bawang Merah");
            lbl_hargaproduct3.setText("Rp 10.000");
            lbl_qty3.setText(sCount_Bawang_Merah);

            product4.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct4.setText("Sapi Import");
            lbl_hargaproduct4.setText("Rp 100.000");
            lbl_qty4.setText(sCount_Sapi);
            
        }

        /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 1,3,5,6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct2.setText("Tomat");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText(sCount_Tomat);

            product3.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct3.setText("Ikan Kakap");
            lbl_hargaproduct3.setText("Rp 50.000");
            lbl_qty3.setText(sCount_Ikan);

            product3.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct4.setText("Sapi Import");
            lbl_hargaproduct4.setText("Rp 50.000");
            lbl_qty4.setText(sCount_Ikan);
            

        }

        /*----------------------------------------------------------------------------------------*/
        else if(sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 2,3,4,5 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.VISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct1.setText("Pisang Raja");
            lbl_hargaproduct1.setText("Rp 20.000");
            lbl_qty1.setText(sCount_Pisang);

            product2.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct2.setText("Tomat");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText(sCount_Tomat);

            product3.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct3.setText("Bawang Merah");
            lbl_hargaproduct3.setText("Rp 10.000");
            lbl_qty3.setText(sCount_Bawang_Merah);

            product4.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct4.setText("Ikan Kakap");
            lbl_hargaproduct4.setText("Rp 50.000");
            lbl_qty4.setText(sCount_Ikan);
            
        }
        /*----------------------------------------------------------------------------------------*/
        else if(sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 2,3,4,6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.VISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct1.setText("Pisang Raja");
            lbl_hargaproduct1.setText("Rp 20.000");
            lbl_qty1.setText(sCount_Pisang);

            product2.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct2.setText("Tomat");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText(sCount_Tomat);

            product3.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct3.setText("Bawang Merah");
            lbl_hargaproduct3.setText("Rp 10.000");
            lbl_qty3.setText(sCount_Bawang_Merah);

            product4.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct4.setText("Sapi Import");
            lbl_hargaproduct4.setText("Rp 100.000");
            lbl_qty4.setText(sCount_Sapi);
            
        }
        /*----------------------------------------------------------------------------------------*/
        else if(sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 2,3,5,6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.VISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct1.setText("Pisang Raja");
            lbl_hargaproduct1.setText("Rp 20.000");
            lbl_qty1.setText(sCount_Pisang);

            product2.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct2.setText("Tomat");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText(sCount_Tomat);

            product3.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct3.setText("Ikan Kakap");
            lbl_hargaproduct3.setText("Rp 50.000");
            lbl_qty3.setText(sCount_Ikan);

            product4.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct4.setText("Sapi Import");
            lbl_hargaproduct4.setText("Rp 100.000");
            lbl_qty4.setText(sCount_Sapi);
            
        }
        /*----------------------------------------------------------------------------------------*/
        else if(sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 3,4,5,6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.VISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct1.setText("Tomat");
            lbl_hargaproduct1.setText("Rp 10.000");
            lbl_qty1.setText(sCount_Tomat);

            product2.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct2.setText("Bawang Merah");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText(sCount_Bawang_Merah);

            product3.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct3.setText("Ikan Kakap");
            lbl_hargaproduct3.setText("Rp 50.000");
            lbl_qty3.setText(sCount_Ikan);

            product4.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct4.setText("Sapi Import");
            lbl_hargaproduct4.setText("Rp 100.000");
            lbl_qty4.setText(sCount_Sapi);
            

        }
        /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && sCount_Sapi.equals("0"))
        {
            System.out.println("if 1,2,3,4,5 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.VISIBLE);
            layout_5.setVisibility(View.VISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct2.setText("Pisang Raja");
            lbl_hargaproduct2.setText("Rp 20.000");
            lbl_qty2.setText(sCount_Pisang);

            product3.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct3.setText("Tomat");
            lbl_hargaproduct3.setText("Rp 10.000");
            lbl_qty3.setText(sCount_Tomat);

            product4.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct4.setText("Bawang Merah");
            lbl_hargaproduct4.setText("Rp 10.000");
            lbl_qty4.setText(sCount_Bawang_Merah);

            product5.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct5.setText("Ikan Kakap");
            lbl_hargaproduct5.setText("Rp 50.000");
            lbl_qty5.setText(sCount_Ikan);
            

        }
        /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 1,2,3,4,6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.VISIBLE);
            layout_5.setVisibility(View.VISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct2.setText("Pisang Raja");
            lbl_hargaproduct2.setText("Rp 20.000");
            lbl_qty2.setText(sCount_Pisang);

            product3.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct3.setText("Tomat");
            lbl_hargaproduct3.setText("Rp 10.000");
            lbl_qty3.setText(sCount_Tomat);

            product4.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct4.setText("Bawang Merah");
            lbl_hargaproduct4.setText("Rp 10.000");
            lbl_qty4.setText(sCount_Bawang_Merah);

            product5.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct5.setText("Sapi Import");
            lbl_hargaproduct5.setText("Rp 100.000");
            lbl_qty5.setText(sCount_Sapi);
            

        }
         /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 1,2,3,5,6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.VISIBLE);
            layout_5.setVisibility(View.VISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct2.setText("Pisang Raja");
            lbl_hargaproduct2.setText("Rp 20.000");
            lbl_qty2.setText(sCount_Pisang);

            product3.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct3.setText("Tomat");
            lbl_hargaproduct3.setText("Rp 10.000");
            lbl_qty3.setText(sCount_Tomat);

            product4.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct4.setText("Ikan Kakap");
            lbl_hargaproduct4.setText("Rp 50.000");
            lbl_qty4.setText(sCount_Ikan);

            product5.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct5.setText("Sapi Import");
            lbl_hargaproduct5.setText("Rp 100.000");
            lbl_qty5.setText(sCount_Sapi);
            

        }
        /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 1,2,4,5,6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.VISIBLE);
            layout_5.setVisibility(View.VISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct2.setText("Pisang Raja");
            lbl_hargaproduct2.setText("Rp 20.000");
            lbl_qty2.setText(sCount_Pisang);

            product3.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct3.setText("Bawang Merah");
            lbl_hargaproduct3.setText("Rp 10.000");
            lbl_qty3.setText(sCount_Bawang_Merah);

            product4.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct4.setText("Ikan Kakap");
            lbl_hargaproduct4.setText("Rp 50.000");
            lbl_qty4.setText(sCount_Ikan);

            product5.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct5.setText("Sapi Import");
            lbl_hargaproduct5.setText("Rp 100.000");
            lbl_qty5.setText(sCount_Sapi);
            

        }
        /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 1,3,4,5,6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.VISIBLE);
            layout_5.setVisibility(View.VISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct2.setText("Tomat");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText(sCount_Tomat);

            product3.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct3.setText("Bawang Merah");
            lbl_hargaproduct3.setText("Rp 10.000");
            lbl_qty3.setText(sCount_Bawang_Merah);

            product4.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct4.setText("Ikan Kakap");
            lbl_hargaproduct4.setText("Rp 50.000");
            lbl_qty4.setText(sCount_Ikan);

            product5.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct5.setText("Sapi Import");
            lbl_hargaproduct5.setText("Rp 100.000");
            lbl_qty5.setText(sCount_Sapi);
            

        }
        /*----------------------------------------------------------------------------------------*/
        else if(sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 2,3,4,5,6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.VISIBLE);
            layout_5.setVisibility(View.VISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            product1.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct1.setText("Pisang Raja");
            lbl_hargaproduct1.setText("Rp 20.000");
            lbl_qty1.setText(sCount_Pisang);

            product2.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct2.setText("Tomat");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText(sCount_Tomat);

            product3.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct3.setText("Bawang Merah");
            lbl_hargaproduct3.setText("Rp 10.000");
            lbl_qty3.setText(sCount_Bawang_Merah);

            product4.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct4.setText("Ikan Kakap");
            lbl_hargaproduct4.setText("Rp 50.000");
            lbl_qty4.setText(sCount_Ikan);

            product5.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct5.setText("Sapi Import");
            lbl_hargaproduct5.setText("Rp 100.000");
            lbl_qty5.setText(sCount_Sapi);
            

        }
        /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && !sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 1,2,3,4,5,6 --> run");
            layout_1.setVisibility(View.VISIBLE);
            layout_2.setVisibility(View.VISIBLE);
            layout_3.setVisibility(View.VISIBLE);
            layout_4.setVisibility(View.VISIBLE);
            layout_5.setVisibility(View.VISIBLE);
            layout_6.setVisibility(View.VISIBLE);

            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText(sCount_Apel);

            product2.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct2.setText("Pisang Raja");
            lbl_hargaproduct2.setText("Rp 20.000");
            lbl_qty2.setText(sCount_Pisang);

            product3.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct3.setText("Tomat");
            lbl_hargaproduct3.setText("Rp 10.000");
            lbl_qty3.setText(sCount_Tomat);

            product4.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct4.setText("Bawang Merah");
            lbl_hargaproduct4.setText("Rp 10.000");
            lbl_qty4.setText(sCount_Bawang_Merah);

            product5.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct5.setText("Ikan Kakap");
            lbl_hargaproduct5.setText("Rp 50.000");
            lbl_qty5.setText(sCount_Ikan);

            product6.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct6.setText("Sapi Import");
            lbl_hargaproduct6.setText("Rp 100.000");
            lbl_qty6.setText(sCount_Sapi);
            
        }

        /*========================================================================================*/
        /*else
        {
            System.out.println("else --> run");
            layout_1.setVisibility(View.INVISIBLE);
            layout_2.setVisibility(View.INVISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);
            btn_selesai.setEnabled(false);

            lbl_harga.setText("Total Rp 0,-");
            lbl_harga.setTextColor(getResources().getColor(R.color.colorWhite));
        }*/



    }

    /*============================================================================================*/
    public void setProduct()
    {
        layout_1.setVisibility(View.VISIBLE);
        layout_2.setVisibility(View.VISIBLE);
        layout_3.setVisibility(View.VISIBLE);
        layout_4.setVisibility(View.INVISIBLE);
        layout_5.setVisibility(View.INVISIBLE);
        layout_6.setVisibility(View.INVISIBLE);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        String sResep = (pref.getString("sResep", "0")).toString();

        if(sResep.equals("resep1"))
        {
            product1.setImageResource(R.drawable.product_apel);
            lbl_namaproduct1.setText("Apel Super");
            lbl_hargaproduct1.setText("Rp 30.000");
            lbl_qty1.setText("3");

            product2.setImageResource(R.drawable.product_pisang);
            lbl_namaproduct2.setText("Pisang Raja");
            lbl_hargaproduct2.setText("Rp 20.000");
            lbl_qty2.setText("2");

            product3.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct3.setText("Tomat");
            lbl_hargaproduct3.setText("Rp 10.000");
            lbl_qty3.setText("1");

            lbl_harga.setText("Total: Rp 120.000,-");
        }
        else
        {
            product1.setImageResource(R.drawable.product_tomat);
            lbl_namaproduct1.setText("Tomat");
            lbl_hargaproduct1.setText("Rp 10.000");
            lbl_qty1.setText("1");

            product2.setImageResource(R.drawable.product_bawang_merah);
            lbl_namaproduct2.setText("Bawang Merah");
            lbl_hargaproduct2.setText("Rp 10.000");
            lbl_qty2.setText("2");

            product3.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct3.setText("Sapi Import");
            lbl_hargaproduct3.setText("Rp 100.000");
            lbl_qty3.setText("1");

            lbl_harga.setText("Total: Rp 130.000,-");
        }

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
            public void afterTextChanged(Editable s) {
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
            public void afterTextChanged(Editable s) {
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

        lbl_qty3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
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

        lbl_qty4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
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
            public void afterTextChanged(Editable s) {
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
            public void afterTextChanged(Editable s) {
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
                Intent intent = new Intent(getBaseContext(), AfterLogin_Cart.class);
                startActivity(intent);
                finish();
            }
        });

        btn_lacak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AfterLogin_LacakDriver.class);
                startActivity(intent);
                finish();
            }
        });

        btn_copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getResepFromSession();

                editor.putString("sCount_Apel", "" + pref.getString("sCount_Apel", ""+sCount_Apel));
                editor.putString("sCount_Pisang", "" + pref.getString("sCount_Pisang",""+sCount_Pisang));
                editor.putString("sCount_Tomat", "" + pref.getString("sCount_Tomat",""+sCount_Tomat));
                editor.putString("sCount_Bawang_Merah", "" + pref.getString("sCount_Bawang_Merah",""+sCount_Bawang_Merah));
                editor.putString("sCount_Ikan", "" + pref.getString("sCount_Ikan",""+sCount_Ikan));
                editor.putString("sCount_Sapi", "" + pref.getString("sCount_Sapi",""+sCount_Sapi));
                editor.commit();

                System.out.println("[copy] sCount_Apel ---> " + pref.getString("sCount_Apel", "0"));
                System.out.println("[copy] sCount_Pisang ---> " + pref.getString("sCount_Pisang", "0"));
                System.out.println("[copy] sCount_Tomat ---> " + pref.getString("sCount_Tomat", "0"));
                System.out.println("[copy] sCount_Bawang_Merah ---> " + pref.getString("sCount_Bawang_Merah", "0"));
                System.out.println("[copy] sCount_Ikan ---> " + pref.getString("sCount_Ikan", "0"));
                System.out.println("[copy] sCount_Sapi ---> " + pref.getString("sCount_Sapi", "0"));

                Intent intent = new Intent(getBaseContext(), AfterLogin_Cart.class);
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

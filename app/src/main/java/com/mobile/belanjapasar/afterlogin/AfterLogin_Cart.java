package com.mobile.belanjapasar.afterlogin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mobile.belanjapasar.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tommy on 10/02/2016.
 */
public class AfterLogin_Cart extends AppCompatActivity {

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

    AppCompatButton btn_selesai;

    public int total = 0;
    public int count = 5;

    int a1,a2,a3,a4,a5;
    int b1,b2,b3,b4;
    int c1,c2,c3;
    int d1,d2;
    int e1;


    /*============================================================================================*/
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afterlogin_cart_activity_main);

        componentDeclare();
        getOrderedProduct();
        getTotal();
        spinnerListAdapter_product();
        productButtonListener();
        navigationButtonListener();
        //productImageListener();

    }
    /*============================================================================================*/
    public void componentDeclare()
    {
        lbl_harga = (AppCompatTextView) findViewById(R.id.lbl_harga);
        btn_cart = (AppCompatImageButton) findViewById(R.id.btn_cart);
        btn_lacak = (AppCompatImageButton) findViewById(R.id.btn_lacak);
        btn_resep = (AppCompatImageButton) findViewById(R.id.btn_resep);
        btn_selesai = (AppCompatButton) findViewById(R.id.btn_selesai);

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
            btn_selesai.setEnabled(false);

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
            btn_selesai.setEnabled(true);
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
            btn_selesai.setEnabled(true);
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
            btn_selesai.setEnabled(true);
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
            btn_selesai.setEnabled(true);
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
            btn_selesai.setEnabled(true);
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
            btn_selesai.setEnabled(true);
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
            btn_selesai.setEnabled(true);
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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);
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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);
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
            btn_selesai.setEnabled(true);
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
            btn_selesai.setEnabled(true);
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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);
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
            btn_selesai.setEnabled(true);
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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);
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
            btn_selesai.setEnabled(true);
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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);
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
            btn_selesai.setEnabled(true);
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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);
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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);
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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);
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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);
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
            btn_selesai.setEnabled(true);
        }
        /*----------------------------------------------------------------------------------------*/
        else if(!sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && sCount_Tomat.equals("0")
                && sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 1,2,5,6 --> run");
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

            product3.setImageResource(R.drawable.product_ikan);
            lbl_namaproduct3.setText("Ikan Kakap");
            lbl_hargaproduct3.setText("Rp 50.000");
            lbl_qty3.setText(sCount_Ikan);

            product4.setImageResource(R.drawable.product_sapi);
            lbl_namaproduct4.setText("Sapi Import");
            lbl_hargaproduct4.setText("Rp 100.000");
            lbl_qty4.setText(sCount_Sapi);
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);
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
            btn_selesai.setEnabled(true);
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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);
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
            btn_selesai.setEnabled(true);
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
            btn_selesai.setEnabled(true);
        }
        /*----------------------------------------------------------------------------------------*/
        else if(sCount_Apel.equals("0")
                && !sCount_Pisang.equals("0")
                && sCount_Tomat.equals("0")
                && !sCount_Bawang_Merah.equals("0")
                && !sCount_Ikan.equals("0")
                && !sCount_Sapi.equals("0"))
        {
            System.out.println("if 2,4,5,6 --> run");
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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);

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
            btn_selesai.setEnabled(true);
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
    public void navigationButtonListener()
    {
        btn_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(getBaseContext(), Login.class);
                startActivity(intent);*/
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

        btn_selesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //setSession
                final SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                final SharedPreferences.Editor editor = pref.edit();
                editor.putString("sTotalHarga", "" + total);

                String nama1 = lbl_namaproduct1.getText().toString().toUpperCase();
                String nama2 = lbl_namaproduct2.getText().toString().toUpperCase();
                String nama3 = lbl_namaproduct3.getText().toString().toUpperCase();
                String nama4 = lbl_namaproduct4.getText().toString().toUpperCase();
                String nama5 = lbl_namaproduct5.getText().toString().toUpperCase();
                String nama6 = lbl_namaproduct6.getText().toString().toUpperCase();

                int a = Integer.parseInt(lbl_qty1.getText().toString());
                int b = Integer.parseInt(lbl_qty2.getText().toString());
                int c = Integer.parseInt(lbl_qty3.getText().toString());
                int d = Integer.parseInt(lbl_qty4.getText().toString());
                int e = Integer.parseInt(lbl_qty5.getText().toString());
                int f = Integer.parseInt(lbl_qty6.getText().toString());

                /*-----------------------------------------------------------------*/
                if( a!=0 )
                {
                    System.out.println("IF A --> RUN");
                    if (nama1.contains("APEL")) {
                        System.out.println("APEL --> RUN");
                        System.out.println("APEL --> " + a);
                        editor.putString("sCount_Apel", "" + a);
                        editor.commit();
                    } else if (nama1.contains("PISANG")) {
                        System.out.println("PISANG --> RUN");
                        System.out.println("PISANG --> " + a);
                        editor.putString("sCount_Pisang", "" + a);
                        editor.commit();
                        a1 = Integer.parseInt(pref.getString("sCount_Pisang", "0"));
                    } else if (nama1.contains("TOMAT")) {
                        System.out.println("TOMAT --> RUN");
                        System.out.println("TOMAT --> " + a);
                        editor.putString("sCount_Tomat", "" + a);
                        editor.commit();
                        a2 = Integer.parseInt(pref.getString("sCount_Tomat", "0"));
                    } else if (nama1.contains("BAWANG")) {
                        System.out.println("BAWANG --> RUN");
                        System.out.println("BAWANG --> " + a);
                        editor.putString("sCount_Bawang_Merah", "" + a);
                        editor.commit();
                        a3 = Integer.parseInt(pref.getString("sCount_Bawang_Merah", "0"));
                    } else if (nama1.contains("IKAN")) {
                        System.out.println("IKAN --> RUN");
                        System.out.println("IKAN --> " + a);
                        editor.putString("sCount_Ikan", "" + a);
                        editor.commit();
                        a4 = Integer.parseInt(pref.getString("sCount_Ikan", "0"));
                    } else if (nama1.contains("SAPI")) {
                        System.out.println("SAPI --> RUN");
                        System.out.println("SAPI --> " + a);
                        editor.putString("sCount_Sapi", "" + a);
                        editor.commit();
                        a5 = Integer.parseInt(pref.getString("sCount_Sapi", "0"));
                    }
                }
                /*-----------------------------------------------------------------*/
                if( b!=0 ) {
                    System.out.println("IF B --> RUN");
                    if (nama2.contains("PISANG")) {
                        System.out.println("PISANG 2 --> RUN");
                        System.out.println("PISANG 2 --> " + b);
                        int total = a1+b;
                        editor.putString("sCount_Pisang", ""+total);
                        editor.commit();
                    } else if (nama2.contains("TOMAT")) {
                        System.out.println("TOMAT 2 --> RUN");
                        System.out.println("TOMAT 2 --> " + b);
                        int total = a2+b;
                        editor.putString("sCount_Tomat", ""+total);
                        editor.commit();
                        b1 = Integer.parseInt(pref.getString("sCount_Tomat", "0"));
                    } else if (nama2.contains("BAWANG")) {
                        System.out.println("BAWANG 2 --> RUN");
                        System.out.println("BAWANG 2 --> " + b);
                        int total = a3+b;
                        editor.putString("sCount_Bawang_Merah", ""+total);
                        editor.commit();
                        b2 = Integer.parseInt(pref.getString("sCount_Bawang_Merah", "0"));
                    } else if (nama2.contains("IKAN")) {
                        System.out.println("IKAN 2 --> RUN");
                        System.out.println("IKAN 2 --> " + b);
                        int total = a4+b;
                        editor.putString("sCount_Ikan", ""+total);
                        editor.commit();
                        b3 = Integer.parseInt(pref.getString("sCount_Ikan", "0"));
                    } else if (nama2.contains("SAPI")) {
                        System.out.println("SAPI 2 --> RUN");
                        System.out.println("SAPI 2 --> " + b);
                        int total = a5+b;
                        editor.putString("sCount_Sapi", ""+total);
                        editor.commit();
                        b4 = Integer.parseInt(pref.getString("sCount_Sapi", "0"));
                    }
                }
                /*-----------------------------------------------------------------*/
                if( c!=0 ) {
                    System.out.println("IF C --> RUN");
                    if (nama3.contains("TOMAT")) {
                        System.out.println("TOMAT 3 --> RUN");
                        System.out.println("TOMAT 3 --> " + c);
                        int total = b1+c;
                        editor.putString("sCount_Tomat", "" + total);
                        editor.commit();
                    } else if (nama3.contains("BAWANG")) {
                        System.out.println("BAWANG 3 --> RUN");
                        System.out.println("BAWANG 3 --> " + c);
                        int total = b2+c;
                        editor.putString("sCount_Bawang_Merah", ""+total);
                        editor.commit();
                        c1 = Integer.parseInt(pref.getString("sCount_Bawang_Merah", "0"));
                    } else if (nama3.contains("IKAN")) {
                        System.out.println("IKAN 3 --> RUN");
                        System.out.println("IKAN 3 --> " + c);
                        int total = b3+c;
                        editor.putString("sCount_Ikan", ""+total);
                        editor.commit();
                        c2 = Integer.parseInt(pref.getString("sCount_Ikan", "0"));
                    } else if (nama3.contains("SAPI")) {
                        System.out.println("SAPI 3 --> RUN");
                        System.out.println("SAPI 3 --> " + c);
                        int total = b4+c;
                        editor.putString("sCount_Sapi", ""+total);
                        editor.commit();
                        c3 = Integer.parseInt(pref.getString("sCount_Sapi", "0"));
                    }
                }
                /*-----------------------------------------------------------------*/
                if( d!=0) {
                    System.out.println("IF D --> RUN");
                    if (nama4.contains("BAWANG")) {
                        System.out.println("BAWANG 4 --> RUN");
                        System.out.println("BAWANG 4 --> " + d);
                        int total = c1+d;
                        editor.putString("sCount_Bawang_Merah", ""+total);
                        editor.commit();
                    } else if (nama4.contains("IKAN")) {
                        System.out.println("IKAN 4 --> RUN");
                        System.out.println("IKAN 4 --> " + d);
                        int total = c2+d;
                        editor.putString("sCount_Ikan", ""+total);
                        editor.commit();
                        d1 = Integer.parseInt(pref.getString("sCount_Ikan", "0"));
                    } else if (nama4.contains("SAPI")) {
                        System.out.println("SAPI 4 --> RUN");
                        System.out.println("SAPI 4 --> " + d);
                        int total = c3+d;
                        editor.putString("sCount_Sapi", ""+total);
                        editor.commit();
                        d2 = Integer.parseInt(pref.getString("sCount_Sapi", "0"));
                    }
                }
                /*-----------------------------------------------------------------*/
                if( e!=0) {
                    System.out.println("IF E --> RUN");
                    if (nama5.contains("IKAN")) {
                        System.out.println("IKAN 5 --> RUN");
                        System.out.println("IKAN 5 --> " + e);
                        int total = d1+e;
                        editor.putString("sCount_Ikan", "" + total);
                        editor.commit();
                    } else if (nama5.contains("SAPI")) {
                        System.out.println("SAPI 5 --> RUN");
                        System.out.println("SAPI 5 --> " + e);
                        int total = d2+e;
                        editor.putString("sCount_Sapi", ""+total);
                        editor.commit();
                        e1 = Integer.parseInt(pref.getString("sCount_Sapi", "0"));
                    }
                }
                /*-----------------------------------------------------------------*/
                if( f!=0) {
                    System.out.println("IF F --> RUN");
                    if (nama6.contains("SAPI")) {
                        System.out.println("SAPI 6 --> RUN");
                        System.out.println("SAPI 6 --> " + f);
                        int total = e1+e;
                        editor.putString("sCount_Sapi", ""+total);
                        editor.commit();
                    }
                }
                /*-----------------------------------------------------------------*/

                System.out.println("[cart - btn_selesai] sCount_Apel --> " + pref.getString("sCount_Apel", "0"));
                System.out.println("[cart - btn_selesai] sCount_Pisang --> " + pref.getString("sCount_Pisang", "0"));
                System.out.println("[cart - btn_selesai] sCount_Tomat --> " + pref.getString("sCount_Tomat", "0"));
                System.out.println("[cart - btn_selesai] sCount_Bawang_Merah --> " + pref.getString("sCount_Bawang_Merah", "0"));
                System.out.println("[cart - btn_selesai] sCount_Ikan --> " + pref.getString("sCount_Ikan", "0"));
                System.out.println("[cart - btn_selesai] sCount_Sapi --> " + pref.getString("sCount_Sapi", "0"));

                if(a==0 && b==0 && c==0 && d==0 && e==0 && f==0)
                {
                    Intent intent = new Intent(getBaseContext(), AfterLogin_Product.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Intent intent = new Intent(getBaseContext(), AfterLogin_AlamatPengiriman.class);
                    startActivity(intent);
                    finish();
                }
            }


        });

    }



    /*============================================================================================*/
    public void productButtonListener()
    {
        final SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        final SharedPreferences.Editor editor = pref.edit();

        btn_min1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = Integer.parseInt( lbl_qty1.getText().toString());

                if(count == 0){
                    lbl_qty1.setText("0");
                }
                else
                {
                    count--;
                    lbl_qty1.setText("" + count);
                    if (lbl_qty1.getText().toString().equals("0"))
                    {
                        String nama1 = lbl_namaproduct1.getText().toString().toUpperCase();
                        int a = 0;

                        if (nama1.contains("APEL")) {
                            editor.putString("sCount_Apel", "" + a);
                            editor.commit();
                        }
                        else if(nama1.contains("PISANG"))
                        {
                            editor.putString("sCount_Pisang", "" + a);
                            editor.commit();
                        }
                        else if(nama1.contains("TOMAT"))
                        {
                            editor.putString("sCount_Tomat", "" + a);
                            editor.commit();
                        }
                        else if(nama1.contains("BAWANG"))
                        {
                            editor.putString("sCount_Bawang_Merah", "" + a);
                            editor.commit();
                        }
                        else if(nama1.contains("IKAN"))
                        {
                            editor.putString("sCount_Ikan", "" + a);
                            editor.commit();
                        }
                        else if(nama1.contains("SAPI"))
                        {
                            editor.putString("sCount_Sapi", "" + a);
                            editor.commit();
                        }

                        lbl_qty1.setText("0");
                        lbl_qty2.setText("0");
                        lbl_qty3.setText("0");
                        lbl_qty4.setText("0");
                        lbl_qty5.setText("0");
                        lbl_qty6.setText("0");

                        System.out.println("[min 0] sCount_Apel --> " + pref.getString("sCount_Apel", "0"));
                        System.out.println("[min 0] sCount_Pisang --> "+pref.getString("sCount_Pisang", "0"));
                        System.out.println("[min 0] sCount_Tomat --> "+pref.getString("sCount_Tomat", "0"));
                        System.out.println("[min 0] sCount_Bawang_Merah --> "+pref.getString("sCount_Bawang_Merah", "0"));
                        System.out.println("[min 0] sCount_Ikan --> "+pref.getString("sCount_Ikan", "0"));
                        System.out.println("[min 0] sCount_Sapi --> " + pref.getString("sCount_Sapi", "0"));

                        getOrderedProduct();
                    }
                    else
                    {

                    }
                }
                getTotal();
            }
        });

        btn_plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count = Integer.parseInt( lbl_qty1.getText().toString());
                count++;
                lbl_qty1.setText("" + count);
                getTotal();

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
                    lbl_qty2.setText("" + count);
                    if (lbl_qty2.getText().toString().equals("0"))
                    {
                        String nama2 = lbl_namaproduct2.getText().toString().toUpperCase();
                        int a = 0;

                        if(nama2.contains("PISANG"))
                        {
                            editor.putString("sCount_Pisang", "" + a);
                            editor.commit();
                        }
                        else if(nama2.contains("TOMAT"))
                        {
                            editor.putString("sCount_Tomat", "" + a);
                            editor.commit();
                        }
                        else if(nama2.contains("BAWANG"))
                        {
                            editor.putString("sCount_Bawang_Merah", "" + a);
                            editor.commit();
                        }
                        else if(nama2.contains("IKAN"))
                        {
                            editor.putString("sCount_Ikan", "" + a);
                            editor.commit();
                        }
                        else if(nama2.contains("SAPI"))
                        {
                            editor.putString("sCount_Sapi", "" + a);
                            editor.commit();
                        }

                        lbl_qty1.setText("0");
                        lbl_qty2.setText("0");
                        lbl_qty3.setText("0");
                        lbl_qty4.setText("0");
                        lbl_qty5.setText("0");
                        lbl_qty6.setText("0");

                        System.out.println("[min 0] sCount_Apel --> " + pref.getString("sCount_Apel", "0"));
                        System.out.println("[min 0] sCount_Pisang --> "+pref.getString("sCount_Pisang", "0"));
                        System.out.println("[min 0] sCount_Tomat --> "+pref.getString("sCount_Tomat", "0"));
                        System.out.println("[min 0] sCount_Bawang_Merah --> "+pref.getString("sCount_Bawang_Merah", "0"));
                        System.out.println("[min 0] sCount_Ikan --> "+pref.getString("sCount_Ikan", "0"));
                        System.out.println("[min 0] sCount_Sapi --> " + pref.getString("sCount_Sapi", "0"));

                        getOrderedProduct();
                    }
                    else
                    {

                    }
                }
                getTotal();
            }
        });

        btn_plus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count = Integer.parseInt( lbl_qty2.getText().toString());
                count++;
                lbl_qty2.setText(""+count);
                getTotal();

            }
        });

        /* ------------------------------------------------------------------------------------- */
        btn_min3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = Integer.parseInt( lbl_qty3.getText().toString());

                if (count == 0) {
                    lbl_qty3.setText("0");

                } else {
                    count--;
                    lbl_qty3.setText("" + count);
                    if (lbl_qty3.getText().toString().equals("0"))
                    {
                        String nama3 = lbl_namaproduct3.getText().toString().toUpperCase();
                        int a = 0;

                        if(nama3.contains("TOMAT"))
                        {
                            editor.putString("sCount_Tomat", "" + a);
                            editor.commit();
                        }
                        else if(nama3.contains("BAWANG"))
                        {
                            editor.putString("sCount_Bawang_Merah", "" + a);
                            editor.commit();
                        }
                        else if(nama3.contains("IKAN"))
                        {
                            editor.putString("sCount_Ikan", "" + a);
                            editor.commit();
                        }
                        else if(nama3.contains("SAPI"))
                        {
                            editor.putString("sCount_Sapi", "" + a);
                            editor.commit();
                        }

                        lbl_qty1.setText("0");
                        lbl_qty2.setText("0");
                        lbl_qty3.setText("0");
                        lbl_qty4.setText("0");
                        lbl_qty5.setText("0");
                        lbl_qty6.setText("0");

                        System.out.println("[min 0] sCount_Apel --> " + pref.getString("sCount_Apel", "0"));
                        System.out.println("[min 0] sCount_Pisang --> "+pref.getString("sCount_Pisang", "0"));
                        System.out.println("[min 0] sCount_Tomat --> "+pref.getString("sCount_Tomat", "0"));
                        System.out.println("[min 0] sCount_Bawang_Merah --> "+pref.getString("sCount_Bawang_Merah", "0"));
                        System.out.println("[min 0] sCount_Ikan --> "+pref.getString("sCount_Ikan", "0"));
                        System.out.println("[min 0] sCount_Sapi --> " + pref.getString("sCount_Sapi", "0"));

                        getOrderedProduct();
                    }
                    else
                    {

                    }
                }

                getTotal();
            }
        });

        btn_plus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count = Integer.parseInt( lbl_qty3.getText().toString());
                count++;
                lbl_qty3.setText("" + count);
                getTotal();

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
                    if (lbl_qty4.getText().toString().equals("0"))
                    {
                        String nama4 = lbl_namaproduct4.getText().toString().toUpperCase();
                        int a = 0;

                        if(nama4.contains("BAWANG"))
                        {
                            editor.putString("sCount_Bawang_Merah", "" + a);
                            editor.commit();
                        }
                        else if(nama4.contains("IKAN"))
                        {
                            editor.putString("sCount_Ikan", "" + a);
                            editor.commit();
                        }
                        else if(nama4.contains("SAPI"))
                        {
                            editor.putString("sCount_Sapi", "" + a);
                            editor.commit();
                        }

                        lbl_qty1.setText("0");
                        lbl_qty2.setText("0");
                        lbl_qty3.setText("0");
                        lbl_qty4.setText("0");
                        lbl_qty5.setText("0");
                        lbl_qty6.setText("0");

                        System.out.println("[min 0] sCount_Apel --> " + pref.getString("sCount_Apel", "0"));
                        System.out.println("[min 0] sCount_Pisang --> "+pref.getString("sCount_Pisang", "0"));
                        System.out.println("[min 0] sCount_Tomat --> "+pref.getString("sCount_Tomat", "0"));
                        System.out.println("[min 0] sCount_Bawang_Merah --> "+pref.getString("sCount_Bawang_Merah", "0"));
                        System.out.println("[min 0] sCount_Ikan --> "+pref.getString("sCount_Ikan", "0"));
                        System.out.println("[min 0] sCount_Sapi --> " + pref.getString("sCount_Sapi", "0"));

                        getOrderedProduct();
                    }
                    else
                    {

                    }
                }

                getTotal();
            }
        });

        btn_plus4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count = Integer.parseInt( lbl_qty4.getText().toString());
                count++;
                lbl_qty4.setText("" + count);
                getTotal();

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

                    if (lbl_qty5.getText().toString().equals("0"))
                    {
                        String nama5 = lbl_namaproduct5.getText().toString().toUpperCase();
                        int a = 0;

                        if(nama5.contains("IKAN"))
                        {
                            editor.putString("sCount_Ikan", "" + a);
                            editor.commit();
                        }
                        else if(nama5.contains("SAPI"))
                        {
                            editor.putString("sCount_Sapi", "" + a);
                            editor.commit();
                        }

                        lbl_qty1.setText("0");
                        lbl_qty2.setText("0");
                        lbl_qty3.setText("0");
                        lbl_qty4.setText("0");
                        lbl_qty5.setText("0");
                        lbl_qty6.setText("0");

                        System.out.println("[min 0] sCount_Apel --> " + pref.getString("sCount_Apel", "0"));
                        System.out.println("[min 0] sCount_Pisang --> "+pref.getString("sCount_Pisang", "0"));
                        System.out.println("[min 0] sCount_Tomat --> "+pref.getString("sCount_Tomat", "0"));
                        System.out.println("[min 0] sCount_Bawang_Merah --> "+pref.getString("sCount_Bawang_Merah", "0"));
                        System.out.println("[min 0] sCount_Ikan --> "+pref.getString("sCount_Ikan", "0"));
                        System.out.println("[min 0] sCount_Sapi --> " + pref.getString("sCount_Sapi", "0"));

                        getOrderedProduct();
                    }
                    else
                    {

                    }
                }
                getTotal();
            }
        });

        btn_plus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count = Integer.parseInt( lbl_qty5.getText().toString());
                count++;
                lbl_qty5.setText("" + count);
                getTotal();

            }
        });
        /* ------------------------------------------------------------------------------------- */
        btn_min6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = Integer.parseInt(lbl_qty6.getText().toString());

                if(count == 0){
                    lbl_qty6.setText("0");
                }
                else {
                    System.out.println("[TEST] else ---> RUN");
                    count--;
                    lbl_qty6.setText(""+count);

                    if (lbl_qty6.getText().toString().equals("0"))
                    {
                        System.out.println("[TEST] if = 0 ---> RUN");

                        editor.putString("sCount_Sapi", "0");
                        editor.commit();

                        lbl_qty1.setText("0");
                        lbl_qty2.setText("0");
                        lbl_qty3.setText("0");
                        lbl_qty4.setText("0");
                        lbl_qty5.setText("0");
                        lbl_qty6.setText("0");

                        System.out.println("[min 0] sCount_Apel --> " + pref.getString("sCount_Apel", "0"));
                        System.out.println("[min 0] sCount_Pisang --> " + pref.getString("sCount_Pisang", "0"));
                        System.out.println("[min 0] sCount_Tomat --> "+pref.getString("sCount_Tomat", "0"));
                        System.out.println("[min 0] sCount_Bawang_Merah --> "+pref.getString("sCount_Bawang_Merah", "0"));
                        System.out.println("[min 0] sCount_Ikan --> "+pref.getString("sCount_Ikan", "0"));
                        System.out.println("[min 0] sCount_Sapi --> " + pref.getString("sCount_Sapi", "0"));

                        System.out.println("[TEST] getORDER ---> RUN");
                        getOrderedProduct();
                        System.out.println("[TEST] getORDER ---> DONE");
                    }
                    else
                    {

                    }
                }

                getTotal();
            }
        });

        btn_plus6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count = Integer.parseInt((String) lbl_qty6.getText());
                count++;
                lbl_qty6.setText(""+count);
                getTotal();

            }
        });
    }

    /*============================================================================================*/
    public void productImageListener()
    {
        product1 = (ImageView) findViewById(R.id.product1);
        product2 = (ImageView) findViewById(R.id.product2);
        product3 = (ImageView) findViewById(R.id.product3);

        lbl_qty1 = (TextView) findViewById(R.id.lbl_qty1);
        lbl_qty2 = (TextView) findViewById(R.id.lbl_qty2);
        lbl_qty3 = (TextView) findViewById(R.id.lbl_qty3);

        product1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count = (String) lbl_qty1.getText();

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
                String count = (String) lbl_qty2.getText();
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
                String count = (String) lbl_qty3.getText();
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

        //setSession
        final SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        final SharedPreferences.Editor editor = pref.edit();
        editor.putString("sTotalHarga", "" + total);

        String nama1 = lbl_namaproduct1.getText().toString().toUpperCase();
        String nama2 = lbl_namaproduct2.getText().toString().toUpperCase();
        String nama3 = lbl_namaproduct3.getText().toString().toUpperCase();
        String nama4 = lbl_namaproduct4.getText().toString().toUpperCase();
        String nama5 = lbl_namaproduct5.getText().toString().toUpperCase();
        String nama6 = lbl_namaproduct6.getText().toString().toUpperCase();

        int a = Integer.parseInt(lbl_qty1.getText().toString());
        int b = Integer.parseInt(lbl_qty2.getText().toString());
        int c = Integer.parseInt(lbl_qty3.getText().toString());
        int d = Integer.parseInt(lbl_qty4.getText().toString());
        int e = Integer.parseInt(lbl_qty5.getText().toString());
        int f = Integer.parseInt(lbl_qty6.getText().toString());

        /* ----------------------------------------------------------------- */
        if( a!=0 )
        {
            System.out.println("IF A --> RUN");
            if (nama1.contains("APEL")) {
                System.out.println("APEL --> RUN");
                System.out.println("APEL --> " + a);
                editor.putString("sCount_Apel", "" + a);
                editor.commit();
            } else if (nama1.contains("PISANG")) {
                System.out.println("PISANG --> RUN");
                System.out.println("PISANG --> " + a);
                editor.putString("sCount_Pisang", "" + a);
                editor.commit();
                a1 = Integer.parseInt(pref.getString("sCount_Pisang", "0"));
            } else if (nama1.contains("TOMAT")) {
                System.out.println("TOMAT --> RUN");
                System.out.println("TOMAT --> " + a);
                editor.putString("sCount_Tomat", "" + a);
                editor.commit();
                a2 = Integer.parseInt(pref.getString("sCount_Tomat", "0"));
            } else if (nama1.contains("BAWANG")) {
                System.out.println("BAWANG --> RUN");
                System.out.println("BAWANG --> " + a);
                editor.putString("sCount_Bawang_Merah", "" + a);
                editor.commit();
                a3 = Integer.parseInt(pref.getString("sCount_Bawang_Merah", "0"));
            } else if (nama1.contains("IKAN")) {
                System.out.println("IKAN --> RUN");
                System.out.println("IKAN --> " + a);
                editor.putString("sCount_Ikan", "" + a);
                editor.commit();
                a4 = Integer.parseInt(pref.getString("sCount_Ikan", "0"));
            } else if (nama1.contains("SAPI")) {
                System.out.println("SAPI --> RUN");
                System.out.println("SAPI --> " + a);
                editor.putString("sCount_Sapi", "" + a);
                editor.commit();
                a5 = Integer.parseInt(pref.getString("sCount_Sapi", "0"));
            }
        }
                /* ----------------------------------------------------------------- */
        if( b!=0 ) {
            System.out.println("IF B --> RUN");
            if (nama2.contains("PISANG")) {
                System.out.println("PISANG 2 --> RUN");
                System.out.println("PISANG 2 --> " + b);
                int total = a1+b;
                editor.putString("sCount_Pisang", ""+total);
                editor.commit();
            } else if (nama2.contains("TOMAT")) {
                System.out.println("TOMAT 2 --> RUN");
                System.out.println("TOMAT 2 --> " + b);
                int total = a2+b;
                editor.putString("sCount_Tomat", ""+total);
                editor.commit();
                b1 = Integer.parseInt(pref.getString("sCount_Tomat", "0"));
            } else if (nama2.contains("BAWANG")) {
                System.out.println("BAWANG 2 --> RUN");
                System.out.println("BAWANG 2 --> " + b);
                int total = a3+b;
                editor.putString("sCount_Bawang_Merah", ""+total);
                editor.commit();
                b2 = Integer.parseInt(pref.getString("sCount_Bawang_Merah", "0"));
            } else if (nama2.contains("IKAN")) {
                System.out.println("IKAN 2 --> RUN");
                System.out.println("IKAN 2 --> " + b);
                int total = a4+b;
                editor.putString("sCount_Ikan", ""+total);
                editor.commit();
                b3 = Integer.parseInt(pref.getString("sCount_Ikan", "0"));
            } else if (nama2.contains("SAPI")) {
                System.out.println("SAPI 2 --> RUN");
                System.out.println("SAPI 2 --> " + b);
                int total = a5+b;
                editor.putString("sCount_Sapi", ""+total);
                editor.commit();
                b4 = Integer.parseInt(pref.getString("sCount_Sapi", "0"));
            }
        }
                /* ----------------------------------------------------------------- */
        if( c!=0 ) {
            System.out.println("IF C --> RUN");
            if (nama3.contains("TOMAT")) {
                System.out.println("TOMAT 3 --> RUN");
                System.out.println("TOMAT 3 --> " + c);
                int total = b1+c;
                editor.putString("sCount_Tomat", "" + total);
                editor.commit();
            } else if (nama3.contains("BAWANG")) {
                System.out.println("BAWANG 3 --> RUN");
                System.out.println("BAWANG 3 --> " + c);
                int total = b2+c;
                editor.putString("sCount_Bawang_Merah", ""+total);
                editor.commit();
                c1 = Integer.parseInt(pref.getString("sCount_Bawang_Merah", "0"));
            } else if (nama3.contains("IKAN")) {
                System.out.println("IKAN 3 --> RUN");
                System.out.println("IKAN 3 --> " + c);
                int total = b3+c;
                editor.putString("sCount_Ikan", ""+total);
                editor.commit();
                c2 = Integer.parseInt(pref.getString("sCount_Ikan", "0"));
            } else if (nama3.contains("SAPI")) {
                System.out.println("SAPI 3 --> RUN");
                System.out.println("SAPI 3 --> " + c);
                int total = b4+c;
                editor.putString("sCount_Sapi", ""+total);
                editor.commit();
                c3 = Integer.parseInt(pref.getString("sCount_Sapi", "0"));
            }
        }
                /* ----------------------------------------------------------------- */
        if( d!=0) {
            System.out.println("IF D --> RUN");
            if (nama4.contains("BAWANG")) {
                System.out.println("BAWANG 4 --> RUN");
                System.out.println("BAWANG 4 --> " + d);
                int total = c1+d;
                editor.putString("sCount_Bawang_Merah", ""+total);
                editor.commit();
            } else if (nama4.contains("IKAN")) {
                System.out.println("IKAN 4 --> RUN");
                System.out.println("IKAN 4 --> " + d);
                int total = c2+d;
                editor.putString("sCount_Ikan", ""+total);
                editor.commit();
                d1 = Integer.parseInt(pref.getString("sCount_Ikan", "0"));
            } else if (nama4.contains("SAPI")) {
                System.out.println("SAPI 4 --> RUN");
                System.out.println("SAPI 4 --> " + d);
                int total = c3+d;
                editor.putString("sCount_Sapi", ""+total);
                editor.commit();
                d2 = Integer.parseInt(pref.getString("sCount_Sapi", "0"));
            }
        }
                /* ----------------------------------------------------------------- */
        if( e!=0) {
            System.out.println("IF E --> RUN");
            if (nama5.contains("IKAN")) {
                System.out.println("IKAN 5 --> RUN");
                System.out.println("IKAN 5 --> " + e);
                int total = d1+e;
                editor.putString("sCount_Ikan", "" + total);
                editor.commit();
            } else if (nama5.contains("SAPI")) {
                System.out.println("SAPI 5 --> RUN");
                System.out.println("SAPI 5 --> " + e);
                int total = d2+e;
                editor.putString("sCount_Sapi", ""+total);
                editor.commit();
                e1 = Integer.parseInt(pref.getString("sCount_Sapi", "0"));
            }
        }
                /* ----------------------------------------------------------------- */
        if( f!=0) {
            System.out.println("IF F --> RUN");
            if (nama6.contains("SAPI")) {
                System.out.println("SAPI 6 --> RUN");
                System.out.println("SAPI 6 --> " + f);
                int total = e1+e;
                editor.putString("sCount_Sapi", ""+total);
                editor.commit();
            }
        }
                /* ----------------------------------------------------------------- */

        System.out.println("[cart - btn_selesai] sCount_Apel --> " + pref.getString("sCount_Apel", "0"));
        System.out.println("[cart - btn_selesai] sCount_Pisang --> " + pref.getString("sCount_Pisang", "0"));
        System.out.println("[cart - btn_selesai] sCount_Tomat --> " + pref.getString("sCount_Tomat", "0"));
        System.out.println("[cart - btn_selesai] sCount_Bawang_Merah --> " + pref.getString("sCount_Bawang_Merah", "0"));
        System.out.println("[cart - btn_selesai] sCount_Ikan --> " + pref.getString("sCount_Ikan", "0"));
        System.out.println("[cart - btn_selesai] sCount_Sapi --> " + pref.getString("sCount_Sapi", "0"));

        Intent intent = new Intent(getBaseContext(), AfterLogin_Product.class);
        startActivity(intent);
        finish();

    }
    /*============================================================================================*/
}

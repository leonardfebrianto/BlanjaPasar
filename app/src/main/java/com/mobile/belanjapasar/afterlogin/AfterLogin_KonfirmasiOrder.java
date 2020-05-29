package com.mobile.belanjapasar.afterlogin;

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

import com.mobile.belanjapasar.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tommy on 10/02/2016.
 */
public class AfterLogin_KonfirmasiOrder extends AppCompatActivity {

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

    AppCompatButton btn_confirm;
    AppCompatButton btn_cancel;

    public int count = 5;


    /*============================================================================================*/
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afterlogin_konfirmasi_order_activity_main);

        componentDeclare();
        navigationButtonListener();
        getOrderedProduct();
        //spinnerListAdapter_product();
        //productButtonListener();
        //productImageListener();

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        String sTotalHarga = pref.getString("sTotalHarga", null);
        String sOngkir = pref.getString("sOngkir", null);

        int totalHarga = Integer.parseInt(sTotalHarga);
        int ongkir = Integer.parseInt(sOngkir);
        int GrandTotal = totalHarga + ongkir;

        lbl_harga.setText("Rp "+GrandTotal+".000,-");
        System.out.println("Total Harga: " + totalHarga);
        System.out.println("Total Harga: " + ongkir);
        System.out.println("Total Harga: " + GrandTotal);
    }

    /*============================================================================================*/
    public void navigationButtonListener()
    {
        btn_confirm = (AppCompatButton) findViewById(R.id.btn_confirm);
        btn_cancel = (AppCompatButton) findViewById(R.id.btn_cancel);

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AfterLogin_SelesaiOrder.class);
                startActivity(intent);
                finish();
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AfterLogin_Product.class);
                startActivity(intent);
                finish();
            }
        });

    }

    /*============================================================================================*/
    public void componentDeclare()
    {
        lbl_harga = (AppCompatTextView) findViewById(R.id.lbl_harga);

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

        System.out.println("sCount_Apel ---> " + sCount_Apel);
        System.out.println("sCount_Pisang ---> " + sCount_Pisang);
        System.out.println("sCount_Tomat ---> " + sCount_Tomat);
        System.out.println("sCount_Bawang_Merah ---> " + sCount_Bawang_Merah);
        System.out.println("sCount_Ikan ---> " + sCount_Ikan);
        System.out.println("sCount_Sapi ---> " + sCount_Sapi);

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
            lbl_qty2.setText(sCount_Tomat);

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
        else
        {
            System.out.println("else --> run");
            layout_1.setVisibility(View.INVISIBLE);
            layout_2.setVisibility(View.INVISIBLE);
            layout_3.setVisibility(View.INVISIBLE);
            layout_4.setVisibility(View.INVISIBLE);
            layout_5.setVisibility(View.INVISIBLE);
            layout_6.setVisibility(View.INVISIBLE);

            lbl_harga.setText("Total Rp 0,-");
            lbl_harga.setTextColor(getResources().getColor(R.color.colorWhite));
        }



    }

    /*============================================================================================*/
    public void productButtonListener()
    {
        btn_min1 = (Button) findViewById(R.id.btn_min1);
        btn_min2 = (Button) findViewById(R.id.btn_min2);
        btn_min3 = (Button) findViewById(R.id.btn_min3);

        btn_plus1 = (Button) findViewById(R.id.btn_plus1);
        btn_plus2 = (Button) findViewById(R.id.btn_plus2);
        btn_plus3 = (Button) findViewById(R.id.btn_plus3);

        lbl_qty1 = (TextView) findViewById(R.id.lbl_qty1);
        lbl_qty2 = (TextView) findViewById(R.id.lbl_qty2);
        lbl_qty3 = (TextView) findViewById(R.id.lbl_qty3);

        /* ------------------------------------------------------------------------------------- */
        btn_min1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = Integer.parseInt((String) lbl_qty1.getText());

                if(count == 0){
                    lbl_qty1.setText("0");
                }
                else {
                    count--;
                    lbl_qty1.setText(""+count);
                }
            }
        });

        btn_plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count = Integer.parseInt((String) lbl_qty1.getText());
                count++;
                lbl_qty1.setText(""+count);

            }
        });

        /* ------------------------------------------------------------------------------------- */
        btn_min2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = Integer.parseInt((String) lbl_qty2.getText());

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

                count = Integer.parseInt((String) lbl_qty2.getText());
                count++;
                lbl_qty2.setText("" + count);

            }
        });

        /* ------------------------------------------------------------------------------------- */
        btn_min3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = Integer.parseInt((String) lbl_qty3.getText());

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

                count = Integer.parseInt((String) lbl_qty3.getText());
                count++;
                lbl_qty3.setText("" + count);

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
    public void onBackPressed()
    {
        Intent intent = new Intent(getBaseContext(), AfterLogin_Product.class);
        startActivity(intent);
        finish();
    }

    /*============================================================================================*/
}

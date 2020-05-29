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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobile.belanjapasar.R;

/**
 * Created by Tommy on 10/02/2016.
 */
public class AfterLogin_SelesaiOrder extends AppCompatActivity {

    AppCompatTextView lbl_harga;
    private AppCompatButton btn_selesai;


    /*============================================================================================*/
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afterlogin_selesai_order_activity_main);

        addButtonListener();

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        String sTotalHarga = pref.getString("sTotalHarga", "0");
        String sOngkir = pref.getString("sOngkir", "0");

        lbl_harga = (AppCompatTextView) findViewById(R.id.lbl_harga);

        int totalHarga = Integer.parseInt(sTotalHarga);
        int ongkir = Integer.parseInt(sOngkir);
        int GrandTotal = totalHarga + ongkir;

        lbl_harga.setText("Rp "+GrandTotal+".000,-");
        System.out.println("Total Harga: " + totalHarga);
        System.out.println("Total Harga: " + ongkir);
        System.out.println("Total Harga: " + GrandTotal);
    }

    /*============================================================================================*/
    public void addButtonListener()
    {
        btn_selesai = (AppCompatButton) findViewById(R.id.btn_selesai);
        btn_selesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.commit();

                Intent intent = new Intent(getBaseContext(), AfterLogin_Product.class);
                startActivity(intent);
                finish();
            }
        });
    }


    /*============================================================================================*/
    public void onBackPressed()
    {
        /*Intent intent = new Intent(getBaseContext(), AfterLogin_Product.class);
        startActivity(intent);
        finish();*/
    }

    /*============================================================================================*/
}

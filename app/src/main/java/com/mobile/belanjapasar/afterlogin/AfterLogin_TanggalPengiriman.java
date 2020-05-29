package com.mobile.belanjapasar.afterlogin;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.mobile.belanjapasar.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.marcohc.robotocalendar.RobotoCalendarView;
import com.marcohc.robotocalendar.RobotoCalendarView.RobotoCalendarListener;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Tommy on 10/02/2016.
 */
public class AfterLogin_TanggalPengiriman extends AppCompatActivity implements RobotoCalendarListener {

    AppCompatSpinner sp_product_category;

    AppCompatImageButton btn_cart;
    AppCompatImageButton btn_lacak;
    AppCompatImageButton btn_resep;

    TextView lbl_ongkoskirim;

    AppCompatButton btn_ok;

    CalendarView calendar;

    public int count = 5;

    private RobotoCalendarView robotoCalendarView;
    private int currentMonthIndex;
    private Calendar currentCalendar;


    /*============================================================================================*/
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afterlogin_tanggal_pengiriman_activity_main);

        lbl_ongkoskirim = (TextView) findViewById(R.id.lbl_ongkoskirim);
        btn_ok = (AppCompatButton) findViewById(R.id.btn_ok);
        btn_ok.setEnabled(true);

        //initializeCalendar();
        calendar();
        navigationButtonListener();
        spinnerListAdapter_product();
    }

    /* ========================================================================================== */
    public void calendar()
    {
        // Gets the calendar from the view
        robotoCalendarView = (RobotoCalendarView) findViewById(R.id.robotoCalendarPicker);

        // Set listener, in this case, the same activity
        robotoCalendarView.setRobotoCalendarListener(this);

        // Initialize the RobotoCalendarPicker with the current index and date
        currentMonthIndex = 0;
        currentCalendar = Calendar.getInstance(Locale.getDefault());

        setCurrentDateMarker();

        /* -------------------------------------------------------------------------------------- */
        //getCurrentSisDateTime
        long currentDate = System.currentTimeMillis();
        SimpleDateFormat day = new SimpleDateFormat("dd");
        SimpleDateFormat month = new SimpleDateFormat("MM");
        SimpleDateFormat year = new SimpleDateFormat("yyyy");

        Date resultdate = new Date(currentDate);
        final int dayOfNow = Integer.parseInt(day.format(resultdate));
        final int monthOfNow = Integer.parseInt(month.format(resultdate));
        final int yearOfNow = Integer.parseInt(year.format(resultdate));

        robotoCalendarView.markDayAsSelectedDay(resultdate);

        /* -------------------------------------------------------------------------------------- */
        //setDefaultTanggalAntar
        final int weekend = currentCalendar.get(Calendar.DAY_OF_WEEK);

        if (weekend == 1 || weekend == 7) {
            String ongkir = "20";
            String tgl_antar = (dayOfNow +"/"+ monthOfNow +"/"+ yearOfNow);
            Toast.makeText(getApplicationContext(), dayOfNow + "/" + monthOfNow + "/" + yearOfNow + " (weekend)", Toast.LENGTH_SHORT).show();
            lbl_ongkoskirim.setText("Ongkir: Rp " + ongkir + ".000,-");

            //setSession
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("sOngkir", ongkir);
            editor.putString("sTglAntar", tgl_antar);
            editor.commit();

            System.out.println("sOngkir --> " + pref.getString("sOngkir", "null"));
            System.out.println("sTglAntar --> " + pref.getString("sTglAntar", "null"));
        }
        else {
            String ongkir = "10";
            String tgl_antar = (dayOfNow +"/"+ monthOfNow +"/"+ yearOfNow);
            Toast.makeText(getApplicationContext(), dayOfNow + "/" + monthOfNow + "/" + yearOfNow, Toast.LENGTH_SHORT).show();
            lbl_ongkoskirim.setText("Ongkir: Rp " + ongkir + ".000,-");

            //setSession
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("sOngkir", ongkir);
            editor.putString("sTglAntar", tgl_antar);
            editor.commit();

            System.out.println("sOngkir --> " + pref.getString("sOngkir", "null"));
            System.out.println("sTglAntar --> " + pref.getString("sTglAntar", "null"));
        }
    }

    /* ========================================================================================== */
    public void setCurrentDateMarker()
    {
        final Date date1;
        final Date date2;

        //setCurrentDate
        robotoCalendarView.markFirstUnderlineWithStyle(RobotoCalendarView.BLUE_COLOR, currentCalendar.getTime());

        //setPublicHoliday
        String values1 = "6-0-2016";
        String values2 = "13-0-2016";
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        try {
            date1 = format.parse(values1);
            date2 = format.parse(values2);

            System.out.println("getTime ---> " + currentCalendar.getTime());
            System.out.println("DATE1 ---> " + date1);
            System.out.println("DATE2 ---> " + date2);

            //belom bisa
            //robotoCalendarView.markSecondUnderlineWithStyle(RobotoCalendarView.RED_COLOR, date1);
            //robotoCalendarView.markFirstUnderlineWithStyle(RobotoCalendarView.RED_COLOR, date2);
        }
        catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /* ========================================================================================== */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    /* ========================================================================================== */
    @Override
    public void onDateSelected(Date date) {

        SimpleDateFormat day = new SimpleDateFormat("dd");
        SimpleDateFormat month = new SimpleDateFormat("MM");
        SimpleDateFormat year = new SimpleDateFormat("yyyy");

        //getCurrentSisDateTime
        long currentDate = System.currentTimeMillis();
        Date resultdate = new Date(currentDate);
        int dayOfNow = Integer.parseInt(day.format(resultdate));
        int monthOfNow = Integer.parseInt(month.format(resultdate));
        int yearOfNow = Integer.parseInt(year.format(resultdate));

        Calendar selected = Calendar.getInstance();
        selected.setTimeInMillis(date.getTime());
        final int dayOfWeek = selected.get(Calendar.DAY_OF_WEEK);
        System.out.println("DayOfWeek ---> " + dayOfWeek);

        /* -------------------------------------------------------------------------------------- */
        //getSelectedDate
        int selected_day = Integer.parseInt(day.format(date));
        int selected_month = Integer.parseInt(month.format(date));
        int selected_year = Integer.parseInt(year.format(date));

        /* -------------------------------------------------------------------------------------- */
        // Mark calendar day
        robotoCalendarView.markDayAsSelectedDay(date);

        // Mark that day with random colors
        final Random random = new Random(System.currentTimeMillis());
        final int style = random.nextInt(1);
        switch (style) {
            case 0:
                //robotoCalendarView.markFirstUnderlineWithStyle(RobotoCalendarView.BLUE_COLOR, date);
                break;
           /* case 1:
               //robotoCalendarView.markSecondUnderlineWithStyle(RobotoCalendarView.GREEN_COLOR, date);
                break;
            case 2:
                //robotoCalendarView.markFirstUnderlineWithStyle(RobotoCalendarView.RED_COLOR, date);
                break;*/
            default:
                break;
        }

        /* -------------------------------------------------------------------------------------- */
        if(selected_month > monthOfNow)
        {
            if (dayOfWeek == 1 || dayOfWeek == 7) {
                System.out.println("IF ---> RUN");

                btn_ok.setEnabled(true);

                String ongkir = "20";
                String tgl_antar = selected_day + "/" + selected_month + "/" + selected_year;
                Toast.makeText(getApplicationContext(), selected_day + "/" + selected_month + "/" + selected_year + " (weekend)", Toast.LENGTH_SHORT).show();
                lbl_ongkoskirim.setText("Ongkir: Rp " + ongkir + ".000,-");

                //setSession
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sOngkir", ongkir);
                editor.putString("sTglAntar", tgl_antar);
                editor.commit();

                System.out.println("sOngkir --> " + pref.getString("sOngkir", "null"));
                System.out.println("sTglAntar --> " + pref.getString("sTglAntar", "null"));
            }
            else {
                System.out.println("ELSE ---> RUN");

                btn_ok.setEnabled(true);

                String ongkir = "10";
                String tgl_antar = selected_day + "/" + selected_month + "/" + selected_year;
                Toast.makeText(getApplicationContext(), selected_day + "/" + selected_month + "/" + selected_year, Toast.LENGTH_SHORT).show();
                lbl_ongkoskirim.setText("Ongkir: Rp " + ongkir + ".000,-");

                //setSession
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sOngkir", ongkir);
                editor.putString("sTglAntar", tgl_antar);
                editor.commit();

                System.out.println("sOngkir --> " + pref.getString("sOngkir", "null"));
                System.out.println("sTglAntar --> " + pref.getString("sTglAntar", "null"));
            }
        }
        else {
            if (selected_day < dayOfNow) {
                System.out.println("IF ---> RUN");

                Toast.makeText(getApplicationContext(), "Anda tidak bisa memilih tanggal ini!", Toast.LENGTH_SHORT).show();
                lbl_ongkoskirim.setText("Ongkir: Rp 0,-");
                btn_ok.setEnabled(false);
            } else if (dayOfWeek == 1 || dayOfWeek == 7) {
                System.out.println("ELSE IF ---> RUN");

                btn_ok.setEnabled(true);

                String ongkir = "20";
                String tgl_antar = selected_day + "/" + selected_month + "/" + selected_year;
                Toast.makeText(getApplicationContext(), selected_day + "/" + selected_month + "/" + selected_year + " (weekend)", Toast.LENGTH_SHORT).show();
                lbl_ongkoskirim.setText("Ongkir: Rp " + ongkir + ".000,-");

                //setSession
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sOngkir", ongkir);
                editor.putString("sTglAntar", tgl_antar);
                editor.commit();

                System.out.println("sOngkir --> " + pref.getString("sOngkir", "null"));
                System.out.println("sTglAntar --> " + pref.getString("sTglAntar", "null"));
            } else {
                System.out.println("ELSE ---> RUN");

                btn_ok.setEnabled(true);

                String ongkir = "10";
                String tgl_antar = selected_day + "/" + selected_month + "/" + selected_year;
                Toast.makeText(getApplicationContext(), selected_day + "/" + selected_month + "/" + selected_year, Toast.LENGTH_SHORT).show();
                lbl_ongkoskirim.setText("Ongkir: Rp " + ongkir + ".000,-");

                //setSession
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("sOngkir", ongkir);
                editor.putString("sTglAntar", tgl_antar);
                editor.commit();

                System.out.println("sOngkir --> " + pref.getString("sOngkir", "null"));
                System.out.println("sTglAntar --> " + pref.getString("sTglAntar", "null"));
            }
        }

    }

    /* ========================================================================================== */
    public void onRightButtonClick() {
        currentMonthIndex++;
        updateCalendar();
    }

    /* ========================================================================================== */
    public void onLeftButtonClick() {
        if(currentMonthIndex==0) {
            //do nothing
        }
        else {
            currentMonthIndex--;
            updateCalendar();
        }
    }

    /* ========================================================================================== */
    private void updateCalendar() {
        currentCalendar = Calendar.getInstance(Locale.getDefault());
        currentCalendar.add(Calendar.MONTH, currentMonthIndex);
        robotoCalendarView.initializeCalendar(currentCalendar);

        /* ------------------------------------------------------------------------------------- */
        //getCurrentSisDateTime
        SimpleDateFormat month = new SimpleDateFormat("MM");
        SimpleDateFormat year = new SimpleDateFormat("yyyy");

        long currentDate = System.currentTimeMillis();
        Date resultdate = new Date(currentDate);
        String monthOfNow = (month.format(resultdate)).toString();

        int a = currentMonthIndex + Integer.parseInt(monthOfNow);
        int b = Integer.parseInt(monthOfNow);

        if(a==b) {
            setCurrentDateMarker();
        }
        else {

        }
    }

    /*============================================================================================*/
    public void navigationButtonListener() {
        btn_cart = (AppCompatImageButton) findViewById(R.id.btn_cart);
        btn_lacak = (AppCompatImageButton) findViewById(R.id.btn_lacak);
        btn_resep = (AppCompatImageButton) findViewById(R.id.btn_resep);
        btn_ok = (AppCompatButton) findViewById(R.id.btn_ok);

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

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AfterLogin_KonfirmasiOrder.class);
                startActivity(intent);
                finish();
            }
        });

    }

    /*============================================================================================*/
    public void spinnerListAdapter_product() {
        sp_product_category = (AppCompatSpinner) findViewById(R.id.sp_product_category);

        List<String> array = new ArrayList<String>();
        array.add("-- Pilih Produk --");
        array.add("Bumbu");
        array.add("Sayur");
        array.add("Daging");
        array.add("Seafood");

        ArrayAdapter<String> product = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, array);
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
                if (productItemSelected.equals("-- Pilih Produk --")) {
                    //do nothing
                } else {
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
    public void onBackPressed() {
        Intent intent = new Intent(getBaseContext(), AfterLogin_Product.class);
        startActivity(intent);
        finish();
    }


    /*============================================================================================*/
}

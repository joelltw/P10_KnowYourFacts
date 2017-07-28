package c347.rp.edu.sg.p10_knowyourfacts;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Fragment> al;
    MyFragmentPagerAdapter adapter;
    ViewPager vPager;

    AlarmManager am;

    Button btnReadLater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vPager = (ViewPager)findViewById(R.id.viewpager1);
        btnReadLater = (Button)findViewById(R.id.btnReadLater);

        FragmentManager fm = getSupportFragmentManager();

        al = new ArrayList<Fragment>();
        al.add(new Frag1());
        al.add(new Frag2());
        al.add(new Frag3());

        adapter = new MyFragmentPagerAdapter(fm, al);

        vPager.setAdapter(adapter);




        btnReadLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int max = vPager.getChildCount();
                if (vPager.getCurrentItem() < max-1){
                    int nextPage = vPager.getCurrentItem() + 1;
                    vPager.setCurrentItem(nextPage, true);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    //display random content
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.previous){
            if(vPager.getCurrentItem()> 0){
                vPager.setCurrentItem(vPager.getCurrentItem() -1,true);
            }
        }else if(item.getItemId() == R.id.next){
            //-1 because childCount is 3 but position is 2
            if(vPager.getCurrentItem()< vPager.getChildCount()-1){
                vPager.setCurrentItem(vPager.getCurrentItem() + 1,true);
            }
        }else if(item.getItemId() == R.id.random){
            Random r = new Random();
            int page = r.nextInt(vPager.getChildCount());
            vPager.setCurrentItem(page,true);
        }
        return super.onOptionsItemSelected(item);
    }
}

package com.example.sample.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.example.sample.R;
import com.example.sample.adapters.ViewPagerAdapter;
import com.example.sample.fragments.ScenarioOneFragment;
import com.example.sample.fragments.ScenarioTwoFragment;

/**
 * Created by Avinash
 */
public class NavigationActivity extends AppCompatActivity {

    private TabLayout mTabLayout;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(new Explode());
        }
        setContentView(R.layout.activity_navigation);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(mViewPager);

        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);
        setupTabs();

    }

    /**
     * create custom tabs with custom tab item layout
     */
    private void setupTabs() {

        TextView tabScenarioOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab_item, null);
        tabScenarioOne.setText(getString(R.string.scenario_one));
        mTabLayout.getTabAt(0).setCustomView(tabScenarioOne);

        TextView tabScenarioTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab_item, null);
        tabScenarioTwo.setText(getString(R.string.scenario_two));
        mTabLayout.getTabAt(1).setCustomView(tabScenarioTwo);

    }

    /**
     * add fragments to viewpager adapter
     * and add adapter to viewpager
     * @param viewPager
     */
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ScenarioOneFragment(), getString(R.string.scenario_one));
        adapter.addFragment(new ScenarioTwoFragment(), getString(R.string.scenario_two));
        viewPager.setAdapter(adapter);
    }

}

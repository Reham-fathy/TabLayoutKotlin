package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.example.tablayout.model.PagerAdapter
import com.example.tablayout.views.Home
import com.example.tablayout.views.Notifications
import com.example.tablayout.views.Search
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var pToolbar:Toolbar
    private lateinit var pTabs:TabLayout
    private lateinit var textView: TextView
    private lateinit var pagerAdapter: PagerAdapter
    private lateinit var viewPagerAdapter: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pToolbar=findViewById(R.id.pToolbar)
        pTabs=findViewById(R.id.tabs)
        textView=findViewById(R.id.textview)
        pToolbar.setTitle(" ")
        textView.setText("TabLayoutDemo: ")
        setSupportActionBar(pToolbar)
        viewPagerAdapter=findViewById(R.id.mypagerview)
        pagerAdapter= PagerAdapter(supportFragmentManager)
        pagerAdapter.addFragment(Home(),"")
        pagerAdapter.addFragment(Search(),"")
        pagerAdapter.addFragment(Notifications(),"")
        viewPagerAdapter.adapter=pagerAdapter
        pTabs.setupWithViewPager(viewPagerAdapter)
        pTabs.getTabAt(0)!!.setIcon(R.drawable.home)
        pTabs.getTabAt(1)!!.setIcon(R.drawable.search)
        pTabs.getTabAt(2)!!.setIcon(R.drawable.notifications)
    }
}
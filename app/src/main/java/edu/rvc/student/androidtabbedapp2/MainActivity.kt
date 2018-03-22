package edu.rvc.student.androidtabbedapp2

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // icons for tabs
    private val homeicons = intArrayOf(R.drawable.tab1, R.drawable.tab2, R.drawable.tab3, R.drawable.tab4)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        configureTabLayout()
    }

    private fun configureTabLayout() {
        //see https://developer.android.com/reference/android/R.drawable.html
        tab_layout.addTab(tab_layout.newTab().setIcon(homeicons[0]))
        tab_layout.addTab(tab_layout.newTab().setIcon(homeicons[1]))
        tab_layout.addTab(tab_layout.newTab().setIcon(homeicons[2]))
        tab_layout.addTab(tab_layout.newTab().setIcon(homeicons[3]))
        val adapter = TabPagerAdapter(supportFragmentManager,
                tab_layout.tabCount)
        pager.adapter = adapter

        pager.addOnPageChangeListener(
                TabLayout.TabLayoutOnPageChangeListener(tab_layout))
        tab_layout.addOnTabSelectedListener(object :
                TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                pager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }

        })
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

package com.example.utspember

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem

import java.util.ArrayList

import com.example.utspember.Class_Adapter.Companion.SPAN_COUNT_ONE
import com.example.utspember.Class_Adapter.Companion.SPAN_COUNT_TWO

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: Class_Adapter
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var items: MutableList<Item_data>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        initItemsData()

        gridLayoutManager = GridLayoutManager(this, SPAN_COUNT_ONE)
        itemAdapter = Class_Adapter(items, gridLayoutManager)
        recyclerView = findViewById<RecyclerView>(R.id.rv)
        recyclerView.adapter = itemAdapter
        recyclerView.layoutManager = gridLayoutManager




    }

    private fun initItemsData() {
        items = ArrayList<Item_data>(9).apply {
            add(Item_data(R.drawable.p, "Lathifatul 'Azzah", "1", 15))
            add(Item_data(R.drawable.u, "Zaky Irfani", "2", 16))
            add(Item_data(R.drawable.r, "Fawaidatuz Zuhda", "3", 17))
            add(Item_data(R.drawable.s, "Rona Naura Khalisa", "4", 18))
            add(Item_data(R.drawable.t, "Kayla Asiyatul Bilqis", "5", 19))
            add(Item_data(R.drawable.u, "M. Miftakhur Rizqi", "6", 20))
            add(Item_data(R.drawable.v, "Azzam Maulana", "7", 21))
            add(Item_data(R.drawable.w, "Auliya Nur Jannah", "8", 22))
            add(Item_data(R.drawable.x, "Nabila Zahra", "9", 23))
            add(Item_data(R.drawable.y, "Fellicia Angelica", "10", 24))
            add(Item_data(R.drawable.p, "Bunga Citra", "11", 30))
            add(Item_data(R.drawable.q, "Nur Ainiyah", "12", 23))
            add(Item_data(R.drawable.r, "Titik NUr Faridah", "13", 22))
            add(Item_data(R.drawable.s, "Felycia", "14", 21))
            add(Item_data(R.drawable.t, "Anissa Kamila", "15", 20))
            add(Item_data(R.drawable.u, "Maulana Haqiqi", "16", 29))
            add(Item_data(R.drawable.v, "Rizki Nazar", "17", 28))
            add(Item_data(R.drawable.w, "Nadia Vega", "18", 27))
            add(Item_data(R.drawable.x, "Nur Haslinda", "19", 26))
            add(Item_data(R.drawable.y, "Natasya Zalza Bila", "20", 25))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_list) {
            switchLayout()
            switchIcon(item)
            return true
        }else if(item.itemId == R.id.menu_grid) {
            switchLayoutG()
            switchIconG(item)
            return true

        }
        return super.onOptionsItemSelected(item)
    }



    private fun switchLayout() {

        gridLayoutManager.spanCount = SPAN_COUNT_ONE

        itemAdapter.notifyItemRangeChanged(0, itemAdapter.itemCount)
    }

    private fun switchIcon(item: MenuItem) {
        if (gridLayoutManager.spanCount == SPAN_COUNT_TWO) {
            item.setIcon(resources.getDrawable(R.drawable.ic_span_3))
        } else {
            item.setIcon(resources.getDrawable(R.drawable.ic_span_1))
        }
    }

    private fun switchLayoutG() {

        gridLayoutManager.spanCount = SPAN_COUNT_TWO

        itemAdapter.notifyItemRangeChanged(0, itemAdapter.itemCount)
    }

    private fun switchIconG(item: MenuItem) {
        if (gridLayoutManager.spanCount == SPAN_COUNT_TWO) {
            item.setIcon(resources.getDrawable(R.drawable.ic_span_3))
        } else {
            item.setIcon(resources.getDrawable(R.drawable.ic_span_1))
        }
    }


}
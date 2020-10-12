package com.mbustama.book

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_book_list.*
import kotlinx.android.synthetic.main.book_list.*
import modelo.BookModel.ITEMS

class BookListActivity : AppCompatActivity() {

    private var mTwoPane: Boolean = false
    private var authorIsAsc: Boolean = true
    private var titleIsAsc: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)
        setSupportActionBar(toolbar)

        if (book_detail_container != null) { // values-w900dp
            mTwoPane = true
        }
        setupRecyclerView(book_list)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = SimpleItemRecyclerViewAdapter(this, ITEMS, mTwoPane)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.sortbyauthor -> {
                authorIsAsc = if( authorIsAsc ) {
                    ITEMS.sortBy { it.author }
                    false
                }else {
                    ITEMS.sortByDescending{ it.author }
                    true
                }
                setupRecyclerView(book_list)
                true
            }
            R.id.sortbytitle -> {
                titleIsAsc = if( titleIsAsc ) {
                    ITEMS.sortBy { it.title }
                    false
                }else {
                    ITEMS.sortByDescending{ it.title }
                    true
                }
                setupRecyclerView(book_list)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

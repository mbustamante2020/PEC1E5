package com.mbustama.book

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_book_detail.*
import kotlinx.android.synthetic.main.book_detail.view.*
import modelo.BookModel


class BookDetailFragment : Fragment() {

    private var mItem: BookModel.BookItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments?.containsKey(ARG_ITEM_ID)!!) {
            mItem = BookModel.ITEM_MAP[arguments?.getString(ARG_ITEM_ID)]
            mItem?.let {
                activity?.toolbar_layout?.title = it.title
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.book_detail, container, false)

        mItem?.let {
            rootView.book_author.text = it.author
            rootView.book_date.text = it.publicationDate.toString()
            rootView.book_description.text = it.description
            rootView.book_image.setImageBitmap(BitmapFactory.decodeStream(context?.assets?.open("${it.URLimage}")))
        }
        return rootView
    }

    companion object {
        const val ARG_ITEM_ID = "item_id"
    }
}


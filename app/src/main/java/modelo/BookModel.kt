package modelo

import java.time.LocalDate
import java.time.Month
import java.util.ArrayList
import java.util.HashMap

object BookModel {

    val ITEMS: MutableList<BookItem> = ArrayList()
    val ITEM_MAP: MutableMap<String, BookItem> = HashMap()

    init {
        addItem(BookItem(
            0,
            "Title1",
            "Author5",
            LocalDate.of(2016, Month.OCTOBER, 13),
            "Description 1",
            "book1.jpg"
        ))
        addItem(BookItem(
            1,
            "Title2",
            "Author3",
            LocalDate.of(2018, Month.APRIL, 1),
            "Description 2",
            "book2.png"
        ))
        addItem(BookItem(
            2,
            "Title3",
            "Author7",
            LocalDate.of(2010, Month.JANUARY, 5),
            "Description 3",
            "book3.jpg"
        ))
        addItem(BookItem(
            3,
            "Title4",
            "Author1",
            LocalDate.of(2010, Month.JANUARY, 5),
            "Description 3",
            "book1.jpg"
        ))
        addItem(BookItem(
            4,
            "Title5",
            "Author7",
            LocalDate.of(2010, Month.JANUARY, 5),
            "Description 3",
            "book3.jpg"
        ))
        addItem(BookItem(
            5,
            "Title6",
            "Author6",
            LocalDate.of(2010, Month.JANUARY, 5),
            "Description 3",
            "book2.jpg"
        ))
        addItem(BookItem(
            6,
            "Title7",
            "Author8",
            LocalDate.of(2010, Month.JANUARY, 5),
            "Description 3",
            "book1.jpg"
        ))

    }

    private fun addItem(item: BookItem) {
        ITEMS.add(item)
        ITEM_MAP[item.identifier.toString()] = item
    }

    data class BookItem(val identifier: Int, val title: String, val author: String, val publicationDate: LocalDate, val description: String, val URLimage: String?) {
        override fun toString(): String = title
    }
}
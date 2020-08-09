package com.example.quotes.model

class QuoteRepository private constructor(private val quoteDao: QuoteDAO) {
    // This may seem redundant.
    // Imagine a code which also updates and checks the backend.
    fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes()

    companion object {
        // Singleton instantiation you already know and love
        @Volatile private var instance: QuoteRepository? = null

        fun getInstance(quoteDao: QuoteDAO) =
            instance ?: synchronized(this) {
                instance ?: QuoteRepository(quoteDao).also { instance = it }
            }
    }
}
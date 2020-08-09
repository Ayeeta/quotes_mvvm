package com.example.quotes.view

import androidx.lifecycle.ViewModel
import com.example.quotes.model.Quote
import com.example.quotes.model.QuoteRepository

class QuotesViewModel (private val quoteRepository: QuoteRepository) : ViewModel(){
    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}
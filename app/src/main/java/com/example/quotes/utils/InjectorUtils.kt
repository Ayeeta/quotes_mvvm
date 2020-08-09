package com.example.quotes.utils

import com.example.quotes.model.Database
import com.example.quotes.model.QuoteRepository
import com.example.quotes.view.QuotesViewModelFactory

object InjectorUtils {
    // This will be called from QuotesActivity
    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        // ViewModelFactory needs a repository, which in turn needs a DAO from a database
        // The whole dependency tree is constructed right here, in one place
        val quoteRepository = QuoteRepository.getInstance(Database.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}
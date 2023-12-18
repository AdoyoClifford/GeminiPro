package com.adoyo.geminipro.di

import com.adoyo.geminipro.data.ChatRepository
import com.adoyo.geminipro.data.ChatRepositoryImpl
import com.adoyo.geminipro.presentation.ChatViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    single<ChatRepository> { ChatRepositoryImpl() }
    viewModelOf(::ChatViewModel)
}
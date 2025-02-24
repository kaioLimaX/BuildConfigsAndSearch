package com.example.buildconfigsandsearch.di

import android.content.Context
import com.example.buildconfigsandsearch.ui.feature.config.model.ConfigBuilder
import com.example.buildconfigsandsearch.ui.feature.config.state.ConfigViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    single { ConfigBuilder() }

    viewModel { (context: Context) -> ConfigViewModel(context) }
}
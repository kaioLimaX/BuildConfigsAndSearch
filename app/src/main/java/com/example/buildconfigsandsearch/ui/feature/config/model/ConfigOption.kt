package com.example.buildconfigsandsearch.ui.feature.config.model

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.buildconfigsandsearch.R
import com.example.buildconfigsandsearch.ui.components.ConfigOptionIcon

enum class ConfigCategory{
    GENERAL,
    APP_PREFERENCES,
    CRITICAL_ACTIONS,
    SUPPORT,
    OTHERS

}

fun ConfigCategory.getDisplayName() : String{
    return when(this){
        ConfigCategory.GENERAL -> "Geral"
        ConfigCategory.APP_PREFERENCES -> "Preferências do aplicativo"
        ConfigCategory.CRITICAL_ACTIONS -> "Ações Críticas"
        ConfigCategory.SUPPORT -> "Suporte"
        ConfigCategory.OTHERS -> "outros"
    }
}

sealed class ConfigOption(
    open val name : String,
    open val type : Type,
    open val category : ConfigCategory = ConfigCategory.OTHERS,
    open val available : Boolean
){

    data class SelectableOption(
        override val name : String,
        override val type : Type,
        override val category : ConfigCategory = ConfigCategory.OTHERS,
        override val available : Boolean = true,
        val selected : Boolean
    ) : ConfigOption(name, type, category, available)

    data class EnabledOption(
        override val name : String,
        override val type : Type,
        override val category : ConfigCategory = ConfigCategory.OTHERS,
        override val available : Boolean = true,
        val enabled : Boolean
    ) : ConfigOption(name, type, category, available)


    sealed class Type(
        open val text: (Context) -> String,
        open val description : (Context) -> String = { "" },
        open val icon: @Composable () -> Unit,
        val info: (Context) -> String = { "" },
    ){
        object Theme : Type(
            {"Tema"},
            {"Alterar Temas"},
            {
                ConfigOptionIcon(
                    painter = painterResource(R.drawable.ic_bluetooth)
                )
            }

        )
    }
}
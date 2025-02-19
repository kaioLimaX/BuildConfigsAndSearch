package com.example.buildconfigsandsearch.ui.feature.config.model

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.buildconfigsandsearch.R
import com.example.buildconfigsandsearch.ui.components.ConfigOptionIcon
import com.example.buildconfigsandsearch.ui.theme.painter.IconsPainter

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
        val description : String,
        override val type : Type,
        override val category : ConfigCategory = ConfigCategory.OTHERS,
        override val available : Boolean = true,
        val selected : Boolean
    ) : ConfigOption(name, type, category, available)

    data class EnabledOption(
        override val name : String,
        val description : String,
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
                    painter = IconsPainter.ThemeIcon
                )
            }
        )
        object Battery : Type(
            {"Bateria"},
            {"Economia de Bateria"},
            {
                ConfigOptionIcon(
                    painter = IconsPainter.BatteryIcon
                )
            }
        )
        object About : Type(
            {"About"},
            {"Acessar inf sobre o app"},
            {
                ConfigOptionIcon(
                    painter = IconsPainter.AboutIcon
                )
            }
        )
        object Location : Type(
            {"Localização"},
            {"Ativar Localização"},
            {
                ConfigOptionIcon(
                    painter = IconsPainter.LocationIcon
                )
            }
        )
        object Mode : Type(
            {"AlterarModo"},
            {"Alterar entre modo Aviao"},
            {
                ConfigOptionIcon(
                    painter = IconsPainter.ModeIcon
                )
            }
        )
        object Sound : Type(
            {"Som"},
            {"Alterar Configuração de som"},
            {
                ConfigOptionIcon(
                    painter = IconsPainter.SoundIcon
                )
            }
        )



    }
}
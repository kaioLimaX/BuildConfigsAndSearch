package com.example.buildconfigsandsearch.ui.feature.config.model

import android.content.Context
import androidx.compose.runtime.Composable

data class ConfigSection(
    val name: String,
    val description: String? = null,
    val type: Type,
    val icon: @Composable () -> Unit,
    val options: List<ConfigOption>
) {
    enum class Type {
        GENERAL_CONFIG, SECURITY_CONFIG, ADVANCED_CONFIG;

        companion object {

            fun Type.text(context: Context): String = when (this) {
                GENERAL_CONFIG -> "Geral"
                SECURITY_CONFIG -> "Segurança"
                ADVANCED_CONFIG -> "Avançado"
            }
            fun Type.description(context: Context): String = when (this) {
                GENERAL_CONFIG -> "configurações gerais"
                SECURITY_CONFIG -> "configurações de segurança"
                ADVANCED_CONFIG -> "configurações avançadas"
            }

        }

    }
}
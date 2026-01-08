package com.example.ud6_ejemplo3.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Usuario(
    @SerialName(value = "id")
    val id: String = "",
    @SerialName(value = "nombre")
    val nombre: String,
    @SerialName(value = "contrasenya")
    val contrasenya: String,
    @SerialName(value = "pedidos")
    val pedidos: List<String>
)


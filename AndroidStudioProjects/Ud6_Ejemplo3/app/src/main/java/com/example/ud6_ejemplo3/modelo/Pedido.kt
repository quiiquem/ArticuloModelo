package com.example.ud6_ejemplo3.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class Pedido( //Intentando conectar los pedidos con productos
    @SerialName(value = "productoId")
    val productoId: String,
    @SerialName(value = "cantidad")
    val cantidad: Int
)


@Serializable
data class Producto(
    @SerialName(value= "id")
    val id: String = "",
    @SerialName(value = "nombre")
    val nombre: String,
    @SerialName(value = "precio")
    val precio: Int,
)


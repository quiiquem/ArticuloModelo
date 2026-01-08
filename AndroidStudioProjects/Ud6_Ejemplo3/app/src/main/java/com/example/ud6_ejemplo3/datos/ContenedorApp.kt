package com.example.ud6_ejemplo3.datos

import com.example.ud6_ejemplo3.conexion.TrabajadoresServicioApi
import com.example.ud6_ejemplo3.conexion.UsuariosServicioApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create

interface ContenedorApp {
    val trabajadorRepositorio: TrabajadorRepositorio

    val usuariosRepositorio: UsuarioRepositorio
}

//Contenedor App que guarde todos los datos, ya que separarlos sería como intentar hacer 2 jsons de lo mismo a la vez (un sinsentido)
class AppContenedor : ContenedorApp{

    private val baseUrl = "http://10.0.2.2:3000"

    private val json = Json { ignoreUnknownKeys = true }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

//Trabajadores
    private val servicioRetrofitTrabajadores: TrabajadoresServicioApi by lazy{
        retrofit.create(TrabajadoresServicioApi::class.java)
    }

    override val trabajadorRepositorio: TrabajadorRepositorio by lazy{
        ConexionTrabajadorRepositorio(servicioRetrofitTrabajadores)
    }

//Usuarios

    private val servicioRetrofitUsuarios: UsuariosServicioApi by lazy{
        retrofit.create(UsuariosServicioApi::class.java)
    }

    override val usuariosRepositorio: UsuarioRepositorio by lazy{
        ConexionUsuarioRepositorio(servicioRetrofitUsuarios)
    }
}

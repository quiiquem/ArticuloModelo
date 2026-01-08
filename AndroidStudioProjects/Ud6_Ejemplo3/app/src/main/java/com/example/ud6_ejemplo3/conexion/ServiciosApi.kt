package com.example.ud6_ejemplo3.conexion

import com.example.ud6_ejemplo3.modelo.Trabajador
import com.example.ud6_ejemplo3.modelo.Usuario
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

//Trabajadores
interface TrabajadoresServicioApi {
    @GET("trabajadores")
    suspend fun obtenerTrabajadores(): List<Trabajador>
    @POST("trabajadores")
    suspend fun insertarTrabajador(
        @Body trabajador: Trabajador
    ): Trabajador

    @PUT("trabajadores/{id}")
    suspend fun actualizarTrabajador(
        @Path("id") id: String,
        @Body trabajador: Trabajador
    ): Trabajador

    @DELETE("trabajadores/{id}")
    suspend fun eliminarTrabajador(
        @Path("id") id: String
    ): Trabajador
}

//Usuarios
interface UsuariosServicioApi {
    @GET("usuario")
    suspend fun obtenerUsuarios(): List<Usuario>

    @POST("usuario")
    suspend fun insertarUsuario(
        @Body usuario: Usuario
    ): Usuario

    @PUT("usuario/{id}")
    suspend fun actualizarUsuario(
        @Path("id") id: String,
        @Body usuario: Usuario
    ): Usuario

    @DELETE("usuario/{id}")
    suspend fun eliminarUsuario(
        @Path("id") id: String
    ): Usuario
}


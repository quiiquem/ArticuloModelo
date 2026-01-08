package com.example.ud6_ejemplo3.datos

import com.example.ud6_ejemplo3.conexion.UsuariosServicioApi
import com.example.ud6_ejemplo3.modelo.Usuario

interface UsuarioRepositorio{

    //Funciones suspend para que no se bloqueen mientras espera a tener los datos
    suspend fun obtenerUsuarios(): List<Usuario>
    suspend fun insertarUsuarios(usuario: Usuario): Usuario
    suspend fun actualizarUsuario(id: String, usuario: Usuario): Usuario
    suspend fun eliminarUsuario(id: String): Usuario
}


//Hacer la clase para guardar el servicioApi (Y pille las cosas necesarias correctamente)
class ConexionUsuarioRepositorio(
    private val usuariosServicioApi: UsuariosServicioApi) : UsuarioRepositorio {
    override suspend fun obtenerUsuarios(): List<Usuario> = usuariosServicioApi.obtenerUsuarios()
    override suspend fun insertarUsuarios(usuario: Usuario): Usuario = usuariosServicioApi.insertarUsuario(usuario)
    override suspend fun actualizarUsuario(id: String, usuario: Usuario): Usuario  = usuariosServicioApi.actualizarUsuario(id, usuario)
    override suspend fun eliminarUsuario(id: String): Usuario = usuariosServicioApi.eliminarUsuario(id)
}
    

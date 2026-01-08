package com.example.ud6_ejemplo3.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.ud6_ejemplo3.TrabajadorAplicacion
import com.example.ud6_ejemplo3.datos.TrabajadorRepositorio
import com.example.ud6_ejemplo3.datos.UsuarioRepositorio
import com.example.ud6_ejemplo3.modelo.Trabajador
import com.example.ud6_ejemplo3.modelo.Usuario
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface TrabajadorUIState {
    data class ObtenerExito(val trabajadores: List<Trabajador>) : TrabajadorUIState
    data class CrearExito(val trabajador: Trabajador) : TrabajadorUIState
    data class ActualizarExito(val trabajador: Trabajador) : TrabajadorUIState
    data class EliminarExito(val id: String) : TrabajadorUIState

    object Error : TrabajadorUIState
    object Cargando : TrabajadorUIState
}

class TrabajadorViewModel(private val trabajadorRepositorio: TrabajadorRepositorio) : ViewModel() {
    var trabajadorUIState: TrabajadorUIState by mutableStateOf(TrabajadorUIState.Cargando)
        private set

    var trabajadorPulsado: Trabajador by mutableStateOf(Trabajador("", "", "", ""))
        private set

    fun actualizarTrabajadorPulsado(trabajador: Trabajador){
        trabajadorPulsado = trabajador
    }

    init{
        obtenerTrabajadores()
    }

    fun obtenerTrabajadores() {
        viewModelScope.launch {
            trabajadorUIState = TrabajadorUIState.Cargando
            trabajadorUIState = try {
                val listaTrabajadores = trabajadorRepositorio.obtenerTrabajadores()
                TrabajadorUIState.ObtenerExito(listaTrabajadores)
            } catch (e: IOException){
                TrabajadorUIState.Error
            } catch (e: HttpException){
                TrabajadorUIState.Error
            }
        }
    }

    fun insertarTrabajador(trabajador: Trabajador) {
        viewModelScope.launch {
            trabajadorUIState = TrabajadorUIState.Cargando
            trabajadorUIState = try {
                val trabajadorInsertado = trabajadorRepositorio.insertarTrabajador(trabajador)
                TrabajadorUIState.CrearExito(trabajadorInsertado)
            } catch (e: IOException){
                TrabajadorUIState.Error
            } catch (e: HttpException){
                TrabajadorUIState.Error
            }
        }
    }

    fun actualizarTrabajador(id: String, trabajador: Trabajador) {
        viewModelScope.launch {
            trabajadorUIState = TrabajadorUIState.Cargando
            trabajadorUIState = try {
                val trabajadorActualizado = trabajadorRepositorio.actualizarTrabajador(
                    id = id,
                    trabajador = trabajador
                )
                TrabajadorUIState.ActualizarExito(trabajadorActualizado)
            } catch (e: IOException){
                TrabajadorUIState.Error
            } catch (e: HttpException){
                TrabajadorUIState.Error
            }
        }
    }

    fun eliminarTrabajador(id: String) {
        viewModelScope.launch {
            trabajadorUIState = TrabajadorUIState.Cargando
            trabajadorUIState = try {
                trabajadorRepositorio.eliminarTrabajador(id)
                TrabajadorUIState.EliminarExito(id)
            } catch (e: IOException){
                TrabajadorUIState.Error
            } catch (e: HttpException){
                TrabajadorUIState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val aplicacion = (this[APPLICATION_KEY] as TrabajadorAplicacion)
                val trabajadorRepositorio = aplicacion.contenedor.trabajadorRepositorio
                TrabajadorViewModel(trabajadorRepositorio = trabajadorRepositorio)
            }
        }
    }
}

sealed interface UsuarioUIState {
    data class ObtenerExito(val usuarios: List<Usuario>) : UsuarioUIState
    data class CrearExito(val usuarios: Usuario) : UsuarioUIState
    data class ActualizarExito(val usuario: Usuario): UsuarioUIState
    data class EliminarExito(val id: String): UsuarioUIState

    object Error: UsuarioUIState
    object Cargando: UsuarioUIState


class UsuarioViewModel(private val usuarioRepositorio: UsuarioRepositorio): ViewModel(){
    var usuarioUIState: UsuarioUIState by mutableStateOf(UsuarioUIState.Cargando)
        private set

    var usuarioPulsado: Usuario by mutableStateOf(Usuario("", "", "", listOf(""))) //puede ser que el listof nos fastidie pero bno hay q probar
        private set

    fun actualizarUsuarioPulsado(usuario: Usuario){
        usuarioPulsado = usuario
    }

    init{
        obtenerUsuarios()
    }

    fun obtenerUsuarios() {
        viewModelScope.launch {
            usuarioUIState = UsuarioUIState.Cargando
            usuarioUIState = try {
                val listaUsuarios = usuarioRepositorio.obtenerUsuarios()
                UsuarioUIState.ObtenerExito(listaUsuarios)
            } catch (e: IOException){
                UsuarioUIState.Error
            } catch (e: HttpException){
                UsuarioUIState.Error
            }
        }
    }

    fun insertarUsuario(usuario: Usuario) {
        viewModelScope.launch {
            usuarioUIState = UsuarioUIState.Cargando
            usuarioUIState = try {
                val usuarioInsertado = usuarioRepositorio.insertarUsuarios(usuario)
                UsuarioUIState.CrearExito(usuarioInsertado)
            } catch (e: IOException){
                UsuarioUIState.Error
            } catch (e: HttpException){
                UsuarioUIState.Error
            }
        }
    }

    fun actualizarUsuario(id: String, usuario: Usuario) {
        viewModelScope.launch {
            usuarioUIState = UsuarioUIState.Cargando
            usuarioUIState = try {
                val usuarioActualizado = usuarioRepositorio.actualizarUsuario(
                    id = id,
                    usuario = usuario
                )
                UsuarioUIState.ActualizarExito(usuarioActualizado)
            } catch (e: IOException){
                UsuarioUIState.Error
            } catch (e: HttpException){
                UsuarioUIState.Error
            }
        }
    }

    fun eliminarUsuario(id: String) {
        viewModelScope.launch {
            usuarioUIState = UsuarioUIState.Cargando
            usuarioUIState = try {
                usuarioRepositorio.eliminarUsuario(id)
                UsuarioUIState.EliminarExito(id)
            } catch (e: IOException){
                UsuarioUIState.Error
            } catch (e: HttpException){
                UsuarioUIState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val aplicacion = (this[APPLICATION_KEY] as TrabajadorAplicacion)
                val usuarioRepositorio = aplicacion.contenedor.usuariosRepositorio
                UsuarioViewModel(usuarioRepositorio = usuarioRepositorio)
            }
        }
    }
}
}

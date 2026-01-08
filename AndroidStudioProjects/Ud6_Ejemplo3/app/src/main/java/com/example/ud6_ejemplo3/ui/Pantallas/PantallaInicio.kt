import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ud6_ejemplo3.R
import com.example.ud6_ejemplo3.ui.Pantallas

@Composable
fun Mostrar_Inicio(){
    Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally){
       Text("Selecciona lo que va a gestionar")
        Row( modifier = Modifier,
            horizontalArrangement  = Arrangement.Center){

        //Boton para ver usuarios
        Button(onClick = {}){
            Text("Usuarios")
        }

        //Boton para ver traajadores
        Button(onClick = {}){
            Text("Trabajadores")
        }
        }
    }

}

enum class Pantallas(@StringRes val titulo: Int){

    PantallaInicio(R.string.pantalla_inicio),
    PantallaActualizar(R.string.actualizar),
    Pantalla_Lista(R.string.lista), //TODO: Cambiar el nombre a este
    PantallaInsertar(R.string.insertar)
}


//Navegacion (la misma función se llama asi)
@Composable

fun Navegacion(navController: NavHostController = rememberNavController()) {
    val pila by navController.currentBackStackEntryAsState()
    val pantallaActual: Pantallas =
        Pantallas.values().find { it.name == pila?.destination?.route } ?: Pantallas.Inicio
    Scaffold(
        topBar = {
            AppTopBar(
                pantallaActual = pantallaActual,
                puedeNavegarAtras = navController.previousBackStackEntry != null,
                onNavegarAtras = { navController.navigateUp() }
            )
        }) { innerPadding ->
        NavHost( //Navhost para poner las pantallas por donde pasará el usuario
            navController = navController,
            startDestination = Pantallas.Inicio.name,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(Pantallas.Inicio.name) {
                Pantallas.Inicio(
                    onBotonUsuario = {
                        navController.navigate(Pantallas.lista.name)
                    },
                    onBotonTrabajador = {
                        navController.navigate(Pantallas.lista.name)
                    }
                )
            }
        }
    }
}

//Top app bar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    pantallaActual: Pantallas,
    puedeNavegarAtras: Boolean,
    onNavegarAtras: () -> Unit
) {
    TopAppBar(
        title = { Text(stringResource(id = pantallaActual.titulo)) },
        navigationIcon = {
            if (puedeNavegarAtras) {
                IconButton(onClick = onNavegarAtras) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                }
            }
        }
    )
}
using articulomodelo.Backend.Modelo;
using articulomodelo.Frontend.ControlUsuario;
using articulomodelo.Frontend.Dialogos;
using articulomodelo.MVVM;
using MahApps.Metro.Controls;
using System.Windows;

namespace articulomodelo
{
    public partial class MainWindow : MetroWindow
    {
        private readonly MVArticulo _mvArticulo;
        private DialogoArticulo _dialogoArticulo;
        private DialogoModeloArticulo _dialogoModeloArticulo;
        private NuevoUsuario _nuevoUsuario;

        //Constructor MainWindow con las ventanas dialogo inyectadas (ahora si podemos pues pusimos los servicios en App.xaml.cs)
        public MainWindow(DialogoModeloArticulo dialogoModeloArticulo,
                          DialogoArticulo dialogoArticulo, MVArticulo mvArticulo, NuevoUsuario nuevoUsuario)
        {
            InitializeComponent();
            _dialogoModeloArticulo = dialogoModeloArticulo;
            _mvArticulo = mvArticulo;
            _nuevoUsuario = nuevoUsuario;
        }

        //Botones de la barra horizontal azul de arriba
        private void min_window_Click(object sender, RoutedEventArgs e)
        {
            this.WindowState = WindowState.Minimized; //maximizar la ventana
        }

        private void max_window_Click(object sender, RoutedEventArgs e)
        {
            if (this.WindowState == WindowState.Normal)
            {
                this.WindowState = WindowState.Maximized; //maximizar la ventana
            }
            else
            {
                this.WindowState = WindowState.Normal; //restaurar la ventana
            }
        }
        private void salir_Click(object sender, RoutedEventArgs e)
        {
            Application.Current.Shutdown(); //cerrar la aplicación
        }

        //Botones que abren dialogos (Crear, Borrar, Modificar...)
        //Crear dialogo
        private void Crear_Click(object sender, RoutedEventArgs e) //Ventana Dialogo Crear Articulo
        {

            //Generar una nueva cada que se inicia para que VM no explote
            var dialogo = new DialogoModeloArticulo(_mvArticulo); 
            dialogo.ShowDialog();
        }



        //TODO: hacer uno para articulo



        //Crear dialogo de borrar
        private void Borrar_Click(object sender, RoutedEventArgs e)
        {
            //TODO: Implementar VM a la ventana
            Window Eliminar_Articulo_Ventana = new Eliminar_Articulo(); //poner value a la ventana que quiero mostrar
            Eliminar_Articulo_Ventana.Show(); //hacer que se vea dicha ventana
        }

        private void NewUser_Click(object sender, RoutedEventArgs e)
        {
            var dialogo = new NuevoUsuario();
            dialogo.ShowDialog();
        }
    }
}
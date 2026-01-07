using articulomodelo.Frontend.ControlUsuario;
using MahApps.Metro.Controls;
using System.Windows;

namespace articulomodelo
{
    public partial class MainWindow : MetroWindow
    {
        public MainWindow() 
        {
            InitializeComponent();
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


        //Crear Funko
        private void Crear_Click(object sender, RoutedEventArgs e) //Ventana Dialogo Crear Articulo
        {
            Window Crear_Articulo_Ventana = new Crear_Articulo(); //poner value a la ventana que quiero mostrar
            Crear_Articulo_Ventana.Show(); //hacer que se vea dicha ventana
        }

        //Crear Borrar Funko
        private void Borrar_Click(object sender, RoutedEventArgs e)
        {
            Window Eliminar_Articulo_Ventana = new Eliminar_Articulo(); //poner value a la ventana que quiero mostrar
            Eliminar_Articulo_Ventana.Show(); //hacer que se vea dicha ventana
        }

     
    }
}
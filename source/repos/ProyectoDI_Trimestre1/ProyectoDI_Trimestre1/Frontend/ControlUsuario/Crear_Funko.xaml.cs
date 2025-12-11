using MahApps.Metro.Controls;
using ProyectoDI_Trimestre1.Frontend.Mensajes;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace ProyectoDI_Trimestre1.Frontend.Dialogos
{
    /// <summary>
    /// Lógica de interacción para Crear_Funko.xaml
    /// </summary>
    public partial class Crear_Funko : MetroWindow
    {
        public Crear_Funko()
        {
            InitializeComponent();
            CargarCategorias();
        }





        private void Hay_Stock(object sender, RoutedEventArgs e)
        {
            if (Stock.IsChecked == true)
            {
                stackPanelCantidad.Visibility = Visibility.Visible;

            } else
            {
                stackPanelCantidad.Visibility = Visibility.Collapsed;
            }
        }

        private static readonly Regex _regex = new Regex("[^0-9]+"); // todo lo que NO sea número
        //Asegurarnos que el usuario no pueda escribir letras en el campo cantidad
        private void cantidad_PreviewTextInput(object sender, TextCompositionEventArgs e)
        {
            e.Handled = !_regex.IsMatch(e.Text);
        }

        //Evitar que el usuario tambien pueda hacer espacio 
        private void cantidad_PreviewKeyDown(object sender, KeyEventArgs e)
        {
            if (e.Key == Key.Space)
            {
                e.Handled = true;
            }
        }

        //Y QUE USUARIO NO PUEDA PEGAR TEXTO TAMPOCO, NO.
        private void cantidad_Pasting(object sender, DataObjectPastingEventArgs e)
        {

        }

        private void Cancelar_Boton(object sender, RoutedEventArgs e)
        {
            MessageBoxResult result = MessageBox.Show( //Mostrar el cuadro de diálogo de cancelar
     "No has guardado los datos, ¿Estás seguro?","Cancelar",MessageBoxButton.YesNo,MessageBoxImage.Warning);

            // Puedes comprobar qué botón pulsó el usuario
            if (result == MessageBoxResult.Yes)
            {
                this.Close(); //cerrar solo esa ventana en concreto
            }
        }

        private async void Guardado(object sender, RoutedEventArgs e)
        {
          string nombre = nombre_funko.Text.Trim();
            string precio = precio_funko.Text.Trim();
            string categoria = categoria_funko.Text.Trim();
            bool hayStock = Stock.IsChecked == true;
            string cantidad_stock = cantidad.Text.Trim();
            // Validar que los campos obligatorios no estén vacíos
            if (string.IsNullOrEmpty(nombre) || string.IsNullOrEmpty(precio) || string.IsNullOrEmpty(categoria))
            {
                MensajeAdvertencia.Mostrar("Error de guardado, faltan los campos obligatorios.", "Warning");
                return;
            } else if (hayStock && string.IsNullOrEmpty(cantidad_stock))
            {
                MensajeError.Mostrar("Error de guardado, si hay stock debe indicar la cantidad.", "Error");
                return;
            }
        }


        private void CargarCategorias()
        {
            // Lógica para cargar categorías en el ComboBox 
            using var context = new Backend.Modelos.EnriqueMinguetProyectoContext();
           categoria_funko.ItemsSource = context.Categorias.ToList();
            categoria_funko.DisplayMemberPath = "Descripcion"; // Tienen que ser los publics que tenemos en el modelo de backend
            categoria_funko.SelectedValuePath = "Idcategorias"; // Valor seleccionado (clave primaria)
        }

        //Edición lo dejamos en TODO hasta que tenga la BD del proyecto intermodular y quite la de DI
        private void CargarEdiciones()
        {

        }

        private void precio_fumko_TextChanged(object sender, TextChangedEventArgs e)
        {

        }

 
    }
}
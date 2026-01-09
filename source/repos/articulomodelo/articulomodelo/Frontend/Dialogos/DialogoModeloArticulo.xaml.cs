using articulomodelo.MVVM;
using MahApps.Metro.Controls;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace articulomodelo.Frontend.Dialogos
{
    /// <summary>
    /// Interaction logic for DialogoModeloArticulo.xaml
    /// </summary>
    public partial class DialogoModeloArticulo : MetroWindow
    {
        private MVArticulo _mvArticulo; //declarar MVArticulo
        public DialogoModeloArticulo(MVArticulo mvArticulo)
        {
            InitializeComponent();
            _mvArticulo = mvArticulo;
        }

        private async void diagModeloArticulo_Loaded(object sender, RoutedEventArgs e)
        {
            await _mvArticulo.Inicializa();
            this.AddHandler(Validation.ErrorEvent, new RoutedEventHandler(_mvArticulo.OnErrorEvent));
            //Enlaza la parte visual con VM , usando el DataContext para que este conectada a la BD
            DataContext = _mvArticulo;
        }

        //BOTONES por activar

        //Boton de guardar modelo artículo
        private async void btnAnyadirModeloArticulo_Click(object sender, RoutedEventArgs e) // Guardar Modelo Artículo con metodo async
        {
            try
            {
                //Decirle al MVArticulo que guarde el modelo de artículo (usando el codigo que tiene VMArticulo)
                bool guardado = await _mvArticulo.GuardarModeloArticuloAsync();
                if (guardado)
                {
                    MessageBox.Show("Modelo de artículo guardado correctamente",
                                         "Éxito", MessageBoxButton.OK, MessageBoxImage.Information);
                    DialogResult = true; // cerrar ventana indicando éxito
                }
                else
                {
                    MessageBox.Show("Error al guardar el modelo de artículo",
                                         "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Se ha producido un error inesperado: " + ex.Message,
                                     "Error", MessageBoxButton.OK, MessageBoxImage.Error);
            }
        }
                private void btnCancelarModeloArticulo_Click(object sender, RoutedEventArgs e)
                {
                    DialogResult = false;
                }

    }
}

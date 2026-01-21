using articulomodelo.MVVM;
using System.Windows.Controls;

namespace articulomodelo.Frontend.ControlUsuario
{
    /// <summary>
    /// Interaction logic for UCListadoModelo.xaml
    /// </summary>
    public partial class UCListadoModelo : UserControl
    {
        private VMModeloArticulo _vmModeloArticulo;
        public UCListadoModelo(VMModeloArticulo vmModeloArticulo)
        {
            InitializeComponent();
           _vmModeloArticulo = vmModeloArticulo;
        }

        private async void usuario_listaAM_loaded(object sender, System.Windows.RoutedEventArgs e)
        {
            await _vmModeloArticulo.InicializarModelosArticulos();
            DataContext = _vmModeloArticulo;
        }
    }
}

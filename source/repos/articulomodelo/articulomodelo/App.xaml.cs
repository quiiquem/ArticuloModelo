using articulomodelo.Backend.Modelo;
using articulomodelo.Backend.Servicios;
using articulomodelo.Frontend.Dialogos;
using articulomodelo.MVVM;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Logging;
using System.Configuration;
using System.Data;
using System.Windows;

namespace articulomodelo
{
    /// <summary>
    /// Interaction logic for App.xaml
    /// </summary>
    public partial class App : Application
    {
        private DiinventarioexamenContext _contexto;
        /// Propiedad para almacenar el proveedor de servicios
        private IServiceProvider _serviceProvider;
        /// <summary>
        /// Constructor de la clase App
        /// </summary>
        public App()
        {
            // Configurar el contenedor de inyección de dependencias
            var serviceCollection = new ServiceCollection();
            // Configurar los servicios
            ConfigureServices(serviceCollection);
            // Construir el proveedor de servicios
            _serviceProvider = serviceCollection.BuildServiceProvider();
            _contexto = new DiinventarioexamenContext();
        }

        private void ConfigureServices(ServiceCollection services)
        {
            // Configurar el contexto de la base de datos
            services.AddDbContext<DiinventarioexamenContext>();

            // Configurar el servicio de logging
            services.AddLogging(configure => configure.AddConsole());

            // Registrar repositorios genéricos
            services.AddScoped(typeof(IGenericRepository<>), typeof(GenericRepository<>));

            // Registrar repositorios específicos (interfaces)
            services.AddScoped<IGenericRepository<Tipoarticulo>, TipoArticuloRepository>();
            services.AddScoped<IGenericRepository<Modeloarticulo>, ModeloArticuloRepository>();
            services.AddScoped<IGenericRepository<Articulo>, ArticuloRepository>();
            services.AddScoped<IGenericRepository<Usuario>, UsuarioRepository>();

            // Registrar repositorios específicos (clases concretas)
            services.AddScoped<UsuarioRepository>();
            services.AddScoped<ArticuloRepository>();
            services.AddScoped<ModeloArticuloRepository>();
            services.AddScoped<TipoArticuloRepository>();

            // MainWindow debería ser Transient, no Singleton
            services.AddTransient<MainWindow>();

            // Registrar ViewModels
            services.AddTransient<MVArticulo>();

            // Registrar ventanas y controles de usuario
            services.AddTransient<Login>();
            services.AddTransient<UCArticulos>();
            services.AddTransient<DialogoModeloArticulo>();
            services.AddTransient<DialogoArticulo>();
        }


        //Poner Login como ventana de inicio
        protected override void OnStartup(StartupEventArgs e)
        {
            // Se genera la ventana de Login
            var loginWindow = _serviceProvider.GetService<Login>();
            loginWindow.Show();
            base.OnStartup(e);
        }
    }
}

using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Logging;
using NLog;
//using ProyectoDI_Trimestre1.Backend.Modelos;
using ProyectoDI_Trimestre1.Backend.Repositorios;
using ProyectoDI_Trimestre1.Frontend.Dialogos;

using System.Configuration;
using System.Data;
using System.Windows;

namespace ProyectoDI_Trimestre1
{
    /// <summary>
    /// Interaction logic for App.xaml
    /// </summary>
    public partial class App : Application 
    {
        //private DiinventarioexamenContext _contexto;
        /// Propiedad para almacenar el proveedor de servicios
        private IServiceProvider _serviceProvider;

        private static readonly Logger logger = LogManager.GetCurrentClassLogger(); //Logger de NLog

        public App()
        {
            // Configurar el contenedor de inyección de dependencias
            var serviceCollection = new ServiceCollection();
            // Configurar los servicios
            ConfigureServices(serviceCollection);
            // Construir el proveedor de servicios
            _serviceProvider = serviceCollection.BuildServiceProvider(); //Creador de servicios
         //   _contexto = new DiinventarioexamenContext(); //Instancia de la BD
        }

        private void ConfigureServices(ServiceCollection services)
        {
            // Configurar el contexto de la base de datos
         //   services.AddDbContext<DiinventarioexamenContext>();
            // Configurar el servicio de logging
            services.AddLogging(configure => configure.AddConsole());
            // Registrar repositorios genéricos
          //  services.AddScoped(typeof(IGenericRepository<>), typeof(GenericRepository<>));
            // Registrar servicios y vistas aquí
            // En primer lugar registramos la ventana principal
            services.AddSingleton<MainWindow>();
            // A continuación, registramos los repositorios específicos
            // Lo hacemos con AddScoped para que se cree una nueva instancia
            // de cada repositorio por cada petición
   
          
            // Registramos los servicios específicos
            services.AddScoped<UsuarioRepository>();
            services.AddScoped<ArticuloRepository>();
            services.AddScoped<ModeloArticuloRepository>();
            services.AddScoped<TipoArticuloRepository>();
            services.AddScoped<UCArticulos>();
            // Registramos las interfaces de usuario
            services.AddTransient<Login>();
            services.AddTransient<UCArticulos>();
            services.AddTransient<DialogoModeloArticulo>();
        }


        protected override void OnStartup(StartupEventArgs e)
        {
            // Se genera la ventana de Login
            var loginWindow = _serviceProvider.GetService<Login>();
            loginWindow.Show();
            base.OnStartup(e);
        }
        protected override void OnExit(ExitEventArgs e)
        {
            logger.Info("Aplicación cerrada");
            base.OnExit(e);
        }

        public void MyMethod1()
        {
            logger.Trace("Sample trace message");
            logger.Debug("Sample debug message");
            logger.Info("Sample informational message");
            logger.Warn("Sample warning message");
            logger.Error("Sample error message");
            logger.Fatal("Sample fatal error message");
            logger.Log(NLog.LogLevel.Info, "Sample informational message");
        }
    }

  
}

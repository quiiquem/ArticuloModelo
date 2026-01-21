using articulomodelo.Backend.Modelo;
using articulomodelo.Backend.Servicios;
using articulomodelo.Frontend.Mensajes;
using articulomodelo.MVVM.Implementacion;
using ProyectoDI_Trimestre1.Frontend.Mensajes;

namespace articulomodelo.MVVM
{
    public class MVArticulo : MVBase
    {
        #region Campos y propiedades privadas

        /// <summary>
        /// Vincular a la vista para mostrar y editar datos de articulo no modelo
        private Articulo _articulo;
        /// <summary>
        /// Repositorio para gestionar las operaciones de datos relacionadas con los artículos
        private ArticuloRepository _articuloRepository;
        /// <summary>
        /// Repositorio para gestionar las operaciones de datos relacionadas con los modelo de artículo
        private ModeloArticuloRepository _modeloarticuloRepository;
        ///<summary>
        /// Repositorio para gestionar las operaciones de datos relacionadas con los espacios
        private EspacioRepository _espacioRepository;
        /// <summary>
        /// Repositorio para gestionar las operaciones de datos relacionadas con los usuarios
        /// </summary>
        private UsuarioRepository _usuarioRepository;

        ///Repositorio de departamentos
        private DepartamentoRepository _departamentoRepository;
        /// <summary>
        /// lista de los usuarios que hay en la base de datos
        /// </summary>
        private List<Usuario> _listaUsuarios;
        /// <summary>
        /// lista de los modelos (que es required)
        private List<Modeloarticulo> _listaModelosArticulos;
        /// <summary>
        /// lista de los espacios disponibles
        private List<Espacio> _listaEspacios;
        /// <summary>
        /// lista de los departamentos
        private List<Departamento> _listaDepartamentos;
        /// </summary>
        #endregion
        #region Getters y Setters
        public List<Usuario> listaUsuarios => _listaUsuarios;
        public List<Modeloarticulo> listaModelos => _listaModelosArticulos;
        public List<Espacio> listaEspacios => _listaEspacios;

        public List<Departamento> listaDepartamentos => _listaDepartamentos;

        // Lista personalizada para el estado
        public List<string?> ListaEstados { get; } = new() { null, // permite estado NULL
        "Nuevo", "Usado", "Dañado" };



        public Articulo articulo
        {
            get => _articulo;
            set => SetProperty(ref _articulo, value);
        }
        #endregion
        public MVArticulo(ArticuloRepository articuloRepository,
                              UsuarioRepository usuarioRepository,
                              ModeloArticuloRepository modeloarticuloRepository,
                              EspacioRepository espacioRepository,
                              DepartamentoRepository departamentoRepository)
        {
            _articuloRepository = articuloRepository;
            _usuarioRepository = usuarioRepository;
            _modeloarticuloRepository = modeloarticuloRepository;
            _espacioRepository = espacioRepository;
            _articulo = new Articulo();

        }

        //-----------------
        //DIALOGO ARTICULO
        //-----------------

        //Listar usuarios (Alta / Baja usuario)
        public async Task InicializarUsuarios()
        {
            try
            {
                _listaUsuarios = await GetAllAsync<Usuario>(_usuarioRepository);
                OnPropertyChanged(nameof(listaUsuarios));
            }
            catch (Exception ex)
            {
                MensajeError.Mostrar("GESTIÓN USUARIOS", "Error al cargar los usuarios\n" +
                    "No puedo conectar con la base de datos", 0);
            }
        }

        //Listar modelos (Campo obligatorio Modelo)
        //Listar modelos (Campo obligatorio Modelo)
        public async Task InicializarModelosArticulos()
        {
            try
            {
                System.Diagnostics.Debug.WriteLine("🔍 Intentando cargar modelos...");
                _listaModelosArticulos = await GetAllAsync<Modeloarticulo>(_modeloarticuloRepository);
                System.Diagnostics.Debug.WriteLine($"✅ Modelos cargados: {_listaModelosArticulos?.Count ?? 0}");
                OnPropertyChanged(nameof(listaModelos));
            }
            catch (Exception ex)
            {
                System.Diagnostics.Debug.WriteLine($"❌ ERROR AL CARGAR MODELOS:");
                System.Diagnostics.Debug.WriteLine($"   Mensaje: {ex.Message}");
                System.Diagnostics.Debug.WriteLine($"   InnerException: {ex.InnerException?.Message}");
                System.Diagnostics.Debug.WriteLine($"   StackTrace: {ex.StackTrace}");

                MensajeError.Mostrar("GESTIÓN MODELOS ARTÍCULOS",
                    $"Error al cargar los modelos de artículos\n{ex.Message}", 0);
            }
        }

        //Listar espacios (Campo obligatorio Espacio)
        public async Task InicializarEspacios()
        {
            try
            {
                _listaEspacios = await GetAllAsync<Espacio>(_espacioRepository);
                OnPropertyChanged(nameof(listaEspacios));
            }
            catch (Exception ex)
            {
                MensajeError.Mostrar("GESTIÓN ESPACIOS", "Error al cargar los espacios\n" +
                    "No puedo conectar con la base de datos", 0);
            }
        }


        //Listar departamentos (Campo opcional)
        public async Task IncializarDepartamentos()
        {
            try
            {
                _listaDepartamentos = await GetAllAsync<Departamento>(_departamentoRepository);
                OnPropertyChanged(nameof(listaDepartamentos));
            }
            catch (Exception ex)
            {
                MensajeError.Mostrar("GESTIÓN DEPARTAMENTOS", "Error al cargar los departamentos\n" +
                    "No puedo conectar con la base de datos", 0);
            }
        }

        //Guardar el articulo 

        public async Task<bool> GuardarArticuloAsync()
        {
            bool correcto = true;
            try
            {
                // ✅ SOLO sincronizar IDs, NO poner en null
                if (articulo.ModeloNavigation != null)
                {
                    articulo.Modelo = articulo.ModeloNavigation.Idmodeloarticulo;
                }

                if (articulo.EspacioNavigation != null)
                {
                    articulo.Espacio = articulo.EspacioNavigation.Idespacio;
                }

                if (articulo.UsuarioaltaNavigation != null)
                {
                    articulo.Usuarioalta = articulo.UsuarioaltaNavigation.Idusuario;
                }

                if (articulo.UsuariobajaNavigation != null)
                {
                    articulo.Usuariobaja = articulo.UsuariobajaNavigation.Idusuario;
                }

                if (articulo.DepartamentoNavigation != null)
                {
                    articulo.Departamento = articulo.DepartamentoNavigation.Iddepartamento;
                }

                if (articulo.DentrodeNavigation != null)
                {
                    articulo.Dentrode = articulo.DentrodeNavigation.Idarticulo;
                }

                System.Diagnostics.Debug.WriteLine($"Guardando - Modelo: {articulo.Modelo}, Espacio: {articulo.Espacio}");

                if (articulo.Idarticulo == 0)
                {
                    await _articuloRepository.AddAsync(articulo);
                }
                else
                {
                    await _articuloRepository.UpdateAsync(articulo);
                }
            }
            catch (Exception ex)
            {
                System.Diagnostics.Debug.WriteLine($"❌ ERROR: {ex.Message}");
                System.Diagnostics.Debug.WriteLine($"❌ INNER: {ex.InnerException?.Message}");
                correcto = false;
            }
            return correcto;
        }
    }
    }

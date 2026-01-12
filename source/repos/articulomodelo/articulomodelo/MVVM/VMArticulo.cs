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
            /// Objeto que guarda el modelo de artículo actual
            /// Está vinculado a la vista para mostrar y editar los datos del artículo
            /// </summary>
            private Modeloarticulo _modeloArticulo;
            /// <summary>
            /// Repositorio para gestionar las operaciones de datos relacionadas con los modelos de artículo
            /// </summary>
            private ModeloArticuloRepository _modeloArticuloRepository;
            /// <summary>
            /// Repositorio para gestionar las operaciones de datos relacionadas con los tipos de artículo
            /// </summary>
            private TipoArticuloRepository _tipoArticuloRepository;
            /// <summary>
            /// lista de tipos de artículos disponibles
            /// </summary>
            private List<Tipoarticulo> _listaTipoArticulos;
            #endregion
            #region Getters y Setters
            public List<Tipoarticulo> listaTiposArticulos => _listaTipoArticulos;
            public Modeloarticulo modeloArticulo
            {
                get => _modeloArticulo;
                set => SetProperty(ref _modeloArticulo, value);
            }
            #endregion
            // Aquí puedes añadir propiedades y métodos específicos para el ViewModel de Artículo
            public MVArticulo(ModeloArticuloRepository modeloArticuloRepository,
                              TipoArticuloRepository tipoArticuloRepository)
            {
                _modeloArticuloRepository = modeloArticuloRepository;
                _tipoArticuloRepository = tipoArticuloRepository;
                _modeloArticulo = new Modeloarticulo();
            }

            public async Task Inicializa()
            {
                try
                {
                    _listaTipoArticulos = await GetAllAsync<Tipoarticulo>(_tipoArticuloRepository);
                }
                catch (Exception ex)
                {
                    MensajeError.Mostrar("GESTIÓN ARTÍCULOS", "Error al cargar los tipos de artículos\n" +
                        "No puedo conectar con la base de datos", 0);
                }
            }

            public async Task<bool> GuardarModeloArticuloAsync()
            {
                bool correcto = true;
                try
                {
                    if (modeloArticulo.Idmodeloarticulo == 0)
                    {
                        // Nuevo modelo de artículo
                        await _modeloArticuloRepository.AddAsync(modeloArticulo);
                    }
                    else
                    {
                        // Actualizar modelo de artículo existente
                        await _modeloArticuloRepository.UpdateAsync(modeloArticulo);
                    }
                }
                catch (Exception ex)
                {
                    // Capturamos la excepción y la registramos en el log
                    correcto = false;
                }
                return correcto;
            }
        }
    }

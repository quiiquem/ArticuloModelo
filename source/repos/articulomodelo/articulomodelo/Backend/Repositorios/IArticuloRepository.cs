using articulomodelo.Backend.Modelo;

namespace articulomodelo.Backend.Servicios
{
    /// <summary>
    /// Interfaz específica para el repositorio de <see cref="Articulo"/>.
    /// Extiende las operaciones CRUD genéricas y añade consultas útiles para artículos.
    /// </summary>
    public interface IArticuloRepository : IGenericRepository<Articulo>
    {
        /// <summary>
        /// Obtiene el último identificador de la tabla de artículos.
        /// Devuelve 0 si no hay registros.
        /// </summary>
        /// <param name="cancellationToken">Token de cancelación.</param>
        Task<int> GetLastIdAsync();

        /// <summary>
        /// Comprueba si <paramref name="numserie"/> es único en la tabla de artículos.
        /// Devuelve true si no existe ningún artículo con ese número de serie.
        /// </summary>
        /// <param name="numserie">Número de serie a comprobar.</param>
        /// <param name="cancellationToken">Token de cancelación.</param>
        Task<bool> IsNumserieUniqueAsync(string numserie);

        /// <summary>
        /// Lista de valores válidos para el campo <c>Estado</c>.
        /// </summary>
        List<string> GetEstados();
    }
}
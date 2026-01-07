using articulomodelo.Backend.Modelo;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Logging;

namespace articulomodelo.Backend.Servicios
{
    /// <summary>
    /// Repositorio específico para la entidad <see cref="Articulo"/>.
    /// Implementa consultas comunes y utilidades relacionadas con artículos.
    /// </summary>
    public class ArticuloRepository : GenericRepository<Articulo>, IArticuloRepository
    {
        private static List<string> _estados = new List<string>
        {
            "Operativo",
            "Mantenimiento",
            "Obsoleto"
        };

        /// <summary>
        /// Crea una nueva instancia de <see cref="ArticuloRepository"/>.
        /// </summary>
        public ArticuloRepository(DiinventarioexamenContext context, ILogger<GenericRepository<Articulo>> logger)
            : base(context, logger)
        {
        }

        /// <inheritdoc/>
        public async Task<int> GetLastIdAsync()
        {
            try
            {
                // Si no hay registros, FirstOrDefaultAsync devolverá 0
                var lastId = await Query(asNoTracking: true)
                                   .OrderByDescending(a => a.Idarticulo)
                                   .Select(a => a.Idarticulo)
                                   .FirstOrDefaultAsync()
                                   .ConfigureAwait(false);
                return lastId;
            }
            catch (Exception)
            {
                // No tragar la excepción: relanzar para que la capa superior la maneje / loguee.
                throw;
            }
        }

        /// <inheritdoc/>
        public async Task<bool> IsNumserieUniqueAsync(string numserie)
        {
            if (string.IsNullOrWhiteSpace(numserie))
            {
                // Consideramos vacío como "único" (no hay colisión con un valor concreto).
                return true;
            }

            try
            {
                var exists = await Query(asNoTracking: true)
                                   .AnyAsync(a => a.Numserie == numserie)
                                   .ConfigureAwait(false);
                return !exists;
            }
            catch (Exception)
            {
                throw;
            }
        }

        /// <inheritdoc/>
        public List<string> GetEstados() => _estados;
    }
}
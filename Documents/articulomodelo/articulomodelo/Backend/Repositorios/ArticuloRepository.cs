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
        public ArticuloRepository(DiinventarioexamenContext context, ILogger<GenericRepository<Articulo>> logger)
            : base(context, logger)
        {
        }
    }
}
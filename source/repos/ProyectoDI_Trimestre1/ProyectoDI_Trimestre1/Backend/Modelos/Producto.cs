using System;
using System.Collections.Generic;

namespace ProyectoDI_Trimestre1.Backend.Modelos;

public partial class Producto
{
    public int IdProducto { get; set; }

    public string Nombre { get; set; } = null!;

    public decimal Precio { get; set; }

    public int? CantidadStock { get; set; }

    public DateTime? FechaIngreso { get; set; }

    public string? UbicacionAlmacen { get; set; }

    public string Categoria { get; set; } = null!;

    public int? EmpleadosIdEmpleado { get; set; }

    public int UbicacionIdUbicacion { get; set; }

    public virtual Ubicacion UbicacionIdUbicacionNavigation { get; set; } = null!;

    public virtual ICollection<Ventum> VentaIdventa { get; set; } = new List<Ventum>();
}

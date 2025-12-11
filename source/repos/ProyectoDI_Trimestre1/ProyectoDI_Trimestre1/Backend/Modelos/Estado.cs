using System;
using System.Collections.Generic;

namespace ProyectoDI_Trimestre1.Backend.Modelos;

public partial class Estado
{
    public int Idestado { get; set; }

    public string? Descripcion { get; set; }

    public virtual ICollection<EstadoHasProducto> EstadoHasProductos { get; set; } = new List<EstadoHasProducto>();
}

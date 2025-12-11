using System;
using System.Collections.Generic;

namespace ProyectoDI_Trimestre1.Backend.Modelos;

public partial class EstadoHasProducto
{
    public int EstadoIdestado { get; set; }

    public int ProductoIdProducto { get; set; }

    public virtual Estado EstadoIdestadoNavigation { get; set; } = null!;
}

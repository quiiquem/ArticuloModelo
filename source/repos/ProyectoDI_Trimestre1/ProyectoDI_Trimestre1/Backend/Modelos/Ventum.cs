using System;
using System.Collections.Generic;

namespace ProyectoDI_Trimestre1.Backend.Modelos;

public partial class Ventum
{
    public int Idventa { get; set; }

    public virtual ICollection<VentaHasCompra> VentaHasCompras { get; set; } = new List<VentaHasCompra>();

    public virtual ICollection<Producto> Productos { get; set; } = new List<Producto>();
}

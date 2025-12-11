using System;
using System.Collections.Generic;

namespace ProyectoDI_Trimestre1.Backend.Modelos;

public partial class VentaHasCompra
{
    public int VentaIdventa { get; set; }

    public int CompraIdcompra { get; set; }

    public int CompraProductoIdProducto { get; set; }

    public string CompraClienteDni { get; set; } = null!;

    public int CompraClienteCompranIdcompra { get; set; }

    public virtual Ventum VentaIdventaNavigation { get; set; } = null!;
}

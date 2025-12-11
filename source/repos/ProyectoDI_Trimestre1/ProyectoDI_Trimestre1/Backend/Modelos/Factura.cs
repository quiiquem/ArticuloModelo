using System;
using System.Collections.Generic;

namespace ProyectoDI_Trimestre1.Backend.Modelos;

public partial class Factura
{
    public int Idfactura { get; set; }

    public decimal? PrecioCompra { get; set; }

    public double? Iva { get; set; }

    public DateTime? Fecha { get; set; }

    public string? Facturacol { get; set; }

    public int CompraIdcompra { get; set; }

    public int CompraProductoIdProducto { get; set; }

    public string CompraClienteDni { get; set; } = null!;

    public int CompraClienteCompranIdcompra { get; set; }
}

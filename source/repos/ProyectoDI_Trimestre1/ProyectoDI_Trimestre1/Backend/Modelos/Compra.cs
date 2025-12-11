using System;
using System.Collections.Generic;

namespace ProyectoDI_Trimestre1.Backend.Modelos;

public partial class Compra
{
    public int Idcompra { get; set; }

    public int ProductoIdProducto { get; set; }

    public string ClienteDni { get; set; } = null!;

    public int CategoriasIdcategorias { get; set; }

    public virtual Categoria CategoriasIdcategoriasNavigation { get; set; } = null!;
}

using System;
using System.Collections.Generic;

namespace ProyectoDI_Trimestre1.Backend.Modelos;

public partial class Categoria
{
    public int Idcategorias { get; set; }

    public string? Descripcion { get; set; }

    public virtual ICollection<Compra> Compras { get; set; } = new List<Compra>();
}

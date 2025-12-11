using System;
using System.Collections.Generic;

namespace ProyectoDI_Trimestre1.Backend.Modelos;

public partial class Empleado
{
    public int IdEmpleado { get; set; }

    public string? Nombre { get; set; }

    public string? Apellidos { get; set; }

    public string? Usuario { get; set; }

    public string? Contraseña { get; set; }

    public int JefeIdJefe { get; set; }

    public int JefeEmpleadosIdEmpleado { get; set; }

    public int CompraIdcompra { get; set; }

    public int CompraProductoIdProducto { get; set; }

    public string CompraClienteDni { get; set; } = null!;

    public int CompraClienteCompranIdcompra { get; set; }

    public virtual Jefe JefeEmpleadosIdEmpleadoNavigation { get; set; } = null!;
}

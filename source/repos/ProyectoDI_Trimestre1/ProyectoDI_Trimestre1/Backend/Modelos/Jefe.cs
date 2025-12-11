using System;
using System.Collections.Generic;

namespace ProyectoDI_Trimestre1.Backend.Modelos;

public partial class Jefe
{
    public int EmpleadosIdEmpleado { get; set; }

    public virtual ICollection<Empleado> Empleados { get; set; } = new List<Empleado>();
}

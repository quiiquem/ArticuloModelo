using System;
using System.Collections.Generic;

namespace ProyectoDI_Trimestre1.Backend.Modelos;

public partial class Permiso
{
    public int Idpermisos { get; set; }

    public string? Descripcionpermiso { get; set; }

    public virtual ICollection<Role> RolesIdroles { get; set; } = new List<Role>();
}

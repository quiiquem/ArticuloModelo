using System;
using System.Collections.Generic;

namespace ProyectoDI_Trimestre1.Backend.Modelos;

public partial class Role
{
    public int Idroles { get; set; }

    public string Nombrerol { get; set; } = null!;

    public string? Descrol { get; set; }

    public int UsuariosIdusuario { get; set; }

    public virtual Usuario UsuariosIdusuarioNavigation { get; set; } = null!;

    public virtual ICollection<Permiso> PermisosIdpermisos { get; set; } = new List<Permiso>();
}

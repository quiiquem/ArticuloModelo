using System;
using System.Collections.Generic;

namespace ProyectoDI_Trimestre1.Backend.Modelos;

public partial class Usuario
{
    public int Idusuario { get; set; }

    public string NomUsuario { get; set; } = null!;

    public string ContraseñaUsuario { get; set; } = null!;

    public virtual ICollection<Cliente> Clientes { get; set; } = new List<Cliente>();

    public virtual ICollection<Role> Roles { get; set; } = new List<Role>();
}

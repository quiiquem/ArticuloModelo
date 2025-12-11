using System;
using System.Collections.Generic;

namespace ProyectoDI_Trimestre1.Backend.Modelos;

public partial class Cliente
{
    public string Dni { get; set; } = null!;

    public string Nombre { get; set; } = null!;

    public string? Apellidos { get; set; }

    public string? Dirección { get; set; }

    public string Email { get; set; } = null!;

    public int UsuariosIdusuario { get; set; }

    public virtual Usuario UsuariosIdusuarioNavigation { get; set; } = null!;
}

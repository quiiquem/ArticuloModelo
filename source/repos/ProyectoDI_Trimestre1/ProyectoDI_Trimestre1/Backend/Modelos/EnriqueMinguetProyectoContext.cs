using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;

namespace ProyectoDI_Trimestre1.Backend.Modelos;

public partial class EnriqueMinguetProyectoContext : DbContext
{
    public EnriqueMinguetProyectoContext()
    {
    }

    public EnriqueMinguetProyectoContext(DbContextOptions<EnriqueMinguetProyectoContext> options)
        : base(options)
    {
    }

    public virtual DbSet<Categoria> Categorias { get; set; }

    public virtual DbSet<Cliente> Clientes { get; set; }

    public virtual DbSet<Compra> Compras { get; set; }

    public virtual DbSet<Empleado> Empleados { get; set; }

    public virtual DbSet<Estado> Estados { get; set; }

    public virtual DbSet<EstadoHasProducto> EstadoHasProductos { get; set; }

    public virtual DbSet<Factura> Facturas { get; set; }

    public virtual DbSet<Jefe> Jeves { get; set; }

    public virtual DbSet<Permiso> Permisos { get; set; }

    public virtual DbSet<Producto> Productos { get; set; }

    public virtual DbSet<Role> Roles { get; set; }

    public virtual DbSet<Ubicacion> Ubicacions { get; set; }

    public virtual DbSet<Usuario> Usuarios { get; set; }

    public virtual DbSet<VentaHasCompra> VentaHasCompras { get; set; }

    public virtual DbSet<Ventum> Venta { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseMySQL("server=127.0.0.1;port=3306;database=enrique-minguet-proyecto;user=root;password=mysql");

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Categoria>(entity =>
        {
            entity.HasKey(e => e.Idcategorias).HasName("PRIMARY");

            entity.ToTable("categorias");

            entity.HasIndex(e => e.Idcategorias, "idcategorias_UNIQUE").IsUnique();

            entity.Property(e => e.Idcategorias).HasColumnName("idcategorias");
            entity.Property(e => e.Descripcion)
                .HasMaxLength(400)
                .HasColumnName("descripcion");
        });

        modelBuilder.Entity<Cliente>(entity =>
        {
            entity.HasKey(e => new { e.Dni, e.UsuariosIdusuario }).HasName("PRIMARY");

            entity.ToTable("cliente");

            entity.HasIndex(e => e.Email, "Email_UNIQUE").IsUnique();

            entity.HasIndex(e => e.UsuariosIdusuario, "fk_cliente_USUARIOS1_idx");

            entity.Property(e => e.Dni)
                .HasMaxLength(9)
                .HasColumnName("DNI");
            entity.Property(e => e.UsuariosIdusuario).HasColumnName("USUARIOS_IDUsuario");
            entity.Property(e => e.Apellidos).HasMaxLength(90);
            entity.Property(e => e.Dirección).HasMaxLength(80);
            entity.Property(e => e.Email).HasMaxLength(100);
            entity.Property(e => e.Nombre).HasMaxLength(45);

            entity.HasOne(d => d.UsuariosIdusuarioNavigation).WithMany(p => p.Clientes)
                .HasForeignKey(d => d.UsuariosIdusuario)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("fk_cliente_USUARIOS1");
        });

        modelBuilder.Entity<Compra>(entity =>
        {
            entity.HasKey(e => new { e.Idcompra, e.ProductoIdProducto, e.ClienteDni, e.CategoriasIdcategorias }).HasName("PRIMARY");

            entity.ToTable("compra");

            entity.HasIndex(e => e.ProductoIdProducto, "fk_COMPRAN_PRODUCTO1_idx");

            entity.HasIndex(e => e.CategoriasIdcategorias, "fk_compra_categorias1_idx");

            entity.HasIndex(e => e.ClienteDni, "fk_compran_cliente1_idx");

            entity.Property(e => e.Idcompra)
                .ValueGeneratedOnAdd()
                .HasColumnName("IDCompra");
            entity.Property(e => e.ProductoIdProducto).HasColumnName("PRODUCTO_ID_Producto");
            entity.Property(e => e.ClienteDni)
                .HasMaxLength(9)
                .HasColumnName("cliente_DNI");
            entity.Property(e => e.CategoriasIdcategorias).HasColumnName("categorias_idcategorias");

            entity.HasOne(d => d.CategoriasIdcategoriasNavigation).WithMany(p => p.Compras)
                .HasForeignKey(d => d.CategoriasIdcategorias)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("fk_compra_categoria");
        });

        modelBuilder.Entity<Empleado>(entity =>
        {
            entity.HasKey(e => new { e.IdEmpleado, e.JefeIdJefe, e.JefeEmpleadosIdEmpleado, e.CompraIdcompra, e.CompraProductoIdProducto, e.CompraClienteDni, e.CompraClienteCompranIdcompra }).HasName("PRIMARY");

            entity.ToTable("empleados");

            entity.HasIndex(e => e.Usuario, "Usuario_UNIQUE").IsUnique();

            entity.HasIndex(e => new { e.CompraIdcompra, e.CompraProductoIdProducto, e.CompraClienteDni, e.CompraClienteCompranIdcompra }, "fk_empleados_compra1_idx");

            entity.HasIndex(e => e.JefeEmpleadosIdEmpleado, "fk_empleados_jefe1");

            entity.HasIndex(e => new { e.JefeIdJefe, e.JefeEmpleadosIdEmpleado }, "fk_empleados_jefe1_idx");

            entity.HasIndex(e => e.JefeIdJefe, "jefe_idJEFE_UNIQUE").IsUnique();

            entity.Property(e => e.IdEmpleado)
                .ValueGeneratedOnAdd()
                .HasColumnName("ID_Empleado");
            entity.Property(e => e.JefeIdJefe).HasColumnName("jefe_idJEFE");
            entity.Property(e => e.JefeEmpleadosIdEmpleado).HasColumnName("jefe_empleados_ID_Empleado");
            entity.Property(e => e.CompraIdcompra).HasColumnName("compra_IDCompra");
            entity.Property(e => e.CompraProductoIdProducto).HasColumnName("compra_PRODUCTO_ID_Producto");
            entity.Property(e => e.CompraClienteDni)
                .HasMaxLength(9)
                .HasColumnName("compra_cliente_DNI");
            entity.Property(e => e.CompraClienteCompranIdcompra).HasColumnName("compra_cliente_COMPRAN_IDCompra");
            entity.Property(e => e.Apellidos).HasMaxLength(90);
            entity.Property(e => e.Contraseña).HasMaxLength(60);
            entity.Property(e => e.Nombre).HasMaxLength(30);
            entity.Property(e => e.Usuario).HasMaxLength(60);

            entity.HasOne(d => d.JefeEmpleadosIdEmpleadoNavigation).WithMany(p => p.Empleados)
                .HasForeignKey(d => d.JefeEmpleadosIdEmpleado)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("fk_empleados_jefe1");
        });

        modelBuilder.Entity<Estado>(entity =>
        {
            entity.HasKey(e => e.Idestado).HasName("PRIMARY");

            entity.ToTable("estado");

            entity.Property(e => e.Idestado).HasColumnName("idestado");
            entity.Property(e => e.Descripcion)
                .HasMaxLength(400)
                .HasColumnName("descripcion");
        });

        modelBuilder.Entity<EstadoHasProducto>(entity =>
        {
            entity.HasKey(e => new { e.EstadoIdestado, e.ProductoIdProducto }).HasName("PRIMARY");

            entity.ToTable("estado_has_producto");

            entity.HasIndex(e => e.EstadoIdestado, "fk_estado_has_producto_estado1_idx");

            entity.HasIndex(e => e.ProductoIdProducto, "fk_estado_has_producto_producto1_idx");

            entity.Property(e => e.EstadoIdestado).HasColumnName("estado_idestado");
            entity.Property(e => e.ProductoIdProducto).HasColumnName("producto_ID_Producto");

            entity.HasOne(d => d.EstadoIdestadoNavigation).WithMany(p => p.EstadoHasProductos)
                .HasForeignKey(d => d.EstadoIdestado)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("fk_estado_has_producto_estado1");
        });

        modelBuilder.Entity<Factura>(entity =>
        {
            entity.HasKey(e => new { e.Idfactura, e.CompraIdcompra, e.CompraProductoIdProducto, e.CompraClienteDni, e.CompraClienteCompranIdcompra }).HasName("PRIMARY");

            entity.ToTable("factura");

            entity.HasIndex(e => new { e.CompraIdcompra, e.CompraProductoIdProducto, e.CompraClienteDni, e.CompraClienteCompranIdcompra }, "fk_factura_compra1");

            entity.Property(e => e.Idfactura).HasColumnName("IDFactura");
            entity.Property(e => e.CompraIdcompra).HasColumnName("compra_IDCompra");
            entity.Property(e => e.CompraProductoIdProducto).HasColumnName("compra_PRODUCTO_ID_Producto");
            entity.Property(e => e.CompraClienteDni)
                .HasMaxLength(9)
                .HasColumnName("compra_cliente_DNI");
            entity.Property(e => e.CompraClienteCompranIdcompra).HasColumnName("compra_cliente_COMPRAN_IDCompra");
            entity.Property(e => e.Facturacol)
                .HasMaxLength(100)
                .HasColumnName("facturacol");
            entity.Property(e => e.Fecha)
                .HasColumnType("date")
                .HasColumnName("FECHA");
            entity.Property(e => e.Iva).HasColumnName("IVA");
            entity.Property(e => e.PrecioCompra)
                .HasPrecision(10)
                .HasColumnName("precio_compra");
        });

        modelBuilder.Entity<Jefe>(entity =>
        {
            entity.HasKey(e => e.EmpleadosIdEmpleado).HasName("PRIMARY");

            entity.ToTable("jefe");

            entity.HasIndex(e => e.EmpleadosIdEmpleado, "fk_jefe_empleados1_idx");

            entity.Property(e => e.EmpleadosIdEmpleado).HasColumnName("empleados_ID_Empleado");
        });

        modelBuilder.Entity<Permiso>(entity =>
        {
            entity.HasKey(e => e.Idpermisos).HasName("PRIMARY");

            entity.ToTable("permisos");

            entity.Property(e => e.Idpermisos).HasColumnName("idpermisos");
            entity.Property(e => e.Descripcionpermiso)
                .HasMaxLength(400)
                .HasColumnName("descripcionpermiso");

            entity.HasMany(d => d.RolesIdroles).WithMany(p => p.PermisosIdpermisos)
                .UsingEntity<Dictionary<string, object>>(
                    "PermisosHasRole",
                    r => r.HasOne<Role>().WithMany()
                        .HasForeignKey("RolesIdroles")
                        .OnDelete(DeleteBehavior.ClientSetNull)
                        .HasConstraintName("fk_permisos_has_roles_roles1"),
                    l => l.HasOne<Permiso>().WithMany()
                        .HasForeignKey("PermisosIdpermisos")
                        .OnDelete(DeleteBehavior.ClientSetNull)
                        .HasConstraintName("fk_permisos_has_roles_permisos1"),
                    j =>
                    {
                        j.HasKey("PermisosIdpermisos", "RolesIdroles").HasName("PRIMARY");
                        j.ToTable("permisos_has_roles");
                        j.HasIndex(new[] { "PermisosIdpermisos" }, "fk_permisos_has_roles_permisos1_idx");
                        j.HasIndex(new[] { "RolesIdroles" }, "fk_permisos_has_roles_roles1_idx");
                        j.IndexerProperty<int>("PermisosIdpermisos").HasColumnName("permisos_idpermisos");
                        j.IndexerProperty<int>("RolesIdroles").HasColumnName("roles_idroles");
                    });
        });

        modelBuilder.Entity<Producto>(entity =>
        {
            entity.HasKey(e => new { e.IdProducto, e.UbicacionIdUbicacion }).HasName("PRIMARY");

            entity.ToTable("producto");

            entity.HasIndex(e => e.Nombre, "Nombre_UNIQUE").IsUnique();

            entity.HasIndex(e => e.EmpleadosIdEmpleado, "fk_PRODUCTO_EMPLEADOS1_idx");

            entity.HasIndex(e => e.UbicacionIdUbicacion, "fk_producto_Ubicacion1_idx");

            entity.Property(e => e.IdProducto)
                .ValueGeneratedOnAdd()
                .HasColumnName("ID_Producto");
            entity.Property(e => e.UbicacionIdUbicacion).HasColumnName("Ubicacion_idUbicacion");
            entity.Property(e => e.CantidadStock).HasColumnName("Cantidad_Stock");
            entity.Property(e => e.Categoria).HasMaxLength(45);
            entity.Property(e => e.EmpleadosIdEmpleado).HasColumnName("EMPLEADOS_ID_Empleado");
            entity.Property(e => e.FechaIngreso)
                .HasColumnType("date")
                .HasColumnName("Fecha_Ingreso");
            entity.Property(e => e.Nombre).HasMaxLength(30);
            entity.Property(e => e.Precio).HasPrecision(10);
            entity.Property(e => e.UbicacionAlmacen)
                .HasMaxLength(45)
                .HasColumnName("Ubicacion_Almacen");

            entity.HasOne(d => d.UbicacionIdUbicacionNavigation).WithMany(p => p.Productos)
                .HasForeignKey(d => d.UbicacionIdUbicacion)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("fk_producto_Ubicacion1");

            entity.HasMany(d => d.VentaIdventa).WithMany(p => p.Productos)
                .UsingEntity<Dictionary<string, object>>(
                    "ProductoHasVentum",
                    r => r.HasOne<Ventum>().WithMany()
                        .HasForeignKey("VentaIdventa")
                        .OnDelete(DeleteBehavior.ClientSetNull)
                        .HasConstraintName("fk_producto_has_venta_venta1"),
                    l => l.HasOne<Producto>().WithMany()
                        .HasForeignKey("ProductoIdProducto", "ProductoUbicacionIdUbicacion")
                        .OnDelete(DeleteBehavior.ClientSetNull)
                        .HasConstraintName("fk_producto_has_venta_producto1"),
                    j =>
                    {
                        j.HasKey("ProductoIdProducto", "ProductoUbicacionIdUbicacion", "VentaIdventa").HasName("PRIMARY");
                        j.ToTable("producto_has_venta");
                        j.HasIndex(new[] { "ProductoIdProducto", "ProductoUbicacionIdUbicacion" }, "fk_producto_has_venta_producto1_idx");
                        j.HasIndex(new[] { "VentaIdventa" }, "fk_producto_has_venta_venta1_idx");
                        j.IndexerProperty<int>("ProductoIdProducto").HasColumnName("producto_ID_Producto");
                        j.IndexerProperty<int>("ProductoUbicacionIdUbicacion").HasColumnName("producto_Ubicacion_idUbicacion");
                        j.IndexerProperty<int>("VentaIdventa").HasColumnName("venta_idventa");
                    });
        });

        modelBuilder.Entity<Role>(entity =>
        {
            entity.HasKey(e => e.Idroles).HasName("PRIMARY");

            entity.ToTable("roles");

            entity.HasIndex(e => e.UsuariosIdusuario, "fk_roles_USUARIOS1_idx");

            entity.Property(e => e.Idroles).HasColumnName("idroles");
            entity.Property(e => e.Descrol)
                .HasMaxLength(400)
                .HasColumnName("descrol");
            entity.Property(e => e.Nombrerol)
                .HasMaxLength(30)
                .HasColumnName("nombrerol");
            entity.Property(e => e.UsuariosIdusuario).HasColumnName("USUARIOS_IDUsuario");

            entity.HasOne(d => d.UsuariosIdusuarioNavigation).WithMany(p => p.Roles)
                .HasForeignKey(d => d.UsuariosIdusuario)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("fk_roles_USUARIOS1");
        });

        modelBuilder.Entity<Ubicacion>(entity =>
        {
            entity.HasKey(e => e.IdUbicacion).HasName("PRIMARY");

            entity.ToTable("ubicacion");

            entity.Property(e => e.IdUbicacion).HasColumnName("idUbicacion");
            entity.Property(e => e.Descripcion).HasMaxLength(400);
        });

        modelBuilder.Entity<Usuario>(entity =>
        {
            entity.HasKey(e => e.Idusuario).HasName("PRIMARY");

            entity.ToTable("usuarios");

            entity.Property(e => e.Idusuario).HasColumnName("IDUsuario");
            entity.Property(e => e.ContraseñaUsuario)
                .HasMaxLength(60)
                .HasColumnName("contraseña_usuario");
            entity.Property(e => e.NomUsuario)
                .HasMaxLength(17)
                .HasColumnName("nom_usuario");
        });

        modelBuilder.Entity<VentaHasCompra>(entity =>
        {
            entity.HasKey(e => new { e.VentaIdventa, e.CompraIdcompra, e.CompraProductoIdProducto, e.CompraClienteDni, e.CompraClienteCompranIdcompra }).HasName("PRIMARY");

            entity.ToTable("venta_has_compra");

            entity.HasIndex(e => new { e.CompraIdcompra, e.CompraProductoIdProducto, e.CompraClienteDni, e.CompraClienteCompranIdcompra }, "fk_venta_has_compra_compra1_idx");

            entity.HasIndex(e => e.VentaIdventa, "fk_venta_has_compra_venta1_idx");

            entity.Property(e => e.VentaIdventa).HasColumnName("venta_idventa");
            entity.Property(e => e.CompraIdcompra).HasColumnName("compra_IDCompra");
            entity.Property(e => e.CompraProductoIdProducto).HasColumnName("compra_PRODUCTO_ID_Producto");
            entity.Property(e => e.CompraClienteDni)
                .HasMaxLength(9)
                .HasColumnName("compra_cliente_DNI");
            entity.Property(e => e.CompraClienteCompranIdcompra).HasColumnName("compra_cliente_COMPRAN_IDCompra");

            entity.HasOne(d => d.VentaIdventaNavigation).WithMany(p => p.VentaHasCompras)
                .HasForeignKey(d => d.VentaIdventa)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("fk_venta_has_compra_venta1");
        });

        modelBuilder.Entity<Ventum>(entity =>
        {
            entity.HasKey(e => e.Idventa).HasName("PRIMARY");

            entity.ToTable("venta");

            entity.Property(e => e.Idventa).HasColumnName("idventa");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}

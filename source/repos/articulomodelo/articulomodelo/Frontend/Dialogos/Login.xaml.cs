using articulomodelo.Backend.Modelo;
using articulomodelo.Frontend.Mensajes;
using MahApps.Metro.Controls;
using System.Windows;
using System.Windows.Controls;

namespace articulomodelo.Frontend.Dialogos
{

    public partial class Login : MetroWindow
    {
        public Login()
        {
            InitializeComponent();
          
        }

        private void btn_login_Click(object sender, RoutedEventArgs e) //Accion de dar al botón de login
        {

        
            if (string.IsNullOrWhiteSpace(txt_user.Text) || string.IsNullOrWhiteSpace(txt_password.Password))
            {
                MensajeAdvertencia.Mostrar("Por favor, rellene todos los campos.", "Warning");
                
                return;
            }

            string usuario = txt_user.Text.Trim(); //vaciarme los campos
            string password = txt_password.Password.Trim();

            if (ValidarLogin(usuario, password)) //Situacion correcta, funciona
            {
                MensajeInformacion.Mostrar("Login correcto,\nbienvenido " + usuario, "LOGIN EXITOSO");
                Window mainWindow = new MainWindow();
                mainWindow.Show();
                this.Close();
            }
            else //Datos incorrectos, no funciona
            {
                MensajeError.Mostrar("Usuario o contraseña incorrectos,\ninserte su usuario e contraseña de nuevo", "ERROR DE LOGIN");
            }
        }

        private bool ValidarLogin(string usuario, string password)
        {
            using (var db = new DiinventarioexamenContext())
            {
                // Buscar usuario en la BD
                var user = db.Usuario.FirstOrDefault(u => u.Username == usuario); //poner campo username 

                if (user == null)
                {
                    return false; // no existe el usuario
                }

                return user.Password == password; // comparar contraseña
            }
        }

       
    }
}

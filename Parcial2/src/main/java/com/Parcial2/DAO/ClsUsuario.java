package com.Parcial2.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.Parcial2.Conexion.ConexionBd;
import com.Parcial2.Entidades.Usuario;

public class ClsUsuario {

	ConexionBd cn = new ConexionBd();
    Connection conexion = cn.RetornarConexion();

    public boolean LoguinUser(String usuario, String Pass) {
        ArrayList<Usuario> ListaUser = new ArrayList<>();
        ArrayList<Usuario> ListarContra = new ArrayList<>();
        try {
            CallableStatement st = conexion.prepareCall("call SP_S_LOGUINUSUARIO(?,?)");

            st.setString("pUsuario", usuario);
            st.setString("pPass", Pass);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setNombre(rs.getNString("Nombre"));
                user.setContrasena(rs.getNString("Contrasena"));
                ListaUser.add(user);
            }
            String usuariodebasedatos = null;
            String passdebasededatos = null;
            for (var iterador : ListaUser) {
                usuariodebasedatos = iterador.getNombre();
                passdebasededatos = iterador.getContrasena();

            }

            CallableStatement st2 = conexion.prepareCall("call SP_S_CRIPSHA2(?)");
            st2.setString("PcripPass", Pass);
            ResultSet rs2 = st2.executeQuery();
            while (rs2.next()) {
                Usuario usercrip = new Usuario();

                usercrip.setContrasena(rs2.getNString("crip"));
                ListarContra.add(usercrip);
            }

            String passcrip = null;
            for (var iterador : ListarContra) {

                passcrip = iterador.getContrasena();

                Pass = passcrip;

            }

            if (usuariodebasedatos != null && passdebasededatos != null) {
                if (usuariodebasedatos.equals(usuario) && passdebasededatos.equals(Pass)) {
                    return true;
                }
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
	
}

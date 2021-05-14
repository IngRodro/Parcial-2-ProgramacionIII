package com.Parcial2.Negocio;

import com.Parcial2.Entidades.Usuario;
import com.Parcial2.DAO.ClsUsuario;

public class ClsLoguin {

	ClsUsuario clsusuario = new ClsUsuario();
	
	public int acceso(Usuario user) {
		int acceso = 0;
		if(clsusuario.LoguinUser(user.getNombre(), user.getContrasena())==true) {
			acceso = 1;
		}
		else {
			
		}
		return acceso;
	}
	
	
}

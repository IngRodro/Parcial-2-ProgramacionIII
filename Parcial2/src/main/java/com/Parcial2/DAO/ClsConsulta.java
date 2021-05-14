package com.Parcial2.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.Parcial2.Entidades.Consulta;
import com.Parcial2.Conexion.ConexionBd;

public class ClsConsulta {

	public ArrayList<Consulta> ListaConsulta() {
		ConexionBd cn = new ConexionBd();
	    Connection conexion = cn.RetornarConexion();
		
        ArrayList<Consulta> Consultas = new ArrayList<>();
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_S_Consulta");
            ResultSet rs = Statement.executeQuery();
            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setId(rs.getInt("Id"));
                consulta.setNombre(rs.getString("Nombre"));
                consulta.setApellido(rs.getString("Apellido"));
                Consultas.add(consulta);
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return Consultas;
    }
	
	
	 public void EliminarConsulta(Consulta consulta) {
	        try {
	        	ConexionBd cn = new ConexionBd();
	    	    Connection conexion = cn.RetornarConexion();
	    	    
	            CallableStatement Statement = conexion.prepareCall("call SP_D_Consulta(?)");
	            Statement.setInt("PidConsulta", consulta.getId());
	            Statement.execute();
	        } catch (Exception e) {
	            System.out.println(e);

	        }
	    }
}

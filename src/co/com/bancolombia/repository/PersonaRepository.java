package co.com.bancolombia.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.com.bancolombia.config.DbConnection;
import co.com.bancolombia.entities.Persona;

public class PersonaRepository {

	DbConnection dbConnection = new DbConnection();

	// Crea una persona
	public String crearPersona(Persona persona) {

		String sql = "INSERT INTO PERSONA(IDENTIFICACION, NOMBRE, EDAD) VALUES (?,?,?)";

		Connection con = dbConnection.getConnection();

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setObject(1, persona.getIdentificacion());
			ps.setObject(2, persona.getNombre());
			ps.setObject(3, persona.getEdad());
			ps.executeUpdate();

			return "Persona registrada satisfactoriamente";

		} catch (SQLException e) {
			return "Error " + e.getMessage();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

			}
		}

	}

	// Consulta todas las personas
	public String consultarPersonas() {
		String sql = "SELECT * FROM PERSONA";

		String respuesta = "";

		Connection con = dbConnection.getConnection();

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			boolean flag = false;
			while (rs.next()) {

				flag = true;
				Persona persona = new Persona();
				persona.setIdentificacion(rs.getInt(1));
				persona.setNombre(rs.getString(2));
				persona.setEdad(rs.getInt(3));
				respuesta += persona.toString();

			}

			if (flag) {
				return respuesta;

			} else {
				return "No hay personas registradas";
			}

		} catch (SQLException e) {
			return "Error " + e.getMessage();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

			}
		}

	}

}

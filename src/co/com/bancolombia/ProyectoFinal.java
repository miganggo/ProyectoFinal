package co.com.bancolombia;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import co.com.bancolombia.entities.Persona;
import co.com.bancolombia.services.PersonaServices;
import co.com.bancolombia.servicesImpl.PersonaServicesImpl;

public class ProyectoFinal {

	public static void main(String[] args) {

		PersonaServices personaService = new PersonaServicesImpl();

		int opcion = 0;

		do {

			String numOpcion = JOptionPane.showInputDialog("1. Crear Persona" + "\n" + "2. Consultar personas" + "\n"
					+ "3. Consultar Persona" + "\n" + "4. Eliminar Persona" + "\n" + "5. Salir");

			opcion = Integer.parseInt(numOpcion);

			// Evaluar opción ingresada
			switch (opcion) {
			case 1:
				personaService.crearPersona();
				break;

			case 2:
				personaService.consultarPersonas();
				break;
			case 3:
				personaService.consultarPersona();
				break;

			case 4:
				personaService.eliminarPersona();
				break;

			default:
				break;
			}
		} while (opcion != 5);

	}

}

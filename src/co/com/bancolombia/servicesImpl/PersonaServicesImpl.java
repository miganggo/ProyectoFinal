package co.com.bancolombia.servicesImpl;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import co.com.bancolombia.entities.Persona;
import co.com.bancolombia.repository.PersonaRepository;
import co.com.bancolombia.services.PersonaServices;

public class PersonaServicesImpl implements PersonaServices {
	
	PersonaRepository personaRepository = new PersonaRepository();

	@Override
	public void crearPersona() {
		String nombre = JOptionPane.showInputDialog("Digite el nombre");
		int edad = Integer.parseInt(JOptionPane.showInputDialog("Digite la edad"));
		int id = Integer.parseInt(JOptionPane.showInputDialog("Digite identificacion"));
		Persona persona = new Persona(nombre, edad, id);
		
		String respuesta = personaRepository.crearPersona(persona);
		
		JOptionPane.showMessageDialog(null, respuesta);

	}

	@Override
	public void consultarPersona() {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarPersona() {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarPersona() {
		// TODO Auto-generated method stub

	}

	@Override
	public void consultarPersonas() {
		
		JOptionPane.showMessageDialog(null, personaRepository.consultarPersonas());

	}
	
	public void prueba() {
		
	}

}

package co.com.udem.nomina.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import co.com.udem.nomina.dto.EmpleadoDto;



public class LecturaArchivo {

	private static final Logger logger = LogManager.getLogger(LecturaArchivo.class);
	private HashMap<String, EmpleadoDto> listaEmpleTabla = new HashMap<String, EmpleadoDto>();
	private int cantidadRegistros = 0;

	public String leerArchivo() {
		BasicConfigurator.configure();
		File archivoNomina = new File("D:\\Ejercicio_Nomina_Empleados\\nominaEmpleados.txt");
		Scanner scanner = null;
		String mensaje = "";

		try {
			scanner = new Scanner(archivoNomina);

			while (scanner.hasNextLine()) {
				String infoEmpleado = scanner.nextLine();
				leerRegistro(infoEmpleado);
				cantidadRegistros++;
			}

		} catch (FileNotFoundException ex) {
			mensaje = "El archivo no está en la ruta especificada";
			logger.error(ex.getMessage());

		} finally {

			if (scanner != null) {
				scanner.close();
			}

		}

		return mensaje;

	}

	private void leerRegistro(String infoEmpleado) {

		Scanner scanner = new Scanner(infoEmpleado);
		scanner.useDelimiter(",");

		while (scanner.hasNext()) {
			EmpleadoDto empleado = new EmpleadoDto();

			empleado.setNombres(scanner.next());
			empleado.setApellidos(scanner.next());
			String cedula = scanner.next();
			empleado.setCedula(cedula);
			empleado.setDepartamento(scanner.next());
			empleado.setSalario(Double.parseDouble(scanner.next()));

			if (!existeEmpleado(cedula)) {
				listaEmpleTabla.put(cedula, empleado);
			}
		}
		imprimirEmpleadoArchivo(listaEmpleTabla);
		scanner.close();

	}

	private boolean existeEmpleado(String cedula) {

		boolean existe = false;

		if (listaEmpleTabla.containsKey(cedula)) {
			existe = true;
		}
		return existe;
	}
	
	private void imprimirEmpleadoArchivo(HashMap<String, EmpleadoDto> listaEmpleTabla) {
		
		BasicConfigurator.configure();
		logger.info(listaEmpleTabla);
		
		
	}
	
	public int cantidadRegistros() {
		return cantidadRegistros;
	}

}

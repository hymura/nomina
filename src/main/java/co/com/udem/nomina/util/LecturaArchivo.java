package co.com.udem.nomina.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import co.com.udem.nomina.dto.EmpleadoDto;

public class LecturaArchivo {
	private static final String RUTA = "C:\\EjemploArchivos\\empleadoproceso.txt";
	private static final Logger logger = LogManager.getLogger(LecturaArchivo.class);
	private HashMap<String, EmpleadoDto> listaEmpleadosTabla = new HashMap<String, EmpleadoDto>();
	private int cantidadRegistros;    

	public String leerArchivo() {
		File archivoNomina = new File(RUTA);
		Scanner scanner = null;
		String mensaje = "";
		cantidadRegistros = 0;

		try {
			scanner = new Scanner(archivoNomina);

			while (scanner.hasNextLine()) {
				String infoEmpleado = scanner.nextLine();
				leerRegistro(infoEmpleado);
				cantidadRegistros++;
			}

			imprimirEmpleadoArchivo(listaEmpleadosTabla);
			
		} catch (FileNotFoundException ex) {
			mensaje = "El archivo no está en la ruta especificada";
			logger.error(ex.getMessage());

		} finally {

			if (scanner != null) {
				scanner.close();
			}

		}
		
		mensaje= mensaje+" - "+"Registros leidos: "+cantidadRegistros;
		return mensaje;

	}

	private void leerRegistro(String infoEmpleado) {
		
		Scanner scanner = null;
		try {        	
            scanner = new Scanner(infoEmpleado);
    		scanner.useDelimiter(",");

    		while (scanner.hasNext()) {
    			EmpleadoDto empleado = new EmpleadoDto();

    			empleado.setNombres(scanner.next());
    			empleado.setApellidos(scanner.next());
    			String cedula = scanner.next();
    			empleado.setCedula(cedula);
    			empleado.setEdad(Integer.parseInt(scanner.next()));
    			empleado.setDepartamento(scanner.next());
    			empleado.setSalario(Double.parseDouble(scanner.next()));

    			validarRegistroEmpleado(cedula, empleado);
    		}
    		
    		scanner.close();
			
		} catch (Exception e) {
			logger.error(e.getStackTrace());			
		}
        finally {

			if (scanner != null) {
				scanner.close();
			}

		}
        
		

	}

	
	private void imprimirEmpleadoArchivo(HashMap<String, EmpleadoDto> listaEmpleadosTabla) {
		
		Iterator<String> iterator =listaEmpleadosTabla.keySet().iterator();
		EmpleadoDto empleado;
		StringBuilder mensaje = new StringBuilder();
		while (iterator.hasNext()) {
			empleado=listaEmpleadosTabla.get(iterator.next());
			
			mensaje.append("Nombre: " + empleado.getNombres());
			mensaje.append(" - ");
			mensaje.append("Apellido: " + empleado.getApellidos());
			mensaje.append(" - ");
			mensaje.append("edad: " + empleado.getEdad());
			mensaje.append(" - ");
			mensaje.append("Salario: " + empleado.getSalario());
			mensaje.append(" - ");
			mensaje.append("Departamento: " + empleado.getDepartamento());

			logger.info(mensaje);
			mensaje.delete(0, mensaje.length());
		}
				
	}
	
	private void validarRegistroEmpleado(String cedula, EmpleadoDto empleado) {
		 
		if (listaEmpleadosTabla.containsKey(cedula)) {
			
			logger.info("El registro  ya existe, cedula: " + cedula);			
		} else {
			listaEmpleadosTabla.put(cedula, empleado);			
		
		}

	}
	
	public int cantidadRegistros() {
		return cantidadRegistros;
	}

}

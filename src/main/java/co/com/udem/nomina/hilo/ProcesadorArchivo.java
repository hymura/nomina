package co.com.udem.nomina.hilo;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import co.com.udem.nomin.hilo.ProcesadorArchivo;
import co.com.udem.nomina.util.LecturaArchivo;
import co.com.udem.nomina.util.PoblarEstructura;



public class ProcesadorArchivo implements Runnable {
	
	private static final Logger logger = LogManager.getLogger(ProcesadorArchivo.class);
	
	String mensaje = "";
	Thread t;
	
	public void iniciarHilo() {
		t = new Thread(new ProcesadorArchivo());
		t.start();
	}
	
	public void run() {
		LecturaArchivo lecturaArchivo = new LecturaArchivo();
		BasicConfigurator.configure();
				
		while(true) {
         	mensaje = lecturaArchivo.leerArchivo();
         	int cantidadRegistros = PoblarEstructura.;
			if(cantidadRegistros == 3) {
				break;
			}
			
		
			logger.info("Mensaje: " + mensaje);
			try {
				Thread.sleep(30000);  
			} catch (InterruptedException e) {
				logger.error(e.getMessage());
				Thread.currentThread().interrupt();
			
			}
			
		}
		

	}

}

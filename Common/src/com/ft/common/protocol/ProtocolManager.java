package com.ft.common.protocol;



public class ProtocolManager {

	public final static String SOLICITAR_TAXI = "Solicitar Taxi";
	public final static String SOLICITAR_TAXI_TAXISTA = "Solicitar Taxista";
	public final static String CONFIRMAR_TAXI = "Confirmar Taxi";
	public final static String INCREMENTAR_PUNTOS = "Incrementar Puntos";
	public final static String SEPARADOR = ":";
	
	/**
	 * 
	 * @param ubicacion
	 * @return el mensaje que usa el pasajero al SMSC para pedir un taxi
	 */
	public static String getSolicitarServicio(String ubicacion)
	{
		return SOLICITAR_TAXI+SEPARADOR+ubicacion;
	}
	
	/**
	 * 
	 * @param pasajeroID
	 * @param ubicacion
	 * @return el mensaje que el SMSC le env�a a cada taxista para confirmar el servicio
	 */
	public static String getSolicitarServicioTaxista(String pasajeroID, String ubicacion )
	{
		return SOLICITAR_TAXI_TAXISTA+SEPARADOR+pasajeroID+SEPARADOR+ubicacion;
	}
	
	
	
	/**
	 * 
	 * @param mensajeSolicitarServicio
	 * @return extrae la direccion de un mensaje de tipo Solicitar Servicio
	 */
	public static String extractDireccion(String mensajeSolicitarServicio)
	{
		if (!isSolicitarServicio(mensajeSolicitarServicio))
		{
			throw new IllegalArgumentException();
		}
		return mensajeSolicitarServicio.split(SEPARADOR)[1];
	}
	
//	public static String getConfirmarServicio(String pasajeroId, int tiempoAprox)
//	{
//		return CONFIRMAR_TAXI+SEPARADOR+pasajeroId +" "+tiempoAprox;
//	}
	
//	public static Confirmacion getConfirmarServicio(String mensaje)
//	{
//		if (!isConfirmarServicio(mensaje))
//		{
//			throw new IllegalArgumentException();
//		}
//		String[] params =  mensaje.split(SEPARADOR)[1].split(" ");
//		return new Confirmacion(params[0], Integer.parseInt(params[1]));
//	}
	
	/**
	 * 
	 * @param tiempoAprox
	 * @return el mensaje que le env�a el taxista al pasajero confirmando su taxi
	 */
	public static String getServicioConfirmado(int tiempoAprox)
	{
		return "Tu servicio ha sido exitosamente confirmado. Llegara en aproximadamente "+tiempoAprox+" minutos.";
	}

	/**
	 * 
	 * @param message
	 * @return de un mensaje Solicitar Servicio Taxista extra el numero de telefono
	 */
	public static String extractNumeroSolicitarServicioTaxista(String message)
	{
		return message.split(SEPARADOR)[1];
	}
	
	/**
	 * 
	 * @param message
	 * @return de un mensaje Solicitar Servicio Taxista extra la posicion de telefono
	 */
	public static String extractUbicacionSolicitarServicioTaxista(String message)
	{
		return message.split(SEPARADOR)[2];
	}
	
	public static boolean isSolicitarServicio(String message)
	{
		return message.matches(SOLICITAR_TAXI+SEPARADOR+".+");
	}
	
	public static boolean isSolicitarServicioTaxista(String message)
	{
		return message.matches(SOLICITAR_TAXI_TAXISTA+SEPARADOR+"[0-9]+"+SEPARADOR+".+");
	}
	
	public static boolean isServicioConfirmado(String message)
	{
		return message.matches("Tu servicio ha sido exitosamente confirmado. Llegara en aproximadamente [0-9]+ minutos.");
	}
	

	
}

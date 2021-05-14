package eldar.ncrivelli.challenger;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Tarjeta {

	static final String VISA = "VISA";
	static final String NARA = "NARA";
	static final String AMEX = "AMEX";

	String marca, cardholder;
	int numeroTarjeta, monto;
	Date fechaVencimiento;

	public Tarjeta (String marca, String cardholder, int numeroTarjeta, Date fechaVencimiento, int monto){
		this.marca = marca;
		this.cardholder = cardholder;
		this.numeroTarjeta = numeroTarjeta;
		this.fechaVencimiento = fechaVencimiento;
		this.monto = monto;
	}

	public String infoTarjeta (){
		return "Tarjeta marca " + marca + ", numero " + numeroTarjeta + ", a nombre de " 
			+ cardholder + " y con fecha de vencimiento el dia " + fechaVencimiento;
	}

	public boolean validaOperacion (int montoOp){
		if(montoOp < 1000)	return true;
		else 	return false;
	}

	public boolean validaTarjeta (Date fechaVencimiento){

		Date fechaActual = new Date(); //averiguar como setear la fecha de hoy

	/*	if(fechaVencimiento > fechaActual)	return true;
		else 	*/return false;
	}

	public boolean distinta (Tarjeta tar1, Tarjeta tar2){

		if(tar1.numeroTarjeta == tar2.numeroTarjeta){
			if (tar1.cardholder.equals(tar2.cardholder)) {
				if (tar1.marca.equals(tar2.cardholder)) {
					if (tar1.fechaVencimiento == tar2.fechaVencimiento) {	//averiguar como se comparan fechas
						return true;
					}
					else return false;
				}
				else return false;
			}
			else return false;
		}
		else return false;
	}

	public double getTasa (String marca){

		double tasa = 0;
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		if(marca.equals(VISA)){
			int año = localDate.getYear();
			int mes = localDate.getMonthValue();
			tasa = (año-2000) / mes;
		}
		else if(marca.equals(NARA)){
			int dia = localDate.getDayOfMonth();
			tasa = dia * 0.5;	
		}
		else if(marca.equals(AMEX)){
			int mes = localDate.getMonthValue();
			tasa = mes * 0.1;	
		}
		
		if(tasa<0.3)	tasa=0.3;
		else if(tasa>5)	tasa=5;
		
		return tasa;
	}
	
	public double getMontoConTasa(double monto, double tasa) {
		return monto + (monto * tasa / 100);
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCardholder() {
		return cardholder;
	}

	public void setCardholder(String cardholder) {
		this.cardholder = cardholder;
	}

	public int getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(int numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}
}
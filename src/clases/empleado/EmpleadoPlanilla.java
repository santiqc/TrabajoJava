package clases.empleado;

import javax.swing.JOptionPane;

public class EmpleadoPlanilla extends Empleado{
	
	private double salarioMensual;
	private double porcentajeAdicionalPorHoraExtra;
	
	
	@Override
	public void registrarDatos() {
		
		super.registrarDatos();
		do {
			setComprobacion(true);
			
		
		try {
			salarioMensual=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario Mensual"));
			
		} catch (Exception e) {
		
			JOptionPane.showMessageDialog(null, "Por favor ingrese un tipo de dato numerico");
			setComprobacion(false);
		}
		}while(isComprobacion()!=true);
		
		porcentajeAdicionalPorHoraExtra=Double.parseDouble(JOptionPane.
				showInputDialog("Ingrese el porcentaje Adicional por hora Extra"));
	}
	
	@Override
	public void imprimirDatosPersona(String datos) {
		
		super.imprimirDatosPersona(datos);
		
		datos = "Salario Mensual: " + salarioMensual + "\n";
		datos += "Porcentaje Adicional Por Hora Extra: " + porcentajeAdicionalPorHoraExtra + "\n";
		
		System.out.println(datos);
	}
	
	
	public double getSalarioMensual() {
		return salarioMensual;
	}
	public void setSalarioMensual(double salarioMensual) {
		this.salarioMensual = salarioMensual;
	}
	public double getPorcentajeAdicionalPorHoraExtra() {
		return porcentajeAdicionalPorHoraExtra;
	}
	public void setPorcentajeAdicionalPorHoraExtra(double porcentajeAdicionalPorHoraExtra) {
		this.porcentajeAdicionalPorHoraExtra = porcentajeAdicionalPorHoraExtra;
	}
	
	
}

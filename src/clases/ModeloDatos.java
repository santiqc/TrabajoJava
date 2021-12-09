package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

import clases.empleado.EmpleadoEventual;
import clases.empleado.EmpleadoPlanilla;
import clases.empleado.Medico;


public class ModeloDatos {
	
	HashMap<String, Paciente> pacientesMap;
	HashMap<String, EmpleadoPlanilla> empleadosPlanillaMap;
	HashMap<String, EmpleadoEventual> empleadosEventualMap;
	HashMap<String, Medico> medicosMap;
	ArrayList<CitaMedica> citasList;
	int contador=0;
	
	public ModeloDatos() {
		pacientesMap=new HashMap<String, Paciente>();
		empleadosPlanillaMap=new  HashMap<String, EmpleadoPlanilla>();
		medicosMap=new HashMap<String, Medico>();
		empleadosEventualMap=new HashMap<String, EmpleadoEventual>();
		citasList=new ArrayList<CitaMedica>();
	}
	
	public void registrarPersona(Paciente miPaciente) {
		
		if(pacientesMap.containsKey(miPaciente.getNumeroDeDNI())) {
			JOptionPane.showMessageDialog(null, "Ya hay un paciente registrado con el mismo numero de documento");
			
			
		}else {
			pacientesMap.put(miPaciente.getNumeroDeDNI(), miPaciente);
			System.out.println("Se ha registrado el paciente "+ miPaciente.getNombre() +"Satisfactoriamente");
		}
		
		
	}
	public void registrarPersona(EmpleadoPlanilla miEmpPlanilla) {
		if(empleadosPlanillaMap.containsKey(miEmpPlanilla.getNumeroDeDNI())) {
			JOptionPane.showMessageDialog(null, "Ya hay un Empleado por Planilla registrado con el mismo numero de documento");
			
			
		}else {
		empleadosPlanillaMap.put(miEmpPlanilla.getNumeroDeDNI(), miEmpPlanilla);
		System.out.println("Se ha registrado el empleado por planilla "+ miEmpPlanilla.getNombre() +"Satisfactoriamente");
		}
		
	}
	public void registrarPersona(EmpleadoEventual miEmpEventual) {
		if(empleadosEventualMap.containsKey(miEmpEventual.getNumeroDeDNI())) {
			JOptionPane.showMessageDialog(null, "Ya hay un Empleado Eventual registrado con el mismo numero de documento");
			
			
		}else {
		empleadosEventualMap.put(miEmpEventual.getNumeroDeDNI(), miEmpEventual);
		System.out.println("Se ha registrado el empleado eventual "+ miEmpEventual.getNombre() +"Satisfactoriamente");
		}
		
	}
	public void registrarPersona(Medico miMedico) {
		if(medicosMap.containsKey(miMedico.getNumeroDeDNI())) {
			JOptionPane.showMessageDialog(null, "Ya hay un Medico registrado con el mismo numero de documento");
			
			
		}else {
		medicosMap.put(miMedico.getNumeroDeDNI(), miMedico);
		System.out.println("Se ha registrado el medico "+ miMedico.getNombre() +"Satisfactoriamente");
		}
		
	}
	
	public void imprimirPacientes() {
		contador=pacientesMap.size();
		if (contador>=1) {
			String msj="PACIENTES REGISTRADOS\n";
			Iterator<String> iterator=pacientesMap.keySet().iterator();
			
			while (iterator.hasNext()) {
				
				String clave = iterator.next();
				pacientesMap.get(clave).imprimirDatosPersona(msj);
				}
			
		} else {JOptionPane.showMessageDialog(null, "No hay pacientes registrados");

		}
		
	}
	public void imprimirEmpleadosEventuales() {
		contador=empleadosEventualMap.size();
		if (contador>=1) {
			String msj="EMPLEADOS EVENTUALES REGISTRADOS\n";
			
			for (String clave : empleadosEventualMap.keySet()) {
				empleadosEventualMap.get(clave).imprimirDatosPersona(msj);
			}
			
		}else {JOptionPane.showMessageDialog(null, "No hay Empleados Eventuales registrados");
		}
	
	
	}
	public void imprimirEmpleadosPorPlanilla() {
		contador=empleadosPlanillaMap.size();
		if (contador>=1) {
			String msj="EMPLEADOS POR PLANILLA REGISTRADOS\n";
			
			for (EmpleadoPlanilla empleadoPlanilla : empleadosPlanillaMap.values()) {
				empleadoPlanilla.imprimirDatosPersona(msj);
			}
			
		}else {JOptionPane.showMessageDialog(null, "No hay Empleados por Planilla registrados");
		}
	
		contador=medicosMap.size();
		if (contador>=1) {
			JOptionPane.showMessageDialog(null,"Los medicos registrados son" );
			String msj="MEDICOS REGISTRADOS\n";
			
			for (Map.Entry<String, Medico> elemento : medicosMap.entrySet()){
				elemento.getValue().imprimirDatosPersona(msj);
			}
			
		} else {JOptionPane.showMessageDialog(null, "No hay Medicos registrados");

		}
		
	}
	public void imprimirMedicos() {
		contador=medicosMap.size();
		if (contador>=1) {
			String msj="MEDICOS REGISTRADOS\n";
			
			for (Map.Entry<String, Medico> elemento : medicosMap.entrySet()){
				elemento.getValue().imprimirDatosPersona(msj);
			}
			
		} else {JOptionPane.showMessageDialog(null, "No hay Medicos registrados");

		}
	
	}
	
	public Medico consultaMedicoPorNombre(String nombreMedico) {
		
		for (Medico medico : medicosMap.values()) {
			
			if (medico.getNombre().equalsIgnoreCase(nombreMedico)) {
				return medico;
			}
		}
		return null;
	}
	
	
	
	
	public Paciente consultarPacientePorDocumento(String documentoPaciente) {
		Paciente miPaciente=null;
		
		if (pacientesMap.containsKey(documentoPaciente)) {
			miPaciente=pacientesMap.get(documentoPaciente);
			
		}
		return miPaciente;
	}
	
	public void registrarCitaMedica(CitaMedica miCita) {
		citasList.add(miCita);
		System.out.println("Se ha registrado la cita exitosamente\n");
		System.out.println(miCita.informacionCitaMedica());
	}
	
	public void imprimirCitasMedicasProgramadas() {
		String msj="CITAS MEDICAS PROGAMADAS\n";
		CitaMedica miCita=null;
		
		System.out.println(msj+"\n");
		
		if (citasList.size()>0) {
			for (int i = 0; i < citasList.size(); i++) {
				miCita=citasList.get(i);
				System.out.println(miCita.informacionCitaMedica());
				
			}
		}else {
			System.out.println("No existen citas programadas");
	}
}
	public void imprimirPacientePorDocumento() {
		String numero=JOptionPane.showInputDialog("Ingrese el documento a consultar");
		String msj="\n<<<<<PACIENTE>>>>>\n";
		if (pacientesMap.containsKey(numero)) {
				pacientesMap.get(numero).imprimirDatosPersona(msj);
			
			}
		}
	
	public void imprimirEmpEventualesPorDocumento() {
		String numero=JOptionPane.showInputDialog("Ingrese el documento a consultar");
		String msj="\n<<<<<EMPLEADO EVENTUAL>>>>>\n";
		if (empleadosEventualMap.containsKey(numero)) {
			empleadosEventualMap.get(numero).imprimirDatosPersona(msj);
			
			}
		}
	
	public void imprimirEmpPlanillaPorDocumento() {
		String numero=JOptionPane.showInputDialog("Ingrese el documento a consultar");
		String msj="\n<<<<<EMPLEADO PLANILLA>>>>>\n";
		if (empleadosPlanillaMap.containsKey(numero)) {
			empleadosPlanillaMap.get(numero).imprimirDatosPersona(msj);
			
		}
	}
	public void imprimirMedicoPorDocumento() {
		String numero=JOptionPane.showInputDialog("Ingrese el documento a consultar");
		String msj="\n<<<<<MEDICOS>>>>>\n";
		if (medicosMap.containsKey(numero)) {
			medicosMap.get(numero).imprimirDatosPersona(msj);
			
			}
		}
	public void imprimirMedico() {
		String msj="MEDICOS REGISTRADOS\n";
		if(medicosMap.size()>0) {
			for (Map.Entry<String, Medico> elemento : medicosMap.entrySet()){
				elemento.getValue().imprimirDatosPersona(msj);
			}
		}else {
			System.out.println("No hay medicos registrados");
		}
	}
	
	
}

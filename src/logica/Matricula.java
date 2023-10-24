
package logica;

import entidades.Estudiante;
import java.util.List;
import java.util.Scanner;


public class Matricula extends Pago {
    
    public Matricula(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void realizarPago(List<Estudiante> listaEstudiantes, String periodoAcademico) {
        System.out.print("Desea pagar la matricula ahora (si/no): ");
        String respuesta = scanner.next().toLowerCase();

        if (respuesta.equals("si")) {
            System.out.print("Ingrese la identificacion del estudiante que pagara la matricula: ");
            String identificacionEstudiante = scanner.next();
            Estudiante estudianteEncontrado = buscarEstudiante(listaEstudiantes, identificacionEstudiante);

            if (estudianteEncontrado != null) {
                double montoMatricula = 450000.0;

                System.out.print("Ingrese el mes de pago de la matricula (2-11): ");
                int mesPago = scanner.nextInt();

                if (validarMesPago(mesPago)) {
                    System.out.print("Ingrese el dia de pago de la matricula: ");
                    int diaPago = scanner.nextInt();

                    if (validarDiaPago(diaPago)) {
                        System.out.println(estudianteEncontrado.getNombre() + " " + estudianteEncontrado.getApellido()
                                + " pago " + montoMatricula + " en el mes " + mesPago + " y el dia " + diaPago + ".");
                        pagos.put(periodoAcademico, montoMatricula);
                        estudianteEncontrado.setMontoMatricula(montoMatricula); // Añadido
                    } else {
                        double intereses = montoMatricula * 0.10;
                        montoMatricula += intereses;
                        System.out.println("Intereses del 10% aplicados.");
                        System.out.println(estudianteEncontrado.getNombre() + " " + estudianteEncontrado.getApellido()
                                + " pago " + montoMatricula + " en el mes " + mesPago + " y el dia " + diaPago + ".");
                        pagos.put(periodoAcademico, montoMatricula);
                        estudianteEncontrado.setMontoMatricula(montoMatricula); // Añadido
                    }
                } else {
                    System.out.println("El mes de pago debe estar entre [2 y 11].");
                }
            } else {
                System.out.println("Estudiante no encontrado con la identificacion proporcionada.");
            }
        } else {
            System.out.println("Pago no realizado, Cuidado");
        }
    }
}
    


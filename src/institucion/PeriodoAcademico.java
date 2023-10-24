package institucion;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PeriodoAcademico {

    private Map<Integer, String> meses;

    public PeriodoAcademico() {
        meses = new HashMap<>();
        meses.put(2, "Febrero");
        meses.put(3, "Marzo");
        meses.put(4, "Abril");
        meses.put(5, "Mayo");
        meses.put(6, "Junio");
        meses.put(7, "Julio");
        meses.put(8, "Agosto");
        meses.put(9, "Septiembre");
        meses.put(10, "Octubre");
        meses.put(11, "Noviembre");
    }

    public String PeriodoAcademico(Scanner scanner) {
        boolean periodoValido = false;
        String periodoAcademico = null;

        while (!periodoValido) {
            System.out.println("Meses disponibles para registro:");
            for (Map.Entry<Integer, String> entry : meses.entrySet()) {
                System.out.println(entry.getKey() + ". " + entry.getValue());
            }
            System.out.print("Ingrese el numero del mes: ");
            int mes = scanner.nextInt();
            if (meses.containsKey(mes)) {
                String mesStr = String.format("%02d", mes);
                System.out.print("Ingrese el año del periodo academico : ");
                int anio = scanner.nextInt();
                if (anio >= 2010 && anio <= 2030) {
                    periodoAcademico = mesStr + "/" + anio;
                    periodoValido = true;
                } else {
                    System.out.println("Año invalido. Por favor, ingrese un año entre 2010 y 2030.");
                }
            } else {
                System.out.println("Mes invalido,seleccione un mes valido.");
            }
        }

        return periodoAcademico;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PeriodoAcademico registro = new PeriodoAcademico();
        boolean reiniciar = true;

        while (reiniciar) {
            String periodo = registro.PeriodoAcademico(scanner);
            System.out.println("Periodo académico registrado: " + periodo);

            System.out.print("Desea registrar otro período academico (S/N): ");
            String opcion = scanner.next();
            if (!opcion.equalsIgnoreCase("S")) {
                reiniciar = false;
            }
        }

        scanner.close();
    }

    String obtenerPeriodoAcademico(Scanner scanner) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

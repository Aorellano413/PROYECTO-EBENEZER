package entidades;

import institucion.PeriodoAcademico;
import logica.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Institucion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String usuario;
        String contrasena;

        System.out.print("Ingrese el nombre de usuario: ");
        usuario = scanner.next();

        System.out.print("Ingrese la contraseña: ");
        contrasena = scanner.next();

        if (contrasena.equals("ebenezer2023")) {
            System.out.println("Bienvenido al sistema de la Institución Ebenezer.");
            PeriodoAcademico registroPeriodoAcademico = new PeriodoAcademico();
            String PeriodoAcademico = null;
            ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

            while (true) {
                System.out.println("\nMenu de Institucion Ebenezer\n");
                System.out.println("1. Registrar periodo academico");
                System.out.println("2. Registrar estudiante");
                System.out.println("3. Registrar pago matricula");
                System.out.println("4. Registrar pago pension");
                System.out.println("5. informe de pagos");
                System.out.println("6. informe de deudas");
                System.out.println("7. Buscar estudiante");
                System.out.println("8. Lista de estudiantes");
                System.out.println("9. Salir");
                System.out.print("Seleccione una opcion: ");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        PeriodoAcademico = registroPeriodoAcademico.PeriodoAcademico(scanner);
                        System.out.println("Periodo academico registrado para " + PeriodoAcademico);
                        break;
                    case 2:
                        boolean nombreValido,
                         apellidoValido;
                        if (PeriodoAcademico != null) {
                            System.out.print("Ingrese el primer nombre del estudiante: ");
                            String nombre = scanner.next();
                            nombreValido = Pattern.matches("[\\p{L}]+", nombre);

                            System.out.print("Ingrese el primer apellido del estudiante: ");
                            String apellido = scanner.next();
                            apellidoValido = Pattern.matches("[\\p{L}]+", apellido);

                            if (nombreValido && apellidoValido) {
                                System.out.print("Ingrese la edad del estudiante : ");
                                String edadInput = scanner.next();

                                if (edadInput.length() == 2 && edadInput.matches("\\d{2}")) {
                                    int edad = Integer.parseInt(edadInput);

                                    System.out.print("Ingrese la identificacion del estudiante: ");
                                    String identificacion = scanner.next();

                                    System.out.print("Ingrese el curso del estudiante: ");
                                    String curso = scanner.next();

                                    Estudiante nuevoEstudiante = new Estudiante(nombre, apellido, edad, identificacion, curso);
                                    listaEstudiantes.add(nuevoEstudiante);
                                    System.out.println("Estudiante registrado correctamente.");
                                } else {
                                    System.out.println("ingrese una edad valida ");
                                }
                            } else {
                                if (!nombreValido) {
                                    System.out.println("El nombre debe contener solo letras.");
                                }
                                if (!apellidoValido) {
                                    System.out.println("El apellido debe contener solo letras.");
                                }
                            }
                        } else {
                            System.out.println("Primero debe registrar el periodo academico.");
                        }
                        break;

                    case 3:
                        Pago matricula = new Matricula(scanner);
                        matricula.realizarPago(listaEstudiantes, PeriodoAcademico);
                        break;
                    case 4:
                        Pago pension = new Pension(scanner);
                        pension.realizarPago(listaEstudiantes, PeriodoAcademico);
                        break;

                    case 5:
                        System.out.println("Informacion de pagos de los estudiantes:");
                        for (Estudiante estudiante : listaEstudiantes) {
                            System.out.println("Estudiante: " + estudiante.getNombre() + " " + estudiante.getApellido());
                            System.out.printf("Monto de matricula pagado: %.2f%n", estudiante.getMontoMatricula());
                            System.out.printf("Monto de pension pagado: %.2f%n", estudiante.getMontoPension());
                        }
                        break;

                    case 6:
                        boolean estudiantesEncontrados = false;
                        System.out.println("Usuarios que no han realizado ningun pago:");
                        for (Estudiante estudiante : listaEstudiantes) {
                            if (estudiante.getMontoMatricula() == 0 && estudiante.getMontoPension() == 0) {
                                System.out.println("Estudiante: " + estudiante.getNombre() + " " + estudiante.getApellido());
                                estudiantesEncontrados = true;
                            }
                        }
                        if (!estudiantesEncontrados) {
                            System.out.println("No se encontro ningun estudiante que no haya realizado ningun pago.");
                        }
                        break;

                    case 7:
                        // Lógica para buscar estudiante
                        scanner.nextLine();
                        System.out.print("Ingrese la identificacion del estudiante que desea buscar: ");
                        String identificacionBuscada = scanner.nextLine();
                        Estudiante estudianteEncontrado = null;

                        for (Estudiante estudiante : listaEstudiantes) {
                            if (estudiante.getIdentificacion().equals(identificacionBuscada)) {
                                estudianteEncontrado = estudiante;
                                break;
                            }
                        }

                        if (estudianteEncontrado != null) {
                            System.out.println("Estudiante encontrado:");
                            System.out.println("Nombre Completo: " + estudianteEncontrado.getNombre() + " " + estudianteEncontrado.getApellido()
                                    + ", Edad: " + estudianteEncontrado.getEdad()
                                    + ", Identificacion: " + estudianteEncontrado.getIdentificacion()
                                    + ", Curso: " + estudianteEncontrado.getCurso());

                            if (estudianteEncontrado.getMontoMatricula() == 0 || estudianteEncontrado.getMontoPension() == 0) {
                                System.out.println("El estudiante esta moroso.");
                            } else {
                                System.out.println("El estudiante no esta moroso.");
                            }
                        } else {
                            System.out.println("No se encontro ningun estudiante con la identificacion ingresada.");
                        }
                        
                        break;

                    case 8:

                        System.out.println("Lista de Estudiantes:");
                        for (Estudiante estudiante : listaEstudiantes) {
                            System.out.println("Nombre Completo: " + estudiante.getNombre() + " " + estudiante.getApellido()
                                    + ", Edad: " + estudiante.getEdad() + ", Identificacion: " + estudiante.getIdentificacion()
                                    + ", Curso: " + estudiante.getCurso());
                        }
                        break;
                    case 9:
                        System.out.println("Saliendo del programa. ");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no valida,seleccione una opcion valida.");
                }
            }
        }
    }
}

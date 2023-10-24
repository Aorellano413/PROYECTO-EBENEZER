package logica;

import entidades.Estudiante;
import java.util.HashMap;
import java.util.Scanner;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public abstract class Pago {

    protected Map<String, Double> pagos = new HashMap<>();
    protected Scanner scanner;

    public Pago(Scanner scanner) {
        this.scanner = scanner;
    }

    public abstract void realizarPago(List<Estudiante> listaEstudiantes, String periodoAcademico);

    protected Estudiante buscarEstudiante(List<Estudiante> listaEstudiantes, String identificacionEstudiante) {
        Estudiante estudianteEncontrado = null;
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getIdentificacion().equals(identificacionEstudiante)) {
                estudianteEncontrado = estudiante;
                break;
            }
        }
        return estudianteEncontrado;
    }

    protected boolean validarMesPago(int mesPago) {
        return mesPago >= 2 && mesPago <= 11;
    }

    protected boolean validarDiaPago(int diaPago) {
        return diaPago >= 1 && diaPago <= 5;
    }

    public Map<String, Double> getPagos() {
        return pagos;
    }
}


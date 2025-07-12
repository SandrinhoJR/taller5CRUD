/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Propietario;

/**
 *
 * @author sandro rendon
 */
public class ControladorPropietario {

    ArrayList<Propietario> propietarios = new ArrayList<>();

    public ArrayList<Propietario> getPropietarios() {
        return propietarios;
    }

    public boolean guardar(Propietario propietario) {
        propietarios.add(propietario);
        return true;
    }

    public Propietario buscar(String documento) {
        for (Propietario propietario : propietarios) {
            if (propietario.getDocumento().equals(documento)) {
                return propietario;
            }
        }
        return null;
    }

    public boolean eliminar(String documento) {
        for (int i = 0; i < propietarios.size(); i++) {
            if (propietarios.get(i).getDocumento().equals(documento)) {
                propietarios.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean editar(Propietario propietario) {
        Propietario aux = buscar(propietario.getDocumento());
        if (aux != null) {
            aux.setNombre(propietario.getNombre());
            aux.setDocumento(propietario.getDocumento());
            aux.setTelefono(propietario.getTelefono());

            return true;
        }
        return false;
    }

    public DefaultTableModel listar() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[]{"Documento", "Nombre", "Telefono "});
        ArrayList<Propietario> propietarios = getPropietarios();
        for (Propietario propietario : propietarios) {
            modelo.addRow(new Object[]{
                propietario.getDocumento(),
                propietario.getNombre(),
                propietario.getTelefono(),});
        }
        return modelo;
    }

}

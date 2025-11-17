/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nomina.modelo;

/**
 * Empleado con salario fijo mensual.
 */
class EmpleadoAsalariado extends Empleado {
    private double salarioMensual;
    private static final double BONO_ANTIGUEDAD = 0.10;
    private static final int ANIOS_PARA_BONO = 5;
    private static final double BONO_ALIMENTACION = 1000000;
    
    public EmpleadoAsalariado(String id, String nombre, String identificacion, 
                              int antiguedadAnios, double salarioMensual) {
        super(id, nombre, identificacion, antiguedadAnios);
        this.salarioMensual = salarioMensual;
    }
    
    @Override
    public double calcularSalarioBruto() {
        return salarioMensual;
    }
    
    @Override
    public double calcularBeneficios() {
        double beneficios = BONO_ALIMENTACION; // Empleado permanente
        
        // Bono por antigüedad
        if (antiguedadAnios > ANIOS_PARA_BONO) {
            beneficios += salarioMensual * BONO_ANTIGUEDAD;
        }
        
        return beneficios;
    }
    
    @Override
    public String getTipoEmpleado() {
        return "Asalariado";
    }
    
    public double getSalarioMensual() { return salarioMensual; }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nomina.modelo;

/**
 * Empleado que cobra por horas trabajadas.
 */
class EmpleadoPorHoras extends Empleado {
    private double tarifaPorHora;
    private double horasTrabajadas;
    private boolean aceptaFondoAhorro;
    
    private static final double HORAS_NORMALES = 40;
    private static final double MULTIPLICADOR_HORAS_EXTRAS = 1.5;
    private static final double PORCENTAJE_FONDO_AHORRO = 0.02;
    
    public EmpleadoPorHoras(String id, String nombre, String identificacion, 
                           int antiguedadAnios, double tarifaPorHora, 
                           double horasTrabajadas, boolean aceptaFondoAhorro) {
        super(id, nombre, identificacion, antiguedadAnios);
        
        // se debe validar: horas no pueden ser negativas
        if (horasTrabajadas < 0) {
            throw new IllegalArgumentException("Las horas trabajadas no pueden ser negativas");
        }
        
        this.tarifaPorHora = tarifaPorHora;
        this.horasTrabajadas = horasTrabajadas;
        this.aceptaFondoAhorro = aceptaFondoAhorro;
    }
    
    @Override
    public double calcularSalarioBruto() {
        double salario = 0;
        
        if (horasTrabajadas <= HORAS_NORMALES) {
            salario = horasTrabajadas * tarifaPorHora;
        } else {
            // Horas normales + horas extras
            double horasNormales = HORAS_NORMALES * tarifaPorHora;
            double horasExtras = (horasTrabajadas - HORAS_NORMALES) * 
                                tarifaPorHora * MULTIPLICADOR_HORAS_EXTRAS;
            salario = horasNormales + horasExtras;
        }
        
        return salario;
    }
    
    @Override
    public double calcularBeneficios() {
        double beneficios = 0;
        
        // Fondo de ahorro para empleados con más de 1 año
        if (antiguedadAnios > 1 && aceptaFondoAhorro) {
            beneficios += calcularSalarioBruto() * PORCENTAJE_FONDO_AHORRO;
        }
        
        return beneficios;
    }
    
    @Override
    public String getTipoEmpleado() {
        return "Por Horas";
    }
    
    public double getTarifaPorHora() { return tarifaPorHora; }
    public double getHorasTrabajadas() { return horasTrabajadas; }
}

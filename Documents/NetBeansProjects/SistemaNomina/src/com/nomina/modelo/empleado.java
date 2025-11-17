/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nomina.modelo;

import com.nomina.interfaces.Beneficiable;
import com.nomina.interfaces.CalculadorSalario;
import com.nomina.interfaces.Deducible;

/**
 *
 * @author Jean Carlos
 */

abstract class Empleado implements CalculadorSalario, Deducible, Beneficiable {
    protected String id;
    protected String nombre;
    protected String identificacion;
    protected int antiguedadAnios;
    
    // Constantes para deducciones
    protected static final double PORCENTAJE_SEGURO_PENSION = 0.04;
    protected static final double PORCENTAJE_ARL = 0.00522; // 0.522% promedio
    
    public Empleado(String id, String nombre, String identificacion, int antiguedadAnios) {
        this.id = id;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.antiguedadAnios = antiguedadAnios;
    }
    
    /**
     * Template Method Pattern: Define el esqueleto del cálculo de salario neto.
     * Las subclases implementan los métodos específicos.
     */
    @Override
    public double calcularSalarioNeto() {
        double salarioBruto = calcularSalarioBruto();
        double beneficios = calcularBeneficios();
        double deducciones = calcularDeducciones();
        
        double salarioNeto = salarioBruto + beneficios - deducciones;
        
        // Validación: salario neto no puede ser negativo
        return Math.max(salarioNeto, 0);
    }
    
    /**
     * Calcula las deducciones obligatorias (Seguro Social, Pensión y ARL).
     */
    @Override
    public double calcularDeducciones() {
        double salarioBruto = calcularSalarioBruto();
        return salarioBruto * (PORCENTAJE_SEGURO_PENSION + PORCENTAJE_ARL);
    }
    
    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getIdentificacion() { return identificacion; }
    public int getAntiguedadAnios() { return antiguedadAnios; }
    
    public abstract String getTipoEmpleado();
}
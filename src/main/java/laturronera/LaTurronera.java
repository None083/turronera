/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package laturronera;

import javax.swing.JOptionPane;

/**
 *
 * @author FX506
 */
public class LaTurronera {

    public static void main(String[] args) {

        final double MANOBRAGRUPOUNO = 0.15;
        final double MANOBRAGRUPODOS = 0.22;

        String codigo = JOptionPane.showInputDialog("""
                                                 PRODUCTOS
                                    -------------------------------------
                                    M1 - Mantecados de limón
                                    P1 - Polvorones
                                    T1 - Turrón de chocolate
                                    T2 - Turrón clásico
                                    M2 - Mazapanes
                                    
                                    Introduzca un código: 
                                    """);

        if (codigo.equalsIgnoreCase("M1")
                || codigo.equalsIgnoreCase("T1")) {
            String materiaPrima = JOptionPane.showInputDialog(
                    "Introduzca el precio de la materia prima");
            double materiaPrimaDouble = Double.parseDouble(materiaPrima);
            if (materiaPrimaDouble >= 0.1 && materiaPrimaDouble <= 1) {
                if (codigo.equalsIgnoreCase("M1")) {
                    double costeProduccion
                            = materiaPrimaDouble + MANOBRAGRUPOUNO;
                    double ventaUnitaria = costeProduccion
                            + (0.5 * costeProduccion);
                    double ventasNecesarias = 2500 / (ventaUnitaria - costeProduccion);
                    ventasNecesarias = Math.ceil(ventasNecesarias);
                    JOptionPane.showMessageDialog(null,
                            """
                                         M1 - Mantecados de limón
                                ------------------------------------------------
                                Coste de producción unitario: %.2f €
                                Precio de venta unitario: %.2f €
                                Ventas necesarias para producir beneficio: %.0f
                                """.formatted(costeProduccion,
                                    ventaUnitaria, ventasNecesarias));
                } else if (codigo.equalsIgnoreCase("T1")) {
                    double costeProduccion
                            = materiaPrimaDouble + MANOBRAGRUPOUNO;
                    double ventaUnitaria = costeProduccion
                            + (0.65 * costeProduccion);
                    double ventasNecesarias = 2500 / (ventaUnitaria - costeProduccion);
                    ventasNecesarias = Math.ceil(ventasNecesarias);
                    JOptionPane.showMessageDialog(null,
                            """
                                        T1 - Turrón de chocolate
                                ------------------------------------------------
                                Coste de producción unitario: %.2f €
                                Precio de venta unitario: %.2f €
                                Ventas necesarias para producir beneficio: %.0f
                                """.formatted(costeProduccion,
                                    ventaUnitaria, ventasNecesarias));
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "El precio de la materia prima no es correcto");
            }
        } else if (codigo.equalsIgnoreCase("P1")
                || codigo.equalsIgnoreCase("T2")
                || codigo.equalsIgnoreCase("M2")) {
            String materiaPrima = JOptionPane.showInputDialog(
                    "Introduzca el precio de la materia prima");
            double materiaPrimaDouble = Double.parseDouble(materiaPrima);
            if (materiaPrimaDouble >= 0.1 && materiaPrimaDouble <= 1) {
                if (codigo.equalsIgnoreCase("P1")
                        || codigo.equalsIgnoreCase("M2")) {
                    double costeProduccion
                            = materiaPrimaDouble + MANOBRAGRUPODOS;
                    double ventaUnitaria = costeProduccion
                            + (0.5 * costeProduccion);
                    double ventasNecesarias = 2500 / (ventaUnitaria - costeProduccion);
                    ventasNecesarias = Math.ceil(ventasNecesarias);
                    JOptionPane.showMessageDialog(null,
                            """
                                            P1 - Polvorones o
                                            M2 - Mazapanes
                                ------------------------------------------------
                                Coste de producción unitario: %.2f €
                                Precio de venta unitario: %.2f €
                                Ventas necesarias para producir beneficio: %.0f
                                """.formatted(costeProduccion,
                                    ventaUnitaria, ventasNecesarias));
                } else if (codigo.equalsIgnoreCase("T2")) {
                    double costeProduccion
                            = materiaPrimaDouble + MANOBRAGRUPODOS;
                    double ventaUnitaria = costeProduccion
                            + (0.65 * costeProduccion);
                    double ventasNecesarias = 2500 / (ventaUnitaria - costeProduccion);
                    ventasNecesarias = Math.ceil(ventasNecesarias);
                    JOptionPane.showMessageDialog(null,
                            """
                                           T2 - Turrón clásico
                                ------------------------------------------------
                                Coste de producción unitario: %.2f €
                                Precio de venta unitario: %.2f €
                                Ventas necesarias para producir beneficio: %.0f
                                """.formatted(costeProduccion,
                                    ventaUnitaria, ventasNecesarias));
                }

            } else {
                JOptionPane.showMessageDialog(null,
                        "El precio de la materia prima no es correcto");
            }

        } else {
            JOptionPane.showMessageDialog(null,
                    "No se ha introducido un código válido ");
        }

    }
}

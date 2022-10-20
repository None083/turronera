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
        
        //se declaran las constantes para las operaciones matemáticas

        final double MANOBRA_M1_T1 = 0.15;
        final double MANOBRA_M2_T2_P1 = 0.22;

        final double BENEFICIO_M1_M2_P1 = 0.5;
        final double BENEFICIO_T1_T2 = 0.65;

        final double BENEFICIO_VENTAS = 2500;

        final double LIMITE_INFERIOR = 0.1;
        final double LIMITE_SUPERIOR = 1;

        //aqui crearé un string con los codigos que se mostrarán con un 
        //joption y pedirá que elijas uno
        
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
        
        //aquí abro un if en el que si inroduzco uno de los codigos dados
        //comenzará a calcular lo que me piden
        //si no es uno de esos codigos aparecerá una ventana diciendo
        //que no es valido

        if (codigo.equalsIgnoreCase("M1")
                || codigo.equalsIgnoreCase("T1")) {
            String materiaPrima = JOptionPane.showInputDialog(
                    "Introduzca el precio de la materia prima");
            double materiaPrimaDouble = Double.parseDouble(materiaPrima);
            if (materiaPrimaDouble >= LIMITE_INFERIOR
                    && materiaPrimaDouble <= LIMITE_SUPERIOR) {
                if (codigo.equalsIgnoreCase("M1")) {
                    double costeProduccion = materiaPrimaDouble + MANOBRA_M1_T1;
                    double ventaUnitaria = costeProduccion
                            + (BENEFICIO_M1_M2_P1 * costeProduccion);
                    double ventasNecesarias = BENEFICIO_VENTAS
                            / (ventaUnitaria - costeProduccion);
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
                    double costeProduccion = materiaPrimaDouble + MANOBRA_M1_T1;
                    double ventaUnitaria = costeProduccion
                            + (BENEFICIO_T1_T2 * costeProduccion);
                    double ventasNecesarias = BENEFICIO_VENTAS
                            / (ventaUnitaria - costeProduccion);
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
                    double costeProduccion = materiaPrimaDouble + MANOBRA_M2_T2_P1;
                    double ventaUnitaria = costeProduccion
                            + (BENEFICIO_M1_M2_P1 * costeProduccion);
                    double ventasNecesarias = BENEFICIO_VENTAS
                            / (ventaUnitaria - costeProduccion);
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
                    double costeProduccion = materiaPrimaDouble + MANOBRA_M2_T2_P1;
                    double ventaUnitaria = costeProduccion
                            + (BENEFICIO_T1_T2 * costeProduccion);
                    double ventasNecesarias = BENEFICIO_VENTAS
                            / (ventaUnitaria - costeProduccion);
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

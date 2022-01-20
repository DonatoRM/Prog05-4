import java.util.Scanner;

/**
 * Ejercicio 4 de Tarea del Bloque de Contenidos 5
 *
 * @author Donato Ramos Martínez
 */
public class EscudosDelEjercitoRomano {

    /**
     * @param args No son necesarios los argumentos del método main
     */
    public static void main(String[] args) {
        // Declaración e inicialización de variable
        int numeroLegionariosElegidos; // Selección de número de Legionarios
        int legionariosComputo; // Número de Legionarios para comprobación
        int tamanoFormacion; // Número de Filas de la Formación
        int legionariosFormacion; // Número de Legionarios por Formación
        int legionariosLibres; // Número de Legionarios restantes
        /*
        Número de Legionarios según el número de eswcudos que posean en la
        Formación.
         */
        long cincoEscudos, tresEscudos, dosEscudos, unEscudo;
        long escudosTotales; // Número de escudos en total
        Scanner leer = new Scanner(System.in);

        // Desarrollo del programa
        /*
        Hacemos un bucle en donde no se sale hasta que introduzcamos el valor 
        cero en el número de Legionarios elegidos.
         */
        do {
            numeroLegionariosElegidos = Integer.parseInt(leer.nextLine());
            escudosTotales = 0; // Al inicio, el número es escudos totales es 0
            /*
            Para realizar los cálculos creamos la nueva variable para que no 
            interfiera en el bucle anterior.
             */
            legionariosComputo = numeroLegionariosElegidos;
            if (numeroLegionariosElegidos > 0) {
                /*
                El bucle siguiente nos asegura que no van a quedar Legionarios
                sin estar en algún tipo de formación.
                 */
                while (legionariosComputo != 0) {
                    tamanoFormacion = 1; // La formación mínima es de 1 Legionario
                    /*
                    Comprobamos con el siguiente bucle el número máximo de filas
                    por formación que se podrá hacer con el número de 
                    Legionarios del Cómputo.
                     */
                    while (((tamanoFormacion + 1) * (tamanoFormacion + 1))
                            <= legionariosComputo) {
                        tamanoFormacion++; // Se va incrementando la variable
                    }
                    /*
                    Una vez que sabemos el tamaño máximo de la formación para
                    el número de Legionarios del cómputo, calculamos cuántos
                    Legionarios entran en dicha formación y cuando quedan fuera
                    de ella.
                     */
                    legionariosFormacion = tamanoFormacion * tamanoFormacion;
                    legionariosLibres = legionariosComputo
                            - legionariosFormacion;

                    /*
                    Según el tamaño de la formación y según la posición del 
                    Legionario, tendrá un número determinado de escudos para
                    defenderse y defender a sus compañeros. 
                     */
                    switch (tamanoFormacion) {
                        case 1:
                            cincoEscudos = 1;
                            tresEscudos = 0;
                            dosEscudos = 0;
                            unEscudo = 0;
                            break;
                        case 2:
                            cincoEscudos = 0;
                            tresEscudos = 4;
                            dosEscudos = 0;
                            unEscudo = 0;
                            break;
                        default:
                            cincoEscudos = 0;
                            tresEscudos = 4;
                            dosEscudos = 4 * (tamanoFormacion - 2);
                            unEscudo = (tamanoFormacion - 2) * (tamanoFormacion - 2);
                    }
                    /*
                    Realizamos la suma de todos los escudos que hay en la 
                    Formación junto con los de las formaciones anteriores.
                     */
                    escudosTotales = escudosTotales + (5 * cincoEscudos) + (3
                            * tresEscudos) + (2 * dosEscudos) + unEscudo;
                    // Ahora, el número de Legionarios del cómputo cambia
                    legionariosComputo = legionariosLibres;
                }
                // Se muestra por pantalla el número total de escudos.
                System.out.println(escudosTotales);
            }
        } while (numeroLegionariosElegidos > 0);
    }
}

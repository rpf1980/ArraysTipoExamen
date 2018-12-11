package com.company;

import java.text.BreakIterator;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void EscribeArray(int[] a)
    {
        int i;
        System.out.print("[");
        for(i = 0; i < a.length-1; i++)
        {
            System.out.print(a[i] + ",");
        }
        System.out.print(a[a.length-1] + "]");
    }

    public static void EscribeArrayBoolean(boolean[] a)
    {
        int i;
        System.out.print("[");
        for(i = 0; i < a.length-1; i++)
        {
            System.out.print(a[i] + ",");
        }
        System.out.print(a[a.length-1] + "]");
    }

    public static void EscribeArrayDouble(double[] a)
    {
        int i;
        System.out.print("[");
        for(i = 0; i < a.length-1; i++)
        {
            System.out.print(a[i] + ",");
        }
        System.out.print(a[a.length-1] + "]");
    }

    public static void IntercambiaParImpar(int[] a)
    {
        int[] b = new int[a.length];
        int i;

        for(i = 0; i < a.length; i++)
        {
            if(i %2== 0)
            {
                b[i] = a[i+1];
            }
            else
            {
                b[i] = a[i-1];
            }
        }

        for(i = 0; i < b.length; i++)
        {
            a[i] = b[i];
        }
    }

    public static boolean CompruebaTarjeta(int[] a)
    {

        boolean valida = false;
        int[] b = new int[a.length];
        int i, j;
        int suma = 0;

        if(a.length == 16)
        {
            j = 0;
            for(i = 0; i < a.length; i++)
            {
                if(i %2 == 0)
                {
                    b[j] = a[i] * 2;
                    j++;
                }
                else
                {
                    suma = suma + a[i];
                }
            }

            for(i = 0; i < b.length; i++)
            {
                if(b[i] >= 10)
                {
                    b[i] -= 9;
                }
                suma = suma + b[i];
            }

            if(suma %10 == 0)
            {
                valida = true;
            }
        }
        else
        {
            System.out.println("La tarjeta no cumple el tamaño de dígitos");
        }
        return valida;
    }

    public static int[] TailArray(int[] a, int n)
    {
        int aux;
        int contador;
        int[] b = new int[n];
        int i, j;

        j = 0;
        for(i = a.length-1; i >= a.length-n; i--)
        {
            b[j] = a[i];
            j++;
        }

        contador = b.length-1;
        for(i = 0; i < b.length/2; i++, contador--)
        {
            aux = b[i];
            b[i] = b[contador];
            b[contador] = aux;
        }
        return b;
    }

    public static boolean Detecta5(int[] a)
    {
        boolean cinco = false;
        int i,j;
        int contador = 0;

        if(a.length >= 5)
        {
            for(i = 0; i < a.length-1; i++)
            {
                j = i + 1;
                contador = 1;
                for(j = i + 1; j < a.length-1; j++)
                {
                    if(contador == 5)
                    {
                        i = a.length;
                        j = a.length;
                        cinco = true;
                    }
                    else
                    {
                        if(a[i] == a[j])
                        {
                            contador += 1;
                        }
                        else
                        {
                            j = a.length;
                            contador = 0;
                        }
                    }
                }
            }

        }
        else
        {
            System.out.println("El tamaño del array no es suficiente");
        }
        return cinco;
    }

    public static boolean Primo(int n)
    {
        boolean primo = true;
        int i;
        int divisores = 0;

        for(i = 1; i <= n; i++)
        {
            if(n %i == 0)
            {
                divisores++;
            }
        }
        if(divisores > 2)
        {
            primo = false;
        }
        return primo;
    }

    public static boolean[] CalculaNPrimos(int n)
    {
        boolean[] primos = new boolean[n+1];
        int i;

        for(i = 0; i <= n; i++)
        {
            if(i == 0 || i == 1)
            {
                primos[i] = false;
            }
            else
            {
                if(Primo(i))
                {
                    primos[i] = true;
                }
            }
        }
        return primos;
    }

   /* public static void EscribeArrayNotas(double[] nota)
    {
        String ANSI_RESET = "\u001B[0m";

        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_WHITE = "\u001B[37m";

        int i;

        System.out.print("[");
        for(i = 0; i < nota.length; i++)
        {
            if(nota[i] < 0 || nota[i] > 10)
            {
                System.out.print(ANSI_YELLOW+"ERROR"+ANSI_RESET);
            }
            else
            {
                if(nota[i] >= 0 && nota[i] < 5)
                {
                    System.out.print(ANSI_RED + nota[i] + ANSI_RESET);
                }
                else
                {
                    if(nota[i] >= 5 && nota[i] <= 10)
                    {
                        System.out.print(ANSI_GREEN + nota[i] + ANSI_RESET);
                    }
                    else
                    {
                        System.out.print(ANSI_WHITE + nota[i] + ANSI_RESET);
                    }
                }
            }
            System.out.print(",");
        }
        System.out.print("\b");
        System.out.print("]");
    }*/

    public static void EscribeArrayNotas(double[] nota)
    {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_WHITE = "\u001B[37m";
        String ANSI_YELLOW = "\u001B[33m";
        int i;

        System.out.print("[");
        for(i = 0; i < nota.length; i++)
        {
            if(nota[i] < 0 || nota[i] > 10)
            {
                System.out.print(ANSI_YELLOW+"Nota no válida"+ANSI_RESET);
            }
            else
            {
                if(nota[i] >= 0 && nota[i] < 5)
                {
                    System.out.print(ANSI_RED + nota[i] + ANSI_RESET);
                }
                else
                {
                    if(nota[i] >= 5 && nota[i] <= 10)
                    {
                        System.out.print(ANSI_GREEN + nota[i] + ANSI_RESET);
                    }
                    else
                    {
                        System.out.print(ANSI_WHITE + nota[i] + ANSI_RESET);
                    }
                }
            }
            System.out.print(",");
        }
        System.out.print("\b");
        System.out.print("]");
    }

    public static int PrimeraPosicionValor(int[] a, int valor)
    {
        int posicion = -1;
        int i;

        for(i = 0; i < a.length; i++)
        {
            if(a[i] == valor)
            {
                posicion = i;
                break;
            }
        }
        return posicion;
    }

    public static void TachaElementosComunes(int[] a, int[] b)
    {
        int[] copiaA = new int[a.length];
        int[] copiaB = new int[b.length];
        int i, j;
        int pos;

        //Comparamos a con b y guardamos iguales de a en copiaA
        for(i = 0; i < a.length; i++)
        {
            for(j = 0; j < b.length; j++)
            {
                if(a[i] == b[j])
                {
                    pos = PrimeraPosicionValor(a, a[i]);
                    copiaA[pos] = a[pos];
                }
            }
        }

        //Comparamos b con a y guardamos iguales de b en copiaB
        for(j = 0; j < b.length; j++)
        {
            for(i = 0; i < a.length; i++)
            {
                if(b[j] == a[i])
                {
                    pos = PrimeraPosicionValor(b, b[j]);
                    copiaB[pos] = b[pos];
                }
            }
        }
        EscribeArray(copiaA);
        System.out.println();
        EscribeArray(copiaB);

    }

    public static int[] BorraDeArray(int[] a, int posicion)
    {
        int[] b = new int[a.length-1];
        int i;

        for(i = 0; i < posicion; i++)
        {
            b[i] = a[i];
        }
        for(i = posicion+1; i < a.length; i++)
        {
            b[i-1] = a[i];
        }
        return b;
    }

    public static int[] CopiaArrayPro(int[] a)
    {
        int[] copia = new int[a.length];
        int i;
        for(i = 0; i < a.length; i++)
        {
            copia[i] += a[i];
        }
        return copia;
    }

    public static int[] EliminaRepetidos(int[] a)
    {
        int posicion;
        int[] b = CopiaArrayPro(a);
        int i;

        for(i = 0; i < b.length; i++)                    //{1,2,3,1,1}
        {
            posicion = PrimeraPosicionValor(b, b[i]);  //Aquí se guarda la posición del primer valor encontrado... En esta parte buscamos si hay un valor igual al array en la posición i

            if(posicion != i)   //Como estamos comprobando las posiciones en las que están los elementos, en el momento que la pisición del elemento no coincida con la primera posición dónde apareció (ya se repite) borramos ese elemento en esa posición
            {
                b = BorraDeArray(b, i);
                i--;
            }
        }
        return b;
    }

    public static int[] RedondeaArray(double[] a)
    {
        int i;
        int[] b = new int[a.length];

        for(i = 0; i < a.length; i++)
        {
            b[i] = (int)Math.floor(a[i]);
        }

        return b;
    }

    public static double[] DecimalesArray(double[] a)
    {
        int i;
        int[] b = new int[a.length];
        double[] resultado = new double[a.length];

        //Obtenemos la parte entera
        b = RedondeaArray(a);

        //Recorremos a y restamos la parte entera a la parte decimal y nos queda la parte decimal
        for(i = 0; i < a.length; i++)
        {
            resultado[i] = a[i] - b[i];
        }
        return resultado;
    }

    public static int[] DesordenaArray(int[] a)
    {
        int[] copia = CopiaArrayPro(a);
        int[] des = new int[copia.length];
        int aleatorio;
        int i, pos;
        Random rd = new Random();

        for(i = 0; i < des.length; i++)
        {
            pos = rd.nextInt(copia.length);
            des[i] = copia[pos];
            copia = BorraDeArray(copia, pos);
        }
        return des;

    }

    public static int MinArray(int[] a)
    {
        int min = a[0];
        int i;

        for(i = 0; i < a.length; i++)
        {
            if(a[i] < min)
            {
                min = a[i];
            }
        }
        return min;
    }

    public static int MaxArray(int[] a)
    {
        int max = a[0];
        int i;

        for(i = 0; i < a.length; i++)
        {
            if(a[i] > max)
            {
                max = a[i];
            }
        }
        return max;
    }

    public static int[] MinMaxArray(int[] a)
    {
        int min = MinArray(a);
        int max = MaxArray(a);
        int tama = max - min+1;
        int[] b = new int[tama];
        int i, j;

        j = 0;
        for(i = min; i <= max; i++)
        {
            b[j] = i;
            j++;
        }
        return b;
    }

    public static void GraficaBarras(int[] a)
    {
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_RESET = "\u001B[0m";

        char c = '█';
        int i, j;

        for(i = 0; i < a.length; i++)
        {
            if(a[i] < 0 || a[i] > 10)
            {
                System.out.println("ERROR");
            }
            else
            {
                if(a[i] >= 5)
                {
                    System.out.print(ANSI_GREEN + a[i] + " " + "\t" + ANSI_RESET);
                    for(j = 0; j < a[i]; j++)
                    {
                        System.out.print(c);
                    }
                }
                else
                {
                    if(a[i] < 5)
                    {
                        System.out.print(ANSI_RED + a[i] + " " + "\t" + ANSI_RESET);
                        for(j = 0; j < a[i]; j++)
                        {
                            System.out.print(c);
                        }
                    }
                }
            }
            System.out.println();

        }
    }

    public static int MejorRacha(int[] a)
    {
        int racha = 0, max = 0;
        int i;

        for(i = 0; i < a.length-1; i++)
        {
            if(a[i] > a[i+1])
            {
                racha += 1;
            }
            else
            {
                if(racha > max)
                {
                    max = racha;
                    racha = 0;
                }
            }
        }
        return max;
    }

    public static int MCM(int a, int b)
    {
        int mcm = 0;
        int multiplo;

        if(a > b)
        {
            multiplo = a;
        }
        else
        {
            multiplo = b;
        }

        while(multiplo %a != 0 || multiplo %b != 0)
        {
            multiplo++;
        }
        return multiplo;
    }

    public static int[] NumerosPrimosPro(int[] a)
    {
        boolean primoActual;
        int conteoDePrimos = 0;
        int[] b = new int[a.length];
        int[] copia = new int[1];
        int i, n, k;
        int posicion;
        int mcm;
        int contadorCopia = 0;

        n = 0;
        //Con el primer bucle rellenamos del 0 al 1000
        for(i = 0; i < a.length; i++)
        {
            a[i] = n;
            n++;
        }
        //Segundo bucle para comprobar nº's del array según algoritmo ejercicio
        for(i = 2; i < a.length; i++)
        {
            if(Primo(a[i]))
            {
                copia[contadorCopia] = a[i];
                copia = Arrays.copyOf(copia, copia.length+1);
                contadorCopia++;

                for(k = i+1; k < a.length; k++)
                {
                    mcm = MCM(a[i],a[k]);
                    if(a[k] %mcm == 0)
                    {
                        posicion = k;
                        if(b[posicion] != -1)
                        {
                            b[posicion] = -1;
                        }
                    }
                }
            }
        }
        if(copia[copia.length-1] == 0)
        {
            copia = BorraDeArray(copia, copia.length-1);
        }
        return copia;
    }

    public static boolean ContieneElemento(int[] a, int elemento)
    {
        boolean contiene = false;
        int i;

        for(i = 0; i < a.length; i++)
        {
            if(a[i] == elemento)
            {
                contiene = true;
            }
        }
        return contiene;
    }

    public static int[] ElementosComunes(int[] a, int[] b)
    {
        int[] arrayComunes = new int[a.length];
        int i, j;

        j = 0;
        for(i = 0; i < a.length; i++)
        {
            if(ContieneElemento(b, a[i]))
            {
                arrayComunes[j] = a[i];
                j++;
            }
        }
        for(i = 0; i < arrayComunes.length; i++)
        {
            if(arrayComunes[i] == 0)
            {
                arrayComunes = BorraDeArray(arrayComunes, i);
                i--;
            }
        }
        return arrayComunes;
    }

    public static boolean HayRepetidos(int[] a)
    {
        boolean repetidos = false;
        int contador = 0;
        int i;

        for(i = 0; i < a.length-1; i++)
        {
            if(a[i] == a[i+1])
            {
                contador++;
            }
        }
        if(contador >= 1)
        {
            repetidos = true;
        }
        return repetidos;
    }

    public static int[] RellenaQuinielaAleatoria()
    {
        Random rd = new Random();
        int i;
        int[] alea = new int[15];

        for(i = 0; i < alea.length; i++)
        {
            alea[i] = rd.nextInt(3);
            if(alea[i] == 0)
            {
                alea[i] = 10;
            }
        }
        return alea;
    }

    public static int AciertosQuiniela(int[] a, int[] b)
    {
        int aciertos = 0;
        int i;

        for(i = 0; i < a.length; i++)
        {
            if(a[i] == b[i])
            {
                aciertos++;
            }
        }
        return aciertos;
    }

    public static double ElementoMedia(double[] a)
    {
        double media;
        double suma = 0;
        int i;
        double min;
        double[] diferencias = new double[a.length];
        int pos;

        //Calculamos la media
        for(i = 0; i < a.length; i++)
        {
            suma = suma + a[i];
        }
        media = suma / a.length;

        //Creamos un array con las diferencias de media - elementos del array... pero con los valores absolutos (para quitar signos negativos)
        for(i = 0; i < a.length; i++)
        {
            diferencias[i] = Math.abs(a[i]-media);
        }

        //Buscamos el primer valor menor en este array "diferencias" (este será el que más se aproxime a la media)
        min = diferencias[0];
        pos = 0;
        for(i = 0; i < diferencias.length; i++)
        {
            if(diferencias[i] < min)
            {
                min = diferencias[i];
                pos = i;
            }
        }
        return a[pos];
    }

    public static int[] ConcatenaArraysPro(int[] a, int[] b)
    {
        //Primera forma de hacerlo
        /*int[] c = new int[a.length + b.length];
        ConcatenaArray55(a,b,c);
        return c;*/

        //-----------------<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>-------------------

        //Segunda forma de hacerlo
        int[] c = new int[a.length + b.length];
        int i;
        for (i = 0; i < a.length; i++)
        {
            c[i] = c[i] + a[i];
        }
        for (i = 0; i < b.length; i++)
        {
            c[i + a.length] += b[i];
        }
        return c;
    }

    public static int[] OrdenaPorMezcla(int[] a, int[] b)
    {
                                        //int[] b = {6,2,7,1};
        Arrays.sort(a);                 //int[] a = {9,4,2,5,6,12,7,8};
        Arrays.sort(b);
        int[] c = new int[a.length+b.length];
        int i = 0;
        int j;

        while(a.length > 0 && b.length > 0)
        {
            if(a[0] < b[0])
            {
                c[i] = a[0];
                a = BorraDeArray(a, 0);
            }
            else
            {
                c[i] = b[0];
                b = BorraDeArray(b, 0);
            }
            i++;
        }

        if(a.length > 0)
        {
            for(j = 0; j < a.length; j++)
            {
                c[i] = a[j];
                i++;
            }
        }
        else
        {
            if(b.length > 0)
            {
                for(j = 0; j < b.length; j++)
                {
                    c[i] = b[j];
                    i++;
                }
            }
        }
        return c;

    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("=======================");
        System.out.println("MENÚ ARRAYS TIPO EXAMEN");
        System.out.println("=======================");
        System.out.println("[1] IntercambiaParImpar");
        System.out.println("[2] CompruebaTarjeta");
        System.out.println("[3] TailArray");
        System.out.println("[4] Detecta5");
        System.out.println("[5] CalculaNPrimos");
        System.out.println("[6] EscribeArrayNotas");
        System.out.println("[7] TachaElementosComunes");
        System.out.println("[8] EliminaRepetidos");
        System.out.println("[9] DOS FUNCIONES (RedondeaArray || DecimalesArray)");
        System.out.println("[10] DesordenaArray");
        System.out.println("[11] MinMaxArray");
        System.out.println("[12] GraficaBarras");
        System.out.println("[13] MejorRacha");
        System.out.println("[14] NumerosPrimosPro");
        System.out.println("[15] ElementosComunes");
        System.out.println("[16] HayRepetidos");
        System.out.println("[17] AciertosQuiniela");
        System.out.println("[18] ElementoMedia");
        System.out.println("[19] OrdenaPorMezcla");   //**NO ESTÁ HECHO
        System.out.println();
        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();

        switch (opcion)
        {
            case 1:
            {
                // Escribe  la  función  intercambiaParImpar.  A  esta  función  le  pasaremos  un  array  de
                //enteros  por  parámetro  y  en  ese  mismo  array  intercambiará  los  elementos  de  las
                //posiciones pares por los elementos de las posiciones impares: el elemento de la posición
                //0 se intercambiará con el de la posición 1, el de la posición 2 con el de la posición 3, etc.
                //El array tendrá que tener un número par de elementos (2, 4, 6, etc.). De no ser así, la
                //función mostrará un mensaje de error y dejará el array como estaba.
                //Ej.:  Si le pasamos [1, 2, 3, 4, 5, 6], el array quedará: [2, 1, 4, 3, 6, 5]
                //  Si le pasamos [1, 2, 1, 2, 1, 2], el array quedará: [2, 1, 2, 1, 2, 1]
                //  Si le pasamos [7, 1, 4, 6, 9, 5], el array quedará: [1, 7, 6, 4, 5, 9]


                int[] a = {1, 2, 3, 4, 5, 6};

                EscribeArray(a);
                System.out.println();
                IntercambiaParImpar(a);
                EscribeArray(a);
                System.out.println();
            }
            break;

            case 2:
            {
                //Escribe la función compruebaTarjeta. A esta función le pasaremos un array de enteros
                //con los 16 números de una tarjeta de crédito. La función nos devolverá un boolean que
                //será true si el número de tarjeta es correcto y false si no lo es. Para averiguar si un
                //número de tarjeta de crédito es correcto utilizaremos el siguiente algoritmo:
                //1.  Multiplicar por dos los valores que estén en las posiciones pares del array (0, 2, …).
                //2.  Si algún valor es mayor que 10, restarle 9 a ese valor.
                //3.  Sumar todos los valores. Si el resultado es múltiplo de 10, la tarjeta es buena.
                //Ejemplos de tarjetas válidas: 5565 8666 4522 7307, 4929 9968 6150 1756
                //
                //Nota:  No  os  carguéis  el  array  inicial.  Si  el  array  no  tiene  16  elementos,  devolver  false
                //directamente.

                int[] a = {5,5,6,5,8,6,6,6,4,5,2,2,7,3,0,7};
                boolean valida;
                EscribeArray(a);
                System.out.println();
                valida = CompruebaTarjeta(a);
                System.out.println(valida);
            }
            break;

            case 3:
            {
                // Escribe  la  función  tailArray.  A  esta  función  le  pasaremos  un  array  de  enteros  y  un
                //número n. La función nos devolverá otro array de enteros con los n últimos elementos
                //del array que le pasamos. O sea, si n = 5, nos devolverá un array con las cinco últimas
                //posiciones del primero. Si n es mayor que el número de elementos del array o n es
                //menor que 0, la función mostrará un mensaje de error y devolverá el array original.
                //Ej.:   Si le pasamos [1, 2, 3, 4, 5, 6] y n=3, nos devolverá: [4, 5, 6]
                //
                //Nota: El array que le pasamos por parámetro debe quedar exactamente igual que al principio;
                //no os lo carguéis.

                int[] a = {1,2,3,4,5,6,7,8,9};
                int n;
                int[] b;

                EscribeArray(a);
                System.out.print("N enteros para recortar: ");
                n = sc.nextInt();

                b = TailArray(a,n);
                EscribeArray(b);

            }
            break;

            case 4:
            {
                // Escribe la función detecta5 a la que le pasamos un array de enteros y nos dice si hay, al
                //menos una vez, cinco números iguales consecutivos (nos devuelve un boolean).

                int[] a = {1,2,1,3,3,3,3,3,4,5,6,7,7,7};
                boolean cinco;

                EscribeArray(a);
                cinco = Detecta5(a);
                System.out.println("\n"+cinco);
            }
            break;

            case 5:
            {
                //Escribe  la  función calculaNPrimos.  A  la función  le pasaremos  un entero  que  será el
                //máximo número primo que queremos calcular. Por ejemplo, si le pasamos el 10 nos dirá
                //qué números son primos entre 1 y 10.
                //El resultado lo devolverá en un array de booleanos, de tal forma que, si un número x es
                //primo, en la posición x pondrá true y si no es primo pondrá false.
                //
                //Ej.:  CalculaNPrimos(10)  nos  devolverá  un  array  de  11  elementos (porque  la  primera
                //posición es 0 y necesitamos 11 para que exista la posición 10).
                //El array será:  [ False False True True False True False True False False False ]
                //Las dos primeras posiciones son false porque el 0 y el 1 no son primos y luego estarán a
                //true las posiciones 2, 3, 5 y 7.

                int n = 10;
                boolean[] resultado;

                System.out.println("Buscaremos " + n + " números primos");
                resultado = CalculaNPrimos(n);
                System.out.println();
                EscribeArrayBoolean(resultado);

            }
            break;

            case 6:
            {
                //Escribe la función EscribeArrayNotas que te escribe por pantalla un array de double que
                //contiene notas del alumnado, con las siguientes características:
                //•  Si la nota está entre 5 y 10, se escribirá en verde.
                //•  Si la nota está entre 0 y 5 (sin incluir el cinco), se escribirá en rojo.
                //•  Si la nota no está entre 0 y 10, en lugar de la nota se escribirá “ERROR” en
                //amarillo.
                //•  El resto de cosas (los corchetes, las comas) se escribirán en blanco.
                //Para cambiar de color en la consola, en Java tenemos que usar los códigos ANSI. Para
                //imprimir en un color, escribiremos el código ANSI correspondiente a ese color y luego
                //escribiremos el texto. Opcionalmente, al terminar escribiremos el código ANSI de reset
                //para volver al color estándar para que el resto del texto nos salga normal.
                //A  continuación,  os  pongo  una  lista  de  los  diferentes  códigos  ANSI  almacenados  en
                //cadenas. Podéis usar estas cadenas para no tener que memorizar los códigos cuando
                //queráis usar los colores.
                //String ANSI_RESET = "\u001B[0m";
                //
                //String ANSI_BLACK = "\u001B[30m";
                //String ANSI_RED = "\u001B[31m";
                //String ANSI_GREEN = "\u001B[32m";
                //String ANSI_YELLOW = "\u001B[33m";
                //String ANSI_BLUE = "\u001B[34m";
                //String ANSI_PURPLE = "\u001B[35m";
                //String ANSI_CYAN = "\u001B[36m";
                //String ANSI_WHITE = "\u001B[37m";
                //
                //String ANSI_BLACK_BACKGROUND = "\u001B[40m";
                //String ANSI_RED_BACKGROUND = "\u001B[41m";
                //String ANSI_GREEN_BACKGROUND = "\u001B[42m";
                //String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
                //String ANSI_BLUE_BACKGROUND = "\u001B[44m";
                //String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
                //String ANSI_CYAN_BACKGROUND = "\u001B[46m";
                //String ANSI_WHITE_BACKGROUND = "\u001B[47m";

                double[] a = {-4.7,4.9,7.9,6.3,5.5,9.9,10.0};
                EscribeArrayNotas(a);
            }
            break;

            case 7:
            {
                //Escribe  la  función  tachaElementosNoComunes  a  la  que  le  pasamos  dos  arrays.  La
                //función sustituirá los elementos de un array que no aparezcan en el otro por ceros (y
                //viceversa).
                //Ej: [1, 3, 5, 7] y [1, 2, 3, 4] => [1, 3, 0, 0] y [1, 0, 3, 0]

                int[] a = {1, 3, 5, 7};
                int[] b = {1, 2, 3, 4};
                TachaElementosComunes(a,b);

            }
            break;

            case 8:
            {
                //Escribe la función eliminaRepetidos a la que le pasas un array y te devuelve otro array
                //en el que se han eliminado los elementos que estén repetidos.
                //Ej: [1, 5, 9, 2, 3, 4, 1, 1, 2] => [1, 5, 9, 2, 3, 4]

                int[] a = {1, 5, 9, 2, 3, 4, 1, 1, 2};
                int[] b;

                EscribeArray(a);
                System.out.println();
                b = EliminaRepetidos(a);
                EscribeArray(b);
            }
            break;

            case 9:
            {
                //Escribe dos funciones: redondeaArray y decimalesArray. A la función redondeaArray le
                //pasaremos un array de double y nos devolverá otro array de double en el que a los
                //números le quitamos la parte decimal.
                //Ej.: [1.56, 2.75, 3, 9.9] => [1, 2, 3, 9]
                //A la función decimalesArray le pasaremos un array de double y nos devolverá otro array
                //de double en el que aparecerán solamente las partes decimales de los números.
                //Ej.: [1.56, 2.75, 3, 9.9] => [0.56, 0.75, 0, 0.9]


                System.out.println("==============================================");
                System.out.println("DOS FUNCIONES (RedondeaArray || DecimalesArray");
                System.out.println("==============================================");
                System.out.println("[1] RedondeaArray");
                System.out.println("[2] DecimalesArray");
                System.out.println();
                System.out.print("Elige una opción: ");
                int op = sc.nextInt();

                switch (op)
                {
                    case 1:
                    {
                        //RedondeaArray
                        double[] a = {1.56, 2.75, 3, 9.9};
                        int[] b;

                        EscribeArrayDouble(a);
                        System.out.println();
                        b = RedondeaArray(a);
                        EscribeArray(b);
                    }
                    break;
                    case 2:
                    {
                        //DecimalesArray
                        double[] a = {1.56, 2.75, 3, 9.9};
                        double[] b;

                        EscribeArrayDouble(a);
                        System.out.println();
                        b = DecimalesArray(a);
                        EscribeArrayDouble(b);
                    }
                    break;
                }
            }
            break;

            case 10:
            {
                //Escribe  la  función  desordenaArray.  La  función  recibirá  un  array  de  enteros  por
                //parámetro, que al término de la función deberá quedar desordenado.
                //Para conseguir esto, iremos cogiendo los elementos de un array de manera aleatoria y
                //los iremos poniendo en un array auxiliar.

                int[] a = {1,2,3,4,5,6,7,8,9};
                int[] desordenado;

                EscribeArray(a);
                System.out.println();
                desordenado = DesordenaArray(a);
                EscribeArray(desordenado);
            }
            break;

            case 11:
            {
                //Escribe  la  función  minMaxArray  a  la  que  le  pasaremos  un  array  de  enteros  y  nos
                //devolverá  otro  array  de  enteros  diferente  en  el  que  aparecerán  los  números
                //comprendidos entre el menor y el mayor del array que le hemos pasado.
                //Con un ejemplo se entiende mejor:
                //•  Le pasamos [7, 3, 9, 4, 4, 6]
                //•  El mínimo es 3, el máximo 9.
                //Nos devolverá [3, 4, 5, 6, 7, 8, 9]

                int[] a = {7, 3, 9, 4, 4, 6};
                int[] b;

                EscribeArray(a);
                System.out.println();
                b = MinMaxArray(a);
                EscribeArray(b);

            }
            break;

            case 12:
            {
                // Escribe la función graficaBarras a la que le pasamos un array de enteros y nos muestra
                //una gráfica de barras por pantalla. Ejemplo: [9, 5, 3, 2, 10]
                // 9 █████████
                // 5 █████
                // 3 ███
                // 2 ██
                //10 ██████████
                //•  Antes de pintar la gráfica, habrá que comprobar que todos los valores estén entre 0
                //y 10 (supongamos que representan vuestras notas). Si hay valores incorrectos, no
                //se pinta la gráfica y se muestra un mensaje de error.
                //•  Usar el caracter ASCII 219 (█) para las barritas
                //•  Dejar una línea en blanco entre barra y barra para que quede bonito.
                //•  OPCIONAL: que los aprobados aparezcan en verde y los suspensos en rojo.

                int[] a = {9, 5, 3, 2, 10};
                EscribeArray(a);
                System.out.println();
                GraficaBarras(a);

            }
            break;

            case 13:
            {
                //Escribe la función mejorRacha a la que le pasamos un array que contiene resultados de
                //fútbol y nos devuelve un entero correspondiente a la mayor racha de victorias seguidas.
                //El array contendrá parejas de números (o sea, su tamaño será par) de los cuales el
                //primero serán los goles que ha marcado nuestro equipo y el segundo los goles que ha
                //recibido (p.ej.: [1, 0, 2, 2, 3, 5] se correspondería con una victoria por 1-0, un empate 2-
                //2 y una derrota por 3-5). La función contará cuantas victorias consecutivas hay y nos
                //devolverá la mayor racha.
                //Ej.:   [2, 1, 1, 0, 1, 1, 0, 1, 1, 0, 2, 0, 5, 1, 2, 2, 1, 0] se corresponde con:
                // 2-1, 1-0, 1-1, 0-1, 1-0, 2-0, 5-1, 2-2, 1-0, con una racha máxima de 3 victorias.

                int[] a = {2, 1, 1, 0, 1, 1, 0, 1, 1, 0, 2, 0, 5, 1, 2, 2, 1, 0};
                int racha;

                EscribeArray(a);
                racha = MejorRacha(a);
                System.out.println("\nMejor racha = " + racha);

            }
            break;

            case 14:
            {
                // Escribe la función numerosPrimosPro que nos calculará los números primos entre 1 y
                //otro número (para probarlo, nos vale con 1000).
                //Esta función usará un algoritmo más avanzado que el que hemos visto con anterioridad
                //y que es mucho más eficiente a la hora de calcular muchos números primos.
                //El funcionamiento es el siguiente (para el ejemplo del 1 al 1000):
                //•  Creamos un array de 1001 elementos (por el cero).
                //•  Empezamos en la posición 2 del array y vamos haciendo lo siguiente:
                //•  Si en esta posición hay un 0 (que es lo que había al principio), añadimos esta
                //posición a una lista de números primos.
                //•  Si había un 0, además, tenemos que ir “tachando” todos los múltiplos de
                //ese número primo poniendo otro valor en esas posiciones (por ejemplo, un
                //-1). En el caso del 2, que sería el primero, pondríamos un -1 en la posición
                //4, 6, 8, 10, 12, etc., y así hasta llegar al 1000.
                //•  Si en la posición hay un -1, eso es que este número ya era múltiplo de uno
                //anterior, así que no hacemos nada y pasamos al siguiente.
                //•  Al final, devolveremos la lista de números primos que hemos ido recopilando.
                //Para comprobarlo, mostrar los números primos entre 1 y 1000 por pantalla y escribir
                //cuántos  números  son  (empieza  por  2,  3,  5,  7...  acaba  por  983,  991,  997  y  son  168
                //números primos en total).

                int tama;
                System.out.println("Tamaño del array: ");
                tama = sc.nextInt();
                int[] a = new int[tama+1];
                int[] b;

                b = NumerosPrimosPro(a);
                EscribeArray(b);

            }
            break;

            case 15:
            {
                //Escribe  una  función  “ElementosComunes”.  La  función  recibirá  dos  arrays  como
                //parámetros  y  nos  devolverá  otra  array  que  contendrá  únicamente  los  elementos
                //comunes a los dos arrays.
                //Ej.:   int[] a = {1, 3, 5, 7};
                //int[] b = {1, 2, 3, 4};
                //EscribeArray(ElementosComunes(a, b));
                //
                //Nos debería escribir: < 1, 3 >

                int[] a = {1,3,5,7};
                int[] b = {1,2,3,4};
                int[] c;

                c = ElementosComunes(a,b);
                EscribeArray(c);

            }
            break;

            case 16:
            {
                // Escriba la función “HayRepetidos” a la que le pasamos un array por parámetros y nos
                //devuelve un booleano que será true si algún elemento se repite más de una vez y false
                //en caso contrario.

                int[] a = {2,3,4,4,5,6};
                boolean repetidos;

                EscribeArray(a);
                repetidos = HayRepetidos(a);
                System.out.println("\n"+repetidos);
            }
            break;

            case 17:
            {
                //Escribe la función “AciertosQuiniela” a la que le pasamos dos arrays de enteros que
                //contienen  15  elementos.  Cada  elemento  podrá  tomar  el  valor  1,  10  ó  2,
                //correspondientes  a  las  opciones  1,  X,  2  que  se  pueden  rellenar  en  una  quiniela.  El
                //primer array contendrá la quiniela que nosotros hemos rellenado y el segundo array
                //contendrá los resultados reales que se dieron en esta pasada jornada. La función nos
                //devolverá un entero que se correspondrá con el número de aciertos en la quiniela (es
                //decir, el número de elementos que en la misma posición son iguales en los dos arrays).
                //Para poder probarlo mejor, escribe la función “RellenaQuinielaAleatoria” que no recibe
                //parámetros y nos devuelve un array de 15 elementos con valores 1, 10 y 2 aleatorios
                //en cada posición. Ej.:
                //int[] jornada24 = {2, 10, 1, 2, 1, 2, 1, 10, 1, 10, 1, 1, 10, 2, 1};
                //int aciertos = AciertosQuiniela(RellenaQuinielaAleatoria(), jornada24);

                int[] a = RellenaQuinielaAleatoria();
                int[] jornada24 = RellenaQuinielaAleatoria();//{2, 10, 1, 2, 1, 2, 1, 10, 1, 10, 1, 1, 10, 2, 1};
                int aciertos;

                EscribeArray(a);
                System.out.println();
                EscribeArray(jornada24);
                aciertos = AciertosQuiniela(a,jornada24);
                System.out.println("\n"+aciertos);


            }
            break;

            case 18:
            {
                // Escribe la función “ElementoMedia” que recibe un array de enteros por parámetro y
                //nos devuelve otro entero, que será el valor del array que más se aproxime a la media
                //aritmética  de  todos  los  elementos.  Si  hay  varios  elementos  que  estén  a  la  misma
                //distancia de la media, nos devolverá el primero de ellos. Nota: la media puede tener
                //decimales.
                //
                //Ej.: de {7, 5, 1, 3} la media es 4, y el 3 y el 5 están igual de cerca, así que devolverá el 5.

                double[] a = {7,5,1,3};
                //double[] a = {7,9,2,5};
                double media;

                EscribeArrayDouble(a);
                media = ElementoMedia(a);
                System.out.println(media);


            }
            break;

            case 19:
            {
                //  Escribe un programa que realice una ordenación por mezcla.
                //  La  ordenación  por  mezcla  consiste  en  coger  dos  arrays  o  listas  que  estén
                //previamente  ordenados  y  juntarlos  de  forma  que  no  se  desordenen.  Para  ello,
                //miramos el primer elemento de cada array o lista y cogemos el más pequeño. Este
                //elemento lo meteremos en el array o lista resultado. Después, cogeremos otra vez
                //el  más  pequeño  de  los  dos,  y  así  hasta  que  una  de  las  dos  listas  esté  vacía,
                //momento en el cual copiaremos lo que queda de la otra lista al final.
                //  El  ejercicio  se  podrá  realizar  en  consola  o  en  entorno  visual  (en  entorno  visual
                //queda más bonito).
                //  Para  su  realización  se  podrán  usar  listas  o  arrays  (o  mejor  aún,  de  los  dos),  de
                //enteros.
                //  Los arrays o listas iniciales los rellenará el usuario y podrán tener cualquier tamaño
                //(no me pongáis el tamaño fijo).
                //  Para ordenar estos arrays o listas iniciales, se recomienda usar el método Sort.

                int[] a = {9,4,2,5,6,12,7,8};
                int[] b = {6,2,7,1};
                int[] c;

                EscribeArray(a);
                System.out.println();
                EscribeArray(b);
                System.out.println();

                c = OrdenaPorMezcla(a,b);
                EscribeArray(c);
            }
            break;

        }
    }
}


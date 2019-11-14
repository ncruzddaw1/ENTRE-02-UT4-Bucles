import java.util.Random;
/**
 *
 * Nicolas Cruz Diaz
 */
public class DemoBucles
{
    private final char ASTERISCO = '*';
    private final char ESPACIO = ' ';
    private Random generador;
    /**
     * Constructor  
     */
    public DemoBucles()
    {
       generador = new Random();
    }

    /**
     * Calcular la mayor potencia de 2 que es menor o igual a numero
     * Asumimos numero > 0
     * 
     * Si numero = 7 devuelve 4             numero = 8 devuelve 8
     *    numero = 19 devuelve 16           numero = 32 devuelve 32
     *    numero = 74 devuelve 64           numero = 1 devuelve 1
     *    numero = 190 devuelve 128
     *    
     *  Usa bucles while
     */
    public int mayorPotencia2(int numero) {
        int contador = 1;
        while(contador <= numero)
        {
            contador = contador * 2;  
        }
        return contador / 2;
    }

    /**
     * Escribir numero como suma de potencias de 2 
     * tal como indica el enunciado (Se asume numero > 0)
     * 
     * Todos los valores se muestran en pantalla fomateados a 6 posiciones 
     * y ajustados a la derecha
     * 
     * Hay que usar el método anterior - 
     * Utiliza bucles while
     * 
     *  77 =    64     8     4     1
     * 215 =   128    64    16     4     2     1
     *  18 =    16     2
     *  64 =    64
     */
    public void escribirSumaPotencias(int numero) 
    {
        int n = mayorPotencia2(numero);
        int potencia = 0;
        while(potencia <= numero)
        {
           potencia = mayorPotencia2(numero);
           numero = numero - potencia;
           System.out.printf("%6d  = ", potencia);
        }
        System.out.println(numero + " = " + potencia);
        
    }

    /**
     * Generar aleatorios entre 0 y 255
     * y escribir cada aleatorio como suma de potencias de 2
     * Parar al salir el 255 o despues de generar n aleatorios
     * (ver enunciado)
     * 
     * Hay que usar el método anterior
     * 
     * Utiliza bucles while
     * 
     */
    public void generarAleatorios(int n) 
    {
       int contador = 1;
       int aleatorio = generador.nextInt(256);
       escribirSumaPotencias(aleatorio);
       while(aleatorio != 0)
       {
           escribirSumaPotencias(aleatorio);
           aleatorio = generador.nextInt(256);
           contador++;
       }
       System.out.println(contador);
    }

    /**
     *  Escribe en pantalla caracter n veces en la misma línes
     *  
     *  Usa bucles for
     */
    public void escribirCaracter(int n, char caracter)
    {
        
        for (int i = 1; i <= n; i++) 
        { 
            System.out.print(caracter);
        } 
    }

    /**
     *  Genera la figura tal como muestra el enunciado 
     *  con ayuda del método anterior
     *  
     *   Usa bucles for
     */
    public  void mostrarEscalera(int escalones, int alto, int ancho) 
    {
        System.out.println();
        for (int i = 0; i < escalones; i++) 
        {     
               for (int a = 1; a <= alto; a++)
               {
                   for (int c = 1; c <= ancho; c++)
                   {
                       escribirCaracter(ancho, ASTERISCO);
                       escribirCaracter(ancho * i, ASTERISCO);
                   }
                   System.out.println();
               }
               System.out.println();          
        } 
    }

}

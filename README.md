1 - Diferencia entre Runnable y Thread:
Runnable es una interfaz que necesita instanciar un hilo para contenerlo. Y Thread es un
hilo de ejecución de un programa. Si nosotros extendemos de un Thread, no vamos a poder
extender de otra clase más, porque java no admite herencia múltiple. Por tal razón es 
que se recomienda la utilización de la interfaz Runnable, porque podemos tener múltiples 
interfaces. Por su parte, un Thread es un hilo de ejecución en un programa. La máquina
virtual de java permite que una aplicación tenga varios subprocesos de ejecución 
ejecutándose simultáneamente. Otra diferencia que podemos encontrar es que Thread.start()
inicia un hilo que llama al método run(), mientras que Runnable.run() sólo llama al 
método run() del hilo.
He aquí un ejemplo que lo muestra claramente y que quedó expresado en cómo hice el trabajo.

public static void main() {
    R1 r1 = new R1();
    R2 r2 = new R2();

    r1.run();
    r2.run();
}
Acá no tenemos múltiples hilos, acá ejecutan el único existente.
public static void main() {
    R1 r1 = new R1();
    R2 r2 = new R2();
    Thread t1 = new Thread(r1);
    Thread t2 = new Thread(r2);

    t1.start();
    t2.start();
}
Nótese que para poder hacer start, es importante crear los hilos y mandarle nuestros runnables. Y si hacemos start, estamos utilizando la multiplicidad de hilos!

2 - Ciclo de vida de un Thread:
El ciclo de vida de un Thread representa los estados por los cuales puede pasar un Thread desde que nace hasta que muere. Un Thread puede contener diferentes estados.
El ciclo del Thread: 
    - new Thread() --------Nuevo Thread.(Nace el hilo, se crea. Permanece vacío o nulo)
    - start() -------------Comienza.(Pasa a un estado de Listo!)
    - Ejecutable-----------Llama al método run() que se ejecuta de forma secuencial.
                           Aun no ha empezado a ejecutarse.
    - En ejecución---------Pasa a este estado cuando se le asignan los recursos del 
                           procesador. Cada hilo tendrá su prooridad.
    - parado---------------Puede estar en wait(), sleep(), suspend(), puede estar
                           bloqueado durante una solicitud de entrada salida.
    - stop()---------------Muerto. :( Aquí termina el método run(). Puede morir por
    muerte natural: cuando sale normalmente de su método run() o por muerte provocada:
    con un stop() por ejemplo.
    
    
    3- Explicar métodos start(), sleep(), yield() y join():
    
    Método start(): Hereda de la super clase Thread e enicia al hilo y llama al método run().
    Método sleep(): Provoca que el intérprete ponga al hilo en curso a dormir durante el número de milisegundos que se indiquen en el parámetro de invocación. Una vez transcurridos esos milisegundos el hilo volverá a estar disponible para su ejecución.
    Método yield(): Hace que el intérprete cambie de contexto entre el hilo actualy el siguiente hilo ejecutable disponible. Es una manera de asegurar que los hilos de menor prioridad no sufran inanición.
    Método join(): Si un Thread necesita esperar a que otro termine, por ejemplo el thread padre, puede usar este método. 







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
public static void main() {
    R1 r1 = new R1();
    R2 r2 = new R2();
    Thread t1 = new Thread(r1);
    Thread t2 = new Thread(r2);

    t1.start();
    t2.start();
}
Nótese que para poder hacer start, es importante crear los hilos y mandarle nuestros runnables.



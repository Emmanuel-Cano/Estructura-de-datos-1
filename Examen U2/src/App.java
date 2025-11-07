import java.util.Scanner;
public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayQueue<JobCustom> queue = new ArrayQueue<>();
        ArrayStack<JobCustom> stack = new ArrayStack<>();
        SinglyLinkedList bitacora = new SinglyLinkedList();

        System.out.println("   Simulador de Procesamiento de Trabajos  ");
        System.out.println("  Comandos: ADD, PROCESS, COMMIT, ROLLBACK, PRINT, END");

        boolean running = true;

        while (running) {
            System.out.print("Ingresa el comando > ");
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            String cmd = parts[0].toUpperCase();

            switch (cmd) {
                case "ADD":
                    if (parts.length < 2) {
                        System.out.println("Falta ID de trabajo");
                    } else {
                        String id = parts[1];
                        queue.offer(new JobCustom(id));
                    }
                    break;

                case "PROCESS":
                    if (parts.length < 2) {
                        System.out.println("Falta número de trabajos a procesar");
                    } else {
                        int n = Integer.parseInt(parts[1]);
                        int count = 0;
                        while (!queue.isEmpty() && count < n) {
                            JobCustom job = queue.poll();
                            stack.push(job);
                            count++;
                        }
                    }
                    break;

                case "COMMIT":
                    while (!stack.isEmpty()) {
                        bitacora.addLast(stack.pop());
                    }
                    break;

                case "ROLLBACK":
                    if (parts.length < 2) {
                        System.out.println("Falta número para rollback");
                    } else {
                        int m = Integer.parseInt(parts[1]);
                        int count = 0;
                        for (int i = 0; i < m; i++) {
                            JobCustom last = bitacora.removeLast();
                            if (last == null) break;
                            queue.offerFront(last);
                            count++;
                        }
                    }
                    break;

                case "PRINT":
                    printState(queue, stack, bitacora);
                    break;

                case "END":
                    System.out.println("ESTADO FINAL");
                    printState(queue, stack, bitacora);
                    running = false;
                    break;

                default:
                    System.out.println("Comando no reconocido");
                    break;
            }
        }

        sc.close();
    }

    private static void printState(ArrayQueue<JobCustom> q, ArrayStack<JobCustom> st, SinglyLinkedList sll) {
        System.out.print("QUEUE (pendientes): ");
        q.print();
        System.out.print("STACK (procesando): ");
        st.print();
        System.out.println("BITÁCORA (confirmados): " + sll);
    }
}

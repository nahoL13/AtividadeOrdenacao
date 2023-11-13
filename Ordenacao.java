public class Ordenacao {

    // Bubble Sort
    static void bubbleSort(int lista[]) {
        int n = lista.length; // Obtém o comprimento do array
        for (int i = 0; i < n-1; i++) { // Loop externo para percorrer o array
            for (int j = 0; j < n-i-1; j++) { // Loop interno para comparar os elementos e fazer as trocas
                if (lista[j] > lista[j+1]) { // Compara elementos adjacentes
                    int temp = lista[j]; // Realiza a troca
                    lista[j] = lista[j+1];
                    lista[j+1] = temp;

                    // Imprime o array após cada troca
                    printArray(lista);
                }
            }
        }
    }

    // Insertion Sort
    static void insertionSort(int lista[]) {
        int n = lista.length; // Obtém o comprimento do array
        for (int i = 1; i < n; ++i) { // Loop externo para percorrer o array
            int key = lista[i]; // Elemento a ser inserido na parte ordenada
            int j = i - 1;

            while (j >= 0 && lista[j] > key) { // Encontra a posição correta para inserção
                lista[j + 1] = lista[j]; // Desloca elementos maiores para abrir espaço
                j = j - 1;
            }
            lista[j + 1] = key; // Insere o elemento na posição correta

            // Imprime o array após cada iteração
            printArray(lista);
        }
    }

    // Quick Sort
    static void quickSort(int lista[], int low, int high) {
        if (low < high) {
            int pivoIndex = partition(lista, low, high); // Encontra a posição do pivô
            System.out.println("Pivô escolhido: " + lista[pivoIndex]);
            printArray(lista);

            quickSort(lista, low, pivoIndex - 1); // Ordena recursivamente a parte antes do pivô
            quickSort(lista, pivoIndex + 1, high); // Ordena recursivamente a parte após o pivô
        }
    }

    static int partition(int lista[], int low, int high) {
        int pivo = lista[high]; // Escolhe o último elemento como pivô
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (lista[j] <= pivo) {
                i++;
                int temp = lista[i];
                lista[i] = lista[j];
                lista[j] = temp;
            }
        }

        int temp = lista[i + 1];
        lista[i + 1] = lista[high];
        lista[high] = temp;

        return i + 1;
    }

    // Método para imprimir um array
    static void printArray(int lista[]) {
        int n = lista.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(lista[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Teste dos algoritmos de ordenação

        int lista[] = {49, 15, 40, 27, 20, 19, 50, 2, 12, 28, 49, 44, 9, 59, 18, 5, 30, 6, 7, 28};

        System.out.println("Lista original:");
        printArray(lista);
        System.out.println("\n");

        // Bubble Sort
        System.out.println("Lista ordenada com Bubble Sort:");
        int listaBubble[] = lista.clone();
        bubbleSort(listaBubble);
        System.out.println("\n");

        // Insertion Sort
        System.out.println("Lista ordenada com Insertion Sort:");
        int listaInsertion[] = lista.clone();
        insertionSort(listaInsertion);
        System.out.println("\n");

        // Quick Sort
        System.out.println("Lista ordenada com Quick Sort:");
        int listaQuick[] = lista.clone();
        quickSort(listaQuick, 0, listaQuick.length - 1);
        System.out.println("Lista ordenada:");
        printArray(listaQuick);
    }
}

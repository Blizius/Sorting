/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort_time;

/**
 *
 * @author Blizius
 */
public class Sort_time {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array = rndArray(100);
        heapSort(array);
    }

    /**
     * generování pole
     *
     * @param length délka pole
     * @return náhodné pole intů
     */
    public static int[] rndArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = rnd(length);
        }
        return array;
    }

    /**
     * generování pole
     *
     * @param length délka pole
     * @return seřazené pole intů
     */
    public static int[] sortedArray(int length) {
        int[] array = new int[length];
        array[0] = (int) (Math.random() * 100) + 1;
        for (int i = 1; i < length; i++) {
            array[i] = array[i - 1] + (int) (Math.random() * 100) + 1;
        }
        return array;
    }

    /**
     * generování pole
     *
     * @param length délka pole
     * @return téměř seřazené pole intů (2 % prvků náhodné)
     */
    public static int[] almostSortedArray(int length) {
        int[] array = new int[length];
        array[0] = (int) (Math.random() * 100) + 1;
        for (int i = 1; i < length; i++) {
            array[i] = array[i - 1] + (int) (Math.random() * 100) + 1;
        }
        for (int i = 50; i < length; i += 50) {
            array[i] = rnd(length);
        }
        return array;
    }

    /**
     * generování náhodného intu
     *
     * @param length délka pole
     * @return náhodný int od 0 do hodnoty délky pole
     */
    public static int rnd(int length) {
        return (int) (Math.random() * length);
    }
    /**
     * třídící funkce, algoritmus Insert Sort
     * @param array pole k setřídění
     */
    public static void insertSort(int [] array){        
        for (int i = 1; i < array.length; i++){
            int a = array[i];
            for (int k = i; k > 0 && a <= array[k-1]; k--){                               
                array[k] = array[k-1];
                array[k-1] = a;                                              
            }                      
        }
    }
    /**
     * třídící funkce, algoritmus Insert Binary Sort
     * @param array pole k setřídění
     */
    public static void insertBinarySort (int [] array){
        for (int i = 1; i < array.length; i++){
            int a = array[i];            
            int p = i-1;
            int l = 0;
            while (l <= p){
                int k = (l+p)/2;
                if (a > array[k]){
                    l = k+1;
                }
                else{
                    p = k-1;
                }
            }
            int j = i;
            while (j > l){
                array[j] = array[j-1];
                j--;
            }   
            array[l] = a;
        }
    }
    /**
     * třídící funkce, algoritmus Quick Sort
     * @param array pole k setřídění
     * @param l index levého konce pole
     * @param p index pravého konce pole
     */
    public static void quickSort(int []array, int l, int p){
        int i = l;
        int j = p;
        int piv = array[((l+p)/2)];
        while (i <= j){
            while (piv > array[i])
                i++;
            while (piv < array[j])
                j--;
            if (i <= j){
                int a = array[i];
                array[i] = array[j];
                array[j] = a;
                i++;
                j--;
            }
        }
        if (l < j)
            quickSort(array, l, j);
        if (i < p)
            quickSort(array, i, p);
    }
    /**
     * třídící funkce, algoritmus Heap Sort
     * @param array pole k setřízení
     * @return nové setřízené pole
     */
    public static void heapSort(int []array){
        int []heap = new int [array.length + 1];
        for (int i = 1; i < heap.length; i++){
            heap [i] = array[i-1];
            fixHeapUp(heap, i);
        }
        for (int i = heap.length-1; i > 1; i--){
            int a = heap[1];
            heap[1] = heap[i];
            array[i-1] = a;
            fixHeapDown(heap, i);
            if (i == 2){
                array[0] = heap[2];
            }
        }           
    }
    /**
     * oprava haldy nahoru
     * @param heap vstupní halda (pole)
     * @param i index aktuálně přidávaného prvku do haldy
     */
    public static void fixHeapUp (int []heap, int i){
        while (i > 1 && heap[i] < heap[i/2]){
            int a = heap[i];
            heap[i] = heap[i/2];
            heap[i/2] = a;
            i = i/2;
        }
    }
    /**
     * oprava haldy dolů
     * @param heap vstupní halda (pole)
     * @param i aktuální délka nesetříděné haldy
     */
    public static void fixHeapDown(int []heap, int i){
        int j = 1;  //index rodiče
        while (2*j <= i){
            int k = 2*j;    //index potomka
            if ((k <= i) && (heap[k] > heap[k+1])){
                k++;                
            }
            if (heap[k] < heap[j]){
                int a = heap[j];
                heap[j] = heap[k];
                heap[k] = a;                
            }
            else{                
                break;
            }
            j = k;            
        }        
    }
}

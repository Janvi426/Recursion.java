import javax.management.timer.TimerNotification;

public class Recursion {
    
    // 1 print decreasing order SC=TC=O(n)
    public static void printDec(int n){
        if(n == 1){
            System.out.print(n);
            return;
        }
        System.out.print(n + " ");
        printDec(n-1);
    }

    // 2 print increasing order (first all fun. calls then print)
    public static void printInc(int n){
        if (n == 1){
            System.out.println(n + " ");
            return;
        }
        printInc(n-1);
        System.out.print(n + " ");
    }
    
    // 3 factorial of n n!
    public static int factorial(int n){
        if( n == 0){
            return 1;
        }
        int fact = n * factorial(n-1);
        return fact;

    }

    // 4 sum of first n numbers   TC=O(2^n) SC=O(n)
    public static int sumOfN(int n){
        if( n == 1){
            return 1;
        }
        int sum = n + sumOfN(n-1);
        return sum;
    }

    // 5 fibonacci series
       public static int fibonacci(int n){
        if( n == 0 || n == 1){
         return n;
        }
        int fib = fibonacci(n-1) + fibonacci(n-2);
        return fib;
    } 

    // 6 check given array is sorted or not (ascending) SC=TC=O(n)
    public static boolean isSorted(int a[], int i){
        if(a[i] == a.length-1){
            return true;
        }
        if(a[i] > a[i+1]){
            return false;
        }
        
        return isSorted(a, i+1);
    }

    // 7 find first occurence of element in array SC=TC=O(n)
    public static int firstOcc(int a1[], int i, int key){
        if(i == a1.length){
            return -1;
        }
        if(a1[i] == key){
            return i;
        }
        return firstOcc(a1, i+1, key); 
    }

    // 8 find last occurence of element in array SC=TC=O(n)
    public static int lastOcc(int a1[], int i, int key){
        if(i == a1.length){
            return -1;
        }
        int isFound = lastOcc(a1, i+1, key);
        if(isFound == -1 && a1[i] == key){
            return i;
        }
        return isFound;
    }

    // 9 give X^n   TC=O(n)
    public static int power(int x, int n){
        if(n == 1){      // n == 0
            return x;    // return 1;  
        }
        return x * power(x, n-1);
    }

    // 10 optimized X^n  TC=O(log n) faster execution 
    public static int optimizedPow(int x, int n){
        if(n == 1){
            return x;
        }
        int halfPow = optimizedPow(x, n/2);
        int halfPowSq = halfPow * halfPow;
        if(n % 2 != 0){
            halfPowSq = x * halfPowSq;
        }
        return halfPowSq;
    }

    // 11 Tilling problem 
    public static int tilling(int n){ // (2 x n) floor size
        if(n == 0 || n == 1){
            return 1;
        }
        // choice - vertical
        int ver = tilling(n-1);
        // choice - horizontal
        int hor = tilling(n-2);
        int totalWays = ver + hor;
        return totalWays;
    }

    // 12 Remove duplicates fron string
    public static void removeDup(String str, int inx, StringBuilder sb, boolean map[]){
        if(inx == str.length()){
            System.out.println(sb);
            return;
        }
        char currChar = str.charAt(inx);
        if(map[currChar - 'a'] == true){
            removeDup(str, inx+1, sb, map);
        } else{
            map[currChar - 'a'] = true;
            removeDup(str, inx+1, sb.append(currChar), map);
        }
    }

    //13 Friends pairing
    public static int friendPair(int n){
        if(n == 1 || n == 2){
            return n;
        }
  /*  // single
        int sin = friendPair(n-1);
        // pair
        int pair = friendPair(n-2);
        int totalPair = (n-1) * pair;
        // total ways
        int totalWays = sin + totalPair;
        return totalWays;  */
        return friendPair(n-1) + (n-1) * friendPair(n-2); // single line code
    }

    // Binary string problem 
    public static void printBinStr(int n, int lastPlace, String str){
        if(n == 0){
            System.out.println(str);
            return;
        }
        printBinStr(n-1, 0, str+"0");
        if(lastPlace == 0){
            printBinStr(n-1, 1, str+"1");
        }
    }
   
    public static void main(String...arg){
        
        int n = 6;
        // 1
        //printDec(n);
        // 2
        //printInc(n);
        // 3
        //System.out.println(factorial(n));
        // 4
        //System.out.println(sumOfN(n));
        // 5
        //System.out.println(fibonacci(n));
        // 6
        //int a[] = {1,2,3,4,5,6};
        // System.out.println( isSorted(a, 0));
        // 7
        int a1[] = {2,5,6,3,7,2,4,5};
        //System.out.println(firstOcc(a1, 0, 5));
        // 8 
        //System.out.println(lastOcc(a1, 0, 5));
        // 9
        //System.out.println(power(2, 10));
        // 10
        //System.out.println(optimizedPow(2, 5));
        // 11
        //System.out.println(tilling(4)); // ways=5
        // 12
        // String str = "googleengine";
        // removeDup(str, 0, new StringBuilder(""), new boolean[26]);
        // 13
        // System.out.println(friendPair(3));
        // 14
        printBinStr(3, 0, "");


    }
}

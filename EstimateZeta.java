public class EstimateZeta{
  public static void main(String[]args) {
    
    //Zeta(n), n > 1
    int n = 2;
    
    //number of arrays created that will be tested for pairwise coprimality
    int iter = 10000;
    
    //maximum value of random numbers generated for arrays
    int max = 1000000;
   
    
    System.out.println(Zeta(n, iter, max));
    
  }
  
  
  
  
  //method that generates an array of n random integers with max on random
  
  public static int[] generateRandoms(int n, int max){
    
    int[] randomArray = new int[n];
    
    for (int i = 0; i < n; i++) {
      int entry = ((int)(Math.random() * max)) + 1;
      randomArray[i] = entry;
    }
    
    return randomArray;
  }
  
  
  
  //method that takes two of numbers, tests coprimality
  
  public static boolean isCoprime(int num1, int num2) {
        
    boolean output = true;
    
    for (int i = 2; i <= num1 && i <= num2; i++) {
      if (num1 % i == 0 && num2 % i == 0) {
        output = false;
        break;
      }      
    }
    return output; 
  }
    
    
  //method that takes an array of numbers, returns true if all possible pairs are coprime
  
  public static boolean isCoprimeArray(int[] arr) {
    
    boolean output = true;
    
    for (int i = 0; i < arr.length; i++) {
      for (int k = i + 1; k < arr.length; k++) {
        if (!(isCoprime(arr[i], arr[k]))) {
            return false;
        }
      }
    }
    return output;    
  }
  
  
  //method that generates a large number of random arrays, tests coprimality, and returns ratio
  
  public static double Zeta(int n, int iter, int max) {
    
    int counter = 0;
    int[][] randomArrayBig = new int[iter][n];
    
    for (int i = 0; i < iter; i++) {
      randomArrayBig[i] = generateRandoms(n, max);
    }
    
    for (int i = 0; i < iter; i++) {
      if (isCoprimeArray(randomArrayBig[i])){
        counter++; 
      }
    }
    
    double num = counter + iter;
    double den = iter;
    double zeta = num / den;
    
    return zeta;   
  } 
}

  

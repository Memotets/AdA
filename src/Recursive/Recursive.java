/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursive;

/**
 *
 * @author memotets89
 */
public class Recursive {
    public static int factorialRecursive(int n){
        if(n==0){
            return 1;
        }
        return (n*factorialRecursive(n-1));
    }
    
    public static int factorialNoRecursive(int n){
        int aux = n;
        int res= n;
        while(aux!=1){
                aux-=1;
                res *= aux;
        }
        return res;
    }
    
   private static int NoProbar(int n){
       return (n*factorialRecursive(n-1));
   }
   
   public static int fibo(int n){
       if (n==1){
            return 1;
       }
       if (n==0){
           return 0;
       }
       return (fibo(n-1)+fibo(n-2));
   }
   
   public static int fiboNoRec(int n){
       int n0=0;
       int n1=1;
       int res=0;
       
       for (int i=2; i<=n; i++){
           res = n0+n1;
           n0=n1;
           n1=res;
       }
       return res;
   }
   
   public static int Sumatoria(int a, int b){
       if(b==0){
           return a;
       }
       if(b<0){
           return Sumatoria(a,b+1)-1;
       }
       return Sumatoria(a, b-1)+1;
   }
   
}

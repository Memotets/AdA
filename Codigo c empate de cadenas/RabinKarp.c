#include<stdio.h>

int main(){
  int n= 200;
  int m= 30;

  char Mensaje [n];
  //char *pa = Mensaje;
  printf("Escriba un mensaje prueba: \n");
  fgets (Mensaje, n, stdin);
  //arreglar cadena de caracteres
  int a =0;
  while (Mensaje[a]!='\n'){
    a=a+1;
  }
  Mensaje[a]= '\0';
  //nunevo valor n
  n=a;
  char cadena [m];
  printf("Mande una subcadena para buscar (no mayor a %d ): \n",m);
  fgets (cadena, m, stdin);
  //arreglar cadena de caracteres
  a=0;
  while (cadena[a]!='\n'){
    a=a+1;
  }
  cadena[a]= '\0';
  //nuevo valor m
  m=a;

// valor de repeticiones
  int ini = 0;
// numero de veces que hash se repite
  int pruebaHash = 0;

//Definicion Hash = promedio de asciis
  int HashCadena = 0;
  for (int i = 0; i< m; i=i+1 ) HashCadena = HashCadena+cadena[i];
  HashCadena = HashCadena/m;


  for (int a = 0; a<n-m; a=a+1){
    // HashCode de las m letras en la posicion a
    int HashAux =0;
    for(int b = 0; b<m; b = b+1 ) HashAux = HashAux+Mensaje[a+b];
    HashAux = HashAux/m;

    //Si son el mismo
    if(HashCadena == HashAux){
          pruebaHash = pruebaHash+1;
          int verificar = 1;
          for (int b =0; b < m; b = b+1){ // chequeo la cadena buscada char por char

            if (cadena[b]!=Mensaje[a+b]){ // si algo no coinside
              verificar = 0; // mando falso
              break; // dejo de buscar
            }//if
          }//for b

      // si la cadena empareja
          if (verificar == 1){
            ini = ini+1; // agrego un empate
          } // if
    }//if hashcode

  }
  printf("Numero de empates: %d\n", ini);
  printf("Numero de Hashes repetidos: %d\n", pruebaHash);
  return 0;
}

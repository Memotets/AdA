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

  char cadena [m];
  printf("Mande una subcadena para buscar (no mayor a %d ): \n",m);
  fgets (cadena, m, stdin);
  //arreglar cadena de caracteres
  a=0;
  while (cadena[a]!='\n'){
    a=a+1;
  }
  cadena[a]= '\0';

//inicio de subcadena auxiliar
  char sub[m];
// valor de repeticiones
  int ini = 0;

  for (int a = 0; a<n-m; a=a+1){
    if (Mensaje[a] == '\0'){
      break;
    }

    int verificar = 1; // variable que actuara como booleano
    for (int b =0; b < m; b = b+1){ // chequeo la cadena buscada char por char
      if (cadena[b] == '\0'){
        break;
      }

      sub[b] = Mensaje[a+b];
      if (cadena[b]!=sub[b]){ // si algo no coinside

        verificar = 0; // mando falso
        break; // dejo de buscar
      }
    }
// si la cadena empareja
    if (verificar == 1){
      ini = ini+1; // agrego un empate
    }
  }
  // despues de todos mi recorrido imprimo mis empates
  printf("%d\n", ini);
  return 0;
}

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

typedef struct
{
    int x, y;
    int w, h;
    int l;
    int estilo;
} Poligono;

void print (Poligono* p){
	if (p->estilo==0)
	{
	printf(
		"Tamanho (%d,%d) / Pos (%d, %d) / Num de Lados (%d) / Poligono Regular\n",
		p->w, p->h, p->x, p->y, p->l
	);
	}
	if (p->estilo==1)
	{
		printf(
		"Tamanho (%d,%d) / Pos (%d, %d) / Num de Lados (%d) / Poligono Estrela\n",
		p->w, p->h, p->x, p->y, p->l
	);	
	}
}

int main (){
	Poligono p1 = {1,1, 10,10, 5, 0};
	print(&p1);
	return 0;
}


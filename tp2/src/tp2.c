#include <pthread.h>
#include <stdlib.h>
#include <stdio.h>
#define N 4

int matrix1 [N][N];
int matrix2 [N][N];

int result [N][N];

void suma(void *arg){
	int *intArg = (int*) arg;
	int row = *intArg;
	for(int i =0; i<N; i++){
		result[row][i] = matrix1[row][i] + matrix2[row][i];
	}
	pthread_exit(NULL);
}

void init(int m[N][N]){
	for(int i = 0; i < N; i++){
		for(int j = 0; j < N; j++){
			m[i][j] = rand()%10;
		}
	}	
}

void printMat(int m[N][N]){
	for(int i = 0; i < N; i++){
		for(int j = 0; j < N; j++){
			printf("%d  ", m[i][j]);
		}
		printf("\n");
	}
}

int main(){
	pthread_t threads[N];
	int rows[N];

	init(matrix1);
	init(matrix2);
	printf("Matrix 1-------------------------\n");
	printMat(matrix1);
	printf("Matrix 2-------------------------\n");
	printMat(matrix2);
	for(int i =0; i< N; i++){
		rows[i] = i;
		pthread_create (&threads[i], NULL, (void*)&suma, (void*)&rows[i]);
	}
	printf("Result---------------------------\n");
	printMat(result);
	for(int i = 0; i < N; i++){
		t
	}
}
#include <sys/types.h>
#include <sys/wait.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

int main(int argc, char *argv[]) {
   	int maxConcurrency = atoi(argv[1]);
   	char* program = argv[2];

   	int qty = 0;

    for (int i = 3; i <= argc; i++) {
        pid_t pid = fork();
        qty++;

        if (pid < 0) {
            fprintf(stderr, "Fork Failed\n");
   	    	return 1;
        }
        else if (pid == 0) {
            // child
        	char* arg = argv[i];
            char cmdfull[strlen(program) + strlen(arg) + 2];
            snprintf(cmdfull, sizeof cmdfull, "%s %s", program, arg);
            execlp("sh", "sh", "-c", cmdfull, NULL);
        }
        else {
        	if (qty == maxConcurrency)
        		{
        			pid_t pidaux = wait(NULL);
        			printf("Child %d Complete\n", pidaux);
        			qty--;
        		}

	    /* parent will wait for the child to complete */
        }

    }

    for (int i = 0; i < qty; ++i)
    {
    	pid_t pidaux = wait(NULL);
            printf("Child %d Complete\n", pidaux);
    }
    return 0;
}
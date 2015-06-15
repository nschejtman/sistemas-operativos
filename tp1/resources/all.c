// --------- Hello World -------

#include <stdio.h>

int main() { 
	printf("Hello World\n");
	return 0;
}

// ---------- Hello World 2 ---------

#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>

int main (int argc, char *argv[]) {
    for (int i = 0; i < argc; i++) {
        printf(" #%d : %s\n", i, argv[i]);
    }

    exit(0);
}

// ------- Process ID --------------

#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>

int main() { 
        pid_t pid    = getpid();
        pid_t parent = getppid();

	printf("Process: %d\n", pid);
	printf("Parent: %d\n", parent);
	return 0;
}

// --------- Sleep -------------------

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main () {
    printf("Waiting...\n");
    sleep(60);

    exit(0);
}

// ---------- Fork ---------

#include <sys/types.h>
#include <sys/wait.h>
#include <stdio.h>
#include <unistd.h>

int main() {

    pid_t pid = fork();
   
    if (pid < 0) {
        fprintf(stderr, "Fork Failed\n");
	return 1;
    }
    else if (pid == 0) {
        // child
        execlp("/bin/ls", "ls", NULL);
    } 
    else {		
	/* parent will wait for the child to complete */
	pid_t child = wait(NULL);
	printf("Child %d Complete\n", child);
    }
   
    return 0;
}

// ------------ Fork N (serial)

#include <sys/types.h>
#include <sys/wait.h>
#include <stdio.h>
#include <unistd.h>

int main() {

    for (int i = 0; i < 10; i++) {
        pid_t pid = fork();
   
        if (pid < 0) {
            fprintf(stderr, "Fork Failed\n");
   	    return 1;
        }
        else if (pid == 0) {
            // child
            execlp("/bin/ls", "ls", NULL);
        } 
        else {		
	    /* parent will wait for the child to complete */
	    pid_t child = wait(NULL);
	    printf("Child %d Complete\n", child);
        }
    }
   
    return 0;
}

// ----------- Fork N (parallel) -----------------

#include <sys/types.h>
#include <sys/wait.h>
#include <stdio.h>
#include <unistd.h>

int main() {
   
    for (int i = 0; i < 10; i++) {
        pid_t pid = fork();
   
        if (pid < 0) {
            fprintf(stderr, "Fork Failed\n");
   	    return 1;
        }
        else if (pid == 0) {
            // child
            execlp("/bin/ls", "ls", NULL);
        } 
        else {		
	    /* parent will wait for the child to complete */
        }
    } 

    for (int i = 0; i < 10; i++) {
        pid_t child = wait(NULL);
	printf("Child %d Complete\n", child);
    }
   
    return 0;
}


// ------------ Run User Program -----------

#include <stdio.h>
#include <unistd.h>

int main(void)
{
    char args[128];
    char *argv[] = { "sh", "-c", args, 0 };
    printf("> ");
    if (fgets(args, 128, stdin) != 0)
    {
        execvp(argv[0], argv);
        fprintf(stderr, "Failed to exec shell on %s", args);
        return 1;
    }
    return 0;
}

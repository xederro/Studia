/*
Autor:  Dawid Jabłoński
Grupa:  WT/NP 11.15
Tytuł:  Zadanie 1, Laboratorium 0
Data:   6 października 2022r.
*/

#include <iostream>
#include <stdio.h>

using namespace std;

int main()
{
    // OBOWIĄZKOWY wydruk danych autora
    printf("Autor: Dawid Jabłoński (WT/NP 11:15)");

    /*
    Podpunkt A
    iostream
    */
    printf("\n\n\nWariant 1 iostream\n\n");

    // Podpunkt A iostream
    cout << "Dawid Jabłoński" << endl;
    cout << "Edwarda Wittiga 6, \n51-628 Wrocław" << endl;
    cout << "+48 643 938 263" << endl;
    cout << "student@example.com" << endl;

    system("PAUSE");
    /*
    Podpunkt A
    iostream
    */
    printf("\n\n\nWariant 2 stdio.h\n\n");

    // Podpunkt B stdio.h
    printf("Adam Kowalski\n");
    printf("Janiszewskiego 11/17, \n50-372 Wrocław\n");
    printf("+48 123 456 789\n");
    printf("admin@example.com\n");

    system("PAUSE");
    return 0;
}
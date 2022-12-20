/*
Autor:  Dawid Jabłoński
Grupa:  WT/N 11.15
Tytul:  Laboratorium 5.2
Data:   10 Grudnia 2022r.
*/

#include <iostream>
#include <stdlib.h>
#include <string.h>

#define bufSize 100

using namespace std;


// Inicjalizacja dynamicznej tablicy dwuwymiarowej. 
// Funkcję należy wywołać na początku programu. 
void InitTab(char**& wsk);

// Dodawanie nowego imienia do tablicy dynamiczne.j 
void AddName(char* buf, char**& wsk);

// Usuwanie imienia znajdującego się w tablicy na  pozycji nr, 
void RemoveNameByIndex(int nr, char**& wsk);

// Usuwanie z tablicy imienia, wprowadzonego z klawiatury 
void RemoveName(char* buf, char**& wsk);

// drukowanie na ekranie wszystkich imion 
void PrintAllNames(char** wsk);

// drukowanie na ekranie imion rozpoczynających wskazaną literą 
void PrintNames(char first_letter, char** wsk);

// sortowanie imion zawartych w tablicy według alfabetu 
void SortAlphabet(char** wsk);

// sortowanie imion zawartych w tablicy według długości 
void SortLength(char** wsk);

int main()
{
    // OBOWIAZKOWY wydruk danych autora
    printf("Autor: Dawid Jablonski (WT/N 11:15)\n");

    char** WSK;   // wskaźnik na dwuwymiarową tablice dynamiczną   
    // w której będą pamiętane wszystkie imiona. 

    InitTab(WSK); // Inicjalizacja tablicy dynamicznej  

    char c = 0;
    char buf[bufSize]; // bufor na dane wczytywane z klawiatury 

    do
    {
        printf("\n0- Wyjdz \n1- Dodaj imie\n2- Usun imie o numerze\n3- Usun imie\n4- Wypisz wszystkie imiona\n5- Wypisz imiona zaczynajace sie na\n6- Sortowanie imion alfabetycznie\n7- Sortuj imiona dlugoscia\n");
        scanf("%hhd", &c);
        scanf("%c");
        switch (c)
        {
        case 0:
        {
            printf("Wychodzenie");
        }
        break;

        case 1:
        {
            printf("Wprowadz imie: ");
            fgets(buf, bufSize, stdin);
            AddName(buf, WSK);
        }
        break;

        case 2:
        {
            int nr;
            printf("Podaj numer imienia do usuniecia: ");
            scanf("%d", &nr);
            RemoveNameByIndex(nr, WSK);
        }
        break;

        case 3:
        {
            printf("Wprowadz imie do usuniecia: ");
            fgets(buf, bufSize, stdin);
            RemoveName(buf, WSK);
        }
        break;

        case 4:
        {
            PrintAllNames(WSK);
        }
        break;

        case 5:
        {
            char first_letter;
            printf("Podaj pierwsza litere imienia: ");
            scanf("%c", &first_letter);
            PrintNames(first_letter, WSK);
        }
        break;

        case 6:
        {
            SortAlphabet(WSK);
        }
        break;

        case 7:
        {
            SortLength(WSK);
        }
        break;

        default:
        {
            printf("Bledny wybor");
        }
        break;
        }

    } while (c != 0);


    return 0;
}


void InitTab(char**& wsk) {
    wsk = new char*;
    *wsk = NULL;
}

void AddName(char* buf, char**& wsk) {
    int end = 0;

    while (wsk[end] != NULL) {
        end++;
    }

    for (int i = 0; i < strlen(buf); i++)
    {
        if (i == 0)
        {
            buf[i] = toupper(buf[i]);
        }
        else if (buf[i - 1] == ' ')
        {
            buf[i] = toupper(buf[i]);
        }
        else
        {
            buf[i] = tolower(buf[i]);
        }
    }

    char** temp = new char* [end + 2];

    for (int i = 0; i < end; i++) {
        temp[i] = wsk[i];
    }

    delete[] wsk;

    wsk = temp;

    wsk[end] = new char[strlen(buf) + 1];

    strcpy(wsk[end], buf);

    wsk[end + 1] = NULL;

    printf("Dodano imie: %s\n", buf);
}

void RemoveNameByIndex(int nr, char**& wsk) {
    nr--; // bo numerujemy od 1 a nie od 0
    int end = 0;

    while (wsk[end] != NULL) {
        end++;
    }

    if (nr < 0 || nr >= end) {
        printf("Nie ma takiego imienia");
        return;
    }

    printf("Usunieto imie: %sZ pozycji: %d\n", wsk[nr], nr + 1);

    delete[] wsk[nr];

    for (int i = nr; i < end; i++) {
        wsk[i] = wsk[i + 1];
    }

    char** temp = new char* [end];

    for (int i = 0; i < end; i++) {
        temp[i] = wsk[i];
    }

    delete[] wsk;

    wsk = temp;

    wsk[end - 1] = NULL;
}

void RemoveName(char* buf, char**& wsk) {
    int end = 0;

    while (wsk[end] != NULL) {
        end++;
    }

    for (int i = 0; i < strlen(buf); i++)
    {
        if (i == 0)
        {
            buf[i] = toupper(buf[i]);
        }
        else if (buf[i - 1] == ' ')
        {
            buf[i] = toupper(buf[i]);
        }
        else
        {
            buf[i] = tolower(buf[i]);
        }
    }

    for (int i = 0; i < end; i++) {
        if (strcmp(wsk[i], buf) == 0) {
            delete[] wsk[i];

            for (int j = i; j < end; j++) {
                wsk[j] = wsk[j + 1];
            }

            char** temp = new char* [end];

            for (int i = 0; i < end; i++) {
                temp[i] = wsk[i];
            }

            delete[] wsk;

            wsk = temp;

            wsk[end - 1] = NULL;

            return;
        }
    }

    printf("Usunieto imie: %s\n", buf);
}

void PrintAllNames(char** wsk) {
    int end = 0;

    while (wsk[end] != NULL) {
        end++;
    }

    for (int i = 0; i < end; i++) {
        printf("%s", wsk[i]);
    }

    if (end == 0) {
        printf("Brak imion");
    }
}

void PrintNames(char first_letter, char** wsk) {
    int end = 0;

    while (wsk[end] != NULL) {
        end++;
    }

    first_letter = toupper(first_letter);

    bool printed = false;
    for (int i = 0; i < end; i++) {
        if (wsk[i][0] == first_letter) {
            printf("%s", wsk[i]);
            printed = true;
        }
    }

    if (end == 0) {
        printf("Brak imion");
    }
    else if (!printed)
    {
        printf("Brak imion zaczynajacych sie na %c", first_letter);
    }
}

void SortAlphabet(char** wsk) {
    int end = 0;

    while (wsk[end] != NULL) {
        end++;
    }

    for (int i = 0; i < end; i++) {
        for (int j = 0; j < end - 1; j++) {
            if (strcmp(wsk[j], wsk[j + 1]) > 0) {
                char* temp = wsk[j];
                wsk[j] = wsk[j + 1];
                wsk[j + 1] = temp;
            }
        }
    }

    printf("Posortowano alfabetycznie\n");
}

void SortLength(char** wsk) {
    int end = 0;

    while (wsk[end] != NULL) {
        end++;
    }

    for (int i = 0; i < end; i++) {
        for (int j = 0; j < end - 1; j++) {
            if (strlen(wsk[j]) > strlen(wsk[j + 1])) {
                char* temp = wsk[j];
                wsk[j] = wsk[j + 1];
                wsk[j + 1] = temp;
            }
        }
    }

    printf("Posortowano dlugoscia\n");
}
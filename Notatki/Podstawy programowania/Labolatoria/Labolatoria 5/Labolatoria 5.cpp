/*
Autor:  Dawid Jabłoński
Grupa:  WT/N 11.15
Tytul:  Zadanie 1a Laboratorium 4
Data:   22 listopada 2022r.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

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
            char buf[81]; // bufor na dane wczytywane z klawiatury 
            printf("Wprowadz imie: ");
            fgets(buf, 81, stdin);
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
            char buf[81]; // bufor na dane wczytywane z klawiatury
            printf("Wprowadz imie do usuniecia: ");
            fgets(buf, 81, stdin);
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
    wsk = (char**)malloc(sizeof(char*));
    wsk[0] = NULL;
}

void AddName(char* buf, char**& wsk) {
    int end = 0;

    while (*wsk != NULL) end++;

    wsk = (char**)realloc(wsk, (end + 2) * sizeof(char*));

    wsk[end + 1] = (char*)malloc(strlen(buf) * sizeof(char));

    wsk[end + 2] = NULL;
}

void RemoveNameByIndex(int nr, char**& wsk) {
    int end = 0;

    while (*wsk != NULL) end++;

    if (nr > end + 1)
    {
        return;
    }

    for (int i = nr - 1; i <= end; i++)
    {
        wsk[i] = wsk[i + 1];
    }

    wsk = (char**)realloc(wsk, end * sizeof(char*));
}

void RemoveName(char* buf, char**& wsk) {
    int end = 0;

    while (*wsk != NULL) end++;

    int nr = 0;
    for (int i = 0; wsk[i] != NULL; i++)
    {
        if (strcmp(buf, wsk[i]) == 0)
        {
            nr = i;
            break;
        }
    }

    if (nr > end + 1)
    {
        return;
    }

    for (int i = nr - 1; i <= end; i++)
    {
        wsk[i] = wsk[i + 1];
    }

    wsk = (char**)realloc(wsk, end * sizeof(char*));
}

void PrintAllNames(char** wsk) {
    for (int i = 0; wsk[i] != NULL; i++)
    {
        for (int j = 0; wsk[i][j] != 0; j++)
        {
            printf("%c", wsk[i][j]);
        }
    }
}

void PrintNames(char first_letter, char** wsk) {
    for (int i = 0; wsk[i] != NULL; i++)
    {
        if (wsk[i][0] == first_letter)
        {
            for (int j = 0; wsk[i][j] != 0; j++)
            {
                printf("%c", wsk[i][j]);
            }
        }
    }
}

void SortAlphabet(char** wsk) {
    int end = 0;

    while (*wsk != NULL) end++;


    for (int i = 0; i < end; i++)
    {
        for (int j = 0; j < end - 1; j++)
        {
            if (strcmp(wsk[j], wsk[j + 1]) > 0)
            {
                char* temp = wsk[j];
                wsk[j] = wsk[j + 1];
                wsk[j + 1] = temp;
            }
        }
    }
}

void SortLength(char** wsk) {
    int end = 0;

    while (*wsk != NULL) end++;

    for (int i = 0; i < end; i++)
    {
        for (int j = 0; j < end - 1; j++)
        {
            if (strlen(wsk[j]) > strlen(wsk[j + 1]))
            {
                char* temp = wsk[j];
                wsk[j] = wsk[j + 1];
                wsk[j + 1] = temp;
            }
        }
    }
}
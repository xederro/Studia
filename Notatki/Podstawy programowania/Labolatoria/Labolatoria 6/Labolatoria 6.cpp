/*
Autor:  Dawid Jabłoński
Grupa:  WT/N 11.15
Tytul:  Laboratorium 6
Data:   26 Grudnia 2022r.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

using namespace std;

struct Ware
{
    char name[21] = { 0 };
    float price = 0;
    unsigned int stock = 0;
};

Ware createWare();
void createTabWithGivenSize(Ware*&, unsigned int&, unsigned int);
void printWare(Ware*, unsigned int);
void printWareName(Ware*, unsigned int, char*);
void printWarePrice(Ware*, unsigned int, char, float);
void printWareStock(Ware*, unsigned int, char, unsigned int);
void addNewWare(Ware*&, unsigned int&);
void removeWare(Ware*&, unsigned int&, unsigned int);
void deleteTab(Ware*&, unsigned int&);
void backupToFile(Ware*, unsigned int, char*);
void backupFromFile(Ware*&, unsigned int&, char*);

int main()
{
    // OBOWIAZKOWY wydruk danych autora
    printf("Autor: Dawid Jablonski (WT/N 11:15)\n");

    Ware* Tab = NULL;
    unsigned int Size = 0;

    char c = 0;
    do
    {
        printf("\n0- Wyjdz \n1- Utworz tablice o podanym rozmiarze\n2- Wypisz dane\n3- Dodaj Towar\n4- Usun Towar\n5- Usun Tabele\n6- Zapisz tabele do pliku\n7- Odczytaj tabele z pliku\n\n");
        scanf("%hhd", &c);
        scanf("%c");
        switch (c) {
        case 0:
        {
            printf("Wychodzenie\n");
        }
        break;

        case 1:
        {
            unsigned int count;
            printf("Wpisz ilosc produktu:\n");
            scanf("%u", &count);
            scanf("%c");
            createTabWithGivenSize(Tab, Size, count);
        }
        break;

        case 2:
        {
            char method = 0;
            printf("1- Wyswietl wszystko\n2- Wyswietl po nazwie\n3- Wyswietl po cenie\n4- Wyswietl po ilosci\n");
            do
            {
                if (method != 0)
                {
                    printf("Zly wybor\n");
                }
                printf("Wybierz ktore wyswietlac:\n");
                scanf("%hhu", &method);
                scanf("%c");
            } while (method != 1 && method != 2 && method != 3 && method != 4);

            switch (method)
            {
            case 1:
                printWare(Tab, Size);
                break;
            case 2:
            {
                char name[21];
                printf("Wpisz nazwe lub jej czesc:\n");
                scanf("%s", name);
                scanf("%c");
                printWareName(Tab, Size, name);
            }
            break;
            case 3:
            {
                char lhe = 0;
                printf("> - Cena wyzsza od\n= - Cena rowna\n< - Cena mniejsza od\n");
                do
                {
                    if (lhe != 0)
                    {
                        printf("Zly wybor\n");
                    }
                    printf("Wpisz znak:\n");
                    scanf("%c", &lhe);
                } while (lhe != '>' && lhe != '=' && lhe != '<');

                float price = 0;
                printf("Wpisz cene:\n");
                scanf("%f", &price);
                printWarePrice(Tab, Size, lhe, price);
            }
            break;
            case 4:
            {
                char lhe = 0;
                printf("> - Ilosc wyzsza od\n= - Ilosc rowna\n< - Ilosc mniejsza od\n");
                do
                {
                    if (lhe != 0)
                    {
                        printf("Zly wybor\n");
                    }
                    printf("Wpisz znak:\n");
                    scanf("%c", &lhe);
                } while (lhe != '>' && lhe != '=' && lhe != '<');

                unsigned int stock = 0;
                printf("Wpisz ilosc:\n");
                scanf("%u", &stock);
                printWareStock(Tab, Size, lhe, stock);
            }
            break;
            }
        }
        break;

        case 3:
        {
            addNewWare(Tab, Size);
        }
        break;

        case 4:
        {
            unsigned int num;
            printf("Wpisz numer produktu do usuniecia:\n");
            scanf("%u", &num);
            scanf("%c");
            removeWare(Tab, Size, num);
        }
        break;

        case 5:
        {
            deleteTab(Tab, Size);
        }
        break;

        case 6:
        {
            char name[51];
            printf("Wpisz nazwe pliku(Max 50 znakow):\n");
            scanf("%s", name);
            scanf("%c");
            backupToFile(Tab, Size, name);
        }
        break;

        case 7:
        {
            char name[56];
            printf("Wpisz nazwe pliku(Max 54 znaki):\n");
            scanf("%s", name);
            scanf("%c");
            backupFromFile(Tab, Size, name);
        }
        break;

        case 8:

            break;

        default:
        {
            printf("Bledny wybor\n");
        }
        break;
        }

        printf("Wskaznik: %p\tRozmiar: %u\n\n", Tab, Size);
    } while (c != 0);


    return 0;
}

Ware createWare() {
    Ware temp;
    printf("Wpisz nazwe produktu:\n");
    fgets(temp.name, 21, stdin);
    for (char* i = temp.name; *i; i++) {
        if (*i == '\n') {
            *i = '\0';
        }
    }
    printf("Wpisz cene produktu:\n");
    scanf("%f", &temp.price);
    scanf("%c");
    printf("Wpisz ilosc produktu:\n");
    scanf("%u", &temp.stock);
    scanf("%c");
    return temp;
}

void createTabWithGivenSize(Ware*& Tab, unsigned int& Size, unsigned int count) {
    Size = count;

    if (Tab != NULL) {
        delete[] Tab;
    }

    Tab = new Ware[count];

    if (Tab == NULL) {
        printf("Problem z przydzieleniem pamieci!\n");
        return;
    }

    while (count-- > 0) {
        printf("\nDodajemy %u. Towar\n", Size - count);
        Tab[Size - count - 1] = createWare();
    }
}

void printWare(Ware* Tab, unsigned int Size) {
    if (Tab == NULL || Size == 0) {
        printf("Brak tablicy\n");
        return;
    }

    printf("+-----------------------------------------------------------------+\n");
    printf("|      Nr.    |         Nazwa         |     Cena     |    Ilosc   |\n");
    printf("+-----------------------------------------------------------------+\n");
    for (unsigned int i = 0; i < Size; i++) {
        printf("| %10u. | %21s | %10.2fzl | %10u |\n", i + 1, Tab[i].name, Tab[i].price, Tab[i].stock);
    }
    printf("+-----------------------------------------------------------------+\n");
}

void printWareName(Ware* Tab, unsigned int Size, char* name) {
    if (Tab == NULL || Size == 0) {
        printf("Brak tablicy\n");
        return;
    }

    printf("+-----------------------------------------------------------------+\n");
    printf("|      Nr.    |         Nazwa         |     Cena     |    Ilosc   |\n");
    printf("+-----------------------------------------------------------------+\n");
    for (unsigned int i = 0; i < Size; i++) {
        if (strstr(Tab[i].name, name) != NULL)
        {
            printf("| %10u. | %21s | %10.2fzl | %10u |\n", i + 1, Tab[i].name, Tab[i].price, Tab[i].stock);
        }
    }
    printf("+-----------------------------------------------------------------+\n");
}

void printWarePrice(Ware* Tab, unsigned int Size, char lhe, float price) {
    if (Tab == NULL || Size == 0) {
        printf("Brak tablicy\n");
        return;
    }

    printf("+-----------------------------------------------------------------+\n");
    printf("|      Nr.    |         Nazwa         |     Cena     |    Ilosc   |\n");
    printf("+-----------------------------------------------------------------+\n");
    for (unsigned int i = 0; i < Size; i++) {
        switch (lhe)
        {
        case '<':
            if (Tab[i].price < price)
            {
                printf("| %10u. | %21s | %10.2fzl | %10u |\n", i + 1, Tab[i].name, Tab[i].price, Tab[i].stock);
            }
            break;
        case '=':
            if (Tab[i].price == price)
            {
                printf("| %10u. | %21s | %10.2fzl | %10u |\n", i + 1, Tab[i].name, Tab[i].price, Tab[i].stock);
            }
            break;
        case '>':
            if (Tab[i].price > price)
            {
                printf("| %10u. | %21s | %10.2fzl | %10u |\n", i + 1, Tab[i].name, Tab[i].price, Tab[i].stock);
            }
            break;

        }
    }
    printf("+-----------------------------------------------------------------+\n");
}

void printWareStock(Ware* Tab, unsigned int Size, char lhe, unsigned int stock) {
    if (Tab == NULL || Size == 0) {
        printf("Brak tablicy\n");
        return;
    }

    printf("+-----------------------------------------------------------------+\n");
    printf("|      Nr.    |         Nazwa         |     Cena     |    Ilosc   |\n");
    printf("+-----------------------------------------------------------------+\n");
    for (unsigned int i = 0; i < Size; i++) {
        switch (lhe)
        {
        case '<':
            if (Tab[i].stock < stock)
            {
                printf("| %10u. | %21s | %10.2fzl | %10u |\n", i + 1, Tab[i].name, Tab[i].price, Tab[i].stock);
            }
            break;
        case '=':
            if (Tab[i].stock == stock)
            {
                printf("| %10u. | %21s | %10.2fzl | %10u |\n", i + 1, Tab[i].name, Tab[i].price, Tab[i].stock);
            }
            break;
        case '>':
            if (Tab[i].stock > stock)
            {
                printf("| %10u. | %21s | %10.2fzl | %10u |\n", i + 1, Tab[i].name, Tab[i].price, Tab[i].stock);
            }
            break;

        }
    }
    printf("+-----------------------------------------------------------------+\n");
}

void addNewWare(Ware*& Tab, unsigned int& Size) {
    Ware* temp = Tab;
    Tab = (Ware*)realloc(Tab, (Size + 1) * sizeof(Ware));
    if (Tab == NULL) {
        printf("Problem z przydzieleniem pamieci!\n");
        Tab = temp;
        return;
    }
    Tab[Size] = createWare();
    Size++;
    if (temp != NULL && temp != Tab) {
        delete[] temp;
    }
}

void removeWare(Ware*& Tab, unsigned int& Size, unsigned int num) {
    if (num > Size || num <= 0) {
        printf("Zly indeks towaru!\n");
        return;
    }

    memcpy(Tab, Tab, (num - 1) * sizeof(Ware));
    memcpy(&Tab[num - 1], &Tab[num], (Size - num) * sizeof(Ware));

    Tab = (Ware*)realloc(Tab, (Size - 1) * sizeof(Ware));

    Size--;
}

void deleteTab(Ware*& Tab, unsigned int& Size) {
    if (Tab != NULL && Size != 0) {
        delete[] Tab;
        Tab = NULL;
        Size = 0;
    }
    else {
        printf("Brak tablicy\n");
        return;
    }
}

void backupToFile(Ware* Tab, unsigned int Size, char* name) {
    if (Tab == NULL || Size == 0) {
        printf("Brak tablicy\n");
        return;
    }

    FILE* file;
    char fileName[56] = { 0 };
    strcat(fileName, name);
    strcat(fileName, ".save");
    file = fopen(fileName, "w");

    if (file == NULL) {
        printf("Nie udalo sie utworzyc pliku!\n");
        return;
    }

    fprintf(file, "%u\n", Size);

    for (unsigned int i = 0; i < Size;i++) {
        fprintf(file, "%s\n", (Tab + i)->name);
        fprintf(file, "%f\n", (Tab + i)->price);
        fprintf(file, "%u\n", (Tab + i)->stock);
    }

    fclose(file);
}

void backupFromFile(Ware*& Tab, unsigned int& Size, char* name) {
    FILE* file;
    file = fopen(name, "r");

    if (file == NULL) {
        printf("Nie udalo sie otworzyc pliku!\n");
        return;
    }

    if (Tab != NULL) {
        delete[] Tab;
        Tab = NULL;
        Size = 0;
    }

    fscanf(file, "%u", &Size);

    if (Size == 0) {
        printf("Brak tablicy\n");
        fclose(file);
        return;
    }

    Tab = new Ware[Size];

    for (unsigned int i = 0; i < Size;i++) {
        fgetc(file);
        fgets((Tab + i)->name, 21, file);
        for (char* j = (Tab + i)->name; *j; j++) {
            if (*j == '\n') {
                *j = '\0';
            }
        }
        fscanf(file, "%f", &((Tab + i)->price));
        fscanf(file, "%u", &((Tab + i)->stock));
    }
    fclose(file);
}
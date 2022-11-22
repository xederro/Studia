/*
Autor:  Dawid Jabłoński
Grupa:  WT/N 11.15
Tytul:  Zadania Laboratorium 4
Data:   22 listopada 2022r.
*/

#include <iostream>

#define N 250

using namespace std;

/*

4.
wypisać jako %p na 16 zamieni

*/

void Wczytywanie(char(&str)[N]) {
    cout << "Wbisz zdanie:\n";
    cin.ignore();
    cin.getline(str, N);
}

void Wypisywanie(char str[N]) {
    for (char i = 0; str[i] != 0; i++) {
        cout << str[i];
    }
}

int Zadanie2UsuwanieLiczb(char(&str)[N]) {
    int count = 0;
    for (char i = 0; str[i] != 0; i++) {
        if (str[i] > '0' && str[i] < '9') {
            for (char k = i; str[k] != 0; k++) {
                str[k] = str[k + 1];
            }
            i--; // jezeli cofnie wszystkie liczby o 1 to pusi sprawdzic jeszcze raz ten sam index
            count++;
        }
    }

    return count;
}


char* Zadanie3UsuwanieKometarzy(char(&str)[N]) {
    for (char i = 0; str[i] != 0; i++) {
        if (str[i] == '/' && str[i + 1] == '/') {
            str[i] = 0;
            break;
        }
        else if (str[i] == '/' && str[i + 1] == '*') {
            do
            {
                for (char k = i; str[k] != 0; k++) {
                    str[k] = str[k + 1];
                }
            } while (!(str[i] == '*' && str[i + 1] == '/'));

            for (char k = 2; k; k--)
            {
                for (char k = i; str[k] != 0; k++) {
                    str[k] = str[k + 1];
                }
            }
        }
    }

    return str;
}


void zadanie4() {

}


int main() {

    // OBOWIAZKOWY wydruk danych autora
    cout << "Autor: Dawid Jablonski (WT/N 11:15)\n";

    // wybór zadania
    unsigned short int wybor = 0;
    do
    {
        cout << "\n0- Wyjscie z programu\n1- Zadanie 2\n2- Zadanie 3\n3- Zadanie 4\n\n";
        cin >> wybor;

        switch (wybor)
        {
        case 0:
            cout << "Do widzenia";
            break;
        case 1:
        {
            /*
                Zadanie 2
            */
            char str[N];
            Wczytywanie(str);
            Zadanie2UsuwanieLiczb(str);
            Wypisywanie(str);
            break;
        }
        case 2:
        {
            /*
                Zadanie 3
            */
            //test komentarza 2 /* abecadlo */ z pieca spadlo
            char str[N];
            Wczytywanie(str);
            char(*str2)[N] = (char(*)[N])Zadanie3UsuwanieKometarzy(str); //zamiana wskaźnika na char na wskaźnik na tablice charów
            Wypisywanie(*str2); // lub Wypisywanie(str);
            break;
        }
        case 3:
            /*
                Zadanie 4
            */
            // zadanie4();
            break;

        default:
            printf("Zly Wybor");
            break;
        }
    } while (wybor != 0);

    return 0;
}
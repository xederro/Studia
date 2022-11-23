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

char C = 'A';
int I = -1135;
long L = 123891246;
float F = 123.45602;
double D = 123.4567890000009;

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

template <typename T>
void Zadanie4WypisywanieBajtow(T* x) {
    for (int i = 0; i < sizeof(T); i++) {
        printf("0x%02x ", *(((char*)x) + i));
    }
    printf("\n");
}

void WypiszZadanie4(char& c, int& i, long& l, float& f, double& d) {
    printf("Char: %p\tsizeof(char): %d\twartosc: %c\t Bajty: ", &c, sizeof(c), c);
    Zadanie4WypisywanieBajtow(&c);
    printf("Int: %p\tsizeof(int): %d\twartosc: %d\t Bajty: ", &i, sizeof(i), i);
    Zadanie4WypisywanieBajtow(&i);
    printf("Long: %p\tsizeof(long): %d\twartosc: %ld\t Bajty: ", &l, sizeof(l), l);
    Zadanie4WypisywanieBajtow(&l);
    printf("Float: %p\tsizeof(float): %d\twartosc: %f\t Bajty: ", &f, sizeof(f), f);
    Zadanie4WypisywanieBajtow(&f);
    printf("Double: %p\tsizeof(double): %d\twartosc: %lf\t Bajty: ", &d, sizeof(d), d);
    Zadanie4WypisywanieBajtow(&d);

}

void zadanie4() {
    char c = 'z';
    int i = 346;
    long l = 13469134;
    float f = .00000123456;
    double d = 123456789.123456789;

    cout << "Globalne:" << endl;
    WypiszZadanie4(C, I, L, F, D);

    cout << "Lokalne:" << endl;
    WypiszZadanie4(c, i, l, f, d);

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
            zadanie4();
            break;

        default:
            printf("Zly Wybor");
            break;
        }
    } while (wybor != 0);

    return 0;
}
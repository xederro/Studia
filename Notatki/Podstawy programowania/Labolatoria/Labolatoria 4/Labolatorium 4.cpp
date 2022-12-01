/*
Autor:  Dawid Jabłoński
Grupa:  WT/N 11.15
Tytul:  Zadanie 2,3,4 z Laboratorium 4
Data:   22 listopada 2022r.
*/

#include <iostream>

#define N 100

using namespace std;

char C;
short I;
long L;
float F;
double D;

void Wczytywanie(char(*str));
void Wypisywanie(char str[N], unsigned long long n);
int Zadanie2UsuwanieLiczb(char(*str));
char* Zadanie3UsuwanieKometarzy(char(*str));
template <typename T>
void Zadanie4WypisywanieBajtow(T* x);
void WypiszZadanie4(char& c, short& i, long& l, float& f, double& d);
void ZmienWskaznikiemZadanie4(char* c, short* i, long* l, float* f, double* d);



int main() {
    srand(time(NULL));

    // OBOWIAZKOWY wydruk danych autora
    printf("Autor: Dawid Jablonski (WT/N 11:15)\n");

    // wybór zadania
    unsigned short int wybor = 0;
    do
    {
        printf("\n0- Wyjscie z programu\n1- Zadanie 2\n2- Zadanie 3\n3- Zadanie 4\n\n");
        scanf("%hhd", &wybor);
        switch (wybor)
        {
        case 0:
            printf("Do widzenia");
            break;
        case 1:
        {
            /*
                Zadanie 2
            */
            char str[N];
            Wczytywanie(str);
            Wypisywanie(str, (unsigned long long)Zadanie2UsuwanieLiczb(str));
            break;
        }
        case 2:
        {
            /*
                Zadanie 3
            */
            char str[N];
            Wczytywanie(str);
            Wypisywanie(str, (unsigned long long)Zadanie3UsuwanieKometarzy(str)); // lub Wypisywanie(str);
            break;
        }
        case 3:
        {
            /*
                Zadanie 4
            */
            char c;
            short i;
            long l;
            float f;
            double d;

            c = 'z';
            i = 346;
            l = 13469134;
            f = .00000123456;
            d = 123456789.123456789;

            C = 'A';
            I = -1135;
            L = 123891246;
            F = 123.45602;
            D = 123.4567890000009;


            printf("Globalne:\n");
            WypiszZadanie4(C, I, L, F, D);

            printf("Lokalne:\n");
            WypiszZadanie4(c, i, l, f, d);

            ZmienWskaznikiemZadanie4(&C, &I, &L, &F, &D);
            ZmienWskaznikiemZadanie4(&c, &i, &l, &f, &d);

            printf("Globalne:\n");
            WypiszZadanie4(C, I, L, F, D);

            printf("Lokalne:\n");
            WypiszZadanie4(c, i, l, f, d);

            *(&I + 6) = rand() % 10000 - 5000; // zmiana części zmiennej
            *(&D - 1) = (rand() * (1.0 / RAND_MAX)) * 1000000; // zmiana 2 zmiennych naraz
            *((long*)(&C + 4)) = rand() % 10000 - 5000;
            *((char*)(&L - 2)) = rand() % 26 + 65;


            *(&f + 3) = rand() % 10000 - 5000;// zapis złego typu do innej zmiennej
            *((short*)((int*)(&d + 1) + 2)) = rand() % 10000 - 5000;
            *(&l - 1) = rand() % 10000 - 5000;

            *(char*)(&d) = rand() % 26 + 65; // zmiana zmiennej bajt po bajcie
            *(char*)(&d + 1) = rand() % 26 + 65; // zmiana zmiennej bajt po bajcie
            *(char*)(&d + 2) = rand() % 26 + 65; // zmiana zmiennej bajt po bajcie
            *(char*)(&d + 3) = rand() % 26 + 65; // zmiana zmiennej bajt po bajcie
            *(char*)(&d + 4) = rand() % 26 + 65; // zmiana zmiennej bajt po bajcie
            *(char*)(&d + 5) = rand() % 26 + 65; // zmiana zmiennej bajt po bajcie
            *(char*)(&d + 6) = rand() % 26 + 65; // zmiana zmiennej bajt po bajcie
            *(char*)(&d + 7) = rand() % 26 + 65; // zmiana zmiennej bajt po bajcie

            printf("Globalne:\n");
            WypiszZadanie4(C, I, L, F, D);

            printf("Lokalne:\n");
            WypiszZadanie4(c, i, l, f, d);
        }
        // nie mogę po tym kodzie jeszcze raz wybrać zadania i nie wiem dla czego, 
        // czy któraś z funkcji zmienia coś w pamięci i dlatego nie mogę wybrać zadania ponownie? 
        // Czy jest inna tego przyczyna

        break;

        default:
            printf("Zly Wybor");
            break;
        }
    } while (wybor != 0);

    return 0;
}

void Wczytywanie(char(*str)) {
    printf("Wbisz zdanie:\n");

    // cin.ignore();
    char c;
    do
    {
        c = getchar();  //ignorujemy znak nowej linii który został w buforze po menu
    } while (c != '\n');


    // cin.getline(str, N);
    fgets(str, N, stdin);
}

void Wypisywanie(char str[N], unsigned long long n) {
    for (char i = 0; str[i] != 0; i++) {
        printf("%c", str[i]);
    }
    printf("\nFunkcja zwraca: %d\n", n);
}

int Zadanie2UsuwanieLiczb(char(*str)) {
    int count = 0;
    for (char i = 0; str[i - count] != 0; i++) {
        if (str[i - count] >= '0' && str[i - count] <= '9') {
            for (char k = i - count; str[k] != 0; k++) {
                str[k] = str[k + 1];
            }
            count++;
        }
    }

    return count;
}


char* Zadanie3UsuwanieKometarzy(char(*str)) {

    for (char i = 0; str[i] != 0; i++) {
        if (str[i] == '/' && str[i + 1] == '/') {
            str[i] = 0;
            break;
        }
        else if (str[i] == '/' && str[i + 1] == '*') {
            char dlKometarza = 0;
            for (char k = i + 2; str[k] != 0; k++) {
                if (str[k] == '*' && str[k + 1] == '/') {
                    dlKometarza = k - i + 2;
                    break;
                }
            }
            if (dlKometarza != 0) {
                for (char k = i; str[k + dlKometarza - 1] != 0; k++) {
                    str[k] = str[k + dlKometarza];
                }
            }
            else {
                str[i] = 0;
                break;
            }
        }
    }

    return str;
}


template <typename T>
void Zadanie4WypisywanieBajtow(T* x) {
    for (int i = 0; i < sizeof(T); i++) {
        printf("0x%02x ", *(((unsigned char*)x) + i));
    }
    printf("\n");
}

void WypiszZadanie4(char& c, short& i, long& l, float& f, double& d) {
    printf("Char: %p\tsizeof(char): %d\twartosc: %c\t Bajty: ", &c, sizeof(c), c);
    Zadanie4WypisywanieBajtow(&c);
    printf("Short: %p\tsizeof(int): %d\twartosc: %d\t Bajty: ", &i, sizeof(i), i);
    Zadanie4WypisywanieBajtow(&i);
    printf("Long: %p\tsizeof(long): %d\twartosc: %ld\t Bajty: ", &l, sizeof(l), l);
    Zadanie4WypisywanieBajtow(&l);
    printf("Float: %p\tsizeof(float): %d\twartosc: %f\t Bajty: ", &f, sizeof(f), f);
    Zadanie4WypisywanieBajtow(&f);
    printf("Double: %p\tsizeof(double): %d\twartosc: %lf\t Bajty: ", &d, sizeof(d), d);
    Zadanie4WypisywanieBajtow(&d);

}

void ZmienWskaznikiemZadanie4(char* c, short* i, long* l, float* f, double* d) {
    *c = rand() % 26 + 65;
    *i = rand() % 10000 - 5000;
    *l = rand() % 1000000000;
    *f = (rand() * (1.0 / RAND_MAX)) * 1000;
    *d = (rand() * (1.0 / RAND_MAX)) * 1000000;
}
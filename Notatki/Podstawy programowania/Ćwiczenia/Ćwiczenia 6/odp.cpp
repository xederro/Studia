#include <iostream>

using namespace std;

// void funkcja_A(int tablica[10]);  
// void funkcja_B(int tablica[ ]);  
// void funkcja_C(int [10] );  
// void funkcja_D(int [ ] );   
//void funkcja_E( [] ); //brakuje typu danych

inline int test(char); // deklaracja funkcji inline, zastępuje funkcję w miejscu jej wywołania, szybsza od zwykłej funkcji, ale może być tylko w jednym pliku
int test(int);//prototyp bez nazw argumentów
int test(float, int);

int main(int argc, char** argv) {//możemy do wywoływania pliku dodac argumenty które w pliku zostaną użyte
    for (int i = 0; i < argc; i++) {
        cout << argv[i] << endl;
    }

    // mogą mieć te same nazwy jeżeli są inne parametry 
    cout << test('a') << endl;
    //coś zwraca
    cout << test(1) << endl;
    cout << test(1.1, 1) << endl;//wywołanie funkcji
    //nie da się przekazać tablicy do funkcji
    return 0;
}

inline int test(char c) {//deklaracja
    cout << c << endl;
}
int test(int i) {
    cout << i << endl;
    exit(0);//kończy program
}

int test(float f, int a) {
    static int testowa = 1; //zmienna statyczna, jest ciągle w pamięci, zapisywana na cały czas trwania programu
    register int testt = 1; // zmienna umieszczona w rejestrze, szybsza od zwykłej zmiennej
    //zmienne deklarowane w funkcji są lokalne, zostają przypisane gdy funkcja się tworzu
    //zostają usunięte gdy funkcja się kończy nie jak globalne które są ciągle w pamięci
    cout << f << endl;
    return (a); // kończy funkcję
}
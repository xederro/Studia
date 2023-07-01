// Napisz funkcję wyświetlającą na ekranie wszystkie możliwe  
// 4-ro literowe palindromy (wyrazy jednakowo czytane od przodu i od tyłu).

#include <stdio.h>

using namespace std;

void palindromy() {
    for (char i = 'a'; i <= 'z'; i++)
    {
        for (char j = 'a'; j <= 'z'; j++)
        {
            printf("%c%c%c%c\n", i, j, j, i);
        }
    }

}

int main() {
    palindromy();
}
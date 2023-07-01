#include <iostream>
#include <ctime>

#define N 100

using namespace std;

short int tab[N];

void wyswietlTabele()
{
    for (char i = 0; i < N; i++)
    {
        cout << tab[i] << " ";
    }
    cout << endl;
}

void uzupelnijTabele()
{

    cout << "Uzupelnianie tabeli " << endl;
    for (char i = 0; i < N; i++)
    {
        tab[i] = (rand() % 2000) - 1000;
    }

    wyswietlTabele();
}

void sortowaniePrzezWstawianie()
{
    cout << "Sortowanie przez wstawianie: " << endl;
    for (short int i = 1; i < N; i++)
    {
        short int temp = tab[i];
        for (short int j = i; j >= 0; j--)
        {
            if ((j - 1 == -1) || tab[j - 1] <= temp)
            {
                tab[j] = temp;
                break;
            }
            else
            {
                tab[j] = tab[j - 1];
            }
        }
    }

    wyswietlTabele();
}

void sortowaniePrzezWybor()
{
    cout << "Sortowanie przez wybor: " << endl;
    for (short int i = 0; i < N; i++)
    {
        short int index = i, value = tab[i];
        for (short int j = i; j < N; j++)
        {
            if (value > tab[j])
            {
                value = tab[j];
                index = j;
            }
        }
        tab[index] = tab[i];
        tab[i] = value;
    }

    wyswietlTabele();
}

void sortowanieBabelkowe()
{
    cout << "Sortowanie babelkowe: " << endl;

    short int sorted;
    do
    {
        sorted = 1;
        for (short int i = 0; i < N - 1; i++)
        {
            if (tab[i] <= tab[i + 1])
            {
                sorted++;
            }
            else
            {
                short int temp = tab[i + 1];
                tab[i + 1] = tab[i];
                tab[i] = temp;
            }
        }
    } while (sorted < N);

    wyswietlTabele();
}

int main()
{
    srand(time(NULL));

    uzupelnijTabele();

    sortowaniePrzezWstawianie();

    uzupelnijTabele();

    sortowaniePrzezWybor();

    uzupelnijTabele();

    sortowanieBabelkowe();

    return 0;
}
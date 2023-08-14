![Cwiczenia_4](/Notatki/Semestr%201/Podstawy%20programowania/%C4%86wiczenia/%C4%86wiczenia%204/Cwiczenia_4.pdf)
![Słowne nazwy typów](/Notatki/Semestr%201/Podstawy%20programowania/%C4%86wiczenia/%C4%86wiczenia%204/S%C5%82owne%20nazwy%20typ%C3%B3w.pdf)
1. 
| Deklaracja zmiennej | Nazwa (słowny opis typu danych)                                                                                                     | Wielkość zmiennej w pamięci (B) |
| ------------------- | ----------------------------------------------------------------------------------------------------------------------------------- | ------------------------------- |
| double a;           | zmienna typu double                                                                                                                 | 8                               |
| float b\[3\];       | 3 elementowa tablica liczb typu float                                                                                               | 12                              |
| char \*c;           | wskaźnik na zmienną typu char                                                                                                       | 4                               |
| int \*d\[3\];       | 3 elementowa tablica wskaźników na zmienną typu int                                                                                 | 12                              |
| short (\*e)\[3\];   | Wskaźnik na 3 elementowa tablicę typu short                                                                                         | 4                               |
| int \*(\*f)\[5\];   | wskaźnik na 5 elementową tablicę wskaźników na liczby typu int                                                                      | 4                               |
| char \*text;        | wskaźnik na początek (pierwszy znak) łańcucha znaków                                                                                | 4                               |
| int tab\[5\];       | 5 elementowa tablica zmiennych typu int                                                                                             | 20                              |
| int \*tab           | wskaźnik na początek (pierwszy element) tablicy liczb typu int                                                                      | 4                               |
| int tab2\[5\]\[2\]; | 5 elementowa tablica 2 elementowych tablic liczb typu int inaczej dwuwymiarowa tablica liczb typu int o 5 wierszach po dwie kolumny | 40                              |
| short \*\*wsk;      | wskaźnik na wskaźnik typu short                                                                                                     | 4                               |
| void (\*fun)();     | wskaźnik na bezparametrową funkcję zwracającą typ void                                                                              | 4                               |
| float (\*fun)(int); | wskaźnik na funkcję przyjmującą parametr typu int zwracającą typ float                                                              | 4                               |
2. 
   ![lista4](/Notatki/Semestr%201/Podstawy%20programowania/%C4%86wiczenia/%C4%86wiczenia%204/lista4.cpp)
3. 
   ```cpp
	   printf("%d, %d\n", tab2[w][k], *(*(tab2 + w) + k));
	   printf("%d, %d\n", tab3[w][k], *(*(tab3 + w) + k));
   ```
   brak różnic
4. 
   ```cpp
   int wk[100][2] = { {0,0} };

        int index = 0;

        for (short w = 0; w < 4; w++)

        {

                for (short k = 0; k < 3; k++)

                {

                        if (k == 0 && w == 0) continue;

                        else if (tab2[wk[0][0]][wk[0][1]] < tab2[w][k])

                        {

                                wk[0][0] = w;

                                wk[0][1] = k;

                                index = 0;

                        }

                        else if (tab2[wk[0][0]][wk[0][1]] == tab2[w][k]) {

                                wk[++index][0] = w;

                                wk[index][1] = k;

                        }

  

                }

        }

        for (int i = 0; i <= index; i++)

        {

                printf("max:%d, na miejscu: w:%d, k:%d\n", tab2[wk[0][0]][wk[0][1]], wk[i][0], wk[i][1]);

        }
   ```
5. 
   ```cpp
   int wk[100][2] = { {0,0} };

        int index = 0;

        for (short w = 0; w < 3; w++)

        {

                for (short k = 0; tab3[w][k] != 0; k++)

                {

                        if (k == 0 && w == 0) continue;

                        else if (tab3[wk[0][0]][wk[0][1]] < tab3[w][k])

                        {

                                wk[0][0] = w;

                                wk[0][1] = k;

                                index = 0;

                        }

                        else if (tab3[wk[0][0]][wk[0][1]] == tab3[w][k]) {

                                wk[++index][0] = w;

                                wk[index][1] = k;

                        }

  

                }

        }

        for (int i = 0; i <= index; i++)

        {

                printf("max:%d, na miejscu: w:%d, k:%d\n", tab3[wk[0][0]][wk[0][1]], wk[i][0], wk[i][1]);

        }
   ```
6. skompiluje się z ostrzeżeniami po czym zadziała i zwróci z
   



& - operator adresowania
\* - operator wyłuskania

[Wykład 5](/Notatki/Semestr%201/Podstawy%20programowania/Wyk%C5%82ady/Wyk%C5%82ad%205/Wyk%C5%82ad%205.md)
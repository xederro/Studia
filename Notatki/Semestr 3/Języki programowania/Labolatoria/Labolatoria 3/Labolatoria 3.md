[Project](/Notatki/Semestr%203/Języki%20programowania/Labolatoria/Labolatoria%203/Project/Project.md)
Podczas laboratorium należy zbudować "mały system", pozwalający na interakcje z użytkownikami (z poziomu konsoli w wersji minimum, z poziomu okienek w wersji maksimum), umożliwiający wykonywanie operacji CRUD (od ang. create, read, update and delete; pol. utwórz, odczytaj, aktualizuj i usuń) na przetwarzanych danych. Dane powinny być w jakiś sposób utrwalane. Mogą być zapisywne w plikach lub bazie danych zapisywanej do pliku (h2 czy sqlite).  
Wymagane jest, by logika biznesowa systemu była oddzielona od interfejsu użytkownika. Ponadto należy obsłużyć własne wyjątki (oprócz wyjątków generowanych przez Java API).  
Budowany system wspierać ma proces obsługi zgłoszeń zamiaru wycięcia drzewa bądź drzew. Oczywiście system ten będzie jedynie "przybliżeniem" rzeczywistości. Aby dało się go zaimplementować przyjmujemy znaczące uproszczenia.  
Zakładamy, że w procesie biorą udział następujący aktorzy: Obywatel, Kontroler, Kierownik. Wymienieni aktorzy uzyskują dostęp do systemu za pośrednictwem osobnych aplikacji: ObywatelApp (oferującej interfejs dla Obywatela), KontrolerApp (oferującej interfejs dla Kontrolera), KierownikApp (oferującej interfejs Kierownika).

- Obywatel: przesyła zgłoszenia zamiaru wycięcia drzewa/drzew, przegląda status swoich zgłoszeń, otrzymuje decyzje wydane przez Kierownika (za pośrednictwem ObywatelApp);
- Kontroler: otrzymuje zlecenie przeprowadzenia kontroli, przeprowadza kontrole i podsumowuje każdą z nich osobnym protokołem (czynności te robi za pośrednictwem KontrolerApp).
- Kierownik: przegląda zgłoszenia Obywateli, zleca zadania kontroli Kontrolerom, analizuje protokoły z kontroli, a na podstawie tej analizy wydaje decyzje (za pośrednictwem KierownikApp).

Zakres gromadzonych danych w systemie może być minimalny.

- obywatel: id, nazwa
- kontroler: id, nazwa
- kierownik: id, nazwa
- zgłoszenie: id_zgłoszenia (nadawane po dokonaniu zgłoszenia), id_obywatela, lista_drzew (drzewo to: numer, nazwa, średnica), status (złożone, przyjęte, zakończone), data_zgłoszenia
- raport: id_raportu, id_zgłoszenia, opis (tekst)
- decyzja: id_decyzji, id_zgłoszenia, id_kierownika, opis (tekst)

Aby przetestować działanie systemu powinno dać się uruchamiać osobno: przynajmniej dwie instancje ObywatelApp, przynajmniej dwie instancje KontrolerApp, jedną instancję KierownikApp.  
Synchronizacja pomiędzy uruchomionymi instancjami wymienionych aplikacji powinna odbywać się poprzez współdzielenie utrwalanych gdzieś danych. W przypadku zapisywania danych w systemie plików może pojawić się kłopot - system operacyjny może zablokować możliwość zapisu do danego pliku, jeśli aktualnie jest on otwarty w innej aplikacji. Wtedy może przydać się właśnie obsługa wyjątków. Generalnie - implementacja wielodostępu to bardzo trudny temat. Na potrzeby laboratorium mocno go upraszczamy (nie ma potrzeby budowania tytaj jakichś bardzo złożonych mechanizmów). W przypadku posługiwania się bazami danych zapisanymi w pliku też ten problem może wystąpić.  
Pozostałe szczegóły mają być zgodne z ustaleniami poczynionymi na początku zajęć.

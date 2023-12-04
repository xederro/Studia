[Project](/Notatki/Semestr%203/Języki%20programowania/Labolatoria/Labolatoria%202/Project/Project.md)
Podczas laboratorium należy rozwiązać problem optymalizacyjny zdefiniowany poniżej. Załóżmy, że jakaś firma organizuje wyjazd na narty. W wyjeździe tym biorą udział uczestnicy w różnym wieku i o różnych preferencjach co do wykorzystywanego sprzętu. Preferencje dotyczące nart (inny sprzęt pomijamy) zapisano w pliku preferences.txt o zawartości:

id,group,skis (wygenerować sobie 50)
1,J,slalom:140;gigant:150
2,A,race:175,allmountain:175
3,C,carving:120
...

gdzie id reprezentuje identyfikator uczestnika, group reprezentuje grupę wiekową, do której dany uczestnik należy, kodowaną jedną literą (C - child, J - junior, A - adult) zaś ski przeznaczone jest na listę preferencji - par określających rodzaj narty oraz jej długość. Ośrodek, do którego dotrzeć mają uczestnicy wyjazdu, ma na swoim stanie narty jak w wykazie zapisanym w pliku wykaz.txt:

quantity,ski (wygenerować)
3,slalom:130
1,carving:130
2,race:170
...

Narty są wypożyczany uczestnikom wyjazdu według specyficznego cennika: dzienny koszt wypożyczenia pary nart jest taki sam dla wszystkich ich rodzajów, obowiązują jednak procentowe zniżki uzależnione od grupy wiekowej wypożyczającego. Zniżki te zapisano w pliku znizki.txt:

group,discount
C,50
J,20
A,0

Ponieważ uczestnicy wyjazdu nie zabierają ze sobą własnego sprzętu, wystąpiła konieczność wymyślenia sposobu na w miarę sensowne przydzielenie im nart z ośrodka. Sposobem tym okazało się minimalizowanie kryterium, w którym uwzględniono:

- różnicę między długościami nart zadeklarowanych w preferencjach a długościami nart przydzielonych,
- różnicę między rodzajem nart zadeklarowanych w preferencjach a rodzajem nart przydzielonych,
- liczbę osób, którym nart nie przydzielono,

Przedstawiony problem należy do problemów kombinatorycznych. Takie problemy można rozwiązywać dokonując przeglądu zupełnego przestrzeni rozwiązań (generując wszystkie możliwe scenariusze przydzielenia nart, a następnie sprawdzając, który z nich daje najlepszy wynik względem zdefiniowanego kryterium) bądź też stosując metody heurystyczne (bazujące na jakiejś wiedzy i sensownych założeniach). Zwykle kryteria formułowane są z uwzględnieniem jakiejś nagrody badź kary (odpowiednio do zbliżania się do lub oddalania się od celu optymalizacyjnego). Proszę zastanowić się, jak zdefiniować kryterium optymalizacji, a następnie, jak zaimplementować algorytm je wykorzystujący. Program, który powstanie, powinien pozwalać na wskazanie pliku danych do załadowania (z listą uczestników, ich preferencjmi oraz zniżkami). Powinien też być napisany w sposób obiektowy (z rozdzieleniem interfejsu użytkownika od części obliczeniowej). Pozostałe szczegóły mają być zgodne z ustaleniami poczynionymi na początku zajęć.


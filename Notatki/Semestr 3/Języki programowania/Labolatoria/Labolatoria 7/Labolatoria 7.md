Projekt
[Projekt](/Notatki/Semestr%203/Języki%20programowania/Labolatoria/Labolatoria%207/Projekt/Projekt.md)

każdy interface zdalny ma dziedziczyć "remote"
mamy korzystać z interface dostarczonych przez prowadzącego
unicast remote object
1 rmi registry u keepera
unexport jawnie trzeba użyć

>[!info]
> przeanalizować przykład 


Podczas laboratorium należy zbudować aplikację działającą w środowisku rozproszonym, wykorzystującą technologię RMI. Dokładniej - należy zaimplementować mały systemu, w którego skład wejdą podsystemy uruchamiane równolegle. Zakładamy, że system będzie pełnić podobną rolę jak w opisie z laboratorium 6. Będzie to symulator sklepu stacjonarnego, w którym klienci zamawiają towary za pośrednictwem terminali, zaś pracownicy sklepu zajmują się dostarczeniem i sprzedażą towarów według tych zamówień. Częściami tego systemu mają być podsystemy:

- Magazynier (Keeper) implementujący interfejs IKeeper
- Dostawca (Deliverer) implementujący interfejs IDeliverer
- Sprzedawca (Seller) implementujący interfejs ISeller
- Klient (Client) implementujący interfejs IClient

Główna różnica w specyfikacji zadania w porównaniu z poprzednim laboratorium polega na tym, że wywołania metod register() i unregister() interfejsu IKeeper mają być synchroniczne (wcześniej były asynchroniczne). Ponadto zniesiono konieczność korzystania z metody getInfo().  
Wykorzystywane interfejsy oraz typ wyliczeniowy zostały zdefiniowane w załączonym do zadania pliku jar. Plik ten należy wykorzystać jako obowiązkową zależność we własnym projekcie.  
Pozostałe szczegóły mają być zgodne z ustaleniami poczynionymi na początku zajęć.
![](/Notatki/Semestr%203/Języki%20programowania/Labolatoria/Labolatoria%207/shop-1.0-SNAPSHOT.jar)
![](/Notatki/Semestr%203/Języki%20programowania/Labolatoria/Labolatoria%207/shopTest.zip)

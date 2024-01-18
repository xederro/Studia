Podczas laboratorium należy zbudować aplikację działającą w środowisku rozproszonym, wykorzystującą do komunikacji gniazda TCP/IP obsługiwane za pomocą klas ServerSocket oraz Socket. Dokładniej - należy zaimlementować mały systemu, w którego skład wejdą podsystemy uruchamiane równolegle (na jednym lub na kilku różnych komputerach). Zakładamy, że system będzie pełnić rolę symulatora sklepu stacjonarnego, w którym klienci zamawiają towary za pośrednictwem terminali, zaś pracownicy sklepu zajmują się dostarczeniem i sprzedażą towarów według tych zamówień (przykładem sklepu działającego wg tego schematu jest np. sklep e-obuwie). Częściami tego systemu mają być podsystemy:

- Magazynier (Keeper),
    - obsługuje sklepowy magazyn z towarami. Odpowiada za rejestrację i wyrejestrowywanie Klientów i pracowników (Sprzedawców i Dostawców) oraz za obsługę ich żądań. Towary w magazynie mogą być opisane tekstowo. Host i port Magazynu są powszechnie znane.
    - wystawia na zadanym porcie (port to parametr) interfejs IK z metodami: register(), unregister(), getOffer(), putOrder(), getOrder(), returnOrder(), getInfo().  
        Metoda register(role, host, port) pozwalać ma Klientowi i pracownikom (Dostawcy i Sprzedawcy) na zarejestrowanie się w sklepie. W atrybutach tej metody podawane jest, kto jest rejestrowany (np. role = 'deliverer') oraz pod jakim adresem ten ktoś będzie nasłuchiwał na informacje zwrotne (np. host = 'localhost', port = '2000').  
        Metoda uregister(id) pozwalać ma na wyrejestrowanie Klienta lub pracownika (Dostawcy lub Sprzedawcy) o wskazanym id.  
        Metoda getOffer(idc) pozwalać ma Klientowi o wskazanym idc na pozyskanie informacji o ofercie sklepu.  
        Metoda putOrder(idc, data) pozwalać ma Klientowi na złożenie zamówienia na towary.  
        Metoda getOrder(idd) pozwalać ma Dostawcy na pobranie pierwszego nieobsłużonego jeszcze zamówienia Klienta (zakładamy, że Magazyn będzie kolejkował te zamówienia).  
        Metoda returnOrder(data) służyć ma do oddania do magazynu towarów zwróconych przez Klienta.  
        Metoda getInfo(id1,id2) pozwalać ma Klientowi lub pracownikowi (Dostawcy lub Sprzedawcy) o id1 na pozyskanie informacji o adresie (hoście i porcie) Klienta lub pracownika (Dostawczy lub Sprzedawcy) o id2. Zakładamy, że zapytanie z id2 = 0 dotyczyć będzie adresu pierwszego "wolnego" sprzedawcy.
    - korzysta z interfejsów ID, IC, IS wystawionych, odpowiednio, przez Dostawcę, Klienta i Sprzedawcę, by porzez metodę response(type,data) przekazywać informacje zwrotne. Atrybut type służy do określenie, do jakiego wysłanego wcześniej żądania odnoszą się te informacje, atrybut data przednosi te informacje.
- Dostawca (Deliverer),
    - wystawia na zadanym porcie (port to parametr) interfejs ID z metodami: response() i returnOrder().  
        Metoda response(type,data) pozwalać ma Magazynierowi na przesłanie odpowiedzi do którejś z wywołanych wcześniej przez Dostawcę metod: register(), getOrder(), getInfo(). Pierwszy atrybut tej metody określa typ odpowiedzi, natomiast data reprezentuje treść odpowiedzi. Przykładowo, wywołanie metody response() z type="registerResponse" oraz data="10" może oznaczać, że Magazynier zareagował na metodę register(), przyznając Dostawcy identyfikator idd=10. Wywołanie metody response() z type="getOrderResponse" oraz data="3,towar1,towar2" może oznaczać, że Klient o identyfikatorze idc=10 zamówił towar1 oraz towar2. Wywołanie metody response() z type="getInfoResponse", data="localhost,4000" może oznaczać, że adres Klienta, o którego zapytał Dostawca, to host=localhost, port=400.  
        Metoda returnOrder(data) pozwalać ma Klientowi zwrócić towary, które wcześniej otrzymał. Towary te zapisane są w atrybucie data (np. data="towar1"). Lista zwracanych atrybutów musi mieć część wspólną z listą towarów dostarczonych Klientowi przez Dostawcę.
    - korzysta z interfejsów IK oraz IC wystawionych, odpowiednio, przez Magazyniera i Klienta.
- Klient (Customer),
    - wystawia na zadanym porcie (port to parametr) interfejs IC z metodami: response(), putOrder(), returnReceipt().  
        Metoda response(type,data) ma być wykorzystywana przez Magazyniera do przesyłania odpowiedzi na żądania: register(), getOffer(), getInfo() - na podobnej zasadzie, jak w przypadku Dostawcy, przy czym Magazynier w odpowiedzi na getOffer przesyła listę wszystkich aktualnie dostępnych towarów (pomijamy stronicowanie).  
        Metoda putOrder(idd,data) pozwalać ma Dostawcy na przekazanie Klientowi towarów zgodnie ze złożonym przez niego zamówieniem (które Klient złożył u Magazyniera). Atrybut idd to identyfikator Dostawcy (np. "1", natomiast data to lista towarów (np. "towar1,towar2,towar3"). Znajomość idd pozwolić ma Klientowi na zwrócenie towarów za pośrednictwem Dostawcy (jeszcze przed pójściem do kasy).  
        Metoda returnReceipt(data) pozwalać ma Sprzedawcy na przekazanie rachunku. W tym przypadku atrybut data reprezentować ma ten rachunek.
    - korzysta z interfejsów IK, ID oraz IS wystawionych, odpowiednio, przez Magazyniera, Dostawcę i Sprzedawcę.
- Sprzedawca (Seller),
    - wystawia na zadanym porcie (port to parametr) interfejs IC z metodami: response(), acceptOrder(). 
        Metoda response(type,data) ma być wykorzystywana przez Magazyniera do przesyłania odpowiedzi na żądania: register(), getOffer(), getInfo() - na podobnej zasadzie, jak w przypadku Dostawcy.  
        Metoda acceptOrder(idc,data) pozwalać ma Klientowi na przekazanie Sprzedawcy towarów, które zamierza zakupić bądź zwrócić. Atrybut idc to identyfikator Klienta (np. "4", natomiast data to lista towarów (np. "towarBrany1,towarBrany2;towarZwracany3"). Znajomość idc pozwolić ma Sprzedawcy na przekazanie rachunku do właściwego Klienta. Jeśli na liście towarów są jakieś pozycje do zwrotu, wtedy Sprzedawca zwraca je Magazynierowi.
    - korzysta z interfejsów IK oraz IS wystawionych, odpowiednio, przez Magazyniera oraz Klienta

Na rysunku poniżej przedstawiono architekturę systemu.  

![](/Notatki/Semestr%203/Języki%20programowania/Labolatoria/Labolatoria%206/Pasted%20image%2020231218112023.png)

Pozostałe szczegóły mają być zgodne z ustaleniami poczynionymi na początku zajęć.
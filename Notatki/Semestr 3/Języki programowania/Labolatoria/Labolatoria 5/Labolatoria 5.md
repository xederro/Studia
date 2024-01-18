[project](/Notatki/Semestr%203/Języki%20programowania/Labolatoria/Labolatoria%205/Project/project.md)
Podczas laboratorium należy zbudować aplikację, w której dojdzie do synchronizacji wielu wątków. Aplikacja powinna być parametryzowana i pozwalać na uruchamianie wątków oraz obserwowanie ich zachowań i stanów.  
Zakładamy, że aplikacja będzie pełnić rolę symulatora akcji malowania wielosegmentowego płotu przez wielu malarzy zdefiniowanej jak niżej.  
Płot do pomalowania składa się z k - segmentów, każdy zaś ma l - sztachet.  
Płot jest malowany przez n - malarzy, którzy pracują z różnym tempem oraz posługują się widerkami z farbą o niekoniecznie tej samej pojemności.  
Każdy malarz rozpoczyna pracę od innego segmentu. Jeśli skończy, to próbuje zająć się segmentem jeszcze niepomalowanym, a jeśli takiego nie ma - próbuje pomóc innemu malarzowi pracującemu nad swoim segmentem.  
Jeśli jakiś malarz dołączy do malowania segmentu malowanego przez kogoś, to rozpoczyna jego malowanie od połowy niepomalowanej jeszcze części (chodzi o to, by malarze nie musieli "przeskakiwać" przez siebie podczas pracy). Gdy do malowania współmalowanego segmentu dołączy kolejny malarz, to powinnien zająć się pracą od połowy najdłuższej sekcji tego segmentu jeszcze niepomalowanej. Przydział kolejnych części do malowania powinien odbywać się według takiego samego schematu.  
Każdy malarz powinien być reprezentowany przez osobny wątek. Można przyjąć założenie, że liczba aktywnych malarzy nie może być większa niż 25. Dzięki temu założeniu generowanym wątkom będzie można przypisać jednoliterową etykietę, zaczynając od a. Litery przypisane malarzom powinny być wykorzystane do wskazania, którą sztachetę pomalował dany malarz.  
Każdy malarz ma wiaderko z farbą, która się zużywa (można przyjąć, że pojemność wiaderka wystarcza na pomalowanie j sztachet). Co jakiś czas malarz wiaderko z farbą musi być uzupełniane (zakładamy, że uzupełnianie wiaderka następuje po całkowitym wyczerpaniu farby). Uzupełnianie farby odbywa się poprzez jej pobranie ze wspólnego zbiornika, do którego farbę dostarcza osobny wątek dostawcy.  
Wizualizacja stanu wątków chyba najłatwiej zrealizować korzystając z etykiet tekstowych umieszczanych na panelu jak na poniższym schemacie:

. \[100\] .
a  b  c  d  e
1  4  4  2  0
| a a a . . . | b . . . . . | c . . . . . | d d . . . . | e e e e . . | 

W pierwszej linii wypisany jest stan zbiornika z farbą (w miejsce kropek powinna pojawić się literki wątku dostawcy, jeśli ten aktualnie uzupełnia zbiornik (po lewej) oraz wątku malarza, który aktualnie uzupełnia wiaderko (po prawej)).  
W drugiej linii wypisane są literki uruchomionych wątków, zaś pod nimi, w trzeciej linii, wypisywane są liczby wskazujące na stan odpowiednich wiaderek z farbą. W czwartej linii wizualizowane są segmenty płotu z pomalowanymi sztachetami.  
Powyższy schemat jest tylko propozycją. Można wymyśleć inny sposób wizualizacji zachowania się wątków.  
Należy zadbać o odpowiednią synchronizację wątków. Proszę się zastanowić, co jest zasobem współdzielonym i przy jakich warunkach wątki mogą pozyskać dostęp do tego zasobu.  
Pozostałe szczegóły mają być zgodne z ustaleniami poczynionymi na początku zajęć.
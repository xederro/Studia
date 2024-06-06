# MIMD - koprocesor - CRAY

## Procesor i koprocesor - 2 w 1
### Współpraca procesora i koprocesora
jednostka centralna robi rozkazy, a sam fragment operacji który wykonuje jakieś zadania przekazuje do koprocesora, dane musi sobie zebrać sam i je odesłać,

### Architektura wewnętrzna

### Formaty danych
warto znać formaty jakie by były, bez wzorów

### Regulacje i rejestry
możemy wybierać tryb nieskończoności, zaokrąglanie, precyzja
wdzięczne pytanie o przerwaniach #kolokwium 

### Lista rozkazów

## MIMD
### Topologia
Diameter - max odległość między dwoma procesorami w systemie
bandwidth - określa ile może danych między procesorami przesłać
bisection bandwidth

Shared bus - prosta, komunikacja przez magistrale, pamięć dla procesora, łatwo doczepić nowe procesory, jeżeli mało korzystamy z magistrali to jest świetny jak nie to to jest bottleneck
ring - punkt punkt więc prosta adresowania, trzeba czekać na sąsiadów by przekazał info, 
tree - punkt punkt, prosta adresacja, może być droga zastępcza mimo awarii, potencjalnie kompaktowa
mesh - sekwencja wykonywania działań, punkt punkt, uporządkowana siatka, 
hypercube - taki mesh ale więcej połączeń, n procesorów logn połączeń
completely connected - każdy z każdym połączony, ale trzeba ogarnąć co skąd przychodzi i kiedy

mogą być struktury przełączane dynamicznie

### Równolegle

PVP parallel vector processor - mamy kilka wartości na których przeprowadzamy te same operacje
SMP symmetric multiprocessor - wiele takich samych procesorów
MPP massively parallel processor - mamy różne lepsze gorsze procesory
DSM distributed shared memory
COW cluster of workstation - składamy kilka komputerów
GRID COMPUTATION - 
MULTI-CORE CPU - 

### typy architektur
smp
pvp

### pamięć
uma - uniform memory access - procesory przez communication mechanism przekazuje dane do współdzielonej pamięci, to inny układ odpowiada za adresowanie. prosta adresacja, proste przepinanie zasobów
numa - nonuniform memory access - każdy procesor ma swoją pamięć i może przez communication mechanizm komunikować się z innymi pamięciami procesorów
ccnuma - cache coherent numa - mamy cache ale możemy pobrać dane z innych cache
coma - cache only memory access - mamy tylko cache

### Multikomputery
NOW - Network of workstation
COW - cluster of workstation
MPP - Massively pararrel processors

### miary i parametry
computation/communication ratio 

speedup factor

ziarnistość zadania

miara R to C

FTC, skalowalność

MaxSpeedup = Amdahl's law 


## CRAY

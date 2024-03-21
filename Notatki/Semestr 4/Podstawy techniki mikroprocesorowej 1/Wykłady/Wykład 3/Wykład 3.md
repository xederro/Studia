![](/Notatki/Semestr%204/Podstawy%20techniki%20mikroprocesorowej%201/Wykłady/Wykład%203/PTM-wyk-3.pdf)

tts 15.28

S1 - IF - pobranie rozkazu
S2 - ID - dekodowanie rozkazu
S3 - OF - wyznaczanie efektywnego adresu
S4 - OF - ładowanie argumentu
S5 - E - egzekucja
S6 - S - zapisanie rezultatów

zamiast
if->id->of->e->s
można:
if->id->of->e->s
  ->if->id->of->e->s
  ->  ->if->id->of->e->s
  ->  ->  ->if->id->of->e->s
  .
  .
  .


przetwarzanie potokowe #kolokwium

problemem są skoki #kolokwium
możemy ignorować skok i dalej przelecieć do kolejnego zadania
możemy poczekać by wiedzieć gdzie skakać
ściągnąć 2 naraz i czekać na rezultat i dobrać odpowiednią drogę



System przerwań #kolokwium co się dzieje jak jest sygnał
arbitraż równoległy
ESKMZP: element systemu komputerowego mogący zgłosić przerwanie

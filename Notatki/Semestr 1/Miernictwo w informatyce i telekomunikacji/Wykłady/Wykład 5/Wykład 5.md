![[Notatki/Semestr 1/Miernictwo w informatyce i telekomunikacji/Wykłady/Wykład 5/Wykład decybele_konspekt_eportal.pdf]]H: PB_dB
[kalkulator](https://www.rohde-schwarz.com/pt/applications/db-calculator-application-note_56280-15492.html)
![[Materia_y_dodatkowe_z_dB_Piotr_Komur_Kalkulator_decybelowy_Elektronika_Praktyczna_ (1).pdf]]
![[Notatki/Semestr 1/Miernictwo w informatyce i telekomunikacji/Wykłady/Wykład 5/Decybele.pdf]]
![[Notatki/Semestr 1/Miernictwo w informatyce i telekomunikacji/Wykłady/Wykład 5/Materia_y_dodatkowe_z_dB_Piotr_Komur_Kalkulator_decybelowy_Elektronika_Praktyczna_ (1).pdf]]

# Decybele

## Mocowy
$X[db] = 10log\frac{P1}{P2}$


## Napięciowy
$X[db] = 20log\frac{U1}{U2}$



$R[\Omega] = {U[V]\over I[A]}$
$logR=logU-LogI$
$db\Omega=dbU=dbI$

## Przykładowe skróty
dBm - decybel względem mW
db$\micro$ - decybel wz. $\micro$V
dBi - anteny izotropowej
dBc - poziom względem fali nośnej

6dB to 4-krotny wzrost mocy ale 2-krotny wzrost napięcia


## Przykładowe obliczenia
30dBmW = 1W

50W -> 100/2W -> 20dBW-3dBW = 17dBW = 17dBW + 30dB = 47dBmW

24dBuV -> 20+10-6 = 10\*3,17/2 = 15,8uV
24dBuV -> 6+6+6+6=2\*2\*2\*2 = 16uV

40mV -> 2\*2\*10 = 6dBmV + 6dBmV + 20dBmV = 32dBmV

80mW -> 10\*2\*2\*2 = 10+3+3+3 = 19dBmW
80mW -> 100mW/1.25 = 20dB-1dB = 19dBmW

-27dBmW -> -30+3dB -> 1$\micro W$\*2 = 2$\micro W$

42dBV -> 20 + 20 + 2 = 10\*10\*1,25 = 125V = $10^{42\over20}$
42dBW -> 20 + 20 + 2 = 100\*100\*1,6 = 16000W = 16kW = $10^{42\over10}$


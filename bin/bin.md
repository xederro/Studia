Fix broken absolute paths (runs on before commit):
-path
	path to root directory
-git
	checks only staged files
![](bin/APR.exe)
```shell
.\APR.exe -git -path=..
```



---
Create study structure:

-in
	path to csv file
-out
	path where to create structure
-pre
	insert before paths
-n
	number of semester
```shell
.\SSC.exe -n=5 -out="..\Notatki" -in=".\Semestr 5.csv" -pre="Notatki/"
```

![](bin/SSC.exe)
![](bin/Semestr%205.csv)

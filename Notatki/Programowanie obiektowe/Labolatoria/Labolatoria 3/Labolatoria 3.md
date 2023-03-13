![[Lab3_lista.pdf]]

```run-java
public class Triangle {  
    public static void print_triangle(int N){  
        int[][] pascal = new int[N+1][N+1];  
  
        if (N >= 0) {  
            pascal[0][0] = 1;  
        }  
        if (N >= 1) {  
            pascal[1][0] = 1;  
            pascal[1][1] = 1;  
        }  
        if (N >= 2) {  
            for (int i = 2; i <= N; i++) {  
                for (int j = i; j >= 0; j--) {  
                    if (j == i || j == 0) {  
                        pascal[i][j] = 1;  
                    } else {  
                        pascal[i][j] = pascal[i-1][j]+pascal[i-1][j-1];  
                    }  
                }  
            }  
        }  
  
        for (int i = 0; i <= N; i++) {  
            for (int j = N-i; j >= 0; j--) {  
                System.out.print("\t");  
            }  
  
            for (int j = 0; j <= i; j++) {  
                System.out.printf("%d\t", pascal[i][j]);  
                if (j != i){  
                    System.out.print("0\t");  
                }  
            }  
  
            System.out.print("\n");  
        }  
    }  
  
    public static void main(String[] args) {  
        print_triangle(10);  
    }  
}
```

```run-java
import java.util.*;  
  
public class Tour {  
    public static void print_capitals(Map<String, String> map) {  
        for (String key : map.keySet()){  
            System.out.printf("%s: %s\n", key, map.get(key));  
        }  
    }  
  
    public static void print_visited(List<String> list) {  
        for (String key : list){  
            System.out.printf("%s\n", key);  
        }  
    }  
  
    public static void print_unique(Set<String> set) {  
        for (String key : set){  
            System.out.printf("%s\n", key);  
        }  
    }  
  
    public static void print_checks(Map<String, String> a, List<String> b, Set<String> c) {  
        if (a.keySet().contains("Szwecja")){  
            System.out.println("A ma Szwecje");  
        } else {  
            System.out.println("A nie ma Szwecji");  
        }  
  
        if (b.contains("Paryż")){  
            System.out.println("B ma Paryżu");  
        } else {  
            System.out.println("B nie ma Paryżu");  
        }  
  
        if (c.contains("Rzym")){  
            System.out.println("C ma Rzymu");  
        } else {  
            System.out.println("C nie ma Rzymu");  
        }  
  
        System.out.printf("A ma: %d\nB ma: %d\nC ma: %d\n", a.size(), b.size(), c.size());  
    }  
  
    public static Map<String, String> create_map() {  
        Map<String, String> a = new HashMap<>();  
  
        a.put("Algieria", "Algier");  
        a.put("Angola", "Luanda");  
        a.put("Benin", "Porto-Novo");  
        a.put("Botswana", "Gaborone");  
        a.put("Burkina Faso", "Wagadugu");  
        a.put("Burundi", "Gitega");  
        a.put("Czad", "Ndżamena");  
        a.put("Demokratyczna Republika Konga", "Kinszasa");  
        a.put("Dżibuti", "Dżibuti");  
        a.put("Egipt", "Kair");  
        a.put("Erytrea", "Asmara");  
        a.put("Etiopia", "Addis Abeba");  
        a.put("Gabon", "Libreville");  
        a.put("Gambia", "Bandżul");  
        a.put("Ghana", "Akra");  
        a.put("Gwinea", "Konakry");  
        a.put("Gwinea Bissau", "Bissau");  
        a.put("Gwinea Równikowa", "Malabo");  
        a.put("Kamerun", "Jaunde");  
        a.put("Kenia", "Nairobi");  
        a.put("Komory", "Moroni");  
        a.put("Kongo", "Brazzaville");  
        a.put("Lesotho", "Maseru");  
        a.put("Liberia", "Monrovia");  
        a.put("Libia", "Trypolis");  
        a.put("Madagaskar", "Antananarywa");  
        a.put("Malawi", "Lilongwe");  
        a.put("Mali", "Bamako");  
        a.put("Maroko", "Rabat");  
        a.put("Mauretania", "Nawakszut");  
        a.put("Mauritius", "Port Louis");  
        a.put("Mozambik", "Maputo");  
        a.put("Namibia", "Windhuk");  
        a.put("Niger", "Niamey");  
        a.put("Nigeria", "Abudża");  
        a.put("Południowa Afryka", "Pretoria");  
        a.put("Republika Środkowoafrykańska", "Bangi");  
        a.put("Republika Zielonego Przylądka", "Praia");  
        a.put("Rwanda", "Kigali");  
        a.put("Senegal", "Dakar");  
        a.put("Seszele", "Victoria");  
        a.put("Sierra Leone", "Freetown");  
        a.put("Somalia", "Mogadiszu");  
        a.put("Eswatini", "Mbabane");  
        a.put("Sudan", "Chartum");  
        a.put("Sudan Południowy", "Dżuba");  
        a.put("Tanzania", "Dodoma");  
        a.put("Togo", "Lomé");  
        a.put("Tunezja", "Tunis");  
        a.put("Uganda", "Kampala");  
        a.put("Wybrzeże Kości Słoniowej", "Jamusukro");  
        a.put("Wyspy Świętego Tomasza i Książęca", "São Tomé");  
        a.put("Zambia", "Lusaka");  
        a.put("Zimbabwe", "Harare");  
        a.put("Szwecja", "Paryż");  
        a.put("Włochy", "Rzym");  
  
        return a;  
    }  
  
    public static List<String> create_list(Map<String, String> map) {  
        List<String> b = new ArrayList<>();  
        Object[] temp = map.values().toArray(new String[0]);  
        Random rand = new Random();  
  
        for (int i = 55; i >= 0; i--){  
            b.add(temp[rand.nextInt(0,temp.length)].toString());  
        }  
  
        return b;  
    }  
  
    public static Set<String> create_set(List<String> list) {  
        return new HashSet<>(list);  
    }  
  
    public static void main(String[] args) {  
        Map<String, String> a = create_map();  
        print_capitals(a);  
        System.out.print("\n\n\n\n");  
  
        List<String> b = create_list(a);  
        print_visited(b);  
        System.out.print("\n\n\n\n");  
  
        Set<String> c = create_set(b);  
        print_unique(c);  
        System.out.print("\n\n\n\n");  
  
        print_checks(a,b,c);  
    }  
}
```

![[Tour.java]]
![[Triangle.java]]
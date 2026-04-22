# siniflar-praktik-1 - Öğrenci Not Sistemi

Öğrenci, ders ve öğretmen sınıfları kullanılarak not ortalaması hesaplayan ve sınıf geçip geçmediğini belirleyen program.

## Sınıflar

- **Teacher**: name, mpno, branch niteliklerini tutar
- **Course**: name, code, prefix, note, Teacher niteliklerini yönetir; öğretmen ataması ve yazdırma metotları içerir
- **Student**: name, stuNo, classes, course1/2/3, avarage, isPass niteliklerini yönetir; not girişi, ortalama hesabı ve geçme kontrolü içerir

## Ödev

Course sınıfına sözlü notu ve ortalamaya etkisi eklenmesi. Her ders için sözlü ağırlığı ayrı belirlenir.  
Örnek: Fizik sözlü %20, sınav %80 → Fizik Ortalaması = (sözlü * 0.20) + (sınav * 0.80)

## Çalıştırma

```bash
javac src/*.java -d out
java -cp out Main
```

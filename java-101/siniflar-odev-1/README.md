# siniflar-odev-1 - Employee Maaş Sistemi

Fabrika çalışanlarının maaşlarını hesaplayan Employee sınıfı. Vergi, bonus ve kıdem zammı hesaplamalarını içerir.

## Sınıf Nitelikleri

name, salary, workHours, hireYear

## Hesaplamalar

- **tax()**: Maaş >= 1000 TL ise %3 vergi
- **bonus()**: Haftada 40 saati aşan her saat için 30 TL
- **raiseSalary()**: 10 yıldan az %5 | 10-19 yıl %10 | 20+ yıl %15 zam (baz yıl: 2021)

## Çalıştırma

```bash
javac src/*.java -d out
java -cp out Main
```

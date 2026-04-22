# Temel Praktik 2 - KDV Hesaplayıcı

KDV'siz fiyatı alıp KDV tutarını ve KDV'li fiyatı hesaplayan Java programı.

## Kurallar

- 0–1000 TL arası: KDV oranı %18
- 1000 TL üzeri: KDV oranı %8

## Formül

```
KDV Tutarı = Fiyat × KDV Oranı
KDV'li Fiyat = Fiyat + KDV Tutarı
```

## Örnek Çıktı

```
KDV'siz fiyatı giriniz: 10
KDV Oranı    : %18
KDV Tutarı   : 1.8
KDV'li Fiyat : 11.8
```

## Çalıştırma

```bash
javac src/Main.java
java -cp src Main
```

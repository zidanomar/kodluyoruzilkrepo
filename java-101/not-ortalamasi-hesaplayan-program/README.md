# Not Ortalaması Hesaplayan Program

Java ile yazılmış, kullanıcıdan 6 dersin sınav puanlarını alıp ortalamasını hesaplayan ve sınıfı geçip geçmediğini ekrana yazdıran basit bir konsol uygulaması.

## Dersler

- Matematik
- Fizik
- Kimya
- Türkçe
- Tarih
- Müzik

## Nasıl Çalışır

1. Program her ders için kullanıcıdan bir puan ister.
2. Girilen 6 puanın aritmetik ortalaması hesaplanır.
3. **Ternary operator** ile ortalama 60'tan büyükse `Sinifi Gecti`, değilse `Sinifta Kaldi` yazdırılır.

```java
String sonuc = ortalama > 60 ? "Sinifi Gecti" : "Sinifta Kaldi";
```

## Çalıştırma

```bash
javac src/Main.java
java -cp src Main
```

## Örnek Çıktı

```
Matematik puanini giriniz: 70
Fizik puanini giriniz: 80
Kimya puanini giriniz: 60
Turkce puanini giriniz: 75
Tarih puanini giriniz: 65
Muzik puanini giriniz: 90
Ortalaminiz: 73.33333333333333
Sinifi Gecti
```

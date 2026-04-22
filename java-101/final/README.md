# Final - Mayın Tarlası

Metin tabanlı Mayın Tarlası oyunu.

## Oyun Kuralları

- Kullanıcı matris boyutunu belirler (minimum 2×2)
- Eleman sayısının ¼'ü kadar rastgele mayın yerleştirilir
- Mayınlar `*`, kapalı alanlar `-` ile gösterilir
- Açılan alanda komşu mayın sayısı yazılır
- Mayına basılırsa **Game Over**, tüm alanlar açılırsa **Kazandınız**

## Örnek

```
Satır Giriniz: 0
Sütun Giriniz: 1
===========================
- 2 -
- - -
- - -
```

## Çalıştırma

```bash
javac src/Main.java
java -cp src Main
```

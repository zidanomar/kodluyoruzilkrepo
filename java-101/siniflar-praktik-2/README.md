# siniflar-praktik-2 - Boks Maçı

Fighter ve Ring sınıfları kullanılarak iki dövüşçü arasındaki boks maçını simüle eden program.

## Sınıflar

- **Fighter**: name, damage, health, weight, dodge niteliklerini tutar; `hit()` ve `dodge()` metotları içerir
- **Ring**: İki dövüşçüyü yönetir; ağırlık kontrolü, tur döngüsü ve kazanan belirleme içerir

## Ödev

İlk vuruşu kimin yapacağını %50 olasılıkla belirleyen sistemi Ring sınıfına entegre etmek.

## Çalıştırma

```bash
javac src/*.java -d out
java -cp out Main
```

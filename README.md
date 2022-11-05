# CINEMA APP

#Proje sahibi:Canberk Erdem

# Açıklama
Bu proje herhangi bir sinema filmine bilet almak için oluşturulmuştur.Aynı zamanda bileti görüntülemek veya iptal etmek için de kullanılabilir.

com.cinema.Cinema classını çalıştırarak uygulamayı başlatabilirsiniz,bu işlemden sonra 8080 numaralı portda (http://localhost:8080) bir web sunucusu başlatır.
Çıkan sayfada SwaggerUI üzerinden istediğiniz işlemleri yapabilirsiniz.

Bu projede kullanılan teknolojiler aşağıda verilmiştir:

* Java 1.8
* Spring Boot
* Database postgreSQL
* Maven


Uygulamanın çalışmasında 4 API hizmet etmektedir. 

#API'ler

* /ticket/create
* /ticket/cancel
* /ticket/view_booking
* /ticket/view_bookings_with_date


## /ticket/create
method: POST
request: {
"audienceSet": [
{
"age": 35,
"audienceName": "canberk",
"audienceSurname": "erdem"
},
{
"age": 32,
"audienceName": "hasan",
"audienceSurname": "yılmaz"
}
],
"seansId": 1
}

Seyirciler yanlarında bir veya daha fazla seyirci için bilet alabilirler.

## /ticket/cancel
method: POST

{
"ticketNumber": "12345678",
"surname": "erdem"
}

Biletin iptali için numara ve soyadı eşleşmesi zorunludur.

## /ticket/view_ticket
method: GET

ticketNumber: {Biletiniz oluşturulduktan sonra elde ettiğiniz biletNumarası}

Seyirciler biletlerini görüntüleyebilir ve tarihini ne zaman olduğunu görebilir.

## /ticket/view_tickets_with_date
method: GET

localDate: The parameter has a format: dd/MM/yyyy

Eğer parametreyi doğru formatta vermezseniz "Tarih parametresini şu formatta veriniz: gg/AA/yyyy"  şeklinde hata mesajı ile karşılaşırsınız.

Bu şekilde projede bir film ve seansa bilet alabilir , bileti iptal edebilir ve bileti görüntülüyerek tarihi ve ne zaman olduğuna bakabilirsiniz.



# Notlar

Seans kelimesinin ingilizce karşılığı java sınıf "Session" olduğundan kodlama sıkıntı yaratıyordu bu yüzden seans kelimesini türkçe kullanmayı tercih ettim.




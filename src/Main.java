// todo - please do not forget creating git repository
//  for this exam and make it public, and also share the link
//  of the project in the group.
public class Main {
    /* 1- Поток в Java — это упрощенный процесс, который может выполняться одновременно с другими потоками
     в той же программе. Поток имеет собственный стек, но разделяет кучу и другие ресурсы с остальной частью программы.
      Потоки могут повысить производительность и скорость отклика приложения, выполняя задачи параллельно1.

Есть два способа создать поток в Java2:

Расширение класса Thread и переопределение его метода run(). Этот метод содержит код, который будет выполняться потоком.
Реализация интерфейса Runnable и определение его метода run(). Этот метод можно передать конструктору объекта Thread,
 а затем запустить, вызвав метод start() потока.*/

/* 2 - Daemon thread - bu Java-da shunday turiq, JVM-dan chiqishga to’sqinlik qilmaydigan turiq. Daemon thread-larning
 asosiy maqsadi - foydalanuvchi turiqlariga xizmat ko’rsatish, masalan, axlat to’plamini tozalash, ishlatilmagan obyektlarning
  xotirasini bo’shatish va keshdan kerakli bo’lmagan yozuvlarni olib tashlash. Foydalanuvchi turiqlari bajarilishi tugaganda,
   JVM to’xtaydi va qolgan daemon thread-lar tashlanadi: finally bloklari bajarilmaydi, steklar yopilmaydi - JVM shunchaki chiqadi.
    Shu sababli daemon thread-larni kamdan-kam ishlatish tavsiya etiladi va ular uchun I/O vazifalarni ishlatish xavfli
 */

/* 3- Thread Executors - bu Java-da turiqlarni boshqarish va yaratishni dasturdan ajratib olish uchun ishlatiladigan obyektlardir.
 Thread Executors turli xil bo’lishi mumkin, lekin eng ko’p ishlatiladigan ikki turi quyidagilar.

 FixedThreadPool - bu belgilangan sonli turiqlardan iborat bo’lgan thread pool-dir. Ushbu executor har bir
  vazifani bajarish uchun mavjud bo’lgan birinchi bo’sh thread-ni tanlaydi. Agar barcha thread-lar band bo’lsa,
   vazifalar navbatda kutadi. FixedThreadPool executor-ni yaratish uchun Executors sinfidagi
    newFixedThreadPool(int nThreads) metodidan foydalanish mumkin.

    CachedThreadPool - bu har qanday sonli vazifalarni bajarish uchun yangi thread-larni yaratadigan va avval yaratilgan thread-larni
     qayta ishlatadigan thread pool-dir. Ushbu executor-da thread-lar soni vazifalar soniga bog’liq bo’ladi. Agar thread-lar ishlatilmagan bo’lsa,
      ular avtomatik ravishda o’chiriladi. CachedThreadPool executor-ni yaratish uchun Executors sinfidagi newCachedThreadPool() metodidan foydalanish
       mumkin.
 */

/* 4- Serialization va deserialization dasturlashda muhim tushunchalardir. Ular obyektlarni saqlash, uzatish va qayta tiklashga imkon beradilar.
 Ular turli xil holatlarda ishlatiladi, masalan, obyektlarni ma’lumotlar bazasida, tarmoq orqali yoki xotirada saqlash uchun.

Serialization - bu obyektning holatini bayt oqimiga aylantirish jarayoni. Bu bayt oqimi keyin faylga saqlanishi, tarmoq orqali yuborilishi yoki
 ma’lumotlar bazasida saqlanishi mumkin. Bayt oqimi obyektning holatini ifodalaydi, bu esa keyinchalik yangi nusxasini yaratish uchun ishlatilishi mumkin.
  Serialization bizga obyektga tegishli ma’lumotlarni saqlab, yangi joyda obyektni qayta yaratishga imkon beradi.


Obyektni serializatsiya qilish uchun, dasturchi avval formatni tanlab, so’ngra mos vositalardan foydalanib obyektni ushbu formatga aylantirishi kerak.

2.1. Serialization formatlari Serialization uchun turli xil formatlar ishlatilishi mumkin, masalan, JSON, XML va binary. JSON va XML serialization uchun
 mashhur formatlar hisoblanadi, chunki ular odam uchun o’qiladigan matn shaklida ma’lumotlarni saqlaydi va boshqa tizimlar tomonidan osongina tahlil qilinadi.
  Binary formatlar esa ko’pincha ijro tezligi sababli ishlatiladi, chunki ular matn asosidagi formatlarga nisbatan o’qish va yozishda tezroqdir.

Deserialization - bu serializationning teskari jarayonidir. U bayt oqimini qayta obyektga aylantirishni o’z ichiga oladi. Bu esa mos vositalardan foydalanib
 bayt oqimini tahlil qilib yangi obyekt yaratish orqali amalga oshiriladi. Javada, binary formatni deserializatsiya qilish uchun ObjectInputStream sinfi ishlatilishi mumkin,
  JSON formatni tahlil qilish uchun esa Jackson kutubxonasi ishlatilishi mumkin.*/

   /* 5-  Log levellari Java dasturlash tilida log fayllarini kategoriyalarga ajratish uchun ishlatiladi. Ammo ular juda maxsus usulda, ya’ni,
    shoshilinchlik darajasiga ko’ra kategoriyalarga ajratiladi. Log levellari quyidagi ma’lumotlarni ajratishga imkon beradi:

    Log fayllarini qidirish paytida filtrlashingiz mumkin.
    Log qiladigan ma’lumotlar miqdorini boshqarishingiz mumkin.
    Tizimdagi ma’lumotlar va hodisalar loglarida berilgan ma’lumotlar va ularning turi log4j konfiguratsiya faylida
    log4j darajasi sozlamalariga bog’liq.
    Har bir log xabari xabar darajasini belgilash uchun oldiga qo’yilgan. Log darajalari org.apache.log4j.Level
    sinfidan bo’lgan. Log4j-da quyidagi log darajalari mavjud:

    ALL: Barcha xabarlar log qilinishi kerakligini ko’rsatadi. Bu siz toifalashtirgan maxsus log darajalarini ham
    o’z ichiga oladi. Agar bu sozlangan bo’lsa, darajalar umuman hisobga olinmaydi, keyin barcha appenders log hodisalarini
    log fayllariga to’kib yuboradi.
    DEBUG: Debug ko’p dasturni ishlab chiqish vaqtida debuglash uchun ishlatiladi. Har bir log xabari ushbu daraja sozlangan bo’lsa,
    log fayllariga chiqadi. Asosan dasturchilar uchun mo’ljallangan.
            INFO: INFO log darajasi dasturning oddiy ishlash haqida xabar berish uchun ishlatiladi. Real vaqtda, tizim administratorlari
    info loglarini tomosha qilishadi va tizimda nima bo’layotganini va normal oqimda muammo yo’qligini tekshirishadi.
    WARN: WARN log darajasi sizda muammo bo’lishi mumkinligini ko’rsatadigan xabarlarni ishlatish uchun mo’ljallangan. Masalan, siz xizmatni
    chaqirishni talab qildingiz va u bir necha marta ulanishdan oldin muvaffaqiyatsiz tugadi. Bu kutilmagan va noaniq holat, ammo haqiqiy zarar
    yetkazilmagan va muammoning davom etishi yoki takrorlanishi ma’lum emas. Kimdir ogohlantirishlarni tekshirishi kerak.
    ERROR: ERROR log darajasi jiddiy muammo bo’lganligini ko’rsatadigan xabarlarni ishlatish uchun mo’ljallangan.
    FATAL kabi jiddiy, ammo hali ham muammo. Bu oddiy ravishda dasturingiz juda istalmagan holatga tushganligini anglatadi. Masalan,
     kutilmagan formatlangan kirish, ma’lumotlar bazasi mavjud emas.
    FATAL: FATAL log darajasi, ERROR kabi, muammoga belgilangan. Ammo ERROR dan farqli o’laroq, juda jiddiy xato hodisasini belgilaydi.
     Ularning mavjudligini oddiy kunlarda ko’rmaysiz, ammo ular paydo bo’lganda, juda yomon yangiliklarni anglatadi, hatto ilova o’limi ham.
    OFF: Bu eng yuqori mumkin bo’lgan martaba va loggingni o’chirish uchun mo’ljallangan.
            TRACE: Ushbu versiya 1.2 da yaqinda kiritilgan va debug daraja loglariga qo’shimcha ma’lumotlarni o’z ichiga oladi.*/
}

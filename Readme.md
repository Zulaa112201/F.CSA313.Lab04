# Lab 4: JUnit 5 & Mutation Testing

* **Оюутны нэр:** Э.Номинзул
* **Оюутны код:** [B242270082]

## Системийн орчин (Environment Versions)
* **mvn version**
Apache Maven 3.9.16 (2bdd9fddda4b155ebf8000e807eb73fd829a51d5)
Maven home: C:\Users\Dell\AppData\Roaming\Code\User\globalStorage\pleiades.java-extension-pack-jdk\maven\latest

* **Java version**
 21.0.5, vendor: Eclipse Adoptium, runtime: C:\Program Files\Eclipse Adoptium\jdk-21.0.5.11-hotspot
Default locale: en_US, platform encoding: UTF-8
OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"
 
## Тестийн мэдээлэл
Бичсэн тестийн методын тоо: 21

results/mvn-test.txt-ийн Tests run тоо: 21 (BUILD SUCCESS)

## Мутацийн тестийн үр дүн
Мутацийн өөрчлөлт: GradeCalculator классын grade >= 90 гэсэн нөхцөлийг зориудаар grade > 90 болгож өөрчилсөн.

Унасан тестүүд: Энэхүү өөрчлөлтийн улмаас results/mvn-test-mutant.txt файл дээр дараах 2 тест амжилтгүй болж унан BUILD FAILURE үр дүн гарсан:

GradeCalculatorTest.ninetyIsExactlyA:17 (expected: <A> but was: <B>)

GradeCalculatorTest.letterGradeBoundaries:36 (expected: <A> but was: <B>)

Сэргээлт: Мутацийн шалгалтын дараа кодыг анхны зөв утгад нь буцаан засаж, mvn test командыг дахин ажиллуулан BUILD SUCCESS төлөвт оруулсан.

 ## Дүгнэлт

Энэхүү лабораторийн ажилд нийт 21 тестийн метод бичсэн бөгөөд **results/mvn-test.txt** файлаас харахад Tests run тоо яг 21 амжилттай ажилласан байна. Тестүүдээ AAA (Arrange-Act-Assert) загвар болон @DisplayName, @ParameterizedTest ашиглан хэрэгжүүлсэн. Мутацийн тестийн шалгалтаар **GradeCalculator** классын **grade >= 90** нөхцөлийг **grade > 90** болгон зориудаар өөрчлөхөд ninetyIsExactlyA() болон letterGradeBoundaries() тестүүд амжилтгүй болж унасан. Энэхүү мутацийн өөрчлөлт нь яг 90 оноо авсан оюутны үнэлгээг алдаатай тооцоолж эхэлснийг уг тестүүд шууд олж илрүүлсэн нь хамгийн сонирхолтой чухал хэсэг байлаа. Ингэснээр хязгаарын утгыг шалгасан нэгж тестүүд бодит логик алдааг яг таг илрүүлэх өндөр чадвартай болох нь практик дээр батлагдсан юм. Шалгалтын дараа кодоо анхны зөв утгад нь буцаан засаж, бүх тестийг хэвийн амжилттай төлөвт орууллаа.
# Sequence Diagrams - User Login & Profile Management

Bu doküman, Java uygulamamızda kullanıcı giriş ve profil yönetimi süreçlerinin adım adım akışlarını gösteren **sequence diagramlarını** içerir. Her akış, kullanıcı eylemleri, sistem davranışları ve veri tabanı etkileşimlerini detaylı olarak açıklamaktadır.  

---

## 1. UC-1: User Login Sequence

**Senaryo:** Kullanıcı TC numarası ve şifre ile sisteme giriş yapmak ister. Sistem giriş bilgilerini doğrular, hatalı girişleri takip eder ve maksimum hatalı giriş limitine ulaşıldığında kullanıcıyı hem SMS hem e-posta ile bilgilendirir. Başarılı girişte kullanıcı profil sayfasına yönlendirilir.

**Sequence Diagram Açıklaması:**

**Detaylı Açıklamalar:**
- **TC ve şifre doğrulama:** Sistem öncelikle TC numarasının 11 haneli ve şifrenin en az 8 karakter, hem harf hem sayı içerdiğini kontrol eder.
- **Kullanıcı kontrolü:** Girilen TC numarası sistemde kayıtlı değilse kullanıcıya `"Kullanıcı mevcut değil"` hatası verilir.
- **Şifre kontrolü:** TC doğruysa şifre kontrol edilir. Şifre hatalıysa `"Kullanıcı adı veya şifre hatalı"` mesajı gösterilir.
- **Hatalı giriş sayısı:** Maksimum 10 hatalı giriş hakkı vardır. 11. hatalı girişte sistem hem SMS hem e-posta ile kullanıcıyı bilgilendirir ve şifre sıfırlama linki gönderir.
- **Başarılı giriş:** Şifre doğru ise kullanıcı başarıyla giriş yapar ve profil sayfasına yönlendirilir.

---

## 2. UC-2: View & Edit Profile Sequence

**Senaryo:** Kullanıcı, giriş yaptıktan sonra profil sayfasını görüntüleyebilir ve bilgilerini güncelleyebilir. Sistem alan doğrulamalarını yapar ve güncellemeyi kaydeder.  

**Sequence Diagram Açıklaması:**

**Detaylı Açıklamalar:**
- Kullanıcı TC numarasını görüntüler, fakat TC değiştirilemez.  
- Güncellenebilir alanlar: isim, soyisim, telefon, e-posta, doğum tarihi ve profil fotoğrafı.  
- Sistem format doğrulaması yapar:
  - Telefon: 10-11 rakam, sadece sayılar.
  - E-posta: `@` ve domain içermeli.
  - Doğum tarihi: geçerli bir tarih olmalı, gelecekteki bir tarih olamaz.
- Başarılı güncelleme sonrası sistem `"Profile updated successfully"` mesajı gösterir.  
- Fotoğraf güncelleme işlemi ayrıca doğrulanır ve veritabanına kaydedilir.  

---

## Notlar ve Öneriler
- Bu sequence diagramlar **ASCII/tablo formatında** hazırlanmıştır. Daha görsel bir temsil için **PlantUML, Lucidchart veya draw.io** kullanılabilir.  
- Her adımda sistemin kullanıcıya verdiği geri bildirim net bir şekilde gösterilmiştir.  
- Hatalı girişler ve şifre sıfırlama süreçleri de ayrı bir alternatif akış olarak modellenmiştir.

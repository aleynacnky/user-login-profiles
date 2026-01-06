# ER Diagram - User Login & Profile Management

Bu doküman, Java uygulamamızda kullanıcı giriş ve profil yönetimi için tasarlanan **Veri Tabanı ER Diyagramı**nı ve tabloların açıklamalarını içerir.

---

## Tablolar ve Açıklamaları

### 1. User
Kullanıcı bilgilerini tutan temel tablo.  
**Alanlar:**
- `user_id` (PK) → Her kullanıcı için benzersiz kimlik.
- `tc_no` (VARCHAR(11), UNIQUE) → Kullanıcının 11 haneli T.C. kimlik numarası.
- `password` (VARCHAR) → Şifre, en az 8 karakter, hem harf hem sayı içermeli.
- `first_name` (VARCHAR) → Ad
- `last_name` (VARCHAR) → Soyad
- `phone_number` (VARCHAR) → Telefon numarası
- `email` (VARCHAR) → E-posta adresi
- `birth_date` (DATE) → Doğum tarihi
- `profile_photo` (BLOB / dosya yolu) → Profil fotoğrafı

---

### 2. LoginAttempt
Kullanıcının giriş denemelerini kaydeden tablo.  
**Alanlar:**
- `attempt_id` (PK) → Her giriş denemesi için benzersiz kimlik
- `user_id` (FK → User.user_id) → Denemeyi yapan kullanıcı
- `attempt_time` (TIMESTAMP) → Deneme zamanı
- `successful` (BOOLEAN) → Başarılı giriş mi?

**İlişki:** User → LoginAttempt = 1:N (Her kullanıcı birden fazla giriş denemesi yapabilir)

---

### 3. PasswordResetRequest
Şifre sıfırlama taleplerini tutan tablo.  
**Alanlar:**
- `request_id` (PK) → Her talep için benzersiz kimlik
- `user_id` (FK → User.user_id) → Talebi yapan kullanıcı
- `request_time` (TIMESTAMP) → Talep zamanı
- `reset_token` (VARCHAR, UNIQUE) → Şifre sıfırlama linki veya token
- `status` (ENUM: pending, used, expired) → Talep durumu

**İlişki:** User → PasswordResetRequest = 1:N (Her kullanıcı birden fazla şifre sıfırlama talebi oluşturabilir)

---



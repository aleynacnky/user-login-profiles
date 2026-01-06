## UC-2: View & Edit Profile
**Actor:** User  
**Precondition:** User is logged in.  
**Trigger:** User opens Profile page.

### Basic Flow (View Profile):
1. System retrieves user's profile from database.
2. System displays profile information:
   - First Name
   - Last Name
   - TC (11 digits)
   - Phone Number
   - Email Address
   - Birth Date
   - Profile Photo

### Alternative Flow (Edit Profile):
1. User chooses to edit profile information.
2. User updates one or more fields:
   - First Name / Last Name
   - Phone Number
   - Email Address
   - Birth Date
   - Profile Photo
3. System validates inputs:
   - Phone number format (10–11 digits, only numbers)
   - Email format (must contain `@` and domain)
   - Birth Date (valid date, cannot be in the future)
4. If all validations pass:
   - System updates the profile in the database.
   - Confirmation message: "Profile updated successfully."
5. If validation fails:
   - System shows an appropriate error message (e.g., "Invalid phone number", "Invalid email format").

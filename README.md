This project is created for educational purposes. 
It allows users to borrow books, contact admins, read "About" page, see all lists of books. Admins have access to all implemented functionalities, like adding books to remote MySQL database, have (read only) access to list of all registered users. Every book borrow generates and shows QR code which keeps borrow UID. By this code user can get borrowed book in a library by scaning code or entering generated UID. All logged users have access to borrowed page where they can see borrow Qr code or they can cancel borrow.

List of users added to database:

ADMINS:
1. login: testlogowania
   
   password: test
   
2. login: admin1

   password: admin

USERS:
1. login: user1
   
   password: user1
2. login: user2
   
   password: user2

*passwords are hashed by BCrypt algorythm and then stored in database, "raw" password is not stored by any field in code.
*jsp pages are created using bootstrap 4.4.1 templates
    
Any suggestions? Contact me!
email: milo99@vp.pl

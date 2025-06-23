## Application B - Server App 

## Description
Application B is the server app which runs a bound service namely SecureEncryptionService. 
The app mainly processes messages from the clients and decrypts them and does the processing.

## Secure Encryption Service
- It is a Bound Service.
- Does interprocess communication using IEncryptionService AIDL interface.
- Uses the help of a CryptoHelper to encrpt and decrpt messages from the client using AES Algorithms and Android Keystore.

## IEncryption Service (AIDL Interface)
- ### twoWayMessaging - A method which is used for two way communication.
- ### sendOneWayMessage - A method which is used for one way communication between the client and the server.
  



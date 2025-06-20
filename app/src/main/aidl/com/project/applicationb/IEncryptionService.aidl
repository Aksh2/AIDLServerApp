package com.project.applicationb;
interface IEncryptionService {
    String processEncrypted(String requestData); // Request-Response
    oneway void sendOneWay(in byte[] requestData);         // One-way
    oneway void sendMessage(in String requestData);         // One-way
}
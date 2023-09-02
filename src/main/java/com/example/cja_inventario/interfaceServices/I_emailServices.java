package com.example.cja_inventario.interfaceServices;

import java.io.File;

public interface I_emailServices {

    void sendEmail(String[] toUser,String subject,String massage);
    void sendEmailWithFile(String[] toUser, String subject, String massage, File file);
}

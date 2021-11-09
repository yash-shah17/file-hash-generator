package Yashsgp;

import Yashsgp.FileChooser;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Driver {
    public static void main(String[] args) {
        FileChooser fc = new FileChooser();
        String filePath = fc.fileChooser();
        File file;
        if (filePath == null) {
            System.out.println("File not chosen");
        } else {
            file = new File(filePath);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                hash md5 = new hash();
                String checksum = md5.checksum(messageDigest, file);
                System.out.println("MD5:");
                System.out.println(checksum);
            } catch (NoSuchAlgorithmException | IOException e) {
                e.printStackTrace();
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD2");
                hash md2 = new hash();
                String checksum = md2.checksum(messageDigest, file);
                System.out.println("MD2:");
                System.out.println(checksum);
            } catch (NoSuchAlgorithmException | IOException e) {
                e.printStackTrace();
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                hash sha256 = new hash();
                String checksum = sha256.checksum(messageDigest, file);
                System.out.println("SHA-256:");
                System.out.println(checksum);
            } catch (NoSuchAlgorithmException | IOException e) {
                e.printStackTrace();
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
                hash sha512 = new hash();
                String checksum = sha512.checksum(messageDigest, file);
                System.out.println("SHA-512:");
                System.out.println(checksum);
            } catch (NoSuchAlgorithmException | IOException e) {
                e.printStackTrace();
            }

        }
    }
}

package Yashsgp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

public class hash {

    /* this method gives a NoSuchAlgorithmException in case
     we pass a string which dosen't have any hashing
     algorithm in its correspondence*/

    public String checksum(MessageDigest digest, File file) throws IOException {

        FileInputStream fis = new FileInputStream(file);
        // Create byte array to read data
        byte[] byteArray = new byte[1024];
        int bytesCount = 0;
        // read the data from file and update that data in
        // the message digest
        while ((bytesCount = fis.read(byteArray)) != -1)
        {
            digest.update(byteArray, 0, bytesCount);
        };
        fis.close();

        // store the bytes returned by the digest() method
        byte[] bytes = digest.digest();
        StringBuilder sb = new StringBuilder();

        // loop through the bytes array
        for (int i = 0; i < bytes.length; i++) {

            // the following line converts the decimal into
            // hexadecimal format and appends that to the
            // StringBuilder object
            sb.append(Integer
                    .toString((bytes[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return sb.toString();
    }
}
package pt.up.fe.Messaging;

import java.net.InetAddress;

public class Message {
    InetAddress source;     //  This may not be used after all.

    String header;
    byte[] messageData;

    /*
     *      Utility function taken from http://stackoverflow.com/questions/5513152/easy-way-to-concatenate-two-byte-arrays
     */

    public static byte[] concatByteArrays(byte[] ... arrays) {
        // Determine the length of the result array
        int totalLength = 0;

        for (int i = 0; i < arrays.length; i++)
            totalLength += arrays[i].length;

        // create the result array
        byte[] result = new byte[totalLength];

        // copy the source arrays into the result array
        int currentIndex = 0;

        for (int i = 0; i < arrays.length; i++) {
            System.arraycopy(arrays[i], 0, result, currentIndex, arrays[i].length);

            currentIndex += arrays[i].length;
        }

        return result;
    }

    public String getHeader() {
        return header;
    }

    public byte[] getMessageData() {
        return messageData;
    }

}

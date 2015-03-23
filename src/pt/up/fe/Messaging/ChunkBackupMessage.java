package pt.up.fe.Messaging;

public class ChunkBackupMessage extends Message {
    public String makeHeader(String version, String fileId, int chunkNo, int replicationDeg) {
        return "PUTCHUNK " + version + " " + fileId + " " + Integer.toString(chunkNo) + " " + Integer.toString(replicationDeg) + " ";
    }

    public byte[] makeMessage(String header, byte[] data) {
        this.header = header;
        header += "\r\n\r\n";   //  Append two <CR><LF>

        byte[] dataHeader = header.getBytes();

        this.msg = concatByteArrays(dataHeader, data);
        return this.msg;
    }

    public String confirmMessage(String version, String fileId, int chunkNo) {
        return "STORED " + version + " " + fileId + " " + Integer.toString(chunkNo) + " ";
    }



}

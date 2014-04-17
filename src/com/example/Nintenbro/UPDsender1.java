package com.example.Nintenbro;

import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


/**
 * Created by student on 4/15/14.
 */
public class UPDsender1 {
    public static void logandSendPacket(String packetContents, String ipAddress, int port) {
        try {
            DatagramSocket socket = new DatagramSocket(port);

            InetAddress address = InetAddress.getByName(ipAddress);

            int messageLength = packetContents.length();
            byte[] byteMessage = packetContents.getBytes();

            DatagramPacket packet = new DatagramPacket(byteMessage, messageLength, port);

            socket.send(packet);

            Log.d("UDP", String.format("Send packet %d to address %s", packet.toString(),port,ipAddress));
        }
        catch(IOException e) {
            Log.e("UDP", "IOException occured during packet send",e);
        }
    }
}

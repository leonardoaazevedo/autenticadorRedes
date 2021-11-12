package ufmg.redestp0;

import ufmg.redestp0.constants.ClientConstants;
import ufmg.redestp0.flow.ByteBufferBuilderFlow;
import ufmg.redestp0.flow.ByteBufferOrderflow;
import ufmg.redestp0.flow.DatagramSocketBuilderFlow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class Client {

    public static ByteBufferBuilderFlow byteBufferBuilderFlow = new ByteBufferBuilderFlow();
    public static ByteBufferOrderflow byteBufferOrderflow = new ByteBufferOrderflow();
    public static DatagramSocketBuilderFlow datagramSocketBuilderFlow = new DatagramSocketBuilderFlow();

    public static void main(String[] args) throws IOException {

        ByteBuffer byteBuffer = byteBufferBuilderFlow.byteBufferBuilder();
        byteBufferOrderflow.byteBufferOrder(byteBuffer);

        byte[] pump_on = byteBuffer.array();
        System.out.println(Arrays.toString(pump_on));

        DatagramSocket clientSocket = datagramSocketBuilderFlow.datagramSocketBuilder();

        InetAddress IPAddress = InetAddress.getByName(ClientConstants.SERVER_HOST_NAME);

        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        String sentence = "2014066803";
        sendData = sentence.getBytes();

        System.out.println("Digite o texto a ser enviado ao servidor: ");

        DatagramPacket sendPacket = new DatagramPacket(pump_on, sendData.length, IPAddress, ClientConstants.SERVER_PORT);

        System.out.println("Enviando pacote UDP para " + ClientConstants.SERVER_HOST_NAME + ":" + ClientConstants.SERVER_PORT);
        clientSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

        clientSocket.receive(receivePacket);
        System.out.println("Pacote UDP recebido...");

        String modifiedSentence = new String(receivePacket.getData());

        System.out.println("Texto recebido do servidor:" + modifiedSentence);
        clientSocket.close();
        System.out.println("Socket cliente fechado!");
    }
}

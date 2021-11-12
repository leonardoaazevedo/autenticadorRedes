package ufmg.redestp0.flow;

import lombok.NoArgsConstructor;

import java.net.DatagramSocket;
import java.net.SocketException;

@NoArgsConstructor
public class DatagramSocketBuilderFlow {

    public DatagramSocket datagramSocketBuilder() throws SocketException {
        return new DatagramSocket();
    }
}

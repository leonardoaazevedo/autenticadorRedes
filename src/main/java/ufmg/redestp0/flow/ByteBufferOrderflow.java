package ufmg.redestp0.flow;


import lombok.RequiredArgsConstructor;
import ufmg.redestp0.constants.ClientConstants;

import java.nio.ByteBuffer;

@RequiredArgsConstructor
public class ByteBufferOrderflow {

    public void byteBufferOrder(ByteBuffer byteBuffer) {
        byteBuffer.putShort((short) 1);
        byteBuffer.putInt(ClientConstants.MATRICULA);
        byteBuffer.putInt(ClientConstants.IDENTIFIER);
    }
}

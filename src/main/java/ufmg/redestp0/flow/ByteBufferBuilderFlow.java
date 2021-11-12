package ufmg.redestp0.flow;


import lombok.RequiredArgsConstructor;
import ufmg.redestp0.constants.ClientConstants;

import java.nio.ByteBuffer;

@RequiredArgsConstructor
public class ByteBufferBuilderFlow {

    public ByteBuffer byteBufferBuilder() {
        return ByteBuffer.allocate(ClientConstants.BUFFER_SIZE);
    }
}

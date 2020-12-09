/*
 * © 2017 AgNO3 Gmbh & Co. KG
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package jcifsng.internal.smb2.lock;


import jcifsng.Configuration;
import jcifsng.internal.SMBProtocolDecodingException;
import jcifsng.internal.smb2.ServerMessageBlock2Response;
import jcifsng.internal.util.SMBUtil;


/**
 * @author mbechler
 *
 */
public class Smb2LockResponse extends ServerMessageBlock2Response {

    /**
     * @param config
     */
    public Smb2LockResponse ( Configuration config ) {
        super(config);
    }


    /**
     * {@inheritDoc}
     *
     * @see jcifsng.internal.smb2.ServerMessageBlock2#writeBytesWireFormat(byte[], int)
     */
    @Override
    protected int writeBytesWireFormat ( byte[] dst, int dstIndex ) {
        return 0;
    }


    /**
     * {@inheritDoc}
     *
     * @see jcifsng.internal.smb2.ServerMessageBlock2#readBytesWireFormat(byte[], int)
     */
    @Override
    protected int readBytesWireFormat ( byte[] buffer, int bufferIndex ) throws SMBProtocolDecodingException {
        int structureSize = SMBUtil.readInt2(buffer, bufferIndex);
        if ( structureSize != 4 ) {
            throw new SMBProtocolDecodingException("Expected structureSize = 4");
        }
        return 4;
    }

}

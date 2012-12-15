/**
 * 
 */
package ru.naumen.nauchat.server.taskrunner;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import javax.tools.SimpleJavaFileObject;

/**
 * @author ivodopyanov
 * @since 15.12.2012
 * 
 */
public class MemoryJavaClassObject extends SimpleJavaFileObject
{
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    public MemoryJavaClassObject(String name, Kind kind)
    {
        super(URI.create("string:///" + name.replace('.', '/') + kind.extension), kind);
    }

    public byte[] getBytes()
    {
        return bos.toByteArray();
    }

    @Override
    public OutputStream openOutputStream() throws IOException
    {
        return bos;
    }
}
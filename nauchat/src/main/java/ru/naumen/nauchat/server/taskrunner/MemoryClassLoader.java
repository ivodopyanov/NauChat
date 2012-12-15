/**
 * 
 */
package ru.naumen.nauchat.server.taskrunner;

/**
 * @author ivodopyanov
 * @since 15.12.2012
 * 
 */
public class MemoryClassLoader extends ClassLoader
{
    private final byte[] classData;
    private final String name;

    public MemoryClassLoader(byte[] classData, String name)
    {
        this.name = name;
        this.classData = new byte[classData.length];
        System.arraycopy(classData, 0, this.classData, 0, classData.length);
    }

    public Class<?> loadClass()
    {
        return defineClass(name, classData, 0, classData.length);
    }
}
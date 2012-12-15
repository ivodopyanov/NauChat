/**
 * 
 */
package ru.naumen.nauchat.server.taskrunner;

import java.io.IOException;
import java.security.SecureClassLoader;

import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;
import javax.tools.StandardJavaFileManager;

/**
 * @author ivodopyanov
 * @since 15.12.2012
 * 
 */
public class MemoryFileManager extends ForwardingJavaFileManager<StandardJavaFileManager>
{
    private MemoryJavaClassObject jclassObject;

    public MemoryFileManager(StandardJavaFileManager fileManager)
    {
        super(fileManager);
    }

    @Override
    public ClassLoader getClassLoader(Location location)
    {
        return new SecureClassLoader()
        {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException
            {
                byte[] b = jclassObject.getBytes();
                return super.defineClass(name, jclassObject.getBytes(), 0, b.length);
            }
        };
    }

    @Override
    public JavaFileObject getJavaFileForOutput(Location location, String className, Kind kind, FileObject sibling)
            throws IOException
    {
        jclassObject = new MemoryJavaClassObject(className, kind);
        return jclassObject;
    }
}
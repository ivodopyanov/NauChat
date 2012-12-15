/**
 * 
 */
package ru.naumen.nauchat.server.taskrunner;

import java.io.IOException;
import java.net.URI;

import javax.tools.SimpleJavaFileObject;

/**
 * @author ivodopyanov
 * @since 15.12.2012
 * 
 */
public class MemoryJavaSourceCodeObject extends SimpleJavaFileObject
{
    private final String fqn;
    private final String sourceCode;

    public MemoryJavaSourceCodeObject(String fqn, String sourceCode)
    {
        super(URI.create("string:///" + fqn.replaceAll("\\.", "/") + Kind.SOURCE.extension), Kind.SOURCE);
        this.fqn = fqn;
        this.sourceCode = sourceCode;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException
    {
        return sourceCode;
    }

    public String getFqn()
    {
        return fqn;
    }

    public String getSourceCode()
    {
        return sourceCode;
    }
}
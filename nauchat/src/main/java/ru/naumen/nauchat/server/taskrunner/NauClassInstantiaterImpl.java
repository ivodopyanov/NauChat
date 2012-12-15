/**
 * 
 */
package ru.naumen.nauchat.server.taskrunner;

import java.io.StringWriter;
import java.net.MalformedURLException;
import java.util.List;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;

import com.google.common.collect.Lists;

/**
 * @author ivodopyanov
 * @since 15.12.2012
 * 
 */
public class NauClassInstantiaterImpl implements NauClassInstantiater
{
    public <T> T createInstanceFromString(String fqn, String code, StringWriter writer,
            DiagnosticCollector<JavaFileObject> diagnostics) throws CompilationFailedException, ClassNotFoundException,
            InstantiationException, IllegalAccessException, MalformedURLException
    {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        JavaFileManager fileManager = new MemoryFileManager(compiler.getStandardFileManager(null, null, null));
        SimpleJavaFileObject fileObject = new MemoryJavaSourceCodeObject(fqn, code);
        List<? extends JavaFileObject> javaFileObjects = Lists.newArrayList(fileObject);

        CompilationTask compilerTask = compiler.getTask(writer, fileManager, diagnostics, null, null, javaFileObjects);
        boolean result = compilerTask.call();
        if (!result)
            throw new CompilationFailedException();
        return (T)fileManager.getClassLoader(null).loadClass(fqn).newInstance();
    }

}
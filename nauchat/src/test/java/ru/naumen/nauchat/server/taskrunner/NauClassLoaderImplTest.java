/**
 * 
 */
package ru.naumen.nauchat.server.taskrunner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaFileObject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author ivodopyanov
 * @since 15.12.2012
 * 
 */
public class NauClassLoaderImplTest
{
    private NauClassInstantiaterImpl loader;

    @Before
    public void setUp() throws Exception
    {
        loader = new NauClassInstantiaterImpl();
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void testCreateInstanceFromString()
    {
        try
        {
            //Загружаем код из файла
            String fqn = "ru.naumen.nauchat.server.taskrunner.Square";
            String code = loadSourceCodeFromFile("/src/test/resources/ru/naumen/nauchat/server/taskrunner/Square.java");

            //Различные объекты, в которые пишутся сообщения об ошибках
            StringWriter writer = new StringWriter();
            DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
            //Создаем экземпляр объекта класса с названием fqn, код которого лежит в переменной code
            MyFunction func = loader.createInstanceFromString(fqn, code, writer, diagnostics);
            //Проверяем, что это он
            Double expected = 9.0;
            Double actual = func.apply(3.0);
            Assert.assertEquals(expected, actual);
        }
        catch (FileNotFoundException e)
        {
            Assert.fail(e.getMessage());
        }
        catch (IOException e)
        {
            Assert.fail(e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            Assert.fail(e.toString());
        }
        catch (InstantiationException e)
        {
            Assert.fail(e.toString());
        }
        catch (IllegalAccessException e)
        {
            Assert.fail(e.toString());
        }
        catch (CompilationFailedException e)
        {
            Assert.fail(e.toString());
        }
    }

    private String loadSourceCodeFromFile(String path) throws IOException
    {
        List<String> lines = Files.readAllLines(Paths.get(System.getProperty("user.dir") + path),
                Charset.forName("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (String line : lines)
            sb.append(line);
        return sb.toString();
    }
}
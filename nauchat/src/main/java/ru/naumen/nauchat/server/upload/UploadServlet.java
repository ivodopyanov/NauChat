/* $Id$ */
package ru.naumen.nauchat.server.upload;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import ru.naumne.nauchat.shared.upload.UploadConstants;

import com.google.inject.Guice;

/**
 * Сервлет для загрузки файлов на сервер.
 * <p>
 * Позволяет за один запрос загрузить один файл.
 * <p>
 * Выдает идентификатор загруженного файла в {@link UploadService}
 * 
 * @see UploadService
 * 
 * @author nshestakov
 * 
 */
@SuppressWarnings("serial")
public class UploadServlet extends HttpServlet
{
    UploadService service;

    @Override
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
        service = Guice.createInjector(new UploadModule()).getInstance(UploadService.class);
    }

    @SuppressWarnings("unchecked")
    protected List<FileItem> extractItems(HttpServletRequest request) throws FileUploadException
    {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        return upload.parseRequest(request);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException
    {
        FileItem item = null;
        try
        {
            try
            {
                Object uplUuid = request.getParameter(UploadConstants.UPLOADED_UUID);
                if (null != uplUuid)
                {
                    // удаляем ранее загруженный файл
                    service.delete((String)uplUuid);
                    return;
                }
            }
            catch (Exception e)//NOPMD
            {
                // игнорируем
            }

            List<FileItem> items = extractItems(request);
            for (FileItem itm : items)
            {
                if (UploadConstants.FILE.equals(itm.getFieldName()))
                {
                    item = itm;
                    break;
                }
            }
            if (null == item)
            {
                setError(response, "File not found " + items.size());
                return;
            }

            String uuid = service.add(item);

            response.setContentType("text/plain");
            PrintWriter writer = response.getWriter();
            writer.print(UploadConstants.START_DELIMITER);
            writer.print(uuid);
            writer.print(UploadConstants.END_DELIMITER);
        }
        catch (Exception e)
        {
            setError(response, e.getMessage());
        }
        finally
        {
            if (null != item)
            {
                item.delete();
            }
        }
    }

    protected void setError(HttpServletResponse response, String msg) throws IOException
    {
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, msg);
    }
}
